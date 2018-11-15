/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import java.util.Scanner;

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
    
    private String[] getInputs() {
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = new String[1];
        
        System.out.println("Select one of the options below:");
        System.out.println("G - What is the goal of the game?\n"
                + "M - How to move\n"
                + "E - Estimate the number of resources\n"
                + "H - Harvest resources"
                + "D - Delivering resources to warehouse"
                + "Q - Quit");
        
        boolean valid = false;
        
        while(valid == false){
            String value = sc.nextLine();

            if(value.length() < 1){
                System.out.println("You must enter a value");
                continue;
            }

            inputs[0] = value;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doAction(String[] inputs) {
        
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
        System.out.println("Create goal instructions");
    }
    public void getMoveInstructions(){
        System.out.println("Create move instructions");
    }
    public void getEstimateInstructions(){
        System.out.println("Create estimate resources instructions");
    }
    public void getHarvestInstructions(){
        System.out.println("Create harvest resources instructions");
    }
    public void getDeliverInstructions(){
        System.out.println("Create deliver resources instructions");
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
