
import CIT260.CityOfAaron.model.Animal;
import CIT260.CityOfAaron.model.Condition;
import CIT260.CityOfAaron.model.InventoryItem;
import CIT260.CityOfAaron.model.ItemType;
import CIT260.CityOfAaron.model.Provision;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1
 */
public class CityOfAaronProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InventoryItem item = new InventoryItem();
        item.setName("Hammer");
        item.setQuantity(10);
        item.setCondition(Condition.Good);
        item.setItemType(ItemType.Tool);
        
        Animal animal = new Animal();
        animal.setName("Horse");
        animal.setAge(5);
        
        Provision provision = new Provision();
        provision.setName("Wheat");
        provision.setPerishable(true);
        
        System.out.println(item);
        System.out.println(animal);
        System.out.println(provision);
        
    
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Select the Resource type");
        System.out.println("G - Grains\n"
                + "L - Legumes\n"
                + "O - Oil\n"
                + "D - Drinking Water\n"
                + "H - Honey\n"
                + "S - Salt\n"
                + "Q - Quit\n");
        
        String op = sc.nextLine();
        
        switch(op){
            case "G":
                System.out.println("you selected grains");
                break;
            case "L":
                System.out.println("you selected legumes");
                break;
            case "O":
                System.out.println("you selected oil");
                break;
            case "D":
                System.out.println("you selected water");
                break;
            case "H":
                System.out.println("you selected honey");
                break;
            case "S":
                System.out.println("you selected salt");
                break;
            case "Q":
                System.out.println("you selected quit");
                break;
        }
    }
}