/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.repository.db.impl;

import basketballpractice.domain.Coach;
import basketballpractice.domain.GenericEntity;
import basketballpractice.domain.Training;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksandar
 */
public class RepositoryDBGenericTest {
    
    RepositoryDBGeneric instance;
    Coach coach1;
    Coach coach2;
    
    public RepositoryDBGenericTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        instance = new RepositoryDBGeneric(true);
        coach1 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        coach2 = new Coach(2, "Phil", "Jackson", "philjackson", "philjackson123", "philjackson18@gmail.com");
    }
    
    @After
    public void tearDown() throws Exception {
        instance.rollback();
    }

    /**
     * Test of add method, of class RepositoryDBGeneric.
     * @throws java.lang.Exception
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        instance.add(coach1);
        instance.add(coach2);
        Training entity = new Training(1, "Running practice", "Running 10 miles", coach1, coach2);
        instance.add(entity);
        List<GenericEntity> tr1 = instance.getAll(entity);
        assertEquals(true, tr1.contains(entity));
    }

    /**
     * Test of getAll method, of class RepositoryDBGeneric.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        instance.add(coach1);
        instance.add(coach2);
        Training entity = new Training(1, "Running practice", "Running 10 miles", coach1, coach2);
        instance.add(entity);
        List<GenericEntity> result = instance.getAll(entity);
        assertEquals(Training.class, result.get(0).getClass());
    }

    /**
     * Test of edit method, of class RepositoryDBGeneric.
     * @throws java.lang.Exception
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        instance.add(coach1);
        instance.add(coach2);
        Training entity = new Training(1, "Running practice", "Running 10 miles", coach1, coach2);
        instance.add(entity);
        entity.setName("Running workout");
        instance.edit(entity);
        List<GenericEntity> list = instance.getAll(entity);
        assertEquals(true, list.contains(entity));
    }

    /**
     * Test of delete method, of class RepositoryDBGeneric.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("add");
        instance.add(coach1);
        instance.add(coach2);
        Training entity = new Training(1, "Running practice", "Running 10 miles", coach1, coach2);
        instance.add(entity);
        List<GenericEntity> tr1 = instance.getAll(entity);
        assertEquals(true, tr1.contains(entity));
        instance.delete(entity);
        List<GenericEntity> tr2 = instance.getAll(entity);
        assertEquals(false, tr2.contains(entity));
    }

}
