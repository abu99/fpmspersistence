/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.Stock;
import com.fpms.persistence.entities.StockPK;
import com.fpms.persistence.test.common.ServiceLocator;
import java.util.Date;
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
public class StockEntityMngrTest {
    
    private static StockEntityMngrLocal instance;
    
    public StockEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        instance = new ServiceLocator().lookup(StockEntityMngrLocal.class);
        
        Mock.setUpStock();
        
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        
        Mock.cleanUpStock();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class StockEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        StockPK stockPK = new StockPK("prod1", "SEC01",new Date(2013, 7, 15));
        Stock stock = new Stock(stockPK, 12, 10000, "IN", "12 sacks of grains ");
        
        Stock expResult = new Stock(stockPK);
        Stock result = instance.create(stock);
        assertEquals(expResult, result);
        
        instance.delete("prod1", "SEC01",new Date(2013, 7, 15));
        
    }

    /**
     * Test of update method, of class StockEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        StockPK stockPK = new StockPK("prod1", "SEC01",new Date(2013, 7, 15));
        Stock stock = new Stock(stockPK, 12, 10000, "IN", "12 sacks of grains ");
        instance.create(stock);
        
        int quantity = 24;
        stock.setQuatity(24);
        
        Stock result = instance.update(stock);
        assertEquals(quantity, result.getQuatity());
        
        instance.delete("prod1", "SEC01",new Date(2013, 7, 15));
        
    }

    /**
     * Test of delete method, of class StockEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        StockPK stockPK = new StockPK("prod1", "SEC01",new Date(2013, 7, 15));
        Stock stock = new Stock(stockPK, 12, 10000, "IN", "12 sacks of grains ");
        instance.create(stock);   
        
        Stock result = instance.get("prod1", "SEC01",new Date(2013, 7, 15));
        assertNotNull(result);
        
        instance.delete("prod1", "SEC01",new Date(2013, 7, 15));
        
        Stock expResult = instance.get("prod1", "SEC01",new Date(2013, 7, 15));
        assertNull(expResult);
        
    }

    /**
     * Test of get method, of class StockEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        StockPK stockPK = new StockPK("prod1", "SEC01",new Date(2011-1900, 0, 1));
        Stock expResult = new Stock(stockPK);
        Stock result = instance.get("prod1", "SEC01",new Date(2011-1900, 0, 1));
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class StockEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        
        int expResult = 3;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of count method, of class StockEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getStocksBetween method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksBetween() throws Exception {
        System.out.println("getStocksBetween");
        Date from = new Date(2010-1900, 11, 1);
        Date to = new Date(2011-1900, 2, 27);
        
        int expResult = 1;
        List result = instance.getStocksBetween(from, to);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksBetweenAndStockType method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksBetweenAndStockType() throws Exception {
        System.out.println("getStocksBetweenAndStockType");
        Date from = new Date(2010-1900, 11, 1);
        Date to = new Date(2011-1900, 2, 27);
        String stockType = "IN";
        
        int expResult = 1;
        List result = instance.getStocksBetweenAndStockType(from, to, stockType);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksBySectionBetween method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksBySectionBetween() throws Exception {
        System.out.println("getStocksBySectionBetween");
        String sectionId = "SEC01";
        Date from = new Date(2010-1900, 11, 1);
        Date to = new Date(2011-1900, 2, 27);
        
        int expResult = 1;
        List result = instance.getStocksBySectionBetween(sectionId, from, to);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStockBySectionAndStockTypeBetween method, of class StockEntityMngr.
     */
    @Test
    public void testGetStockBySectionAndStockTypeBetween() throws Exception {
        System.out.println("getStockBySectionAndStockTypeBetween");
        String sectionId = "SEC01";
        Date from = new Date(2010-1900, 11, 1);
        Date to = new Date(2011-1900, 2, 27);
        String stockType = "IN";
        
        int expResult = 1;
        List result = instance.getStockBySectionAndStockTypeBetween(sectionId, from, to, stockType);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksByproductBetween method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksByproductBetween() throws Exception {
        System.out.println("getStocksByproductBetween");
        String productId = "prod1";
        Date from = new Date(2010-1900, 11, 1);
        Date to = new Date(2011-1900, 2, 27);
        
        int expResult = 1;
        List result = instance.getStocksByproductBetween(productId, from, to);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksByProductAndStockTypeBetween method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksByProductAndStockTypeBetween() throws Exception {
        System.out.println("getStocksByProductAndStockTypeBetween");
        String productId = "prod1";
        Date from = new Date(2010-1900, 11, 1);
        Date to = new Date(2011-1900, 2, 27);
        String stockType = "IN";
        
        int expResult = 1;
        List result = instance.getStocksByProductAndStockTypeBetween(productId, from, to, stockType);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksBySection method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksBySection() throws Exception {
        System.out.println("getStocksBySection");
        String sectionId = "SEC01";
        
        int expResult = 1;
        List result = instance.getStocksBySection(sectionId);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStockByProduct method, of class StockEntityMngr.
     */
    @Test
    public void testGetStockByProduct() throws Exception {
        System.out.println("getStockByProduct");
        String productId = "prod1";
        
        int expResult = 1;
        List result = instance.getStockByProduct(productId);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksByStockType method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksByStockType() throws Exception {
        System.out.println("getStocksByStockType");
        String stockType = "IN";
       
        int expResult = 2;
        List result = instance.getStocksByStockType(stockType);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getStocksByProductAndSection method, of class StockEntityMngr.
     */
    @Test
    public void testGetStocksByProductAndSection() throws Exception {
        System.out.println("getStocksByProductAndSection");
        String productId = "prod1";
        String sectionId = "SEC01";
        
        int expResult = 1;
        List result = instance.getStocksByProductAndSection(productId, sectionId);
        assertEquals(expResult, result.size());
        
    }
}