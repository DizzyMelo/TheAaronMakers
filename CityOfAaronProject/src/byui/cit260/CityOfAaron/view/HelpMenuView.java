/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmelo
 */
public class HelpMenuView extends View{

    public HelpMenuView() {
    }
    
    public void displayHelpMenuView(){
        boolean endView = false;
        
        do{
            String[] inputs = getInputs();
            if(inputs.length == 0 || inputs[0].toUpperCase().equals("Q")){
                return;
            }
            endView = doAction(inputs);
        }while(endView == false);
    }
    
    public String[] getInputs() {
        
        String[] inputs = new String[1];
        
        this.console.println("Select one of the options below:");
        this.console.println("G - What is the goal of the game?\n"
                + "M - How to move\n"
                + "E - Estimate the number of resources\n"
                + "H - Harvest resources"
                + "D - Delivering resources to warehouse"
                + "Q - Quit");
        
        boolean valid = false;
        
        while(valid == false){
            try {
                String value = this.keyboard.readLine();
                
                if(value.length() < 1){
                    ErrorView.display(this.getClass().getName(), "You must enter a value");
                    continue;
                }
                
                inputs[0] = value;
                valid = true;
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "There was a problem reading the input: " + ex.getMessage());
            }
        }
        
        return inputs;
    }

    public boolean doAction(String[] inputs) {
        
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase();
        
        switch(menuItem){
            case "G":
                this.getGoalInstructions();
                break;
            case "M":
                this.getMoveInstructions();
                break;
            case "E":
                this.getEstimateInstructions();
                break;
            case "H":
                this.getHarvestInstructions();
                break;
            case "D":
                this.getDeliverInstructions();
                break;
            case "Q":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        
        return false;
    }
    
    public void getGoalInstructions(){
        this.console.println("Create goal instructions");
    }
    public void getMoveInstructions(){
        this.console.println("Create move instructions");
    }
    public void getEstimateInstructions(){
        this.console.println("Create estimate resources instructions");
    }
    public void getHarvestInstructions(){
        this.console.println("Create harvest resources instructions");
    }
    public void getDeliverInstructions(){
        this.console.println("Create deliver resources instructions");
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInput(String promptMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
