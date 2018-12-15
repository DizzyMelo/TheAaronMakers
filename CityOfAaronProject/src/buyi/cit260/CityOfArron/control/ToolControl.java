/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buyi.cit260.CityOfArron.control;

import CIT260.CityOfAaron.model.Game;
import CIT260.CityOfAaron.model.Tool;
import CIT260.CityOfAaron.model.ToolType;
import cityofaaronproject.CityOfAaronProject;

/**
 *
 * @author danielmelo
 */
public class ToolControl {
    public static Tool[] addTools(ToolType type){
        Game game = CityOfAaronProject.getCurrentGame();
        Tool[] tools = game.getTools();
        
        Tool tool = tools[type.ordinal()];
        tool.setQuantity(tool.getQuantity()+1);
        tool.setType(type);
        
        return tools;
    }
}
