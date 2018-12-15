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
public enum InventoryItemType {
    lumber("Lumber",2),
    ore("Ore",1),
    grain("Grain",1),
    legume("Legume",2),
    oil("Oil",1),
    water("Water",1),
    honey("Honey",2),
    salt("Salt",1),
    axe("Axe",2),
    hammer("Hammer",5),
    drill("Drill",2),
    shovel("Shovel",3),
    sickle("Sickle",2),
    saw("Saw",1),
    nails("Nails",2);
    
    private String name;
    private double weight;

    private InventoryItemType(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
}
