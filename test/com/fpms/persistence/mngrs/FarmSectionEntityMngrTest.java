/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmSection;
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
public class FarmSectionEntityMngrTest {
    
    private static FarmSectionEntityMngrLocal instance;
    
    public FarmSectionEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        instance = new ServiceLocator().lookup(FarmSectionEntityMngrLocal.class);
        
        Mock.setUpSections();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
        
        Mock.cleanUpSections();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FarmSectionEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        FarmSection section = new FarmSection("SEC2", "fishing");
        FarmSection expResult = new FarmSection("SEC2");
        FarmSection result = instance.create(section);
        assertEquals(expResult, result);
        
        instance.delete("SEC2");
        
        
    }

    /**
     * Test of update method, of class FarmSectionEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        FarmSection section = new FarmSection("SEC2", "fishing");
        instance.create(section);
        String expResult = "farming";
        section.setSectionName(expResult);
        FarmSection result = instance.update(section);
        assertEquals(expResult, result.getSectionName());
        
        instance.delete("SEC2");
    }

    /**
     * Test of delete method, of class FarmSectionEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        
        String sectionId = "SEC2";
        FarmSection section = new FarmSection(sectionId, "fishing");
        instance.create(section);
        
        FarmSection result = instance.get(sectionId);
        assertNotNull(result);
        
        
        instance.delete(sectionId);
        
        FarmSection expResult = instance.get(sectionId);
        assertNull(expResult);
        
    }

    /**
     * Test of get method, of class FarmSectionEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String sectionId = "SEC01";
        FarmSection expResult = new FarmSection(sectionId);
        FarmSection result = instance.get(sectionId);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class FarmSectionEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        int expResult = 4;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
        }

    /**
     * Test of count method, of class FarmSectionEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        int expResult = 4;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }
}