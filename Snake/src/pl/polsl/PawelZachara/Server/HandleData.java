///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pl.polsl.PawelZachara.Server;
//import pl.polsl.PawelZachara.Exception.InvalidInputException;
//        
///**
// * @author Michal Sosna
// * @version 1.2
// * 
// */
//
//public class HandleData {
//    
//    public String handleData(int inputInfo){
//        History history = new History();
//        /**
//         * Exception is thrown if input data is not valid
//         */
//        
//        
//        
//        try{
//            int parsedInput = Integer.parseInt(textInput);
//
//            InvalidInputException wrongInput = new InvalidInputException();
//            try {
//                wrongInput.process(parsedInput);
//                tableWithOutputData = calc.calculate(parsedInput);
//
//            } 
//            catch (InvalidNumberException ex) {
//                //jLabel3.setText("Sorry, your number is not in the range of 1-3999.");
//                tableWithOutputData = "Sorry, your number is not in the range of 1-3999.";
//            }
//        }
//        catch (InvalidInputException ex) {
//            //jLabel3.setText("Sorry, please input a valid number - your input is not an integer.");
//            tableWithOutputData = "Sorry, please input a valid number - your input is not an integer.";
//        }
//        return tableWithOutputData;
//    }
//    
//    public String handleHistory(String textInput){
//        //Calculation calc = new Calculation();
//        History history = new History();
//        String tableWithOutputData = new String();
//        
//        //tableWithOutputData[0] = null;
//        //tableWithOutputData[1] = null;
//
//        /**
//         * Nested exception:
//         * First exception is thrown if input data is not a number
//         * Second exception is thrown if input data is a number, but it is also larger than 3999 or smaller than 1
//         */
//        try{
//            int parsedInput = Integer.parseInt(textInput);
//
//            InvalidNumberException numberOutOfRange = new InvalidNumberException();
//            try {
//                numberOutOfRange.process(parsedInput);
//                //jLabel3.setText(calc.calculate(parsedInput));
////                tableWithOutputData = calc.calculate(parsedInput);
//
//                //jLabel5.setText(history.read(".\\data.txt") + textInput);
//                tableWithOutputData = history.read(".\\data.txt") + textInput;
//                history.save(textInput, ".\\data.txt");
//            } 
//            catch (InvalidNumberException ex) {
//                //jLabel3.setText("Sorry, your number is not in the range of 1-3999.");
//                //tableWithOutputData = "Sorry, your number is not in the range of 1-3999.";
//            }
//        }
//        catch (NumberFormatException ex) {
//            //jLabel3.setText("Sorry, please input a valid number - your input is not an integer.");
//            //tableWithOutputData = "Sorry, please input a valid number - your input is not an integer.";
//        }
//        return tableWithOutputData;
//    }
//}
//
