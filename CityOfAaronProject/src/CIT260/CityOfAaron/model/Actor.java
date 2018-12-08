/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author kss_s
 */
public enum Actor implements Serializable{
    
    Nephi("Nephi", "description", new Point(0,0)),
    Lehi("Lehi", "description", new Point(0,0)),
    Alma("Alma", "description", new Point(0,0)),
    Moroni("Moroni", "description", new Point(0,0)),
    Mormon("Mormon", "description", new Point(0,0));
    
    private String name, description;
    private Point coordinates;

    private Actor(String name, String description, Point coordinates) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + '}';
    }
    
}
