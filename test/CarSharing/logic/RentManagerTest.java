/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.model.Auto;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Düring, Matti
 */
public class RentManagerTest {
    ArrayList<Auto> autos = new ArrayList<Auto>();
    
    public RentManagerTest() {
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
     * Test of getUnusedCars method, of class RentManager.
     */
    @Test
    public void testGetUnusedCars() {
        System.out.println("getUnusedCars");
        boolean expResult = true;
        boolean result = !(RentManager.getUnusedCars() == null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRentedCars method, of class RentManager.
     */
    @Test
    public void testGetRentedCars() {
        System.out.println("getRentedCars");
        int accID = 0;
        boolean expResult = true;
        boolean result = !(RentManager.getRentedCars(accID) == null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rentCar method, of class RentManager.
     */
    @Test
    public void testRentCar() {
        System.out.println("rentCar");
        String carName = "Audi Q7";
        int accID = 1;
        RentManager.rentCar(carName, accID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of releaseCar method, of class RentManager.
     */
    @Test
    public void testReleaseCar() {
        System.out.println("releaseCar");
        String carName = "Audi Q7";
        int accID = 1;
        RentManager.releaseCar(carName, accID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
