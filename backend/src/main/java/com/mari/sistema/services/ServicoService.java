package com.mari.sistema.services;

import com.mari.sistema.model.Servico;
import com.mari.sistema.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ServicoService extends AbstractCrudService<Servico> {

    @Inject
    private GenericDao<Servico> dao;
    
    @Override
    protected GenericDao<Servico> getDao() {
        return dao;
    }
}
