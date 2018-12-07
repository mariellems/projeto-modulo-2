package com.mari.sistema.utils.auth;

import com.mari.sistema.model.Sessao;
import com.mari.sistema.services.UsuarioService;
import java.io.IOException;
import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@RequestAuth
@Priority(Priorities.AUTHENTICATION)
public class JwtAuthFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Inject @Logged
    private Sessao sessaoUsuario;

    @Inject
    private UsuarioService usuarioService;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        try {
            String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            String token = authHeader.substring("Bearer".length()).trim();

            sessaoUsuario.setUsuarioLogado(usuarioService.validateSessao(token).getUsuarioLogado());
            sessaoUsuario.setToken(token);
        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

        }
    
     @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String token = usuarioService
                .generateSessao(sessaoUsuario.getUsuarioLogado())
                .getToken();
        if (token != null && !token.isEmpty()) {
            responseContext.getHeaders().add("X-Token", token);
        }
    }

    }