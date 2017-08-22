/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ExpenseType;
import com.fpms.persistence.entities.Expenses;
import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.test.common.ServiceLocator;
import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aabello
 */
public class ExpensesEntityMngrTest {
    private static ExpensesEntityMngrLocal instance;
    
    public ExpensesEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        instance = new ServiceLocator().lookup(ExpensesEntityMngrLocal.class);
        
        Mock.setUpExpenses();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        
        Mock.cleanUpExpenses();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ExpensesEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Expenses expenses = new Expenses("exp02", 2000,
                new Date(2013, 10, 9), "fuel for diesel generator");
        
        expenses.setTypeId(new ExpenseType("ex01"));
        expenses.setSectionId(new FarmSection("SEC01"));
        Expenses expResult = new Expenses("exp02");
        Expenses result = instance.create(expenses);
        assertEquals(expResult, result);
        
        instance.delete("exp02");
        
    }

    /**
     * Test of update method, of class ExpensesEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Expenses expenses = new Expenses("exp02", 2000,
                new Date(2013, 10, 9), "fuel for diesel generator");
        
        expenses.setTypeId(new ExpenseType("ex01"));
        expenses.setSectionId(new FarmSection("SEC01"));
        instance.create(expenses);
        
        Double amount = new Double(3000);
        expenses.setAmount(amount);
        
        Expenses result = instance.update(expenses);
        assertEquals(amount, (Double)result.getAmount());
        
        instance.delete("exp02");
       
    }

    /**
     * Test of delete method, of class ExpensesEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Expenses expenses = new Expenses("exp02", 2000,
                new Date(2013, 10, 9), "fuel for diesel generator");
        
        expenses.setTypeId(new ExpenseType("ex01"));
        expenses.setSectionId(new FarmSection("SEC01"));
        instance.create(expenses);
        
        Expenses result = instance.get("exp02");
        assertNotNull(result);
        
        instance.delete("exp02");
        Expenses expResult = instance.get("exp02");
        assertNull(expResult);
                
       }

    /**
     * Test of get method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String id = "exp01";
        Expenses expResult = new Expenses("exp01");
        Expenses result = instance.get(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        
        int expResult = 3;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of count method, of class ExpensesEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }
    
        /**
     * Test of getExpensesByMonthAndYear method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesByMonthAndYear() throws Exception {
        System.out.println("getExpensesByMonthAndYear");
        int month = 6;
        int year = 2013-1900;
        
        List result = instance.getExpensesByMonthAndYear(month, year);
        assertEquals(1, result.size());
    }

    /**
     * Test of getExpensesByMonthYearAndExpenseType method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesByMonthYearAndExpenseType() throws Exception {
        System.out.println("getExpensesByMonthYearAndExpenseType");
        int month = 6;
        int year = 2013-1900;
        String typeId = "ex01";
        
        List result = instance.getExpensesByMonthYearAndExpenseType(month, year, typeId);
        assertEquals(1, result.size());
    }
//
    /**
     * Test of getExpensesBetween method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesBetween() throws Exception {
        System.out.println("getExpensesBetween");
        Date from = new Date(2013-1900, 6, 4);
        Date to = new Date(2013-1900, 6, 20);
       
        int expResult = 1;
        List result = instance.getExpensesBetween(from, to);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getExpensesByExpenseTypeBetween method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesByExpenseTypeBetween() throws Exception {
        System.out.println("getExpensesByExpenseTypeBetween");
        Date from = new Date(2013-1900, 6, 4);
        Date to = new Date(2013-1900, 6, 20);
       
        String typeId = "ex01";
        
        int expResult = 1;
        List result = instance.getExpensesByExpenseTypeBetween(from, to, typeId);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getExpensesBySectionMonthAndYear method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesBySectionMonthAndYear() throws Exception {
        System.out.println("getExpensesBySectionMonthAndYear");
        String sectionId = "SEC01";
        int month = 6;
        int year = 2013-1900;
        int expResult = 1;
        List result = instance.getExpensesBySectionMonthAndYear(sectionId, month, year);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getExpensesBySectionMonthYearAndExpenseType method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesBySectionMonthYearAndExpenseType() throws Exception {
        System.out.println("getExpensesBySectionMonthYearAndExpenseType");
        String sectionId = "SEC01";
        int month = 6;
        int year = 2013-1900;
        String typeId = "ex01";
        int expResult = 1;
        List result = instance.getExpensesBySectionMonthYearAndExpenseType
                (sectionId, month, year, typeId);
        assertEquals(expResult, result.size());
       
    }

    /**
     * Test of getExpensesBySectionAndBetween method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesBySectionAndBetween() throws Exception {
        System.out.println("getExpensesBySectionAndBetween");
        String sectionId = "SEC01";
        Date from = new Date(2013-1900, 6, 4);
        Date to = new Date(2013-1900, 6, 20);
        int expResult = 1;
        List result = instance.getExpensesBySectionAndBetween(sectionId, from, to);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getExpensesBySectionExpenseTypeAndBetween method, of class ExpenseEntityMngr.
     */
    @Test
    public void testGetExpensesBySectionExpenseTypeAndBetween() throws Exception {
        System.out.println("getExpensesBySectionExpenseTypeAndBetween");
        String sectionId = "SEC01";
        Date from = new Date(2013-1900, 6, 4);
        Date to = new Date(2013-1900, 6, 20);
        String typeId = "ex01";
        int expResult = 1;
        List result = instance.getExpensesBySectionExpenseTypeAndBetween
                (sectionId, from, to, typeId);
        assertEquals(expResult, result.size());
       
    }

    /**
     * Test of getExpensesBySection method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGetExpensesBySection_3args() throws Exception {
        System.out.println("getExpensesBySection");
        String sectionId = "SEC01";
        Date from = new Date(2013-1900, 6, 4);
        Date to = new Date(2013-1900, 6, 20);
        
       
        int expResult = 1;
        List result = instance.getExpensesBySection(sectionId, from, to);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getExpensesBySection method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGetExpensesBySection_4args() throws Exception {
        System.out.println("getExpensesBySection");
        String sectionId = "SEC01";
        Date from = new Date(2013-1900, 6, 4);
        Date to = new Date(2013-1900, 6, 20);
        String typeId = "ex01";
        
        int expResult = 1;
        List result = instance.getExpensesBySection(sectionId, from, to, typeId);
        assertEquals(expResult, result.size());
       
    }

    /**
     * Test of getExpensesBySection method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGetExpensesBySection_String() throws Exception {
        System.out.println("getExpensesBySection");
        String sectionId = "SEC01";
        
        int expResult = 1;
        List result = instance.getExpensesBySection(sectionId);
        assertEquals(expResult, result.size());
       
    }

    /**
     * Test of getExpensesBySection method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGetExpensesBySection_String_String() throws Exception {
        System.out.println("getExpensesBySection");
        String sectionId = "SEC01";
        String typeId = "ex01";
        
        int expResult = 1;
        List result = instance.getExpensesBySection(sectionId, typeId);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getExpensesByExpenseType method, of class ExpensesEntityMngr.
     */
    @Test
    public void testGetExpensesByExpenseType() throws Exception {
        System.out.println("getExpensesByExpenseType");
        String typeId = "ex01";
        
        int expResult = 1;
        List result = instance.getExpensesByExpenseType(typeId);
        assertEquals(expResult, result.size());
        
    }
}