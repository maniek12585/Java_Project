package pl.polsl.PawelZachara.Server;

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
 * @author Michal Sosna
 * @version 3.1
 * 
 * Arabic numerals to Roman calculator
 */

public class History {
    public void save(String inputNumberInStringType, String fileNameAndPath){
        /**
         * @param inputNumberInStringType
         * @param fileNameAndPath
         * @return null
         * 
         * Arabic numeral passed as String is saved
         * to specified file in certain path
         */
        
        List<String> previousInputs = new ArrayList<>();
       
        try{
            FileWriter fileWriter = new FileWriter(fileNameAndPath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(inputNumberInStringType);
            printWriter.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "File can not be written");
           
        }
        return;
    }
    
   public String read(String fileNameAndPath){
       /**
         * @param inputNumberInStringType
         * @return dataToShow.toString()
         * 
         * File from specified path is read
         * and data is parsed to String type
         */
       
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
