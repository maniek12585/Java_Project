package pl.polsl.PawelZachara.NumberConversion.ModelTest;

import org.junit.*;
import static org.junit.Assert.*;
import pl.polsl.PawelZachara.NumberConversion.Server.Converter;


/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

public class CalculationTest {
    
    /**
     * Tests for correct values
     */
    @Test
    public void testStringToIntCorrectValue(){
        Converter calc = new Converter();
        String inputValue = "MDXXIII";
        int expected = 1523;
        
        int real = calc.romanToDecimal(inputValue);
        
        assertEquals("Calculation: For value " + inputValue + " test passed negative", expected, real);
    }
    
    /**
     * Tests for incorrect values (out of range)
     */
    @Test
    public void testStringToIntIncorrectValue(){
        Converter calc = new Converter();
        int expected = -300;
        String inputValue = "-MMM";
        
        int real = calc.romanToDecimal(inputValue);
        
        assertEquals("Calculation: For value " + inputValue + " test passed negative", expected, real);
    }
    
    /**
     * Tests for limit values (0, which does not exist in Roman Numerals)
     */
    @Test
    public void testStringToIntLimitValue(){
        Converter calc = new Converter();
        String inputValue = " ";
        int expected = 0;
        
        int real = calc.romanToDecimal(inputValue);

        
        assertEquals("For value " + inputValue + " test passed negative", expected, real);
    }
}
