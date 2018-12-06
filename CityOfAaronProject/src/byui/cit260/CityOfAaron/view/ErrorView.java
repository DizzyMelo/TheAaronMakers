/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.CityOfAaron.view;
import cityofaaronproject.CityOfAaronProject;
import java.io.PrintWriter;


/**
 *
 * @author danielmelo
 */
public class ErrorView {
    private static PrintWriter errorFile = CityOfAaronProject.getOutFile();
    private static PrintWriter logFile = CityOfAaronProject.getLogFile();

    public static PrintWriter getErrorFile() {
        return errorFile;
    }

    public static void setErrorFile(PrintWriter errorFile) {
        ErrorView.errorFile = errorFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        ErrorView.logFile = logFile;
    }
    
    public static void display(String className, String errorMessage){
        errorFile.println(
        "\n--- ERROR -----------------------------------------------------"
                + "\n" + errorMessage
                + "\n-----------------------------------------------------"
        );
        
        logFile.printf("%n%n%s", className + " - " + errorMessage);
    }
}
