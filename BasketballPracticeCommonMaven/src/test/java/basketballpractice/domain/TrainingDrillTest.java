/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
public class TrainingDrillTest {
    
    public TrainingDrillTest() {
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
     * Test of setId method, of class TrainingDrill.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = -50;
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id);
                }
        );
        assertEquals("TrainingDrill ID can't be a negative number", exception.getMessage());
        int id2 = 7;
        try {
            instance.setId(id2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(id2, instance.getId());
    }

    
    /**
     * Test of setTraining method, of class TrainingDrill.
     */
    @Test
    public void testSetTraining() {
        System.out.println("setTraining");
        Training training = new Training(1, "", "Description of", new Coach(), new Coach());
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setTraining(training);
                }
        );
        assertEquals("Training must be fully initialized", exception.getMessage());
        Coach coach1 = new Coach(1, "Phil", "Jackson", "phil1234", "philjack", "philjackson@gmail.com");
        Coach coach2 = new Coach(2, "Doc", "Rivers", "doc123", "docrivers", "docrivers@gmail.com");
        Training training2 = new Training(1, "Good name", "Description of", coach1, coach2);
        try {
            instance.setTraining(training2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(training2, instance.getTraining());
    }

    
    /**
     * Test of setCreatedOn method, of class TrainingDrill.
     */
    @Test
    public void testSetCreatedOn() {
        System.out.println("setCreatedOn");
        Date createdOn = new Date(2020, 3, 3);
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setCreatedOn(createdOn);
                }
        );
        assertEquals("Date of creation must be today's date", exception.getMessage());
        Date createdOn2 = new Date();
        try {
            instance.setCreatedOn(createdOn2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(createdOn2, instance.getCreatedOn());
    }

    
    /**
     * Test of setDescription method, of class TrainingDrill.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDescription(description);
                }
        );
        assertEquals("Description must be at least 10 characters long", exception.getMessage());
        String description2 = "Shooting tournament";
        try {
            instance.setDescription(description2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(description2, instance.getDescription());
    }

    
    /**
     * Test of setDrill method, of class TrainingDrill.
     */
    @Test
    public void testSetDrill() {
        System.out.println("setDrill");
        Drill drill = new Drill(1, "Shooting", "");
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDrill(drill);
                }
        );
        assertEquals("Drill must be fully initialized.", exception.getMessage());
        Drill drill2 = new Drill(1, "Shooting", "Shooting exibition");
        try {
            instance.setDrill(drill2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(drill2, instance.getDrill());
    }

   
    /**
     * Test of setAssignee method, of class TrainingDrill.
     */
    @Test
    public void testSetAssignee() {
        System.out.println("setAssignee");
        Coach assignee = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "");
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setAssignee(assignee);
                }
        );
        assertEquals("Assignee must be fully initialized.", exception.getMessage());
        Coach assignee2 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        try {
            instance.setAssignee(assignee2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(assignee2, instance.getAssignee());
    }

    /**
     * Test of setAuthor method, of class TrainingDrill.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        Coach author = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "");
        TrainingDrill instance = new TrainingDrill();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setAuthor(author);
                }
        );
        assertEquals("Author must be fully initialized.", exception.getMessage());
        Coach author2 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        try {
            instance.setAuthor(author2);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDrillTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(author2, instance.getAuthor());
    }
}
