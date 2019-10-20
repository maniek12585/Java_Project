/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.Model;

import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Snake {

 
    private final int SNAKE_JOINT_SIZE = 20;
    private final int SNAKE_MAX_LENGTH = SNAKE_JOINT_SIZE * SNAKE_JOINT_SIZE - 116;

    
    private ArrayList<Point> snakeJoints = new ArrayList<>();
    /**
     * @return the SNAKE_JOINT_SIZE
     */
    public int getSNAKE_JOINT_SIZE() {
        return SNAKE_JOINT_SIZE;
    }

    

    
   
}
   
    

