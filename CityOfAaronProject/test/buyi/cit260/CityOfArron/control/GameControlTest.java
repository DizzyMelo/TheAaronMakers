/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Barrel;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.ResourcesType;
import CIT260.CityOfAaron.model.StorageShed;
import CIT260.CityOfAaron.model.Wagon;

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
    @Test
    public void testHarvestResources() throws Exception {
        Wagon wagon = new Wagon();
        Location location = new Location();
        InventoryItem tools = new InventoryItem();
        ItemType type = null;
        double percentage;
        double expResult;
        double result;
        
        System.out.println("Test harvest Resources");
        
        
        System.out.println("Test 1");
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        percentage = 50;
        expResult = 250;
        
        result = GameControl.harvestResources(location, tools, wagon, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 2");
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        percentage = 50;
        expResult = -1;
        
        result = GameControl.harvestResources(null, tools, wagon, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 3");
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        percentage = 50;
        expResult = -2;
        
        result = GameControl.harvestResources(location, null, wagon, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 4");
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        percentage = 50;
        expResult = -3;
        
        result = GameControl.harvestResources(location, tools, null, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 5");
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        percentage = 0;
        expResult = -4;
        
        result = GameControl.harvestResources(location, tools, wagon, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 6");
        wagon.setWeightAvailable(400);
        location.setHasResources(false);
        tools.setItemType(type.Tool);
        percentage = 50;
        expResult = -5;
        
        result = GameControl.harvestResources(location, tools, wagon, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 7");
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Provisions);
        percentage = 50;
        expResult = -6;
        
        result = GameControl.harvestResources(location, tools, wagon, percentage);
        assertEquals(expResult, result, 0.01);
        
        
        
        System.out.println("Test 8");
        wagon.setWeightAvailable(200);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        percentage = 50;
        expResult = -7;
        
        result = GameControl.harvestResources(location, tools, wagon, percentage);
        assertEquals(expResult, result, 0.01);
    }
//
//    /**
//     * Test of deliverResources method, of class GameControl.
//     */
    @Test
    public void testDeliverResources() {
    
        Wagon wagon = new Wagon();
        StorageShed shed = new StorageShed();
        Barrel barrel = new Barrel();
        int expResult;
        int result;
        
        System.out.println("Test deliver Resources");
        
        
        System.out.println("Test 1");
        
        wagon.setWeight(400);
        wagon.setType(ResourcesType.Ore);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(50);
        barrel.setNumberOfBarrelsAvailable(10);
        expResult = 8;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
        
        
        System.out.println("Test 2");
        
        wagon.setWeight(0);
        wagon.setType(ResourcesType.Ore);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(50);
        barrel.setNumberOfBarrelsAvailable(10);
        expResult = -1;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
        
        
        System.out.println("Test 3");
        
        wagon.setWeight(400);
        wagon.setType(ResourcesType.Grains);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(50);
        barrel.setNumberOfBarrelsAvailable(10);
        expResult = -2;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
        
        
        System.out.println("Test 4");
        
        wagon.setWeight(40000);
        wagon.setType(ResourcesType.Ore);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(50);
        barrel.setNumberOfBarrelsAvailable(10);
        expResult = -4;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
        
        
        System.out.println("Test 5");
        
        wagon.setWeight(400);
        wagon.setType(ResourcesType.Ore);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(50);
        barrel.setNumberOfBarrelsAvailable(5);
        expResult = -3;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
        
        
        System.out.println("Test 6");
        
        wagon.setWeight(400);
        wagon.setType(ResourcesType.Ore);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(1000);
        barrel.setNumberOfBarrelsAvailable(10);
        expResult = -6;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
        
        
        System.out.println("Test 7");
        
        wagon.setWeight(400);
        wagon.setType(ResourcesType.Ore);
        shed.setType(ResourcesType.Ore);
        barrel.setWeight(50);
        barrel.setNumberOfBarrelsAvailable(1000);
        expResult = -7;
        result = GameControl.deliverResources(wagon, shed, barrel);
        assertEquals(expResult, result, 0.01);
    }

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
