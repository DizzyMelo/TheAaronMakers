/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.awt.Point;
import java.util.Objects;

/**
 *
 * @author danielmelo
 */
public class Location {
    private Point point;
    private String description;
    private boolean visited, bloked;
    private boolean hasResources;
    

    public Location(Point point, String description, boolean visited, boolean bloked, boolean hasResources) {
        this.point = point;
        this.description = description;
        this.visited = visited;
        this.bloked = bloked;
        this.hasResources = hasResources;
    }

    

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.point);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + (this.visited ? 1 : 0);
        hash = 79 * hash + (this.bloked ? 1 : 0);
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
        if (this.visited != other.visited) {
            return false;
        }
        if (this.bloked != other.bloked) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.point, other.point)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "point=" + point + ", description=" + description + ", visited=" + visited + ", bloked=" + bloked + '}';
    }
    
    
}
