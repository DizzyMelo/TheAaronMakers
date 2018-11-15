/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Wagon;
import buyi.cit260.CityOfArron.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public abstract class HarvestResourceView extends View {

    public HarvestResourceView() {
    }
    
    public void displayHarvestResouceView(){
        boolean endView = false;
        
        do{
            String[] inputs = getInputs();
            if(inputs[0].length() <= 0){
                System.out.println("You must enter a value greater than zero");
                continue;
            }
            endView = doAction(inputs);
        }while(endView == false);
    }
    
    public String[] getInputs() {
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = new String[1];
        
        System.out.println("Enter the percentage you want to harvest from the amount: ");
        
        boolean valid = false;
        
        while(valid == false){
            String value = sc.nextLine();

            if(String.valueOf(value).length() < 1){
                System.out.println("You must enter a value");
                continue;
            }

            inputs[0] = value;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doAction(double[] inputs) {
        
        Wagon wagon = new Wagon();
        Location location = new Location();
        InventoryItem tools = new InventoryItem();
        ItemType type = null;
        double percentage;
        double result;
        
        percentage = inputs[0];
        wagon.setWeightAvailable(400);
        location.setHasResources(true);
        tools.setItemType(type.Tool);
        
        
        
        result = GameControl.harvestResources(location, tools, wagon, percentage);
        System.out.println("The result is: " + result);
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayGameMenuView();
        
        return false;
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getInputs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInput(String promptMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean doAction(String[] inputs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getInputs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
