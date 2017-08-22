/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.Expenses;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabello
 */
@Local
public interface ExpensesEntityMngrLocal {
    
    public Expenses create(Expenses expenses);
    public Expenses update(Expenses expenses);
    public void delete(String id);
    public Expenses get(String id);
    public List<Expenses> getAll();
    public int count();
    List<Expenses> getExpensesByMonthAndYear(int month, int year);
    List<Expenses> getExpensesByMonthYearAndExpenseType(int month, int year, 
            String typeId);
    List<Expenses> getExpensesBetween(Date from, Date to);
    List<Expenses> getExpensesByExpenseTypeBetween(Date from, Date to, String typeId);
    List<Expenses> getExpensesBySectionMonthAndYear(
            String sectionId, int month, int year);
    List<Expenses> getExpensesBySectionMonthYearAndExpenseType(
            String sectionId, int month, int year, String typeId);
    List<Expenses> getExpensesBySectionAndBetween(
            String sectionId, Date from, Date to);
    List<Expenses> getExpensesBySectionExpenseTypeAndBetween(
            String sectionId, Date from, Date to, String typeId);
    List<Expenses> getExpensesBySection(String sectionId, Date from, Date to);
    List<Expenses> getExpensesBySection(String sectionId, Date from, Date to, String typeId);
    List<Expenses> getExpensesBySection(String sectionId);
    List<Expenses> getExpensesBySection(String sectionId, String typeId);
    
    List<Expenses> getExpensesByExpenseType(String typeId);
 }
