package com.mari.sistema.rest.resources;

import com.mari.sistema.model.Sessao;
import com.mari.sistema.model.Usuario;
import com.mari.sistema.services.UsuarioService;
import com.mari.sistema.utils.auth.Logged;
import com.mari.sistema.utils.auth.RequestAuth;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("auth")
@RequestScoped
public class UsuarioResource {

    @Inject
    private UsuarioService service;
    
    @Inject @Logged
    private Sessao sessaoUsuario;
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Usuario usuario) {
        Sessao sessao = service.login(usuario);
        if (sessao == null) 
            return Response.status(Response.Status.UNAUTHORIZED).build();
        return Response.ok(sessao).build();
    }
    
    @GET
    @Path("@me")
    @RequestAuth
    @Produces(MediaType.APPLICATION_JSON)
    public Sessao me() {
        return sessaoUsuario;
    }
   
   @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sessao registro(Usuario usuario) {
        return service.login(service.insert(usuario));
    }
}