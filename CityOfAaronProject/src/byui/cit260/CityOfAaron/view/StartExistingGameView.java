/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Game;
import buyi.cit260.CityOfArron.control.GameControl;
import cityofaaronproject.CityOfAaronProject;
import java.io.IOException;

/**
 *
 * @author danielmelo
 */
public class StartExistingGameView extends View{

    public StartExistingGameView() {
        
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        this.console.println("Start a saved game instructions");
        String input1 = this.getInput("Enter the path to start the saved the file");
        inputs[0] = input1;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[0];
        Game game = CityOfAaronProject.getCurrentGame();
        
        try {
            GameControl.getGame(filePath);
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error IO: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "Error E: " + ex.getMessage());
            return false;
        }
        
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
        
        
        return true;
    }
    
}
