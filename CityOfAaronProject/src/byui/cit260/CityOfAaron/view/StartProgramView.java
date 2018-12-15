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
public class StartProgramView extends View{

    public StartProgramView() {
    }
    
    public void displayStartProgramView(){
        boolean endOfView = false;
        
        do {
            String playersName = this.getInput("\n"
                    + "\t==========================================="
                    + "\n"
                    + "\t\tWelcome to this amazing Game"
                    + "\n"
                    + "\t==========================================="
                    + "\n\n"
                + "\n*** Enter your name ***\n");
            String[] input = new String[1];
            input[0] = playersName;
            if(input[0].toUpperCase().equals("Q")){
                return;
            }
            endOfView = doAction(input);
        }while(endOfView != true);
        
    }

    @Override
    public boolean doAction(String[] inputs) {

        String playersName = inputs[0];
        Player player = GameControl.savePlayer(playersName);
        if(player == null){
            System.out.println("Could not create player"
                + "Enter a different name.");
            return false;
        }
        System.out.println("=================================== Welcome to the game " + playersName + " We hope you have a lot of fun!"
                + "===================================");
        
        MainMenuView menuView = new MainMenuView();
        menuView.displayMainMenuView();
        return true;
    }

    @Override
    public String[] getInputs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


