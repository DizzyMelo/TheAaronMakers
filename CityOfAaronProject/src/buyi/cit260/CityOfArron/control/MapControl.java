/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Actor;
import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Map;
import CIT260.CityOfAaron.model.ResourceLocation;
import cityofaaronproject.CityOfAaronProject;
import java.util.ArrayList;


/**
 *
 * @author danielmelo
 */
public class MapControl {
         
     public static Map createMap(Game game,int noOfRows,int noOfColumns){
         System.out.println("Create map called");
         if(noOfRows < 0 || noOfColumns < 0){
             return null;
         }
         
         Map map = new Map();
         map.setDescription("This is the description");
         map.setNoOfRows(noOfRows);
         map.setNoOfColumns(noOfColumns);
         game.setMap(map);
         
         Location[][] location = createLocations(0,0);
         
         if(location == null){
             return null;
         }
         
         int success = assignActorsToLocations(location);
         
         if(success < 0){
             return null;
         }
         
         success = assignItemsToLocations(location, game.getItems());
         
         if(success < 0){
             return null;
         }
         
         return map;
     }
     
    public static Location[][] createLocations(int rows, int columns){
        Game game = CityOfAaronProject.getCerruentGame();
        
        if(game == null || rows < 1 || columns < 1){
            return null;
        }
        
        Location locations[][] = new Location[rows][columns];
        
        ResourceLocation location = new ResourceLocation();
        locations[0][0] = location;
        
        location.setDescription("Here goes the description");
        location.setRow(0);
        location.setColumn(0);
        location.setHasResources(false);
        location.setVisited(false);
        location.setBloked(true);
        
        location.setAmountAvailable(1000);
        location.setAmountUsed(0);
        
        ArrayList<Actor> actors = new ArrayList<>();
        location.setActors(actors);
        
        ArrayList<InventoryItem> itemsInLocation = new ArrayList<>();
        location.setItemsInLocation(itemsInLocation);
        
        return locations;
    }

    private static int assignActorsToLocations(Location[][] locations){
        return 0;
    }

    private static int assignItemsToLocations( Location[][] locations,InventoryItem[] itemsInGame){
        return 0;
    }
}
