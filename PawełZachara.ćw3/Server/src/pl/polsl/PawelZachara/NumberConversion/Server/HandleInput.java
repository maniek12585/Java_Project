package pl.polsl.PawelZachara.NumberConversion.Server;

/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

/**
 * class that is responsible for handle input from client
 */
public class HandleInput {
    public String handleData(String textInput){
        Converter converter = new Converter();
        int result = 0;

        System.out.println(textInput);
        
        
        InvalidRomanNumberException notValidRomanNumber = new InvalidRomanNumberException();
        try {
            System.out.println(textInput);
            notValidRomanNumber.check(textInput);
            result = Converter.romanToDecimal(textInput);
        } 
        catch (InvalidRomanNumberException ex) {
            return " Sorry, your number is not valid roman number.";
        }
        return Integer.toString(result);
    }
    
    /**
    * saves hitory of usage
     * @param textInput
     * @return table with output data
    */
    public String handleHistory(String textInput){
        History history = new History();
        String tableWithOutputData = new String();
       
        try{

            InvalidRomanNumberException notValidRomanNumber = new InvalidRomanNumberException();
            try {
                notValidRomanNumber.check(textInput);
                tableWithOutputData = history.read(".\\data.txt") + textInput;
                history.save(textInput, ".\\data.txt");
            } 
            catch (InvalidRomanNumberException ex) {
            }
        }
        catch (NumberFormatException ex) {
        }
        return tableWithOutputData;
    }
}
