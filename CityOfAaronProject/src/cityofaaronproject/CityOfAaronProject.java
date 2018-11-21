package cityofaaronproject;


import CIT260.CityOfAaron.model.Animal;
import CIT260.CityOfAaron.model.Condition;
import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Provision;
import byui.cit260.CityOfAaron.view.StartProgramView;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class CityOfAaronProject {
    private static Game cerruentGame = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
    }

    public static Game getCerruentGame() {
        return cerruentGame;
    }

    public static void setCerruentGame(Game cerruentGame) {
        CityOfAaronProject.cerruentGame = cerruentGame;
    }
    
    
}