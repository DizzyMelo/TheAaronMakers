/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.Player;
import buyi.cit260.CityOfArron.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author danielmelo
 */
public class MainMenuView extends View {

    public MainMenuView() {
    }
    
    public void displayMainMenuView(){
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
        
        System.out.println("Select one of the options below:");
        System.out.println("N - Start new game\n"
                + "R - Restart existing game\n"
                + "H - Get help on how to play the game\n"
                + "E - Exit");
        
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
            case "N":
                startNewGame();
                break;
            case "R":
                restartGame();
                break;
            case "H":
                getHelp();
                break;
            case "E":
                return true;
            default:
                System.out.println("Invalid menu item");
                break;
        }
        
        return false;
    }
    
    public void startNewGame(){
        Game game = new Game();
        GameControl.createNewGame(GameControl.getPlayer());
        GameMenuView gameView = new GameMenuView();
        gameView.displayGameMenuView();
    }
    
    public void restartGame(){
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.displayStartExistingGameView();
    }
    
    public void getHelp(){
        HelpMenuView help = new HelpMenuView();
        help.displayHelpMenuView();
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
