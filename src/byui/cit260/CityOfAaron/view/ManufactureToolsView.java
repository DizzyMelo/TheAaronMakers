/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import java.util.Scanner;

/**
 *
 * @author Emmanuel Abunyaah
 */
public class ManufactureToolsView extends View {
    
    public ManufactureToolsView() {
        
    }
    
    @Override
    public String[] getInputs() {
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = new String[1];
        
        System.out.println("Select a tool:");
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
        System.out.println("You Selected Axe");
    }

    private void selectHammer() {
        System.out.println("You Selected Hammer");
    }

    private void selectDrill() {
        System.out.println("You Selected Drill");
    }

    private void selectShovel() {
        System.out.println("You Selected Shovel");
    }

    private void selectSickle() {
        System.out.println("You Selected Sickle");
    }

    @Override
    public String getInput(String promptMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }     
}
