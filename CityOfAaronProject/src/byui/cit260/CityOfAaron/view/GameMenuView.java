/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Map;
import cityofaaronproject.CityOfAaronProject;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = new String[1];
        
        System.out.println("Select one of the options below:");
        System.out.println("V - View map\n"
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
                + "H - Help\n"
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
            case "H":
                this.displayMap();
                break;
            case "Q":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        
        return false;
    }
    
    public void displayMap(){
        
        Game game = CityOfAaronProject.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        System.out.println("THE LAND OF BOUNTIFUL");
            System.out.print("    ");
        for(int i = 0; i < map.getNoOfColumns(); i++){
            System.out.print(String.valueOf(i+1)+"    ");
        }
        
        
        for(int i = 0; i < (map.getNoOfRows()); i++){
            System.out.println(" ");
            System.out.println("-------------------------");
            System.out.print(String.valueOf(i+1));
            for(int j = 0; j < (map.getNoOfColumns()); j++){
                System.out.print(" | ");
                
                    
                    Location location = locations[i][j];
                    
                    if(location.isVisited()){
                        String mapSymbol = "*";
                        System.out.print(mapSymbol);
                    }else{
                        System.out.print("??");
                    }
                
                
            }
            System.out.print(" |");
        }
        
        System.out.println("");
        System.out.println("-------------------------");
        
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
        System.out.println("movePersonNewLocation called");
    }

    private void estimateResourceNeeded() {
        System.out.println("estimateResourceNeeded called");
    }

    private void designBarrels() {
        System.out.println("designBarrels called");
    }

    private void constructTools() {
        System.out.println("constructTools called");
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

    private void saveGame() {
        System.out.println("saveGame called");
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
