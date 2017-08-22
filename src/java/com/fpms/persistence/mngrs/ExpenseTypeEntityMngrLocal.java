/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ExpenseType;
import java.util.List;

/**
 *
 * @author aabello
 */
public interface ExpenseTypeEntityMngrLocal {
    
    public ExpenseType create(ExpenseType expenseType);
    public ExpenseType update(ExpenseType expenseType);
    public void delete(String expenseId);
    public ExpenseType get(String expenseId);
    public List<ExpenseType> getAll();
    public int count();
    
}
