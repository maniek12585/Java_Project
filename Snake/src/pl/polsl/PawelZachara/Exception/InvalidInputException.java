/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.Exception;

/**
 * @author Michal Sosna
 * @version 3.1
 * 
 * Arabic numerals to Roman calculator
 */


public class InvalidInputException extends Exception{
    /**
     *
     * @param inputValue
     * @throws InvalidInputException
     */
    public void process(int inputValue) throws InvalidInputException{
        
        //process input
        System.out.println("invalid input");
        }
    }


