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
import CIT260.CityOfAaron.model.Player;
import CIT260.CityOfAaron.model.ResourcesType;
import CIT260.CityOfAaron.model.StorageShed;
import CIT260.CityOfAaron.model.Wagon;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public class GameControl {
    private Location location;
    private InventoryItem tools;
    private ItemType item;
    private Player player = new Player();
    
    double totalAmount = 500;
    
    public double harvestResources() {
        Scanner sc = new Scanner(System.in);
        
        if(!location.isHasResources()) {
            return -1;
        }
        
        if(tools.getItemType() != item.Tool) {
            return -1;
        }
        
        System.out.println("Enter the percentage you want to harvest");
        double percentage = sc.nextDouble();
        
        while (percentage <= 0) {
            System.out.println("Invalid number\n Reenter the percentage");
            percentage = sc.nextDouble();
        }
        
        player.setName("John");
        
        Wagon wagon = new Wagon(10,600,player,ResourcesType.Grains);
        
        double realAmount = totalAmount / percentage;
        
        while(realAmount >= wagon.getWeightAvailable()){
            System.out.println("The wagon cannot support the weight\n Reenter the percentage");
            percentage = sc.nextDouble();
        }
        
        wagon.setWeight(wagon.getWeight() + realAmount);
        System.out.println("You made it!!!");
        System.out.println("Deliver the resources to the appropriate shed");
        
        return 0.0;
    }
    
    public double deliverResources(Wagon wagon, StorageShed shed, Barrel barrel) {
        
        if(wagon.getWeight() == 0){
            System.out.println("Wagon is empty!");
            return -1;
        }
        
        if(shed.getType() != wagon.getType()) {
            System.out.println("You are in the wrong shed!");
            return -1;
        }
        return 0.0;
    }
    
}
