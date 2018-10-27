/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import org.junit.Test;
import static org.junit.Assert.*;
//import 
/**
 *
 * @author Emmanuel Abunyaah
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    /**
     * Test of harvestResources method, of class GameControl.
     */
//    @Test
//    public void testHarvestResources() {
//    }
//
//    /**
//     * Test of deliverResources method, of class GameControl.
//     */
//    @Test
//    public void testDeliverResources() {
//    }

    /**
     * Test of calculateVolume method, of class GameControl.
     */
    @Test
    public void testCalculateVolume() {
      double diameter;
      double height;
      double expResult;
      double result;
      
      System.out.println("calculatVolumeTest");
      
      System.out.println("test 1");
      diameter = 5;
      height = 10;
      expResult = 196.35;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);  

      System.out.println("test 2");
      diameter = -1;
      height = 10;
      expResult = -1;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);  
      
      System.out.println("test 3");
      diameter = 2;
      height = -1;
      expResult = -2;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);
      
      System.out.println("test 4");
      diameter = 0;
      height = 5;
      expResult = 0;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);
      
      System.out.println("test 5");
      diameter = 2;
      height = 0;
      expResult = 0;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);
      
      System.out.println("test 6");
      diameter = 100;
      height = 10;
      expResult = 78539.81633;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);
      
      System.out.println("test 7");
      diameter = 20;
      height = 200;
      expResult = 62831.8530;
      result = GameControl.calculateVolume(diameter, height);
      assertEquals(expResult, result, 0.01);
      
        //calculateVolume(diamenter, height)
    }
    

    /**
     * Test of calculateMaximumWeight method, of class GameControl.
     */
//    @Test
//    public void testCalculateMaximumWeight() {
//    }
//
//    /**
//     * Test of designBarrel method, of class GameControl.
//     */
//    @Test
//    public void testDesignBarrel() {
//    }
    
}
