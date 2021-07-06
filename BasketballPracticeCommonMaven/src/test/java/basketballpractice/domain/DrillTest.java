/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

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
public class DrillTest {
    
    Drill instance;
    
    public DrillTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Drill();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class Drill.
     */
    @Test
    public void testSetId1() {
        System.out.println("setId");
        int id = -10;
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id);
                }
        );
        assertEquals("ID must be a positive number", exception.getMessage());
    }

    /**
     * Test of setId method, of class Drill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetId2() throws Exception {
        int id2 = 5;
        instance.setId(id2);
        assertEquals(id2, instance.getId());
    }
    
    /**
     * Test of setName method, of class Drill.
     */
    @Test
    public void testSetName1() {
        System.out.println("setName");
        String name = "Sh";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setName(name);
                }
        );
        assertEquals("Drill name must have at least 5 characters", exception.getMessage());
    }
    
    /**
     * Test of setName method, of class Drill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetName2() throws Exception {
        String name2 = "Shooting";
        instance.setName(name2);
        assertEquals(name2, instance.getName());
    }

    /**
     * Test of setDescription method, of class Drill.
     */
    @Test
    public void testSetDescription1() {
        System.out.println("setDescription");
        String description = "Shooting";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDescription(description);
                }
        );
        assertEquals("Drill description must have at least 10 characters", exception.getMessage());
    }
    
    /**
     * Test of setDescription method, of class Drill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetDescription2() throws Exception {
        String description2 = "Shooting three pointers";
        instance.setDescription(description2);
        assertEquals(description2, instance.getDescription());
    }
}
