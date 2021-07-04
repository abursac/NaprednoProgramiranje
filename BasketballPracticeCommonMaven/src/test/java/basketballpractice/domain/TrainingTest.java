/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
public class TrainingTest {
    
    public TrainingTest() {
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
     * Test of setId method, of class Training.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = -10;
        Training instance = new Training();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id);
                }
        );
        assertEquals("Training ID can't be a negative number", exception.getMessage());
        int id2 = 5;
        try {
            instance.setId(id2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(id2, instance.getId());
    }

    /**
     * Test of setName method, of class Training.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Tr";
        Training instance = new Training();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setName(name);
                }
        );
        assertEquals("Training name must have at least 5 characters", exception.getMessage());
        String name2 = "TrainingName";
        try {
            instance.setName(name2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(name2, instance.getName());
    }

    /**
     * Test of setDescription method, of class Training.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Desc";
        Training instance = new Training();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDescription(description);
                }
        );
        assertEquals("Training description must have at least 10 characters", exception.getMessage());
        String description2 = "Description of a training";
        try {
            instance.setDescription(description2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(description2, instance.getDescription());
    }

    /**
     * Test of setOwner method, of class Training.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        Coach owner = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "");
        Training instance = new Training();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setOwner(owner);
                }
        );
        assertEquals("Training owner must be fully initialized.", exception.getMessage());
        Coach owner2 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        try {
            instance.setOwner(owner2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(owner2, instance.getOwner());
    }

    /**
     * Test of setAssignees method, of class Training.
     */
    @Test
    public void testSetAssignees() {
        System.out.println("setAssignees");
        List<Coach> assignees = new ArrayList<Coach>();
        Training instance = new Training();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setAssignees(assignees);
                }
        );
        assertEquals("You must add at least one assignee.", exception.getMessage());
        Coach coach = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        List<Coach> assignees2 = new ArrayList<>();
        assignees2.add(coach);
        try {
            instance.setAssignees(assignees2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(assignees2, instance.getAssignees());
    }
}
