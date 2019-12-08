package pl.polsl.PawelZachara.NumberConversion.ModelTest;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import pl.polsl.PawelZachara.NumberConversion.Server.History;

/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

public class HistoryTest {
    
    /**
     * Tests for correct values
     */
    @Test
    public void testFileWriteRead(){
        String inputValue = "MMM";
        String path = ".\\testFile.txt";
        History history = new History();
        String expected = "3000, ";
       
        history.save(inputValue, path); 
        
        assertEquals("History: File operation for correct values - Test passed negative", expected, history.read(path));
        
        File file = new File(path);
        file.delete();
    }
    
    /**
     * Tests for incorrect values (our file uses only special letters)
     */
    @Test
    public void testFileWriteReadIncorrectValue(){
        String inputValue = "This should be text";
        String path = ".\\testFile.txt";
        History history = new History();
        String expected = "This should be text";
        
        history.save(inputValue, path);
               
        
        assertEquals("History: File operation for incorrect values - Test passed negative", expected, history.read(path));
        
        
        File file = new File(path);
        file.delete();
    }
    
    /**
     * Tests for incorrect path
     */
    @Test
    public void testFileWriteReadIncorrectPath(){

        String inputValue = "MMM";
        String path = ".\\testFileWrongName.txt";
        History history = new History();
        String expected = "MMM, ";
        history.save(inputValue, path);       
        
        
        assertEquals("History: File operation for incorrect path - Test passed negative", expected, history.read(path));
        
        File file = new File(path);
        file.delete();
    }
    
    /**
     * Tests for null values
     */
    @Test
    public void testFileWriteNullValue(){
        String inputValue = null;
        String path = ".\\testFile.txt";
        History history = new History();
        String expected = null + ", ";
        
        history.save(inputValue, path);
        
        assertEquals("History: File operation for null values - Test passed negative", expected, history.read(path));
        
         File file = new File(path);
        file.delete();
    }
}
