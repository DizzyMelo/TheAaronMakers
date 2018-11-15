/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;

/**
 *
 * @author 1
 */
public abstract class View implements ViewInterface {
    
    public View(){
        
        @Override
        public void display(){
        boolean endView = false;
        
        do{
            double[] inputs = getInputs();
            if(inputs[0] <= 0){
                System.out.println("You must enter a value greater than zero");
                continue;
            }
            endView = doAction(inputs);
        }while(endView == false);
    }
        @Override    
        public String getInput(String promptMessage){
        double[] inputs = new double[1];
        
        System.out.println(promptMessage);
        
        boolean valid = false;
        
        while(valid == false){
            int value = sc.nextInt();

            if(String.valueOf(value).length() < 1){
                System.out.println("You must enter a value");
                continue;
            }

            inputs[0] = value;
            valid = true;
    }    
    }
    
}
