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
public class StorageShed {
    Location location;
    ResourcesType type;
    double quantity;

    public StorageShed() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ResourcesType getType() {
        return type;
    }

    public void setType(ResourcesType type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    
    
}
