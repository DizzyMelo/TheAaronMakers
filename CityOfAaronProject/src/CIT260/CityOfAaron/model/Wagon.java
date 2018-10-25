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
public class Wagon {
    private double weight, weightAvailable;
    private Player player;

    public Wagon(double weight, double weightAvailable, Player player) {
        this.weight = weight;
        this.weightAvailable = weightAvailable;
        this.player = player;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeightAvailable() {
        return weightAvailable;
    }

    public void setWeightAvailable(double weightAvailable) {
        this.weightAvailable = weightAvailable;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.weightAvailable) ^ (Double.doubleToLongBits(this.weightAvailable) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.player);
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
        final Wagon other = (Wagon) obj;
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weightAvailable) != Double.doubleToLongBits(other.weightAvailable)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wagon{" + "weight=" + weight + ", weightAvailable=" + weightAvailable + ", player=" + player + '}';
    }
    
    
    
}
