package pl.polsl.PawelZachara.NumberConversion.ModelTest;

import org.junit.*;
import pl.polsl.PawelZachara.NumberConversion.Server.InvalidRomanNumberException;


/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

public class InvalidNumberExceptionTest {
    InvalidRomanNumberException ex = new InvalidRomanNumberException();
    
    /**
     * Test for values not in range
     * @throws InvalidRomanNumberException
     */
    @Test(expected = InvalidRomanNumberException.class)
    public void shouldThrowInvalidNumberException() throws InvalidRomanNumberException{
        String value = "MMMMM";
        
        ex.check(value);
        
        System.out.println("InvalidNumberException - test passed negative");
    }   
}