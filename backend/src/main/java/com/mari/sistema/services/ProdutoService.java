package com.mari.sistema.services;

import com.mari.sistema.model.Produto;
import com.mari.sistema.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoService extends AbstractCrudService<Produto> {

    @Inject
    private GenericDao<Produto> dao;
    
    @Override
    protected GenericDao<Produto> getDao() {
        return dao;
    }
}
