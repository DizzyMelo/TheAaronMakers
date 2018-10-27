/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.CityOfAaron.model;



/*
   T - Timber
   O - Ore
   G - Grains
   L - Legumes
   O - Oil
   W - Drinking water
   H - Honey
   S - Salt
   Q - Quit

*/
/**
 *
 * @author danielmelo
 */
public enum ResourcesType {
   Timber(""),
   Ore(""),
   Grains(""),
   Legumes(""),
   Oil(""),
   Drinkingwater(""),
   Honey(""),
   Salt("");
   
   
   private String type;

    private ResourcesType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResourcesType{" + "type=" + type + '}';
    }
   
   
}
