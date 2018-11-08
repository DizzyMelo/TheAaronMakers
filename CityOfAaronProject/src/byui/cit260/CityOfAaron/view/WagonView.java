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
public class WagonView {
    public WagonView() {
    }
    
    /**
     *
     */
    public void WagonView(){
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
        
        System.out.println("Wagon Characteristics:");
        System.out.println("W - weight\n"
                + "WA - weightAvailable\n"
                + "P - player\n"
                + "T - type\n");
                  
        
        boolean valid = false;
        
        while(valid == false){
            String value = sc.nextLine();

            if(value.length() < 1){
                System.out.println("You must choice an option");
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
            case "W":
                this.getWeight();
                break;
            case "WA":
                this.getWeightAvailable();
                break;
            case "P":
                this.getPlayer();
                break;
            case "T":
                this.getType();
                break;
        }
        
        return false;
    }
    
    

    private void getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getWeightAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
