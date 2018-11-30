/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control.exceptions;

import CIT260.CityOfAaron.model.Barrel;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.StorageShed;
import CIT260.CityOfAaron.model.Wagon;

/**
 *
 * @author 1
 */
public class GameControlException extends Exception{

    public GameControlException() {
    }

    public GameControlException(String message) {
        super(message);
    }

    public GameControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameControlException(Throwable cause) {
        super(cause);
    }

    public GameControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
 
    public void harvestResources(Location location, InventoryItem tools, Wagon wagon, double percentage) 
    throws GameControlException{
        double totalAmount = 500;
        if(location == null){
            System.out.println("Location is null");
            throw new GameControlException("Location can not be null");
        }
      if(tools == null){
            System.out.println("Inventory item is null");
            throw new GameControlException("Inventory item can not be null");
        }
      if(wagon == null){
            System.out.println("Wagon is null");
            throw new GameControlException("Wagon can not be null");
        }
      if(percentage <= 0) {
            System.out.println("Invalid percentage");
            throw new GameControlException("Percentage must be greater than zero");
        }
      if(!location.isHasResources()) {
            System.out.println("Location has no resources");
            throw new GameControlException("Location must have at least one kind of resources");
        }
      if(tools.getItemType() != ItemType.Tool) {
            System.out.println("You don't have the proper tools to harvest");
            throw new GameControlException("proper tools are needed to harvest");
        }
      double realAmount = Math.round((totalAmount * percentage)/100);
      
      if(realAmount > wagon.getWeightAvailable()){
            System.out.println("The wagon cannot hold the weight");
            throw new GameControlException("Be Careful of not overloading the Wagon");
        }
      wagon.setWeight(wagon.getWeight() + realAmount);
        System.out.println("You made it!!!");
        //System.out.println("Deliver the resources to the appropriate shed");
        
    } 
    
    public int deliverResources(Wagon wagon, StorageShed shed, Barrel barrel) 
    throws GameControlException{
        
        if(wagon.getWeight() <= 0){
            throw new GameControlException("wagon.getWeight must be greater than zero");
        }
        
        if(wagon.getWeight() >= 1000){
            throw new GameControlException("wagon.getWeight must be less than 1000");
        }
        
        if(shed.getType() != wagon.getType()) {
            throw new GameControlException("shed and wagon need to have the same resources type");
        }
        
        if(barrel.getWeight() >= 1000){
            throw new GameControlException("barrel.getWeight must be less than 1000");
        }
        
        if(barrel.getNumberOfBarrelsAvailable() >= 1000){
            throw new GameControlException("Number of Barrels can not be greater than 1000");
        }
        
        double totalWeightSupported = barrel.getWeight() * barrel.getNumberOfBarrelsAvailable();
        int neededBarrels = (int) Math.round(wagon.getWeight() / barrel.getWeight());
        
        if(wagon.getWeight() > totalWeightSupported){
            throw new GameControlException("Max weight exceeded");
        }
        
        if(neededBarrels > barrel.getNumberOfBarrelsAvailable()) {
          throw new GameControlException("Do not exceed the limit of barrels available");  
        }
        shed.setQuantity(wagon.getWeight());  
        barrel.setNumberOfBarrelsAvailable(barrel.getNumberOfBarrelsAvailable() - neededBarrels);
        return neededBarrels;
    }
    
    public double calculateVolume(double diameter, double height)
        throws GameControlException{
        
        if (diameter < 0)
            throw new GameControlException("Diameter can not be negative");
        
         if (diameter > 100)
            throw new GameControlException("Diameter can not be greater than 100");
    
        if (height < 0)
            throw new GameControlException("Height can not negative");
        
         if (height > 200)
            throw new GameControlException("Height can not be greater than 200");
            
        double radius = diameter / 2;
        double volume = Math.PI * (radius * radius) * height;
        
        return volume;
    }
}
    
