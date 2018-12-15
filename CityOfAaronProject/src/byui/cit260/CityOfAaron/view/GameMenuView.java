/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Map;
import buyi.cit260.CityOfArron.control.BarrelControl;
import buyi.cit260.CityOfArron.exceptions.BarrelControlException;
import cityofaaronproject.CityOfAaronProject;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmelo
 */
public class GameMenuView extends View{

    public GameMenuView() {
    }
    
    public void displayGameMenuView(){
        boolean endView = false;
        
        do{
            String[] inputs = getInputs();
            if(inputs.length == 0 || inputs[0].toUpperCase().equals("Q")){
                return;
            }
            endView = doAction(inputs);
        }while(endView == false);
    }

    /**
     *
     * @return
     */
    @Override
    public String[] getInputs() {
        
        
        String[] inputs = new String[1];
        
        this.console.println("Select one of the options below:");
        this.console.println("V - View map\n"
                + "I - View list of items in inventory\n"
                + "A - View list of actors\n"
                + "S - View ship status\n"
                + "L - View contents of location\n"
                + "M - Move person to new location\n"
                + "E - Estimate the resource needed\n"
                + "B - Design barrels\n"
                + "C - Construct tools\n"
                + "R - Harvest resource\n"
                + "D - Deliver resource\n"
                + "W - Work on ship\n"
                + "P - Pack ship\n"
                + "J - Launch ship\n"
                + "S - Save game\n"
                + "G - Game Reports\n"
                + "H - Help\n"
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
        
    /**
     *
     * @param inputs
     * @return
     */
    @Override
    public boolean doAction(String[] inputs) {
        
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase();
        
        switch(menuItem){
            case "V":
                this.displayMap();
                break;
            case "I":
                this.viewListOfItems();
                break;
            case "A":
                this.viewListOfActors();
                break;
            case "T":
                this.viewShipStatus();
                break;
            case "L":
                this.viewContentsOfLocation();
                break;
            case "M":
                this.movePersonNewLocation();
                break;
            case "E":
                EstimateResourceView er = new EstimateResourceView();
                er.display();
                break;
            case "B":
                this.designBarrels();
                break;
            case "C":
                this.constructTools();
                break;
            case "R":
                //HarvestResourceView.displayHarvestResouceView();
                break;
            case "D":
                this.deliverResource();
                break;
            case "W":
                this.workOnShip();
                break;
            case "P":
                this.packShip();
                break;
            case "J":
                this.launchShip();
                break;
            case "S":
                this.saveGame();
                break;
                
            case "G":
                this.displayGameReporst();
                break;
            case "H":
                this.displayHelp();
                break;
            case "Q":
                return true;
            default:
                this.console.println("Invalid menu item");
                break;
        }
        
        return false;
    }
    
    public void displayMap(){
        
        Game game = CityOfAaronProject.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        this.console.println("THE LAND OF BOUNTIFUL");
            this.console.print("    ");
        for(int i = 0; i < map.getNoOfColumns(); i++){
            this.console.print(String.valueOf(i+1)+"    ");
        }
        
        
        for(int i = 0; i < (map.getNoOfRows()); i++){
            this.console.println(" ");
            this.console.println("-------------------------");
            this.console.print(String.valueOf(i+1));
            for(int j = 0; j < (map.getNoOfColumns()); j++){
                this.console.print(" | ");
                
                    Location location = locations[i][j];
                    
                    if(location.isVisited()){
                        String mapSymbol = "*";
                        this.console.print(mapSymbol);
                    }else{
                        this.console.print("??");
                    }
                
            }
            this.console.print(" |");
        }
        
        this.console.println("");
        this.console.println("-------------------------");
        
    }

    private void viewListOfItems() {
        System.out.println("viewListOfItems called");
    }

    private void viewListOfActors() {
        System.out.println("viewListOfActors called");
    }

    private void viewShipStatus() {
        System.out.println("viewShipStatus called");
    }

    private void viewContentsOfLocation() {
        System.out.println("viewContentsOfLocation called");
    }

    private void movePersonNewLocation() {
        MoveActorView mv = new MoveActorView();
        mv.display();
    }

    private void estimateResourceNeeded() {
        System.out.println("estimateResourceNeeded called");
    }

    private void designBarrels() {
        ManufactureBarrelView mb = new ManufactureBarrelView();
        mb.display();
    }

    private void constructTools() {
        ManufactureToolsView mt = new ManufactureToolsView();
        mt.display();
    }

    private void harvestResource() {
        System.out.println("harvestResource called");
    }

    private void deliverResource() {
        System.out.println("deliverResource called");
    }

    private void workOnShip() {
        System.out.println("workOnShip called");
    }

    private void packShip() {
        System.out.println("packShip called");
    }

    private void launchShip() {
        System.out.println("launchShip called");
    }
    
    private void displayHelp() {
        HelpMenuView hm = new HelpMenuView();
        hm.displayHelpMenuView();
    }
    
    private void displayGameReporst() {
        GameReportsView hm = new GameReportsView();
        hm.display();
    }

    private void saveGame() {
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display();
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
