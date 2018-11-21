/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

/**
 *
 * @author kss_s
 */
public class ResourceLocation extends Location{
    private int amountAvailable, amountUsed;

    public ResourceLocation() {
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.amountAvailable;
        hash = 29 * hash + this.amountUsed;
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
        final ResourceLocation other = (ResourceLocation) obj;
        if (this.amountAvailable != other.amountAvailable) {
            return false;
        }
        if (this.amountUsed != other.amountUsed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResourceLocation{" + "amountAvailable=" + amountAvailable + ", amountUsed=" + amountUsed + '}';
    }
    
    
}
