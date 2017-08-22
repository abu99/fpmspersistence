/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.persistence.mngrs;

import com.fpms.persistence.entities.User;
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
public class UserEntityMngrTest {
    
    private static UserEntityMngrLocal instance;
    
    public UserEntityMngrTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = new ServiceLocator().lookup(UserEntityMngrLocal.class);
        
        Mock.setUpUser();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        Mock.cleanUpUser();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class UserEntityMngr.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        User user = new User("user001", "Abubakar Bello", "modibbos", "Farm Manager");
        
        User result = instance.create(user);
        User expResult = new User("user001");
        assertEquals(expResult, result);
        
        instance.delete("user001");
    }

    /**
     * Test of update method, of class UserEntityMngr.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        User user = new User("user001", "Abubakar Bello", "modibbos", "Farm Manager");
        instance.create(user);
        
        String userName= "Abubakar A Bello";
        user.setFullName(userName);
        User result = instance.update(user);
        assertEquals(userName, result.getFullName());
        
        instance.delete("user001");
    }

    /**
     * Test of delete method, of class UserEntityMngr.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        
        User user = new User("user001", "Abubakar Bello", "modibbos", "Farm Manager");
        instance.create(user);
        
        User result = instance.get("user001");
        assertNotNull(result);
        
        instance.delete("user001");
        
        
        User expResult = instance.get("user001");
        assertNull(expResult);
    }

    /**
     * Test of get method, of class UserEntityMngr.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String userId = "user002";
        
        User expResult = new User(userId);
        
        User result = instance.get(userId);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class UserEntityMngr.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        
        int expResult = 1;
        List result = instance.getAll();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of count method, of class UserEntityMngr.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }
}