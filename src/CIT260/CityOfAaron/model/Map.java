/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 1
 */
public class Map implements Serializable{
    
    private int location;
    private Point currentLocation;

    public Map() {
    }

    
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.location;
        hash = 89 * hash + Objects.hashCode(this.currentLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Map{" + "location=" + location + ", currentLocation=" + currentLocation + '}';
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.location != other.location) {
            return false;
        }
        if (!Objects.equals(this.currentLocation, other.currentLocation)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
