/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.util.Objects;

/**
 *
 * @author danielmelo
 */
public class Barrel {
    private double diamenter, height,volume,weight;
    private ResourcesType type;
    private int numberOfBarrelsAvailable;

    public Barrel() {
    }

    public double getDiamenter() {
        return diamenter;
    }

    public void setDiamenter(double diamenter) {
        this.diamenter = diamenter;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ResourcesType getType() {
        return type;
    }

    public void setType(ResourcesType type) {
        this.type = type;
    }

    public int getNumberOfBarrelsAvailable() {
        return numberOfBarrelsAvailable;
    }

    public void setNumberOfBarrelsAvailable(int numberOfBarrelsAvailable) {
        this.numberOfBarrelsAvailable = numberOfBarrelsAvailable;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.diamenter) ^ (Double.doubleToLongBits(this.diamenter) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.volume) ^ (Double.doubleToLongBits(this.volume) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.numberOfBarrelsAvailable;
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
        final Barrel other = (Barrel) obj;
        if (Double.doubleToLongBits(this.diamenter) != Double.doubleToLongBits(other.diamenter)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.volume) != Double.doubleToLongBits(other.volume)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (this.numberOfBarrelsAvailable != other.numberOfBarrelsAvailable) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Barrel{" + "diamenter=" + diamenter + ", height=" + height + ", volume=" + volume + ", weight=" + weight + ", type=" + type + ", numberOfBarrelsAvailable=" + numberOfBarrelsAvailable + '}';
    }

    
}
