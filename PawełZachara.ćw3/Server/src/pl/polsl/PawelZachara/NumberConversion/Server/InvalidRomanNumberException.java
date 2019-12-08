package pl.polsl.PawelZachara.NumberConversion.Server;

import java.util.stream.IntStream;
/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

/**
 * own implemented exception for valid roman numerals
 */
public class InvalidRomanNumberException extends Exception {

    private static final String romanLetters = "MDCLXVI";

    /**
     *
     * @param inputValue
     * @throws InvalidRomanNumberException
     */
      public void check(String inputValue) throws InvalidRomanNumberException {
        /**
         * @param inputValue
         * @return null
         *
         * If number is not valid an exception is thrown
         */

        for (char letter : inputValue.toCharArray()) 
        {
            System.out.println(letter);
            if(romanLetters.indexOf(letter) == -1)
            {
                throw new InvalidRomanNumberException();
            }
        }
    }
}
