/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketballpractice.communication;

import basketballpractice.domain.Coach;
import basketballpractice.domain.Drill;
import basketballpractice.domain.Training;
import basketballpractice.domain.TrainingDrill;
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
public class CommunicationTest {
    
    public CommunicationTest() {
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
     * Test of login method, of class Communication.
     */
    @org.junit.Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String username = "";
        String password = "";
        Communication instance = null;
        Coach expResult = null;
        Coach result = instance.login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCoaches method, of class Communication.
     */
    @org.junit.Test
    public void testGetAllCoaches() throws Exception {
        System.out.println("getAllCoaches");
        Communication instance = null;
        List<Coach> expResult = null;
        List<Coach> result = instance.getAllCoaches();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTrainings method, of class Communication.
     */
    @org.junit.Test
    public void testGetAllTrainings() throws Exception {
        System.out.println("getAllTrainings");
        Communication instance = null;
        List<Training> expResult = null;
        List<Training> result = instance.getAllTrainings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTraining method, of class Communication.
     */
    @org.junit.Test
    public void testAddTraining() throws Exception {
        System.out.println("addTraining");
        Training training = null;
        Communication instance = null;
        instance.addTraining(training);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editTraining method, of class Communication.
     */
    @org.junit.Test
    public void testEditTraining() throws Exception {
        System.out.println("editTraining");
        Training training = null;
        Communication instance = null;
        instance.editTraining(training);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTraining method, of class Communication.
     */
    @org.junit.Test
    public void testDeleteTraining() throws Exception {
        System.out.println("deleteTraining");
        Training training = null;
        Communication instance = null;
        instance.deleteTraining(training);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTrainingDrills method, of class Communication.
     */
    @org.junit.Test
    public void testGetAllTrainingDrills() throws Exception {
        System.out.println("getAllTrainingDrills");
        Training training = null;
        Communication instance = null;
        List<TrainingDrill> expResult = null;
        List<TrainingDrill> result = instance.getAllTrainingDrills(training);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTrainingDrill method, of class Communication.
     */
    @org.junit.Test
    public void testAddTrainingDrill() throws Exception {
        System.out.println("addTrainingDrill");
        TrainingDrill trainingDrill = null;
        Communication instance = null;
        instance.addTrainingDrill(trainingDrill);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editTrainingDrill method, of class Communication.
     */
    @org.junit.Test
    public void testEditTrainingDrill() throws Exception {
        System.out.println("editTrainingDrill");
        TrainingDrill trainingDrill = null;
        Communication instance = null;
        instance.editTrainingDrill(trainingDrill);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTrainingDrill method, of class Communication.
     */
    @org.junit.Test
    public void testDeleteTrainingDrill() throws Exception {
        System.out.println("deleteTrainingDrill");
        TrainingDrill trainingDrill = null;
        Communication instance = null;
        instance.deleteTrainingDrill(trainingDrill);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDrills method, of class Communication.
     */
    @org.junit.Test
    public void testGetAllDrills() throws Exception {
        System.out.println("getAllDrills");
        Communication instance = null;
        List<Drill> expResult = null;
        List<Drill> result = instance.getAllDrills();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrainingDrillById method, of class Communication.
     */
    @org.junit.Test
    public void testGetTrainingDrillById() throws Exception {
        System.out.println("getTrainingDrillById");
        TrainingDrill trainingDrill = null;
        Communication instance = null;
        TrainingDrill expResult = null;
        TrainingDrill result = instance.getTrainingDrillById(trainingDrill);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Communication.
     */
    @org.junit.Test
    public void testLogout() throws Exception {
        System.out.println("logout");
        Communication instance = null;
        instance.logout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
