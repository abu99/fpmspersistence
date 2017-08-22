/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.ProductOtherUnits;
import com.fpms.persistence.entities.ProductOtherUnitsPK;
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
public class ProductOtherUnitsEntityMngrTest {
    private static ProductOtherUnitsEntityMngrLocal instance;
    
    public ProductOtherUnitsEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = new ServiceLocator().
                lookup(ProductOtherUnitsEntityMngrLocal.class);
        Mock.setUpProductOtherUnits();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        
        Mock.cleanUpProductOtherUnits();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProductOtherUnitsEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ProductOtherUnitsPK PoUPK = new ProductOtherUnitsPK("prod1", "SEC01", "sachet");
                
        ProductOtherUnits otherUnits = new ProductOtherUnits();
        otherUnits.setProductOtherUnitsPK(PoUPK);
        otherUnits.setCount(10);
        
        ProductOtherUnits expResult = new ProductOtherUnits(PoUPK);
        ProductOtherUnits result = instance.create(otherUnits);
        assertEquals(expResult, result);
        
        instance.delete("prod1", "SEC01", "sachet");
       
    }

    /**
     * Test of update method, of class ProductOtherUnitsEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ProductOtherUnitsPK PoUPK = new ProductOtherUnitsPK("prod1", "SEC01", "sachet");
                
        ProductOtherUnits otherUnits = new ProductOtherUnits();
        otherUnits.setProductOtherUnitsPK(PoUPK);
        otherUnits.setCount(10);
        instance.create(otherUnits);
        
        int count = 12;
        otherUnits.setCount(count);
        ProductOtherUnits result = instance.update(otherUnits);
        assertEquals(count, result.getCount());
        
        instance.delete("prod1", "SEC01", "sachet");
        
    }

    /**
     * Test of delete method, of class ProductOtherUnitsEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        ProductOtherUnitsPK PoUPK = new ProductOtherUnitsPK("prod1", "SEC01", "sachet");
                
        ProductOtherUnits otherUnits = new ProductOtherUnits();
        otherUnits.setProductOtherUnitsPK(PoUPK);
        otherUnits.setCount(10);
        instance.create(otherUnits);
        
        ProductOtherUnits result = instance.get("prod1", "SEC01", "sachet");
        assertNotNull(result);
       
        instance.delete("prod1", "SEC01", "sachet");
        
        ProductOtherUnits expResult = instance.get("prod1", "SEC01", "sachet");
        assertNull(expResult);
        
    }

    /**
     * Test of get method, of class ProductOtherUnitsEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        ProductOtherUnitsPK otherUnitsPK = new 
                ProductOtherUnitsPK("prod1", "SEC01", "pack");
        
        ProductOtherUnits expResult = new ProductOtherUnits(otherUnitsPK);
        ProductOtherUnits result = instance.get("prod1", "SEC01", "pack");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class ProductOtherUnitsEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        
        int expResult = 3;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of count method, of class ProductOtherUnitsEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }
}