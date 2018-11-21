/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author danielmelo
 */
public class Location {
    private int row, column;
    private String description;
    private boolean visited, bloked;
    private boolean hasResources;
    private ArrayList<Actor> actors;
    private ArrayList<InventoryItem> itemsInLocation;

    public Location() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBloked() {
        return bloked;
    }

    public void setBloked(boolean bloked) {
        this.bloked = bloked;
    }

    public boolean isHasResources() {
        return hasResources;
    }

    public void setHasResources(boolean hasResources) {
        this.hasResources = hasResources;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<InventoryItem> getItemsInLocation() {
        return itemsInLocation;
    }

    public void setItemsInLocation(ArrayList<InventoryItem> itemsInLocation) {
        this.itemsInLocation = itemsInLocation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.row;
        hash = 97 * hash + this.column;
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (this.visited ? 1 : 0);
        hash = 97 * hash + (this.bloked ? 1 : 0);
        hash = 97 * hash + (this.hasResources ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.actors);
        hash = 97 * hash + Objects.hashCode(this.itemsInLocation);
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (this.bloked != other.bloked) {
            return false;
        }
        if (this.hasResources != other.hasResources) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        if (!Objects.equals(this.itemsInLocation, other.itemsInLocation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", description=" + description + ", visited=" + visited + ", bloked=" + bloked + ", hasResources=" + hasResources + ", actors=" + actors + ", itemsInLocation=" + itemsInLocation + '}';
    }
    
}
