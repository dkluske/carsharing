/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.model.Kunde;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OnTheRockz
 */
public class LoginManagerTest {
    Kunde kunde = new Kunde("Schmidt", "Werner", "CarUser", 2);
    
    public LoginManagerTest() {
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
     * Test of checkLoginCredentials method, of class LoginManager.
     */
    @Test
    public void testCheckLoginCredentials() {
        System.out.println("checkLoginCredentials");
        String accName = "root";
        String accPass = "passwort";
        boolean expResult = true;
        boolean result = LoginManager.checkLoginCredentials(accName, accPass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getKunde method, of class LoginManager.
     */
    @Test
    public void testGetKunde() {
        Kunde kunde = new Kunde("Schmidt", "Werner", "CarUser", 2);
        System.out.println("getKunde");
        String accName = "CarUser";
        String expResult = kunde.toString();
        Kunde result = LoginManager.getKunde(accName);
        assertEquals(expResult, result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
