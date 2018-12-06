/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import java.util.Scanner;
import cityofaaronproject.CityOfAaronProject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1
 */
public abstract class View implements ViewInterface {
    
    protected final BufferedReader keyboard = CityOfAaronProject.getInFile();
    protected final PrintWriter console = CityOfAaronProject.getOutFile();
    
    public View(){
    }
        
    @Override
    public void display(){
        boolean endView = false;
        do{
            String[] inputs = getInputs();
            if(inputs[0].length() <= 0){
                ErrorView.display(this.getClass().getName(), "You must enter a value");
                continue;
            }
            endView = doAction(inputs);
        }while(endView == false);
    }
        @Override    
        public String getInput(String promptMessage){
            String[] inputs = new String[1];
        
            System.out.println(promptMessage);
        
            boolean valid = false;

            while(valid == false){
                try {
                    String value = this.keyboard.readLine();
                    
                    if(String.valueOf(value).length() < 1){
                        ErrorView.display(this.getClass().getName(), "You must enter a value");
                        continue;
                    }
                    
                    inputs[0] = value;
                    valid = true;
                } catch (IOException ex) {
                    System.out.println("There was a problem reading the input");
                    ErrorView.display(this.getClass().getName(), "There was a problem reading the input: " + ex.getMessage());
                }
            }
        return inputs[0];
    }
    
}
