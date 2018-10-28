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
//    public void designBarrel() {
//        Scanner sc = new Scanner(System.in);
//        
//        System.out.println("Select the Resource type");
//        System.out.println("G - Grains\n"
//                + "L - Legumes\n"
//                + "O - Oil\n"
//                + "D - Drinking Water\n"
//                + "H - Honey\n"
//                + "S - Salt\n"
//                + "Q - Quit\n");
//        
//        String op = sc.nextLine();
//        
//        switch(op){
//            case "G":
//            double volume = calculateVolume(5.0, 2);
//            double maximumWeight = calculateMaximumWeight(volume, 10)
//                break;
//            case "L":
//                
//                break;
//            case "O":
//                
//                break;
//            case "D":
//                
//                break;
//            case "H":
//                
//                break;
//            case "S":
//                
//                break;
//            case "Q":
//                
//                break;
//        }
//    }
}

