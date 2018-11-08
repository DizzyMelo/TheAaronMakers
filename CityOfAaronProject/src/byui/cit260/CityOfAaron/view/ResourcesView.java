/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import java.util.Scanner;

/**
 *
 * @author 1eonardo Castrillón
 */
public class ResourcesView {
    public ResourcesView() {
    }
    
    public void displayResourcesView(){
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
        
        System.out.println("Select one of the available resources:");
        System.out.println("O - Ore\n"
                + "T - Timber\n"
                + "G - Grains\n"
                + "L - Legumes\n"
                + "I - Oil\n"
                + "W - Drinking water\n"
                + "H - Honey\n"
                + "S - Salt\n"
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
            case "O":
                this.getOreAmount();
                break;
            case "G":
                this.getGrainsAmount();
                break;
            case "L":
                this.getLegumesAmount();
                break;
            case "I":
                this.getOilAmount();
                break;
            case "W":
                this.getDrinkingWaterAmount();
                break;
            case "H":
                this.getHoneyAmount();
                break;
            case "S":
                this.getSaltAmount();
                break;    
            case "Q":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        
        return false;
    }
    
    public void getOreAmount(){
        System.out.println("Create ore amount");
    }
    public void getGrainsAmount(){
        System.out.println("Create grains amount");
    }
    public void getLegumesAmount(){
        System.out.println("Create legumes amount");
    }
    public void getOilAmount(){
        System.out.println("Create oil amount");
    }
    public void getDrinkingWaterAmount(){
        System.out.println("Create drinking water amount");
    }
    public void getHoneyAmount(){
        System.out.println("Create honey amount");
    }
    public void getSaltAmount(){
        System.out.println("Create salt amount");
    }
    
    
}
