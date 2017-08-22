/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.Expenses;
import com.fpms.util.crud.CrudServiceProviderLocal;
import static com.fpms.util.crud.QueryParameter.*;
import com.fpms.util.MaxDay;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aabello
 */
@Stateless
public class ExpensesEntityMngr implements ExpensesEntityMngrLocal{
    
    @EJB
    private CrudServiceProviderLocal crudServiceProvider;
    @EJB
    private ExpenseTypeEntityMngrLocal expenseTypeEntityMngr;
    @EJB
    private FarmSectionEntityMngrLocal sectionEntityMngr;
    
    @Override
    public Expenses create(Expenses expenses) {
        String expenseTypeId = expenses.getTypeId().getTypeId();
        String sectionId = expenses.getSectionId().getSectionId();
        expenses.setTypeId(expenseTypeEntityMngr.get(expenseTypeId));
        expenses.setSectionId(sectionEntityMngr.get(sectionId));
        return crudServiceProvider.create(expenses);
    }

    @Override
    public Expenses update(Expenses expenses) {
        String expenseTypeId = expenses.getTypeId().getTypeId();
        String sectionId = expenses.getSectionId().getSectionId();
        expenses.setTypeId(expenseTypeEntityMngr.get(expenseTypeId));
        expenses.setSectionId(sectionEntityMngr.get(sectionId));
        return crudServiceProvider.update(expenses);
    }

    @Override
    public void delete(String id) {
        Expenses ex = get(id);
        crudServiceProvider.delete(ex);
    }

    @Override
    public Expenses get(String id) {
        return crudServiceProvider.find(id, Expenses.class);
    }

    @Override
    public List<Expenses> getAll() {
        return crudServiceProvider.findByNamedQuery("Expenses.findAll",
                Expenses.class);
    }

    @Override
    public int count() {
        return getAll().size();
    }
    
    @Override
    public List<Expenses> getExpensesByMonthAndYear(int month, int year) {
        Date date1 = new Date(year, month, 1);
        Date date2 = new Date(year, month, MaxDay.getMaxDay(month));
        
        return getExpensesBetween(date1, date2);
    }

    @Override
    public List<Expenses> getExpensesByMonthYearAndExpenseType(int month, int year, 
            String typeId) {
        Date date1 = new Date(year, month, 1);
        Date date2 = new Date(year, month, MaxDay.getMaxDay(month));
        
        return getExpensesByExpenseTypeBetween(date1, date2, typeId);
    }

     @Override
    public List<Expenses> getExpensesBetween(Date from, Date to) {
        return crudServiceProvider.findByNamedQuery("Expenses.findBetween", 
                with("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(), 
                Expenses.class);
    }

    @Override
    public List<Expenses> getExpensesByExpenseTypeBetween(
            Date from, Date to, String typeId) {
        return crudServiceProvider.findByNamedQuery("Expenses.findByExpenseTypeAndBetween", 
                with("typeId", typeId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(), 
                Expenses.class);
    }

    @Override
    public List<Expenses> getExpensesBySectionMonthAndYear(
            String sectionId, int month, int year) {
        Date date1 = new Date(year, month, 1);
        Date date2 = new Date(year, month, MaxDay.getMaxDay(month));
        
        return getExpensesBySectionAndBetween(sectionId, date1, date2);
    }

    @Override
    public List<Expenses> getExpensesBySectionMonthYearAndExpenseType(
            String sectionId, int month, int year, String typeId) {
        Date date1 = new Date(year, month, 1);
        Date date2 = new Date(year, month, MaxDay.getMaxDay(month));
        
        return getExpensesBySectionExpenseTypeAndBetween(
                sectionId, date1, date2, typeId);
    }

    @Override
    public List<Expenses> getExpensesBySectionAndBetween(
            String sectionId, Date from, Date to) {
        return crudServiceProvider.findByNamedQuery(
                "Expenses.findBySectionAndBetween", 
                with("sectionId", sectionId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(), 
                Expenses.class);
    }

    @Override
    public List<Expenses> getExpensesBySectionExpenseTypeAndBetween(
            String sectionId, Date from, Date to, String typeId) {
        return crudServiceProvider.findByNamedQuery("Expenses.findBySectionExpenseTypeAndBetween", 
                with("sectionId", sectionId)
                .and("typeId", typeId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(), 
                Expenses.class);
    }
    
    
    @Override
    public List<Expenses> getExpensesBySection(String sectionId, Date from, Date to) {
        return crudServiceProvider.findByNamedQuery("Expenses.findBySectionAndBetween", 
                with("dateCreated1", from)
                .and("dateCreated2", to)
                .and("sectionId", sectionId)
                .parameters(), 
                Expenses.class);
    }

    @Override
    public List<Expenses> getExpensesBySection(String sectionId, Date from, Date to, String typeId) {
         return crudServiceProvider.findByNamedQuery("Expenses.findBySectionExpenseTypeAndBetween",
                with("sectionId", sectionId)
                .and("typeId", typeId)
                .and("dateCreated1", from)
                .and("dateCreated2", to)
                .parameters(),
                Expenses.class);
    }

    @Override
    public List<Expenses> getExpensesBySection(String sectionId) {
        return crudServiceProvider.findByNamedQuery("Expenses.findBySection", 
                with("sectionId", sectionId)
                .parameters(),
                Expenses.class);
    }
    
    @Override
    public List<Expenses> getExpensesBySection(String sectionId, String typeId) {
        return crudServiceProvider.findByNamedQuery("Expenses.findBySectionAndType", 
                with("sectionId", sectionId)
                .and("typeId", typeId)
                .parameters(),
                Expenses.class);
    }

    @Override
    public List<Expenses> getExpensesByExpenseType(String typeId) {
        return crudServiceProvider.findByNamedQuery("Expenses.findByType", 
                with("typeId", typeId)
                .parameters(),
                Expenses.class);
    }

    
    
    
}
