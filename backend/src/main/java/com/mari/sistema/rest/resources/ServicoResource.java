package com.mari.sistema.rest.resources;

import com.mari.sistema.model.Servico;
import com.mari.sistema.rest.AbstractCrudResource;
import com.mari.sistema.services.AbstractCrudService;
import com.mari.sistema.services.ServicoService;
import com.mari.sistema.utils.auth.RequestAuth;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestAuth
@Path("servicos")
public class ServicoResource extends AbstractCrudResource<Servico> {

    @Inject
    private ServicoService service;
    
    @Override
    protected AbstractCrudService<Servico> getService() {
        return service;
    }
    
}
