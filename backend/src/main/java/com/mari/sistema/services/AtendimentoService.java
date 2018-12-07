package com.mari.sistema.services;

import com.mari.sistema.model.Atendimento;
import com.mari.sistema.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AtendimentoService extends AbstractCrudService<Atendimento> {

    @Inject
    private GenericDao<Atendimento> dao;
    
    @Override
    protected GenericDao<Atendimento> getDao() {
        return dao;
    }
}
