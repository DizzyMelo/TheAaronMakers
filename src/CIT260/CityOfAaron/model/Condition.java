/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;

import java.io.Serializable;

/**
 *
 * @author danielmelo
 */
public enum Condition{
    
    Good("Good"),
    Fair("Fair"),
    Poor("Poor");
    private String condition;

    private Condition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Condition{" + "condition=" + condition + '}';
    }
    
    
}
