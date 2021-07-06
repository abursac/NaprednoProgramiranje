/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.domain;

import java.util.ArrayList;
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
public class TrainingTest {
    
    Coach coachExample1;
    Coach coachExample2;
    Training instance;
    
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
        coachExample1 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "");
        coachExample2 = new Coach(1, "Aleksandar", "Bursac", "acobursac", "acobursac123", "acobursac18@gmail.com");
        instance = new Training();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class Training.
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
        assertEquals("Training ID can't be a negative number", exception.getMessage());
    }

    /**
     * Test of setId method, of class Training.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetId2() throws Exception {
        int id2 = 5;
        instance.setId(id2);
        assertEquals(id2, instance.getId());
    }
    
    /**
     * Test of setName method, of class Training.
     */
    @Test
    public void testSetName1() {
        System.out.println("setName");
        String name = "Tr";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setName(name);
                }
        );
        assertEquals("Training name must have at least 5 characters", exception.getMessage());
    }
    
    /**
     * Test of setName method, of class Training.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetName2() throws Exception {
        String name2 = "TrainingName";
        instance.setName(name2);
        assertEquals(name2, instance.getName());
    }

    /**
     * Test of setDescription method, of class Training.
     */
    @Test
    public void testSetDescription1() {
        System.out.println("setDescription");
        String description = "Desc";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setDescription(description);
                }
        );
        assertEquals("Training description must have at least 10 characters", exception.getMessage());
    }
    
    /**
     * Test of setDescription method, of class Training.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetDescription2() throws Exception {
        String description2 = "Description of a training";
        instance.setDescription(description2);
        assertEquals(description2, instance.getDescription());
    }

    /**
     * Test of setOwner method, of class Training.
     */
    @Test
    public void testSetOwner1() {
        System.out.println("setOwner");
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setOwner(coachExample1);
                }
        );
        assertEquals("Training owner must be fully initialized.", exception.getMessage());
    }
    
    /**
     * Test of setOwner method, of class Training.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetOwner2() throws Exception {
        instance.setOwner(coachExample2);
        assertEquals(coachExample2, instance.getOwner());
    }

    /**
     * Test of setAssignees method, of class Training.
     */
    @Test
    public void testSetAssignees1() {
        System.out.println("setAssignees");
        List<Coach> assignees = new ArrayList<>();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setAssignees(assignees);
                }
        );
        assertEquals("You must add at least one assignee.", exception.getMessage());
    }
    
    /**
     * Test of setAssignees method, of class Training.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetAssignees2() throws Exception {
        List<Coach> assignees2 = new ArrayList<>();
        assignees2.add(coachExample2);
        instance.setAssignees(assignees2);
        assertEquals(assignees2, instance.getAssignees());
    }
}
