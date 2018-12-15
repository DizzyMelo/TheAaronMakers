/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Actor;
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
import CIT260.CityOfAaron.model.Tool;
import CIT260.CityOfAaron.model.ToolType;
import CIT260.CityOfAaron.model.Wagon;
import cityofaaronproject.CityOfAaronProject;
import java.util.Scanner;
import buyi.cit260.CityOfArron.exceptions.GameControlException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    
    public static double harvestResources(Location location, InventoryItem tools, Wagon wagon, double percentage) throws Exception{
        double totalAmount = 500;
        if(location == null){
            throw new GameControlException("The location is a null object"); 
        }
        
        if(tools == null){
            throw new GameControlException("The Inventory Item is a null object.");
        }
        
        if(wagon == null){
            throw new GameControlException("The Wagon is a null object.");
        }
        
        if(percentage <= 0) {
            throw new GameControlException("The Wagon is a null object.");
        }
        
        if(!location.isHasResources()) {
            throw new GameControlException("TLocation has no resources");
        }
        
        if(tools.getItemType() != ItemType.Tool) {
            throw new GameControlException("You don't have the proper tools to harvest");
        }
        
        double realAmount = Math.round((totalAmount * percentage)/100);
        
        if(realAmount > wagon.getWeightAvailable()){
            throw new GameControlException("The wagon cannot hold the weight");
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

    
    public static int createNewGame(Player player){
        Map map = null;
        if(player == null){
            return -1;
        }
        
        Game game = new Game();
        game.setPlayer(player);
        
        CityOfAaronProject.setCurrentGame(game);
        
        game.setItems(createItems());
        map = MapControl.createMap(game, 4, 4);
        
        if(map == null){
            System.out.println("Create map failed");
            return -2;
        }
        game.setMap(map);
        
        game.setTools(createTools());
        
        System.out.println("Create game ran ok");
        return 1;
    }
    
    public static Tool[] createTools(){
        
        Tool[] tools = new Tool[5];
        
        Tool tool = new Tool();
        tool.setQuantity(0);
        tool.setType(ToolType.Axe);
        
        tools[ToolType.Axe.ordinal()] = tool;
        
        Tool tool2 = new Tool();
        tool.setQuantity(0);
        tool.setType(ToolType.Hammer);
        
        tools[ToolType.Hammer.ordinal()] = tool2;
        
        Tool tool3 = new Tool();
        tool.setQuantity(0);
        tool.setType(ToolType.Drill);
        
        tools[ToolType.Drill.ordinal()] = tool3;
        
        Tool tool4 = new Tool();
        tool.setQuantity(0);
        tool.setType(ToolType.Shovel);
        
        tools[ToolType.Shovel.ordinal()] = tool4;
        
        Tool tool5 = new Tool();
        tool.setQuantity(0);
        tool.setType(ToolType.Sickle);
        
        tools[ToolType.Sickle.ordinal()] = tool5;
        
        return tools;
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
     
     public static void saveGame(Game game, String filePath) throws Exception{ 
        if(game == null || (filePath == null || filePath.length() < 1)){
            throw new GameControlException("Game of File path is invalid!");
        }
        
        try(FileOutputStream outPut = new FileOutputStream(filePath);
            ObjectOutputStream obj = new ObjectOutputStream(outPut)){
            
            obj.writeObject(game);
        }catch(IOException ex){
            throw ex;
        }
        
    }
     
     public static boolean saveListOfActors(String filePath) throws Exception{ 
        if(filePath == null || filePath.length() < 1){
            throw new GameControlException("File path is invalid!");
        }
        
        try(FileOutputStream outPut = new FileOutputStream(filePath);
            ObjectOutputStream obj = new ObjectOutputStream(outPut)){
            
            for(int i = 0; i < Actor.values().length; i++){
                obj.writeObject(Actor.values()[i]);
            }
            
            return true;
                    
        }catch(IOException ex){
            throw ex;
        }
        
    }
     
    public static Game getGame(String filePath) throws GameControlException, ClassNotFoundException, IOException {
        if(filePath == null){
            throw new GameControlException("Invalid file path");
        }
        Game game = null;
        try(FileInputStream outPut = new FileInputStream(filePath);
            ObjectInputStream obj = new ObjectInputStream(outPut)){
            
            game = (Game) obj.readObject();
            CityOfAaronProject.setCurrentGame(game);
            CityOfAaronProject.setCurrentPlayer(game.getPlayer());
            
        }catch(IOException ex){
            throw ex;
        }
        
        
        return game;
    }
     
}