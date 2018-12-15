/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.InventoryItemType;
import buyi.cit260.CityOfArron.control.BarrelControl;
import buyi.cit260.CityOfArron.exceptions.BarrelControlException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public class ManufactureBarrelView extends View{

    public ManufactureBarrelView() {
    }
    
    
     @Override
     public String[] getInputs() {
         Scanner sc = new Scanner(System.in);
         
         String[] inputs = new String[1];
         
         System.out.println("\n Select an item to design a barrel:");
         System.out.println("\nG - Grains\n"+ 
                            "L - Legumes\n" +
                            "O - Oil\n" +
                            "W - Drinking Water\n" +
                            "H - Honey\n" +
                            "S - Salt\n" +
                            "Q - Quit");
         boolean valid = false;
         
         while(valid == false){
             String value = sc.nextLine();

             if(value.length() < 1){
                 System.out.println("Please Enter a Value");
                 continue;
             }

             inputs[0] = value;
             valid = true;
         }
         
         return inputs;
     }
     @Override
     public boolean doAction(String[] inputs) {
         
         String menuItem = inputs[0];
         menuItem = menuItem.toUpperCase();
         
         
          switch(menuItem){
             case "G":
                 this.selectItem(InventoryItemType.grain);
                 break;
             case "L":
                 this.selectItem(InventoryItemType.legume);
                 break;
             case "O":
                 this.selectItem(InventoryItemType.oil);
                 break;
             case "W":
                 this.selectItem(InventoryItemType.water);
                 break;
             case "H":
                 this.selectItem(InventoryItemType.honey);
                 break;
            case "S":
                 this.selectItem(InventoryItemType.salt);
                 break;

             case "Q":
                 return true;
             default:
                 System.out.println("Invalid Menu Item");
                 break;
         }
         
         return false;
     }
     
     private void selectItem(InventoryItemType type){
         try{
            
            this.console.println("Enter the diameter of the barrel");
            String diameterStr = this.keyboard.readLine();
            double diameter = 0;
            try{
                diameter = Double.parseDouble(diameterStr);
            }catch(NumberFormatException ex){
                ErrorView.display(this.getClass().getName(), "Please enter a number: " + ex.getMessage());
                return;
            }
            
            
            this.console.println("Enter the height of the barrel");
            String heightStr = this.keyboard.readLine();
            double height = 0;
            try{
                height = Double.parseDouble(heightStr);
            }catch(NumberFormatException ex){
                ErrorView.display(this.getClass().getName(), "Please enter a number: " + ex.getMessage());
            }
            
            double volume = 0;
            try {
                volume = BarrelControl.calculateVolume(diameter, height);
            } catch (BarrelControlException ex) {
                System.out.println(ex.getMessage());
            }
            
            double maxWeight = 0;
            try {
                maxWeight = BarrelControl.calculateMaximumWeight(volume, type.getWeight());
            } catch (BarrelControlException ex) {
                System.out.println(ex.getMessage());
                ErrorView.display(this.getClass().getName(), "Error: " + ex.getMessage());
            }
            
            this.console.println("\tThe diameter is: " + Math.round(diameter));
            this.console.println("\tThe volume is: " + Math.round(volume));
            this.console.println("\tThe maximum weight is: " + Math.round(maxWeight));
            
        }catch(IOException ex){
            ErrorView.display(this.getClass().getName(), "Error : " + ex.getMessage());
        }
     }
}
