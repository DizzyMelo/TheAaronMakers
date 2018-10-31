/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Player;
import buyi.cit260.CityOfArron.control.GameControl;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public class StartProgramView {

    public StartProgramView() {
    }
    
    public void displayStartProgramView(){
        boolean endOfView = false;
        
        do {
            String[] input = getInputs();
            if(input[0].toUpperCase().equals("Q")){
                return;
            }
            endOfView = doAction(input);
        }while(endOfView != true);
        
    }

    private String[] getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("getInputs method called");
        
        String[] inputs = new String[1];
        
        System.out.println("Welcome to this amazing Game");
        
        boolean valid = false;
        
        while(valid == false){
            System.out.println("Enter your name");
        
            String value = sc.nextLine();

            if(value.length() < 1){
                System.out.println("You must enter a non-blank value");
                continue;
            }

            inputs[0] = value;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doAction(String[] inputs) {

        String playersName = inputs[0];
        Player player = GameControl.savePlayer(playersName);
        if(player == null){
            System.out.println("Could not create player"
                + "Enter a different name.");
            return false;
        }
        System.out.println("================================================= Welcome to the game " + playersName + " We hope you have a lot of fun!"
                + "=================================================");
        
        //mainMenuView = Create a new MainMenuView object
        //mainMenuView.displayMainMenuView()
        return true;
    }
}
