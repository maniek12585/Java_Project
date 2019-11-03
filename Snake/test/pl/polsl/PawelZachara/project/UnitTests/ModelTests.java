/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.project.UnitTests;
import static org.junit.Assert.*;
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.polsl.PawelZachara.project.Model.*;
import pl.polsl.PawelZachara.project.View.Board;

/**
 *
 * @author Admin
 */
public class ModelTests {
    
  private Board board;  
  private Snake testSnake;
 
    @Before
    public void init() {
        board = new Board();
        testSnake = new Snake(board);
    }
 
    @Test
    public void testGetSnakeCurrentDirection() {
        assertNotNull(testSnake.getSnakeCurrentDirection());
    }
 
    @Test
    public void testGetAllSnakeJointsXPos() {
        assertNotNull(testSnake.getAllSnakeJointsXPos());
    }
 
    @After
    public void destroy() {
        System.out.println("garbage collector will destroy initializes objects on its own");
    }

}
