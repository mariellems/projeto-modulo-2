package com.mari.sistema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Sessao {
    
    private Usuario usuarioLogado;
    private String token;

    public Sessao() {
        this.usuarioLogado = null;
        this.token = null;
    }

    public Sessao(Usuario usuarioLogado, String token) {
        this.usuarioLogado = usuarioLogado;
        this.token = token;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @JsonIgnore
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public String getNomeUsuario() {
        return usuarioLogado.getNome();
    }
    
    public String getLoginUsuario() {
        return usuarioLogado.getEmail();
    }

    public String getToken() {
        return token;
    }

}

