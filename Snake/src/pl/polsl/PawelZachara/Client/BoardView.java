/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.Client;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import pl.polsl.PawelZachara.Server.Snake;

/**
 *
 * @author Admin
 */
public class BoardView extends JPanel{

    /**
     * board width 
     */
    private int boardWidth;
    
    /**
     * board height
     */
    private int boardHeight;
    
    /**
     * @param boardWidth the boardWidth to set
     */
    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }
    
    /**
     * @param boardHeight the boardHeight to set
     */
    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    /**
     * prints game over when player loose
     * @param graphicsComponent is board graphic component
     */
    private void gameOver(Graphics graphicsComponent, int playerScore) {
        
        String msg = "Game Over , Your score : " + playerScore;
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        graphicsComponent.setColor(Color.white);
        graphicsComponent.setFont(small);
        graphicsComponent.drawString(msg, (boardWidth - metr.stringWidth(msg)) / 2, boardHeight / 2);
    }
    
    /**
     * own implemented logic that draws snake on board
     *
     * @param graphicsComponent is board graphic component
     * @param snake snake reference to get info about position
     * @param playerName player name
     * @param apple apple to draw
     * @param head snake head to draw
     * @param snakeJoint snake joint to draw
     * @param playerScore player score displayed at the end of game
     */
    public void doDrawing(Graphics graphicsComponent,Snake snake,String playerName,Image apple, Image head, Image snakeJoint,int playerScore) {
        if (snake.isInGame()) {

            graphicsComponent.drawImage(apple, snake.getAppleXPos(), snake.getAppleYPos(), this);

            for (int z = 0; z < snake.getSnakeJoints(); z++) {
                if (z == 0) {
                    graphicsComponent.drawImage(head, snake.getAllSnakeJointsXPosElem(z), snake.getAllSnakeJointsYPosElem(z), this);
                } else {
                    graphicsComponent.drawImage(snakeJoint, snake.getAllSnakeJointsXPosElem(z), snake.getAllSnakeJointsYPosElem(z), this);
                }
            }

            graphicsComponent.drawString(playerName, 0 , 0);
            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(graphicsComponent,playerScore);
        }
    }
}
