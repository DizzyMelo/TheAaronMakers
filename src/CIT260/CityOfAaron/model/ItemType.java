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
public enum ItemType {
    
    Animal("Animal"),
    Tool("Tool"),
    Provisions("Provisions");
    
    private String type;

    private ItemType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ItemType{" + "type=" + type + '}';
    }

    
}
