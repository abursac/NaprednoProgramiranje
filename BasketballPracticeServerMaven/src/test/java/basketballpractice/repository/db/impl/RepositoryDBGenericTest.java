/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository.db.impl;

import basketballpractice.domain.Coach;
import basketballpractice.domain.GenericEntity;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Aleksandar
 */
public class RepositoryDBGenericTest {
    
    public RepositoryDBGenericTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class RepositoryDBGeneric.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        RepositoryDBGeneric instance = new RepositoryDBGeneric();
        Coach coach1 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        Coach coach2 = new Coach(2, "Phil", "Jackson", "philjackson", "philjackson123", "philjackson18@gmail.com");
        instance.add(coach1);
        instance.add(coach2);
        Training entity = new Training(1, "Running practice", "Running 10 miles", coach1, coach2);
        
        instance.add(entity);
 
        List<GenericEntity> tr1 = instance.getAll(entity);
        assertEquals(true, tr1.contains(entity));
        instance.rollback();
        
        
    }

    /**
     * Test of getAll method, of class RepositoryDBGeneric.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        GenericEntity entity = null;
        RepositoryDBGeneric instance = new RepositoryDBGeneric();
        List<GenericEntity> expResult = null;
        List<GenericEntity> result = instance.getAll(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class RepositoryDBGeneric.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        GenericEntity entity = null;
        RepositoryDBGeneric instance = new RepositoryDBGeneric();
        instance.edit(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RepositoryDBGeneric.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        GenericEntity entity = null;
        RepositoryDBGeneric instance = new RepositoryDBGeneric();
        instance.delete(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class RepositoryDBGeneric.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        GenericEntity entity = null;
        RepositoryDBGeneric instance = new RepositoryDBGeneric();
        GenericEntity expResult = null;
        GenericEntity result = instance.getById(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAssignees method, of class RepositoryDBGeneric.
     */
    @Test
    public void testAddAssignees() {
        System.out.println("addAssignees");
        Training training = null;
        RepositoryDBGeneric instance = new RepositoryDBGeneric();
        instance.addAssignees(training);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
