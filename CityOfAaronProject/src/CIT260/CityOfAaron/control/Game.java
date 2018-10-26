/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.control;

/**
 *
 * @author 1
 */
public class Game {
  public class GameControl {
    private Location location;
    private InventoryItem tools;
    private ItemType item;
    private Player player = new Player();
    
    double totalAmount = 500;
    
    public double harvestResources() {
        scanner sc = new scanner(System.in);
        
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
        
        Wagon wagon = new Wagon(10,600,player);
        
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
}
