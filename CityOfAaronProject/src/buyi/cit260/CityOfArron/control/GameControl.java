/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Barrel;
import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
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
        map = createMap(game, 10, 10);
        
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
         
         int number = 0;
         InventoryItem[] items = new InventoryItem[number];
         return items;
     }
     
     public static Map createMap(Game game,int noOfRows,int noOfColumns){
         System.out.println("Create map called");
         Map map = new Map();
         return map;
     }

}