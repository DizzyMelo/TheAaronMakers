package cityofaaronproject;


import CIT260.CityOfAaron.model.Animal;
import CIT260.CityOfAaron.model.Condition;
import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Player;
import CIT260.CityOfAaron.model.Provision;
import CIT260.CityOfAaron.model.Tool;
import byui.cit260.CityOfAaron.view.ErrorView;
import byui.cit260.CityOfAaron.view.StartProgramView;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
    private static Game currentGame = null;
    private static Player currentPlayer = null;
    
    private static PrintWriter outFile = null;
    private static PrintWriter logFile = null;
    private static BufferedReader inFile = null;
    private static ArrayList<Tool> tools = new ArrayList<>();

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        CityOfAaronProject.logFile = logFile;
    }
    
    public static PrintWriter getOutFile(){
        return outFile;
    }
    
    public static void setOutFile(PrintWriter outFile){
        CityOfAaronProject.outFile = outFile;
    }
    
    public static BufferedReader getInFile(){
        return inFile; 
    }
    
    public static void setInfile(BufferedReader inFile){
         CityOfAaronProject.inFile = inFile;
    }
        public static Game getCurrentGame(){
        return currentGame;
    }

    public static void setCurrentGame(Game cerruentGame) {
        CityOfAaronProject.currentGame = cerruentGame;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        CityOfAaronProject.currentPlayer = currentPlayer;
    }

    public static ArrayList<Tool> getTools() {
        return tools;
    }

    public static void setTools(ArrayList<Tool> tools) {
        CityOfAaronProject.tools = tools;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     try{  
        
        inFile = new BufferedReader(new InputStreamReader(System.in)); 
        outFile = new PrintWriter(System.out, true);
        logFile = new PrintWriter("logFile.txt");
        
        // TODO code application logic here
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        return;
        
    } catch (Throwable e){
        
        ErrorView.display("CityOfAaronProject", "Exception: " + e.toString()+
                                                "\nCause:" + e.getCause() +
                                                "\nMessage:" + e.getMessage());
        
        e.printStackTrace();
    }
     
         finally{
         
         try{
         
             if (inFile != null){
                 inFile.close();
             }
                 
             if (outFile != null){
                 outFile.close();
             }
             
             if (logFile != null){
                 logFile.close();
             }
         
         } catch (IOException ex){
             //System.out.println("Error closing files");
             ErrorView.display("CityOfAaronProject", "Error closing files");
             return;
            }
        } 
    }
    
}