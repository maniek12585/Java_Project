/**
 * package containing model side of project
 */
package pl.polsl.PawelZachara.Server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pl.polsl.PawelZachara.Client.BoardView;

/**
 * @author Paweł Zachara
 * @version 1.2
 * @since 2019-11-30
 */

/**
     * board class that implements behaviours that happens on board
     */
public class Board extends JPanel implements ActionListener {

    /**
     * window width
     */
    private final int boardWidth = 300;
    /**
     * window height
     */
    private final int boardHeight = 300;
    /**
     * size of board field size
     */
    private final int fieldSize = 10;
    /**
     * snake reference
     */
    private Snake snake;

     /**
     * player reference
     */
    private Player player;
    /**
     * boardView reference
     */
    private BoardView boardView;
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
     * @return the snakeJoint image
     */
    public Image getSnakeJointImage() {
        return snakeJoint;
    }

    /**
     * @return the apple image
     */
    public Image getAppleImage() {
        return apple;
    }

    /**
     * @return the head image
     */
    public Image getHeadImage() {
        return head;
    }

    /**
     * @return the boardWidth
     */
    public int getBoardWidth() {
        return boardWidth;
    }

    /**
     * @return the boardHeight
     */
    public int getBoardHeight() {
        return boardHeight;
    }

    /**
     * @return the fieldSize
     */
    public int getFieldSize() {
        return fieldSize;
    }

    /**
     * sets snake reference in board class
     *
     * @param snake snake reference
     */
    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    
    /**
     * overrided method that is called when acition (for exmaple key press) will
     * be performed
     *
     * @param event event performed
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (snake.isInGame()) {

            snake.checkAppleCollision();
            snake.checkCollision();
            snake.move();
        }

        repaint();
    }

    /**
     * method that initialise gameplay board
     * @param playerName
     */
    public void initBoard(Player player) {
        this.player = player;
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(getBoardWidth(), getBoardHeight()));
        loadImages();
    }
    
    public void initBoardView(Snake snake)
    {
        boardView  = new BoardView();
        boardView.setBoardWidth(boardWidth);
        boardView.setBoardHeight(boardHeight);
    }
    
    /**
     * method that loads images from drive
     */
    public void loadImages() {

        ImageIcon imageIconDot = new ImageIcon("src/resources/dot.png");
        snakeJoint = imageIconDot.getImage();

        ImageIcon imageIconApple = new ImageIcon("src/resources/apple.png");
        apple = imageIconApple.getImage();

        ImageIcon imageIconHead = new ImageIcon("src/resources/head.png");
        head = imageIconHead.getImage();
    }

    /*
    inner private class used for getting input 
     */
    private class TAdapter extends KeyAdapter {
        
        
        /**
         * overrided method that is called when key get pressed
         *
         * @param event event from pressed key
         */
        @Override
        public void keyPressed(KeyEvent event) {

            int key = event.getKeyCode();

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

    
        /**
     * JPlane overrided method that draw whole graphic side of interface
     *
     * @param graphicsComponent board graphic component
     */
    @Override
    public void paintComponent(Graphics graphicsComponent) {
        super.paintComponent(graphicsComponent);
        boardView.doDrawing(graphicsComponent,snake,player.getPlayerName(), getAppleImage(), getHeadImage(), getSnakeJointImage(),player.getScore());
    }
}
