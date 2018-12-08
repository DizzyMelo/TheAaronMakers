/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Actor;
import buyi.cit260.CityOfArron.control.GameControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmelo
 */
public class GameReportsView extends View{

    public GameReportsView() {
    }
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        String input1 = this.getInput("\n\nChoose one of the options below\n"
                + "A - Print list of actors\n"
                + "I - Print list of items in inventory\n"
                + "E - Exit\n");
        inputs[0] = input1;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase();
        
        switch(menuItem){
            case "A":
                printListOfActors();
                break;
            case "I":
                printListOfItems();
                break;
            case "E":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        
        return false;
    }

    private void printListOfActors(){
        
        this.console.println("Select a file path");
        String filePath = this.getInput("Enter the path to start the saved the file");
        String content = "";
        
        String fe = System.getProperty("user.dir");
        this.console.println(fe);

        this.console.println("\n\n   LIST OF ACTORS       ");
        
        this.console.printf("%n%-10s%-10s","NAME","COORDINATES");
        this.console.printf("%n%-10s%-10s","----","-----------");
        for(int i = 0; i < Actor.values().length; i++){
            String coord = "("+Actor.values()[i].getCoordinates().x + Actor.values()[i].getCoordinates().y + ")";
            this.console.printf("%n%-10s%-10s",Actor.values()[i].getName(),coord);
        }
        
        
        try {
            GameControl.saveListOfActors(filePath);
            this.console.println("\nFile created!");
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "Error: " + ex.getMessage());
        }
    }

    private void printListOfItems() {
        this.console.println("print list of items");
        this.console.printf("print list of items");
    }
    
}
