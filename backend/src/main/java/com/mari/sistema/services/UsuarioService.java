package com.mari.sistema.services;

import com.mari.sistema.model.Sessao;
import com.mari.sistema.model.Usuario;
import com.mari.sistema.utils.GenericDao;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuarioService extends AbstractCrudService<Usuario> {

    private static final String KEY = "minhachavebunitapracarambaqueehsohminha";

    @Inject
    private GenericDao<Usuario> dao;
    
    private Usuario findByEmail(String email) {
        List<Usuario> base = getDao().findAll("email", email, "nome");

        if (!base.isEmpty() && base.size() == 1) {
        
             return base.get(0);
        }
        
         return null;
    }
    
     public Sessao login(Usuario usuario) {
        Usuario userBase = findByEmail(usuario.getEmail());

        if (userBase != null) {
            if (userBase.getSenha().equals(usuario.getSenha())) {
                
            return generateSessao(userBase);
            }
        }
        return null;
    }
     
     public Sessao generateSessao(Usuario usuario) {
        if (usuario == null || usuario.getEmail() == null) {
            return null;
        }
        Key key = Keys.hmacShaKeyFor(KEY.getBytes());
        String token = Jwts.builder().setSubject(usuario.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(
                        LocalDateTime.now().plusMinutes(5L).atZone(ZoneId.systemDefault()).toInstant()
                        
                        )
                )
                .signWith(key)
                .compact();
        return new Sessao(usuario, token);
     }
     
    public Sessao validateSessao(String token) {
    Key key = Keys.hmacShaKeyFor(KEY.getBytes());
    Jws<Claims> headerJwt = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        
    Usuario usuario = findByEmail(headerJwt.getBody().getSubject());
     return new Sessao(usuario, token);
    }

    @Override
    protected GenericDao<Usuario> getDao() {
        return dao;
    }

}