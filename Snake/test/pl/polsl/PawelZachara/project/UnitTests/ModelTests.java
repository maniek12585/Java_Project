/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.project.UnitTests;

import pl.polsl.PawelZachara.Server.Snake;
import pl.polsl.PawelZachara.Server.Player;
import pl.polsl.PawelZachara.Server.Board;
import java.awt.Color;
import java.awt.Dimension;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class ModelTests {

    @Test
    public void testSnakeJointsCount() {
        //GIVEN
        Board board = new Board();
        Player player = new Player("Kowalski");
        Snake snake = new Snake(board,player);
        
        //WHEN
        snake.initGame();
        
        //THEN
        assertEquals(snake.getSnakeJoints(), 3);
        System.out.println("Something went wrong while initializing snake length");
    }
    
    @Test
    public void testSnakeInit() {
        //GIVEN
        Board board = new Board();
        Player player = new Player("Kowalski");
        Snake snake = new Snake(board,player);
        
        //WHEN
        snake.initGame();
        
        //THEN
        assertNull(snake.getAllSnakeJointsXPos());
        assertNull(snake.getAllSnakeJointsYPos());
        assertNull(snake.getTimer());

        System.out.println("Something went wrong during snake init");
    }
    
    @Test
    public void testBoardInit() {
        //GIVEN
        Board board = new Board();
        Player player = new Player("Kowalski");
        Snake snake = new Snake(board,player);
        
        //WHEN
        board.initBoard(player);
        
        //THEN
        assertEquals(board.getBackground(), Color.black);
        assertEquals(board.getPreferredSize(),new Dimension(board.getBoardWidth(),board.getBoardHeight()));
        System.out.println("Something went wrong during board init");
    }
    
    @Test
    public void testImageLoad() {
        //GIVEN
        Board board = new Board();
        
        //WHEN
        board.loadImages();
        
        //THEN
        assertNull(board.getHeadImage());
        assertNull(board.getAppleImage());
        assertNull(board.getSnakeJointImage());
        System.out.println("Something went wrong loading images");
    }
}
