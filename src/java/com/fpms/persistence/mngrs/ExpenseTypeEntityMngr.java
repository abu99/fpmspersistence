/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ExpenseType;
import com.fpms.util.crud.CrudServiceProviderLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class ExpenseTypeEntityMngr implements ExpenseTypeEntityMngrLocal{

    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    
    @Override
    public ExpenseType create(ExpenseType expenseType) {
        
        return crudServiceProvider.create(expenseType);
    }

    @Override
    public ExpenseType update(ExpenseType expenseType) {
       return crudServiceProvider.update(expenseType);
    
    }

    @Override
    public void delete(String expenseId) {
        ExpenseType ext = get(expenseId);
        crudServiceProvider.delete(ext);
    }

    @Override
    public ExpenseType get(String expenseId) {
        return crudServiceProvider.find(expenseId, ExpenseType.class);
    
    }

    @Override
    public List<ExpenseType> getAll() {
        return crudServiceProvider.findByNamedQuery("ExpenseType.findAll", 
                ExpenseType.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }
    
}
