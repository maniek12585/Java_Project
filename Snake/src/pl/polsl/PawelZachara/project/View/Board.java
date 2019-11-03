/**
 * package containing model side of project 
 */
package pl.polsl.PawelZachara.project.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pl.polsl.PawelZachara.project.Model.Snake;
import pl.polsl.PawelZachara.project.Model.Direction;
/**
* @author  Paweł Zachara
* @version 1.1
 *@since   2019-11-02
*/
public class Board extends JPanel implements ActionListener {

    /**
    * window width
    */
    private final int B_WIDTH = 300;
    /**
    * window height
    */
    private final int B_HEIGHT = 300;
    /**
    * size of board field size
    */
    private final int FIELD_SIZE = 10;
    /**
     * snake reference
     */
    private Snake snake;
   
    /*
    *image for snake joint
    */
    private Image snakeJoint;
    /*
    *image for apple
    */
    private Image apple;
     /*
    *image for snake head
    */
    private Image head;

    /**
     * @return the B_WIDTH
     */
    public int getB_WIDTH() {
        return B_WIDTH;
    }

    /**
     * @return the B_HEIGHT
     */
    public int getB_HEIGHT() {
        return B_HEIGHT;
    }
    /**
     * @return the FIELD_SIZE
     */
    public int getFIELD_SIZE()
    {
        return FIELD_SIZE;
    }

    /**
     * class constructor
     */
    public Board() {
        
        initBoard();
        snake = new Snake(this);
        
    }
    
    /**
     * JPlane overrided method that draw whole graphic side of interface
     * @param g board graphic component
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    /**
     * method that draws player name on board
     * @param name name that player give
     */
    public void drawPlayerName(String name)
    {
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        this.getGraphics().setColor(Color.white);
        this.getGraphics().setFont(small);
        this.getGraphics().drawString(name, (getB_WIDTH() - metr.stringWidth(name)) / 2, getB_HEIGHT() - 10);
        
    }
    
    /**
     * overrided method that is called when acition (for exmaple key press) will be performed
     * @param e event performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (snake.isInGame()) {

            snake.checkAppleCollision();
            snake.checkCollision();
            snake.move();
        }

        repaint();
    }

    /**
     * method that initialise gameplay board
     */
    private void initBoard(){

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(getB_WIDTH(), getB_HEIGHT()));
        loadImages();
        
        
    }
    /**
     * method that loads images from drive
     */
    private void loadImages() {
       
            ImageIcon iid = new ImageIcon("src/resources/dot.png");
            snakeJoint = iid.getImage();

            ImageIcon iia = new ImageIcon("src/resources/apple.png");
            apple = iia.getImage();

            ImageIcon iih = new ImageIcon("src/resources/head.png");
            head = iih.getImage();

        }
        
    
    /**
     * own implemented logic that draws snake on board
     * @param g is board graphic component
     */
    private void doDrawing(Graphics g) {
        if (snake.isInGame()) {

            g.drawImage(apple, snake.getAppleXPos(), snake.getAppleYPos(), this);
            
            for (int z = 0; z < snake.getSnakeJoints(); z++) {
                if (z == 0) {
                    g.drawImage(head, snake.getAllSnakeJointsXPosElem(z), snake.getAllSnakeJointsYPosElem(z), this);
                } else {
                    g.drawImage(snakeJoint, snake.getAllSnakeJointsXPosElem(z), snake.getAllSnakeJointsYPosElem(z), this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    /**
     * prints game over when player loose
     * @param g is board graphic component
     */
    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (getB_WIDTH() - metr.stringWidth(msg)) / 2, getB_HEIGHT() / 2);
    }

    
    /*
    inner private class used for getting input 
    */
    private class TAdapter extends KeyAdapter {

        /**
        * overrided method that is called when key get pressed
        * @param e event from pressed key 
        */
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && !(snake.getSnakeCurrentDirection() == Direction.RIGHT)) {
                snake.setSnakeDirection(Direction.LEFT);
            }

            if ((key == KeyEvent.VK_RIGHT) && !(snake.getSnakeCurrentDirection() == Direction.LEFT)) {
                  snake.setSnakeDirection(Direction.RIGHT);
            }

            if ((key == KeyEvent.VK_UP) && !(snake.getSnakeCurrentDirection() == Direction.DOWN)) {
                snake.setSnakeDirection(Direction.UP);
            }
            
            if ((key == KeyEvent.VK_DOWN) && !(snake.getSnakeCurrentDirection() == Direction.UP)) {
                snake.setSnakeDirection(Direction.DOWN);
            }
        }
    }
    
}
