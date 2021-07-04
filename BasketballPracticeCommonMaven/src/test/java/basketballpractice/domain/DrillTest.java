/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    }
    
    @After
    public void tearDown() {
    }

        /**
     * Test of setId method, of class Drill.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = -10;
        Drill instance = new Drill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id);
                }
        );
        assertEquals("ID must be a positive number", exception.getMessage());
        int id2 = 5;
        try {
            instance.setId(id2);
        } catch (Exception ex) {
            Logger.getLogger(DrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(id2, instance.getId());
    }

    /**
     * Test of setName method, of class Drill.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Sh";
        Drill instance = new Drill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setName(name);
                }
        );
        assertEquals("Drill name must have at least 5 characters", exception.getMessage());
        String name2 = "Shooting";
        try {
            instance.setName(name2);
        } catch (Exception ex) {
            Logger.getLogger(DrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(name2, instance.getName());
    }

    /**
     * Test of setDescription method, of class Drill.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Shooting";
        Drill instance = new Drill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDescription(description);
                }
        );
        assertEquals("Drill description must have at least 10 characters", exception.getMessage());
        String description2 = "Shooting three pointers";
        try {
            instance.setDescription(description2);
        } catch (Exception ex) {
            Logger.getLogger(DrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(description2, instance.getDescription());
    }   
}
