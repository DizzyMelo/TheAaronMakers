/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

import CIT260.CityOfAaron.model.Actor;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Player;
import buyi.cit260.CityOfArron.control.MapControl;
import buyi.cit260.CityOfArron.exceptions.MapControlException;
import java.util.Scanner;
import cityofaaronproject.CityOfAaronProject;

/**
 *
 * @author danielmelo
 */
public class MoveActorView extends View{

    public MoveActorView() {
    }
    
    @Override
    public String[] getInputs() {
        Scanner sc = new Scanner(System.in);
        String[] inputs = new String[2];
        
        System.out.println("Instructions to move to new location");
        String value = sc.nextLine();
        inputs[0] = value;
        
        value = sc.nextLine();
        inputs[1] = value;
        
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        int row = 0;
        int column = 0;
        String rowString = inputs[0];
        String columnString = inputs[1];
        try {
           row = Integer.parseInt(rowString);
           column = Integer.parseInt(columnString);
        }catch (NumberFormatException e){
           System.out.println("The row and column must be a number");
           return false;
        }
        Player player = CityOfAaronProject.getCurrentGame().getPlayer();
   
    
        Actor actor = null;
            try{
               Location newLocation = MapControl.moveActor(actor, row, column);
                       //MapControl.moveActor(actor, row, column);
                       }catch(MapControlException e){
                           System.out.println("error passed with the exception");
                           return false;
                       }
            
            System.out.println("description of the scene in the newLocation");

            return true;
    }
    
}
