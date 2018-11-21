/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Barrel;
import CIT260.CityOfAaron.model.Condition;
import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.InventoryItemType;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Map;
import CIT260.CityOfAaron.model.Player;
import CIT260.CityOfAaron.model.ResourcesType;
import CIT260.CityOfAaron.model.StorageShed;
import CIT260.CityOfAaron.model.Wagon;
import cityofaaronproject.CityOfAaronProject;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public class GameControl {
    private Location location;
    private InventoryItem tools;
    private ItemType item;
    private static Player player = new Player();
    
    
    Wagon wagon = new Wagon(10,600,player,ResourcesType.Grains);
    
    public static Player savePlayer(String name){
        player.setName(name);
        return player;
    }
    
    public static Player getPlayer(){
        return player;
    }
    
    public static double harvestResources(Location location, InventoryItem tools, Wagon wagon, double percentage) {
        double totalAmount = 500;
        if(location == null){
            System.out.println("Location is null");
            return -1;
        }
        
        if(tools == null){
            System.out.println("Inventory item is null");
            return -2;
        }
        
        if(wagon == null){
            System.out.println("Wagon is null");
            return -3;
        }
        
        if(percentage <= 0) {
            System.out.println("Invalid percentage");
            return -4;
        }
        
        if(!location.isHasResources()) {
            System.out.println("Location has no resources");
            return -5;
        }
        
        if(tools.getItemType() != ItemType.Tool) {
            System.out.println("You don' have the proper tools to harvest");
            return -6;
        }
        
        double realAmount = Math.round((totalAmount * percentage)/100);
        
        if(realAmount > wagon.getWeightAvailable()){
            System.out.println("The wagon cannot hold the weight");
            return -7;
        }
        
        wagon.setWeight(wagon.getWeight() + realAmount);
        System.out.println("You made it!!!");
        //System.out.println("Deliver the resources to the appropriate shed");
        
        return realAmount;
    }
    
    public static int deliverResources(Wagon wagon, StorageShed shed, Barrel barrel) {
        
        if(wagon.getWeight() <= 0){
            return -1;
        }
        
        if(wagon.getWeight() >= 1000){
            return -4;
        }
        
        if(shed.getType() != wagon.getType()) {
            return -2;
        }
        
        if(barrel.getWeight() >= 1000){
            return -6;
        }
        
        if(barrel.getNumberOfBarrelsAvailable() >= 1000){
            return -7;
        }
        
        double totalWeigthSupported = barrel.getWeight() * barrel.getNumberOfBarrelsAvailable();
        int neededBarrels = (int) Math.round(wagon.getWeight() / barrel.getWeight());
        
        if(wagon.getWeight() > totalWeigthSupported){
            return -3;
        }
        
        if(neededBarrels > barrel.getNumberOfBarrelsAvailable()) {
          return -5;  
        }
        shed.setQuantity(wagon.getWeight());  
        barrel.setNumberOfBarrelsAvailable(barrel.getNumberOfBarrelsAvailable() - neededBarrels);
        return neededBarrels;
    }
    public static double calculateVolume(double diameter, double height) {
        if (diameter < 0)
            return -1;
        
         if (diameter > 100)
            return -3;
    
        if (height < 0)
            return -2;
        
         if (height > 200)
            return -4;
            
        double radius = diameter / 2;
        double volume = Math.PI * (radius * radius) * height;
        
        return volume;
    }
    public double calculateMaximumWeight (double volume, double weight){
        double maximumWeight = volume * weight;
        
        return maximumWeight;
    }
    
    public static int createNewGame(Player player){
        Map map = null;
        if(player == null){
            return -1;
        }
        
        Game game = new Game();
        game.setPlayer(player);
        
        CityOfAaronProject.setCerruentGame(game);
        
        game.setItems(createItems());
        map = MapControl.createMap(game, 10, 10);
        
        if(map == null){
            System.out.println("Create map failed");
            return -2;
        }
        game.setMap(map);
        
        System.out.println("Create game ran ok");
        return 1;
    }
    
     public static InventoryItem[] createItems(){
         System.out.println("Create Items called");
         
         InventoryItem[] items = new InventoryItem[15];
         
         InventoryItem item = new InventoryItem();
         
         item.setName("Lumber");
         item.setQuantity(0);
         items[InventoryItemType.lumber.ordinal()] = item;
         
         item.setName("Ore");
         item.setQuantity(0);
         items[InventoryItemType.ore.ordinal()] = item;
         
         item.setName("Grain");
         item.setQuantity(0);
         items[InventoryItemType.grain.ordinal()] = item;
         
         item.setName("Legume");
         item.setQuantity(0);
         items[InventoryItemType.legume.ordinal()] = item;
         
         item.setName("Oil");
         item.setQuantity(0);
         items[InventoryItemType.oil.ordinal()] = item;
         
         item.setName("Water");
         item.setQuantity(0);
         items[InventoryItemType.water.ordinal()] = item;
         
         item.setName("Honey");
         item.setQuantity(0);
         items[InventoryItemType.honey.ordinal()] = item;
         
         item.setName("Salt");
         item.setQuantity(0);
         items[InventoryItemType.salt.ordinal()] = item;
         
         item.setName("Axe");
         item.setQuantity(0);
         items[InventoryItemType.axe.ordinal()] = item;
         
         item.setName("Hammer");
         item.setQuantity(0);
         items[InventoryItemType.hammer.ordinal()] = item;
         
         item.setName("Drill");
         item.setQuantity(0);
         items[InventoryItemType.drill.ordinal()] = item;
         
         item.setName("Shovel");
         item.setQuantity(0);
         items[InventoryItemType.shovel.ordinal()] = item;
         
         item.setName("Sickle");
         item.setQuantity(0);
         items[InventoryItemType.sickle.ordinal()] = item;
         
         item.setName("Saw");
         item.setQuantity(0);
         items[InventoryItemType.saw.ordinal()] = item;
         
         item.setName("Nails");
         item.setQuantity(0);
         items[InventoryItemType.nails.ordinal()] = item;
         
         
         return items;
     }
     
}