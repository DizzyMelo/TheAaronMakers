/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Actor;
import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.InventoryItemType;
import CIT260.CityOfAaron.model.Location;
import CIT260.CityOfAaron.model.Map;
import CIT260.CityOfAaron.model.QuestionLocation;
import CIT260.CityOfAaron.model.ResourceLocation;
import cityofaaronproject.CityOfAaronProject;
import java.awt.Point;
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
         
         Location[][] location = createLocations(noOfRows,noOfColumns);
         
         map.setLocations(location);
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
        Game game = CityOfAaronProject.getCurrentGame();
        
        if(game == null || rows < 1 || columns < 1){
            return null;
        }
        
        Location locations[][] = new Location[rows][columns];
        
        //Location 1
        ResourceLocation location = new ResourceLocation();
        locations[0][0] = location;

        location.setDescription("Here goes the description");
        location.setRow(0);
        location.setColumn(0);
        location.setHasResources(true);
        location.setVisited(false);
        location.setBloked(true);
        
        location.setAmountAvailable(1000);
        location.setAmountUsed(0);
        
        //Location 1
        ResourceLocation location1 = new ResourceLocation();
        locations[0][1] = location1;

        location1.setDescription("Here goes the description");
        location1.setRow(0);
        location1.setColumn(0);
        location1.setHasResources(true);
        location1.setVisited(false);
        location1.setBloked(true);
        
        location1.setAmountAvailable(1000);
        location1.setAmountUsed(0);
        
        //Location 1
        ResourceLocation location2 = new ResourceLocation();
        locations[0][2] = location2;

        location2.setDescription("Here goes the description");
        location2.setRow(0);
        location2.setColumn(0);
        location2.setHasResources(true);
        location2.setVisited(false);
        location2.setBloked(true);
        
        location2.setAmountAvailable(1000);
        location2.setAmountUsed(0);
        
        //Location 3
        ResourceLocation location3 = new ResourceLocation();
        locations[0][3] = location3;

        location3.setDescription("Here goes the description");
        location3.setRow(0);
        location3.setColumn(0);
        location3.setHasResources(true);
        location3.setVisited(false);
        location3.setBloked(true);
        
        location3.setAmountAvailable(1000);
        location3.setAmountUsed(0);
        
        //Location 4
        ResourceLocation location4 = new ResourceLocation();
        locations[1][0] = location4;

        location4.setDescription("Here goes the description");
        location4.setRow(0);
        location4.setColumn(0);
        location4.setHasResources(true);
        location4.setVisited(false);
        location4.setBloked(true);
        
        location4.setAmountAvailable(1000);
        location4.setAmountUsed(0);
        
        //Location 5
        ResourceLocation location5 = new ResourceLocation();
        locations[1][1] = location5;

        location5.setDescription("Here goes the description");
        location5.setRow(0);
        location5.setColumn(0);
        location5.setHasResources(true);
        location5.setVisited(false);
        location5.setBloked(true);
        
        location5.setAmountAvailable(1000);
        location5.setAmountUsed(0);
        
        
        
        
        //Location 6
        QuestionLocation location6 = new QuestionLocation();
        locations[1][2] = location6;

        location6.setDescription("Here goes the description");
        location6.setRow(0);
        location6.setColumn(0);
        location6.setHasResources(true);
        location6.setVisited(false);
        location6.setBloked(true);
        
        location6.setRequiredCorrect(true);
        location6.setNoCorrect(true);
        location6.setBonus(0);
        
        //Location 7
        QuestionLocation location7 = new QuestionLocation();
        locations[1][3] = location7;

        location7.setDescription("Here goes the description");
        location7.setRow(0);
        location7.setColumn(0);
        location7.setHasResources(true);
        location7.setVisited(false);
        location7.setBloked(true);
        
        location7.setRequiredCorrect(true);
        location7.setNoCorrect(true);
        location7.setBonus(0);
        
        //Location 8
        ResourceLocation location8 = new ResourceLocation();
        locations[2][0] = location8;

        location8.setDescription("Here goes the description");
        location8.setRow(0);
        location8.setColumn(0);
        location8.setHasResources(true);
        location8.setVisited(false);
        location8.setBloked(true);
        
        location8.setAmountAvailable(1000);
        location8.setAmountUsed(0);
        
        //Location 9
        ResourceLocation location9 = new ResourceLocation();
        locations[2][1] = location9;

        location9.setDescription("Here goes the description");
        location9.setRow(0);
        location9.setColumn(0);
        location9.setHasResources(true);
        location9.setVisited(false);
        location9.setBloked(true);
        
        location9.setAmountAvailable(1000);
        location9.setAmountUsed(0);
        
        //Location 10
        QuestionLocation location10 = new QuestionLocation();
        locations[2][2] = location10;

        location10.setDescription("Here goes the description");
        location10.setRow(0);
        location10.setColumn(0);
        location10.setHasResources(true);
        location10.setVisited(false);
        location10.setBloked(true);
        
        location10.setRequiredCorrect(true);
        location10.setNoCorrect(true);
        location10.setBonus(0);
        
        //Location 11
        QuestionLocation location11 = new QuestionLocation();
        locations[2][3] = location11;

        location11.setDescription("Here goes the description");
        location11.setRow(0);
        location11.setColumn(0);
        location11.setHasResources(true);
        location11.setVisited(false);
        location11.setBloked(true);
        
        location11.setRequiredCorrect(true);
        location11.setNoCorrect(true);
        location11.setBonus(0);
        
        
        //Location 12
        ResourceLocation location12 = new ResourceLocation();
        locations[3][0] = location12;

        location12.setDescription("Here goes the description");
        location12.setRow(0);
        location12.setColumn(0);
        location12.setHasResources(true);
        location12.setVisited(false);
        location12.setBloked(true);
        
        location12.setAmountAvailable(1000);
        location12.setAmountUsed(0);
        
        //Location 13
        ResourceLocation location13 = new ResourceLocation();
        locations[3][1] = location13;

        location13.setDescription("Here goes the description");
        location13.setRow(0);
        location13.setColumn(0);
        location13.setHasResources(true);
        location13.setVisited(false);
        location13.setBloked(true);
        
        location13.setAmountAvailable(1000);
        location13.setAmountUsed(0);
        
        //Location 14
        QuestionLocation location14 = new QuestionLocation();
        locations[3][2] = location14;

        location14.setDescription("Here goes the description");
        location14.setRow(0);
        location14.setColumn(0);
        location14.setHasResources(true);
        location14.setVisited(false);
        location14.setBloked(true);
        
        location14.setRequiredCorrect(true);
        location14.setNoCorrect(true);
        location14.setBonus(0);
        
        //Location 11
        QuestionLocation location15 = new QuestionLocation();
        locations[3][3] = location15;

        location15.setDescription("Here goes the description");
        location15.setRow(0);
        location15.setColumn(0);
        location15.setHasResources(true);
        location15.setVisited(false);
        location15.setBloked(true);
        
        location15.setRequiredCorrect(true);
        location15.setNoCorrect(true);
        location15.setBonus(0);
        
        
        ArrayList<Actor> actors = new ArrayList<>();
        location.setActors(actors);
        
        ArrayList<InventoryItem> itemsInLocation = new ArrayList<>();
        location.setItemsInLocation(itemsInLocation);
        
        return locations;
    }

    private static int assignActorsToLocations(Location[][] locations){
        
        if(locations == null){
            return -1;
        }
        
        Location location = locations[0][0];
        location.setActor(Actor.Nephi);
        Point actorCoordinates = Actor.Nephi.getCoordinates();
        actorCoordinates.x = 0;
        actorCoordinates.y = 0;
        
        return 1;
    }

    private static int assignItemsToLocations( Location[][] locations,InventoryItem[] itemsInGame){
        
        if(locations == null || itemsInGame == null){
            return -1;
        }
        
        Location location = locations[0][0];
        location.setItem(itemsInGame[InventoryItemType.legume.ordinal()]);
        
        return 1;
    }
}
