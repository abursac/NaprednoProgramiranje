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
public class CoachTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class Coach.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id1 = -1;
        Coach instance = new Coach();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setId(id1);
                }
        );
        assertEquals("ID must be 0 or larger number", exception.getMessage());
        int id2 = 1;
        try {
            instance.setId(id2);
        } catch (Exception ex) {
            Logger.getLogger(CoachTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(id2, instance.getId());
    }

    /**
     * Test of setFirstname method, of class Coach.
     */
    @Test
    public void testSetFirstname() {
        System.out.println("setFirstname");
        String firstname = "T";
        Coach instance = new Coach();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setFirstname(firstname);
                }
        );
        assertEquals("First name must have at least 2 characters", exception.getMessage());
        String firstname2 = "Aleksandar";
        try {
            instance.setFirstname(firstname2);
        } catch (Exception ex) {
            Logger.getLogger(CoachTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(firstname2, instance.getFirstname());
    }

    /**
     * Test of setLastname method, of class Coach.
     */
    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lastname = "V";
        Coach instance = new Coach();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setLastname(lastname);
                }
        );
        assertEquals("Last name must have at least 2 characters", exception.getMessage());
        String lastname2 = "Bursac";
        try {
            instance.setLastname(lastname2);
        } catch (Exception ex) {
            Logger.getLogger(CoachTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(lastname2, instance.getLastname());
    }

    /**
     * Test of setUsername method, of class Coach.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "is";
        Coach instance = new Coach();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setUsername(username);
                }
        );
        assertEquals("Username must have at least 4 characters", exception.getMessage());
        String username2 = "acobursac";
        try {
            instance.setUsername(username2);
        } catch (Exception ex) {
            Logger.getLogger(CoachTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(username2, instance.getUsername());
    }

    /**
     * Test of setPassword method, of class Coach.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "sifra";
        Coach instance = new Coach();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setPassword(password);
                }
        );
        assertEquals("Password must have at least 8 characters", exception.getMessage());
        String password2 = "acobursac123";
        try {
            instance.setPassword(password2);
        } catch (Exception ex) {
            Logger.getLogger(CoachTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(password2, instance.getPassword());
    }

    /**
     * Test of setEmail method, of class Coach.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "acobursac18@gmail.co";
        Coach instance = new Coach();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    instance.setEmail(email);
                }
        );
        assertEquals("E-mail must finish with '.com'", exception.getMessage());
        String email2 = "acobursac18@gmail.com";
        try {
            instance.setEmail(email2);
        } catch (Exception ex) {
            Logger.getLogger(CoachTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(email2, instance.getEmail());
    }

}
