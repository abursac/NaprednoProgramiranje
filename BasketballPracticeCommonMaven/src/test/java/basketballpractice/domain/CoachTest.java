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
public class CoachTest {
    
    Coach instance;
    
    public CoachTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Coach();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class Coach.
     */
    @Test
    public void testSetId1() {
        System.out.println("setId");
        int id1 = -1;
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id1);
                }
        );
        assertEquals("ID must be 0 or larger number", exception.getMessage());
    }
    
    /**
     * Test of setId method, of class Coach.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetId2() throws Exception {
        int id2 = 1;
        instance.setId(id2);
        assertEquals(id2, instance.getId());
    }

    /**
     * Test of setFirstname method, of class Coach.
     */
    @Test
    public void testSetFirstname1() {
        System.out.println("setFirstname");
        String firstname = "T";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setFirstname(firstname);
                }
        );
        assertEquals("First name must have at least 2 characters", exception.getMessage());
    }

    /**
     * Test of setFirstname method, of class Coach.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetFirstname2() throws Exception {
        String firstname2 = "Aleksandar";
        instance.setFirstname(firstname2);
        assertEquals(firstname2, instance.getFirstname());
    }
    
    /**
     * Test of setLastname method, of class Coach.
     */
    @Test
    public void testSetLastname1() {
        System.out.println("setLastname");
        String lastname = "V";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setLastname(lastname);
                }
        );
        assertEquals("Last name must have at least 2 characters", exception.getMessage());
    }

    /**
     * Test of setLastname method, of class Coach.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetLastname2() throws Exception {
        String lastname2 = "Bursac";
        instance.setLastname(lastname2);
        assertEquals(lastname2, instance.getLastname());
    }
    
    /**
     * Test of setUsername method, of class Coach.
     */
    @Test
    public void testSetUsername1() {
        System.out.println("setUsername");
        String username = "is";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setUsername(username);
                }
        );
        assertEquals("Username must have at least 4 characters", exception.getMessage());
    }

    /**
     * Test of setUsername method, of class Coach.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetUsername2() throws Exception {
        String username2 = "acobursac";
        instance.setUsername(username2);
        assertEquals(username2, instance.getUsername());
    }
    
    /**
     * Test of setPassword method, of class Coach.
     */
    @Test
    public void testSetPassword1() {
        System.out.println("setPassword");
        String password = "sifra";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setPassword(password);
                }
        );
        assertEquals("Password must have at least 8 characters", exception.getMessage());
    }

    /**
     * Test of setPassword method, of class Coach.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetPassword2() throws Exception {
        String password2 = "acobursac123";
        instance.setPassword(password2);
        assertEquals(password2, instance.getPassword());
    }
    
    /**
     * Test of setEmail method, of class Coach.
     */
    @Test
    public void testSetEmail1() {
        System.out.println("setEmail");
        String email = "acobursac18@gmail.co";
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setEmail(email);
                }
        );
        assertEquals("E-mail must finish with '.com'", exception.getMessage());
    }

    /**
     * Test of setEmail method, of class Coach.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetEmail2() throws Exception {
        String email2 = "acobursac18@gmail.com";
        instance.setEmail(email2);
        assertEquals(email2, instance.getEmail());
    }
}
