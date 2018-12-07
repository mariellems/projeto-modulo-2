package com.mari.sistema.rest.resources;

import com.mari.sistema.model.Atendimento;
import com.mari.sistema.rest.AbstractCrudResource;
import com.mari.sistema.services.AbstractCrudService;
import com.mari.sistema.services.AtendimentoService;
import com.mari.sistema.utils.auth.RequestAuth;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestAuth
@Path("atendimento")
public class AtendimentoResource extends AbstractCrudResource<Atendimento> {

    @Inject
    private AtendimentoService service;

    @Override
    protected AbstractCrudService<Atendimento> getService() {
        return service;
    }

}
