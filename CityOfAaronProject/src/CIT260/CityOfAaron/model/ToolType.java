/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

/**
 *
 * @author danielmelo
 */
public enum ToolType {
    Axe("Axe"),
    Hammer("Hammer"),
    Drill("Drill"),
    Shovel("Shovel"),
    Sickle("Sickle");
    
    private String name;

    private ToolType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
