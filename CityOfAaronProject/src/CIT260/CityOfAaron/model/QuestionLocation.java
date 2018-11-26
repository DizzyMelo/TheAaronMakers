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
public class QuestionLocation extends Location{
    private boolean requiredCorrect, noCorrect;
    private int bonus;

    public QuestionLocation() {
    }

    public boolean isRequiredCorrect() {
        return requiredCorrect;
    }

    public void setRequiredCorrect(boolean requiredCorrect) {
        this.requiredCorrect = requiredCorrect;
    }

    public boolean isNoCorrect() {
        return noCorrect;
    }

    public void setNoCorrect(boolean noCorrect) {
        this.noCorrect = noCorrect;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.requiredCorrect ? 1 : 0);
        hash = 43 * hash + (this.noCorrect ? 1 : 0);
        hash = 43 * hash + this.bonus;
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
        final QuestionLocation other = (QuestionLocation) obj;
        if (this.requiredCorrect != other.requiredCorrect) {
            return false;
        }
        if (this.noCorrect != other.noCorrect) {
            return false;
        }
        if (this.bonus != other.bonus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QuestionLocation{" + "requiredCorrect=" + requiredCorrect + ", noCorrect=" + noCorrect + ", bonus=" + bonus + '}';
    }
    
    
}
