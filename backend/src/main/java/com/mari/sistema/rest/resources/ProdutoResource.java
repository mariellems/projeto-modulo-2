package com.mari.sistema.rest.resources;

import com.mari.sistema.model.Produto;
import com.mari.sistema.rest.AbstractCrudResource;
import com.mari.sistema.services.AbstractCrudService;
import com.mari.sistema.services.ProdutoService;
import com.mari.sistema.utils.auth.RequestAuth;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestAuth
@Path("produtos")
public class ProdutoResource extends AbstractCrudResource<Produto> {

    @Inject
    private ProdutoService service;
    
    @Override
    protected AbstractCrudService<Produto> getService() {
        return service;
    }
    
}
