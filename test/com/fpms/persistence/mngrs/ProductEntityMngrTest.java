/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.Product;
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
public class ProductEntityMngrTest {

    private static ProductEntityMngrLocal instance;

    public ProductEntityMngrTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = new ServiceLocator().lookup(ProductEntityMngrLocal.class);

        Mock.setUpProduct();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        Mock.cleanUpProduct();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProductEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Product product = new Product("prod2", "Egg", "crate");
        product.setSectionId(new FarmSection("SEC02"));
        

        Product expResult = new Product("prod2");
        Product result = instance.create(product);
        assertEquals(expResult, result);

        instance.delete("prod2");

    }

    /**
     * Test of update method, of class ProductEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");

        Product product = new Product("prod2", "Egg", "crate");
        product.setSectionId(new FarmSection("SEC02"));
        instance.create(product);

        String productName = "kwai";
        product.setProductName(productName);
        Product result = instance.update(product);
        assertEquals(productName, result.getProductName());

        instance.delete("prod2");
    }

    /**
     * Test of delete method, of class ProductEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");

        Product product = new Product("prod2", "Egg", "crate");
        product.setSectionId(new FarmSection("SEC02"));
        instance.create(product);

        Product result = instance.get("prod2");
        assertNotNull(result);

        instance.delete("prod2");

        Product expResult = instance.get("prod2");
        assertNull(expResult);
    }

    /**
     * Test of get method, of class ProductEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String productId = "prod1";

        Product expResult = new Product("prod1");
        Product result = instance.get(productId);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAll method, of class ProductEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        int expResult = 3;
        List result = instance.getAll();
        assertEquals(expResult, result.size());

    }

    /**
     * Test of count method, of class ProductEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");

        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);

    }

    /**
     * Test of getProducts method, of class ProductEntityMngr.
     */
    @Test
    public void testGetProducts() throws Exception {
        System.out.println("getProducts");
        String sectionId = "SEC01";
        
        int expResult = 1;
        List result = instance.getProducts(sectionId);
        assertEquals(expResult, result.size());
        
    }
}