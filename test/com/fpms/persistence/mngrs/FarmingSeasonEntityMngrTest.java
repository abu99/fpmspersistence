/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.FarmingSeason;
import com.fpms.persistence.entities.FarmingSeasonPK;
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
public class FarmingSeasonEntityMngrTest {
    private static FarmingSeasonEntityMngrLocal instance;
    
    public FarmingSeasonEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        instance = new ServiceLocator().lookup(FarmingSeasonEntityMngrLocal.class);
        
        Mock.setUpSeason();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
        Mock.cleanUpSeason();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FarmingSeasonEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        FarmingSeasonPK seasonPk = new FarmingSeasonPK("SEC02", new Date(2012, 9, 1));
        
        FarmingSeason season = new FarmingSeason();
        season.setFarmingSeasonPK(seasonPk);
        season.setEndDate(new Date(2013, 10, 1));
       
        FarmingSeason expResult = new FarmingSeason("SEC02", new Date(2012, 9, 1));
        FarmingSeason result = instance.create(season);
        assertEquals(expResult, result);
        
        instance.delete("SEC02", new Date(2012, 9, 1));
    }

    /**
     * Test of update method, of class FarmingSeasonEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        FarmingSeasonPK seasonPk = new FarmingSeasonPK("SEC02", new Date(2010, 9, 1));
        
        FarmingSeason season = new FarmingSeason();
        season.setFarmingSeasonPK(seasonPk);
        season.setEndDate(new Date(2013, 10, 1));
        instance.create(season);
        
        Date d = new Date(2013,9,1);
        season.setEndDate(d);
        FarmingSeason result = instance.update(season);
        assertEquals(d, result.getEndDate());
        
        instance.delete("SEC02", new Date(2010, 9, 1));
    
    }

    /**
     * Test of delete method, of class FarmingSeasonEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        FarmingSeasonPK seasonPk = new FarmingSeasonPK("SEC02", new Date(2010, 9, 1));
        
        FarmingSeason season = new FarmingSeason();
        season.setFarmingSeasonPK(seasonPk);
        season.setEndDate(new Date(2013, 10, 1));
        instance.create(season);
        
        FarmingSeason result = instance.get("SEC02", new Date(2010, 9, 1));
        assertNotNull(result);
        
        instance.delete("SEC02", new Date(2010, 9, 1));
        
        FarmingSeason expResult = instance.get("SEC02", new Date(2010, 9, 1));
        assertNull(expResult);
        }

    /**
     * Test of get method, of class FarmingSeasonEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        FarmingSeasonPK seasonPK = new FarmingSeasonPK("SEC01", new Date(2012-1900, 9, 1));
        FarmingSeason expResult = new FarmingSeason(seasonPK);
        FarmingSeason result = instance.get("SEC01", new Date(2012-1900, 9, 1));
        assertEquals(expResult, result);
        
       
        
    }
//
//    /**
//     * Test of getAll method, of class FarmingSeasonEntityMngr.
//     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        
        int expResult = 3;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of count method, of class FarmingSeasonEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }
}