/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.InventoryItem;
import buyi.cit260.CityOfArron.exceptions.BarrelControlException;

/**
 *
 * @author danielmelo
 */
public class BarrelControl {
    public static double calculateVolume(double diameter, double height) throws BarrelControlException{
        if (diameter < 0){
            throw new BarrelControlException("Diameter has to be greater than zero.");
        }
        
         if (diameter > 100){
             throw new BarrelControlException("Diameter has to be smaller than one handred.");
         }
    
        if (height < 0){
            throw new BarrelControlException("Height has to be greater than zero.");
            
        }
        
         if (height > 200){
            throw new BarrelControlException("Height has to be greater than zero.");
         }
            
        double radius = diameter / 2;
        double volume = Math.PI * (radius * radius) * height;
        
        return volume;
    }
    public static double calculateMaximumWeight (double volume, double weight) throws BarrelControlException{
        if(volume <= 0){
            throw new BarrelControlException("Volume has to be greater than zero.");
        }
        if(weight <= 0){
            throw new BarrelControlException("Weight has to be greater than zero.");
        }
        double maximumWeight = volume * weight;
        
        return maximumWeight;
    }
    
}
