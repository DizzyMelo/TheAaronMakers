/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import java.util.Scanner;

/**
 *
 * @author kss_s
 */
public class EstimateResourceView extends View{

    public EstimateResourceView() {
    }
    
    @Override
    public String[] getInputs() {
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = new String[1];
        
        System.out.println("Select one of the options below:");
        System.out.println("T - Timber\n" +
                            "O - Ore\n" +
                            "G - Grains\n" +
                            "L - Legumes\n" +
                            "O - Oil\n" +
                            "W - Drinking water\n" +
                            "H - Honey\n" +
                            "S - Salt\n" +
                            "Q - Quit");
        
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

    @Override
    public boolean doAction(String[] inputs) {
        
        String menuItem = inputs[0];
        menuItem = menuItem.toUpperCase();
        
        switch(menuItem){
            case "T":
                this.selectTimber();
                break;
            case "R":
                this.selectOre();
                break;
            case "G":
                this.selectGrains();
                break;
            case "L":
                this.selectLegumes();
                break;
            case "O":
                this.selectOil();
                break;
            case "W":
                this.selectWater();
                break;
            case "H":
                this.selectHoney();
                break;
            case "S":
                this.selectSalt();
                break;
            
            case "Q":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        
        return false;
    }

    private void selectTimber() {
        System.out.println("Timber selected");
    }

    private void selectOre() {
        System.out.println("Ore selected");
    }

    private void selectGrains() {
        System.out.println("Grains selected");
    }

    private void selectLegumes() {
        System.out.println("Legumes selected");
    }

    private void selectOil() {
        System.out.println("Oil selected");
    }

    private void selectWater() {
        System.out.println("Water selected");
    }

    private void selectHoney() {
        System.out.println("Honey selected");
    }

    private void selectSalt() {
        System.out.println("Salt selected");
    }
    
}
