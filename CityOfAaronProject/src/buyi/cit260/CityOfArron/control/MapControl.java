/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Map;


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
          return null;
      }
      
       private static int assignActorsToLocations(Location[][] locations){
           return 0;
       }
       
       private static int assignItemsToLocations( Location[][] locations,InventoryItem[] itemsInGame){
           return 0;
       }
}
