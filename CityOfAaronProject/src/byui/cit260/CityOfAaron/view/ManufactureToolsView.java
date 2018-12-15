/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Tool;
import CIT260.CityOfAaron.model.ToolType;
import buyi.cit260.CityOfArron.control.ToolControl;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public class ManufactureToolsView extends View {
     
     public ManufactureToolsView() {
         
     }
     
     @Override
     public String[] getInputs() {
         Scanner sc = new Scanner(System.in);
         
         String[] inputs = new String[1];
         
         System.out.println("\n Select a tool:");
         System.out.println("A - Axe\n" +
                             "H - Hammer\n" +
                             "D - Drill\n" +
                             "S - Shovel\n" +
                             "C - Sickle\n" +
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
             case "A":
                 this.selectAxe();
                 break;
             case "H":
                 this.selectHammer();
                 break;
             case "D":
                 this.selectDrill();
                 break;
             case "S":
                 this.selectShovel();
                 break;
             case "C":
                 this.selectSickle();
                 break;

             case "Q":
                 return true;
             default:
                 System.out.println("Invalid Menu Item");
                 break;
         }
         
         return false;
     }
     
     private void selectAxe() {
         Tool[] tools = ToolControl.addTools(ToolType.Axe);
         this.console.println("=================================================");
         this.console.println("\tItem added to the inventory list!\n\tNow you have "+ 
                                tools[ToolType.Axe.ordinal()].getQuantity() + " Axes in the inventory");
         this.console.println("=================================================");
     }

     private void selectHammer() {
         Tool[] tools = ToolControl.addTools(ToolType.Hammer);
         this.console.println("=================================================");
         this.console.println("\tItem added to the inventory list!\n\tNow you have "+ 
                                tools[ToolType.Axe.ordinal()].getQuantity() + " Hammers in the inventory");
         this.console.println("=================================================");
     }

     private void selectDrill() {
         Tool[] tools = ToolControl.addTools(ToolType.Drill);
         this.console.println("=================================================");
         this.console.println("\tItem added to the inventory list!\n\tNow you have "+ 
                                tools[ToolType.Axe.ordinal()].getQuantity() + " Drills in the inventory");
         this.console.println("=================================================");
     }

     private void selectShovel() {
         Tool[] tools = ToolControl.addTools(ToolType.Shovel);
         this.console.println("=================================================");
         this.console.println("\tItem added to the inventory list!\n\tNow you have "+ 
                                tools[ToolType.Axe.ordinal()].getQuantity() + " Shovels in the inventory");
         this.console.println("=================================================");
         
     }

     private void selectSickle() {
         Tool[] tools = ToolControl.addTools(ToolType.Sickle);
         this.console.println("=================================================");
         this.console.println("\tItem added to the inventory list!\n\tNow you have "+ 
                                tools[ToolType.Axe.ordinal()].getQuantity() + " Sickles in the inventory");
         this.console.println("=================================================");
     }

     @Override
     public String getInput(String promptMessage) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }     
 }
