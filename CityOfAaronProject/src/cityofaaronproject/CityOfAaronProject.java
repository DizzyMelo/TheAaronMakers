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
    private static Game currentGame = null;
    
    private static PrintWriter outfile = null;
    private static BufferedReader infile = null;
    
    public static PrintWriter getOutFile(){
    }
    
    public static void setOutFile(PrintWriter outFile){
        CityOfAaronProject.outFile = outFile;
    }
    
    public static BufferedReader getInFile(){
        return inFile; 
    }
    
    public static void setInfile(BufferedReader inFile){
         CityOfAaronProject = inFile;
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     try{  
        
        CityOfAaronProject.inFile =
                new BufferedReader(new InputStreamReader(System.in));
        
        CityOfAaronProject.outFile = new PrintWriter(System.out, true);
        
        // TODO code application logic here
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        return;
        
    } catch (Throwable e){
        
        System.out.println["Exception: " + e.toString()+
                           "\nCause:" + e.getCause() +
                           "\nMessage:" + e.getMessage()];
        
        e.printStackTrace();
    }
     
         finally{
         
         try{
         
             if (CityOfAaronProject.inFile != null);
                 CityOfAaronProject.inFile.close();
                 
             if (CityOfAaronProject.outFile != null)
                 CityOfAaronProject.outFile.close();
         
         } catch (IOException ex){
             System.out.println("Error closing files");
             return;
         }
     }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game cerruentGame) {
        CityOfAaronProject.currentGame = cerruentGame;
    }
    
    
}