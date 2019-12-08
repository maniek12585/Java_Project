package pl.polsl.PawelZachara.NumberConversion.Server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;


/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

/**
 * class that is responsible for saving usage history 
 */
public class History {
    
    /**
    * @param input
    * @param fileNameAndPath
    * 
    * Arabic numeral passed as String is saved
    * to specified file in certain path
    */
    public void save(String input, String fileNameAndPath){
       
        List<String> previousInputs = new ArrayList<>();
       
       try{
            FileWriter fileWriter = new FileWriter(fileNameAndPath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(input);
            printWriter.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "File can not be written");
           
        }
        return;
    }
    
   /**
     * @param fileNameAndPath
    * @return dataToShow.toString()
    * 
    * File from specified path is read
    * and data is parsed to String type
    */
       
   public String read(String fileNameAndPath){
       
        StringBuilder dataToShow = new StringBuilder();
 
        try (Stream<String> stream = Files.lines(Paths.get(fileNameAndPath), StandardCharsets.UTF_8)) 
        {   
           stream.forEach(line -> dataToShow.append(line).append(", "));
        }
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "Cannot find 'data.txt'  - new file was made");
        }
 
        return dataToShow.toString();
    }
    
}
