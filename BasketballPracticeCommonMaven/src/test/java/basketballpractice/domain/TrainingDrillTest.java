/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.util.Date;
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
    Coach coachExample1;
    Coach coachExample2;
    TrainingDrill instance;
    
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
        instance = new TrainingDrill();
        coachExample1 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "");
        coachExample2 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
    }
    
    @After
    public void tearDown() {
    }

   
    /**
     * Test of setId method, of class TrainingDrill.
     */
    @Test
    public void testSetId1() {
        System.out.println("setId");
        int id = -50;
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id);
                }
        );
        assertEquals("TrainingDrill ID can't be a negative number", exception.getMessage());
    }

    /**
     * Test of setId method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetId2() throws Exception {
        int id2 = 7;
        instance.setId(id2);
        assertEquals(id2, instance.getId());
    }
    
    /**
     * Test of setTraining method, of class TrainingDrill.
     */
    @Test
    public void testSetTraining1() {
        System.out.println("setTraining");
        Training training = new Training(1, "", "Description of", new Coach(), new Coach());
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setTraining(training);
                }
        );
        assertEquals("Training must be fully initialized", exception.getMessage());
    }

    /**
     * Test of setTraining method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetTraining2() throws Exception {
        Coach coach1 = new Coach(1, "Phil", "Jackson", "phil1234", "philjack", "philjackson@gmail.com");
        Coach coach2 = new Coach(2, "Doc", "Rivers", "doc123", "docrivers", "docrivers@gmail.com");
        Training training2 = new Training(1, "Good name", "Description of", coach1, coach2);
        instance.setTraining(training2);
        assertEquals(training2, instance.getTraining());
    }
    
    /**
     * Test of setCreatedOn method, of class TrainingDrill.
     */
    @Test
    public void testSetCreatedOn1() {
        System.out.println("setCreatedOn");
        Date createdOn = new Date(2020, 3, 3);
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setCreatedOn(createdOn);
                }
        );
        assertEquals("Date of creation must be today's date", exception.getMessage());
    }

    /**
     * Test of setCreatedOn method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetCreatedOn2() throws Exception {
        Date createdOn2 = new Date();
        instance.setCreatedOn(createdOn2);
        assertEquals(createdOn2, instance.getCreatedOn());
    }
    
    /**
     * Test of setDescription method, of class TrainingDrill.
     */
    @Test
    public void testSetDescription1() {
        System.out.println("setDescription");
        String description = "";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDescription(description);
                }
        );
        assertEquals("Description must be at least 10 characters long", exception.getMessage());
    }

    /**
     * Test of setDescription method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetDescription2() throws Exception {
        String description2 = "Shooting tournament";
        instance.setDescription(description2);
        assertEquals(description2, instance.getDescription());
    }
    
    /**
     * Test of setDrill method, of class TrainingDrill.
     */
    @Test
    public void testSetDrill1() {
        System.out.println("setDrill");
        Drill drill = new Drill(1, "Shooting", "");
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDrill(drill);
                }
        );
        assertEquals("Drill must be fully initialized.", exception.getMessage());
    }

    /**
     * Test of setDrill method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetDrill2() throws Exception {
        Drill drill2 = new Drill(1, "Shooting", "Shooting exibition");
        instance.setDrill(drill2);
        assertEquals(drill2, instance.getDrill());
    }
   
    /**
     * Test of setAssignee method, of class TrainingDrill.
     */
    @Test
    public void testSetAssignee1() {
        System.out.println("setAssignee");
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setAssignee(coachExample1);
                }
        );
        assertEquals("Assignee must be fully initialized.", exception.getMessage());
    }

    /**
     * Test of setAssignee method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetAssignee2() throws Exception {
        instance.setAssignee(coachExample2);
        assertEquals(coachExample2, instance.getAssignee());
    }
    
    /**
     * Test of setAuthor method, of class TrainingDrill.
     */
    @Test
    public void testSetAuthor1() {
        System.out.println("setAuthor");
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setAuthor(coachExample1);
                }
        );
        assertEquals("Author must be fully initialized.", exception.getMessage());
    }
    
    /**
     * Test of setAuthor method, of class TrainingDrill.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetAuthor2() throws Exception {
        instance.setAuthor(coachExample2);
        assertEquals(coachExample2, instance.getAuthor());
    }
}
