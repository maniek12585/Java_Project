/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Paweł Zachara
 */

/**
     * own implemented class to handle exception when player doesn't pass his name
     */
public class InitGameException extends Exception{
    /**
     * Non-parameter constructor
     */
    public InitGameException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     * @param parent parent in which message box will be displayed
     */
    public InitGameException(String message,JFrame parent) {
        super(message);
        JOptionPane.showMessageDialog(parent, message, message, JOptionPane.ERROR_MESSAGE);
    }
}
