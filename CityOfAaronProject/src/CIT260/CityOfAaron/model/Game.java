/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author 1
 */
public class Game implements Serializable{

   private Player player; 
   private String theMap;
   private String storeHouse;
   private int currentPopulation;
   private int acresOwned;
   private int wheatInStoreage;
   private Player thePlayer;
   private InventoryItem[] items;
   private Map map;
   
   

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
   
    public Game() {
    }
   
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getTheMap() {
        return theMap;
    }

    public void setTheMap(String theMap) {
        this.theMap = theMap;
    }

    public String getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(String storeHouse) {
        this.storeHouse = storeHouse;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public int getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public int getWheatInStoreage() {
        return wheatInStoreage;
    }

    public void setWheatInStoreage(int wheatInStoreage) {
        this.wheatInStoreage = wheatInStoreage;
    }

    public InventoryItem[] getItems() {
        return items;
    }

    public void setItems(InventoryItem[] items) {
        this.items = items;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.player);
        hash = 31 * hash + Objects.hashCode(this.theMap);
        hash = 31 * hash + Objects.hashCode(this.storeHouse);
        hash = 31 * hash + this.currentPopulation;
        hash = 31 * hash + this.acresOwned;
        hash = 31 * hash + this.wheatInStoreage;
        hash = 31 * hash + Objects.hashCode(this.thePlayer);
        hash = 31 * hash + Arrays.deepHashCode(this.items);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.currentPopulation != other.currentPopulation) {
            return false;
        }
        if (this.acresOwned != other.acresOwned) {
            return false;
        }
        if (this.wheatInStoreage != other.wheatInStoreage) {
            return false;
        }
        if (!Objects.equals(this.theMap, other.theMap)) {
            return false;
        }
        if (!Objects.equals(this.storeHouse, other.storeHouse)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.thePlayer, other.thePlayer)) {
            return false;
        }
        if (!Arrays.deepEquals(this.items, other.items)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + player + ", theMap=" + theMap + ", storeHouse=" + storeHouse + ", currentPopulation=" + currentPopulation + ", acresOwned=" + acresOwned + ", wheatInStoreage=" + wheatInStoreage + ", thePlayer=" + thePlayer + ", items=" + items + '}';
    }
   
    
}
