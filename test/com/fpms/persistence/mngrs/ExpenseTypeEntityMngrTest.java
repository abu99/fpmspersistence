/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ExpenseType;
import com.fpms.persistence.test.common.ServiceLocator;
import java.util.List;
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
public class ExpenseTypeEntityMngrTest {
    
    private static ExpenseTypeEntityMngrLocal instance;
    
    public ExpenseTypeEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        instance = new ServiceLocator().lookup(ExpenseTypeEntityMngrLocal.class);
        
        Mock.setUpExpenseType();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        
        Mock.cleanUpExpenseType();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ExpenseTypeEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ExpenseType expenseType = new ExpenseType("ex02", "staff payment");
       
        ExpenseType expResult = new ExpenseType("ex02");
        ExpenseType result = instance.create(expenseType);
        assertEquals(expResult, result);
        
        instance.delete("ex02");
    }

    /**
     * Test of update method, of class ExpenseTypeEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ExpenseType expenseType = new ExpenseType("ex02", "bills");
        instance.create(expenseType);
        
        String expResult = "transportation";
        expenseType.setTypeName(expResult);
        ExpenseType result = instance.update(expenseType);
        assertEquals(expResult, result.getTypeName());
        
        instance.delete("ex02");
    }

    /**
     * Test of delete method, of class ExpenseTypeEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        ExpenseType expenseType = new ExpenseType("ex02", "bills");
        instance.create(expenseType);
        
        ExpenseType result =  instance.get("ex02");
        assertNotNull(result);
        
        instance.delete("ex02");
        
        ExpenseType expResult =  instance.get("ex02");
        assertNull(expResult);
    }

    /**
     * Test of get method, of class ExpenseTypeEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String exTypeId = "ex01";
        ExpenseType expResult = new ExpenseType("ex01");
        ExpenseType result = instance.get(exTypeId);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class ExpenseTypeEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        
        int expResult = 3;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of count method, of class ExpenseTypeEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }
}