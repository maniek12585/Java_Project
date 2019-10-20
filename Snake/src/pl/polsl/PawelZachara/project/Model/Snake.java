package pl.polsl.PawelZachara.project.Model;

import javax.swing.JPanel;
import javax.swing.Timer;
import pl.polsl.PawelZachara.project.View.Board;

/**
* @author  Paweł Zachara
* @version 1.0
* @since   2019-10-20 
*/

public class Snake extends JPanel  {

 
    /**
     * number of snake joints
     */
    private int snakeJoints;
    /**
     * number of all field on board
     */
    private int ALL_FIELDS = 900;
    /**
     * array that represents snake joints x positions
     */
    private int[] allSnakeJointsXPos = new int[ALL_FIELDS];
    /**
     * array that represents snake joints y positions
     */
    private int[] allSnakeJointsYPos = new int[ALL_FIELDS];
    /**
     * random snake spawn position
     */
    private int RAND_POS = 29;
    /**
     * delay used for setting game speed
     */
    private int DELAY = 140;
    /**
     * x apple position
     */
    private int appleXPos;
    /**
     * y apple position
     */
    private int appleYPos;
    /**
     * if snake turned left true else false;
     */
    private boolean leftDirection = false;
    /**
     * if snake turned right true else false;
     */
    private boolean rightDirection = true;
    /**
     * if snake turned up true else false;
     */
    private boolean upDirection = false;
    /**
     * if snake turned down true else false;
     */
    private boolean downDirection = false;
    
    /*
    * if game is on this is true else this is false;
    */
    private boolean inGame = true;
    /**
     * game timer
     */
    private Timer timer;
    /**
     * reference on game board
     */
    private Board board;
    
    /**
     *Snake class constructor initialise calling initGame method and setting board reference
     * @param board
     */
    public Snake(Board board)
    {
        this.board = board;
        initGame();
    }
    
      
    /**
     * @return the inGame
    */
    public boolean isInGame() {
        return inGame;
    }

    /**
     * @param inGame the inGame to set
     */
    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
    
    /**
     * @return the allSnakeJointsXPos
     */
    public int[] getAllSnakeJointsXPos() {
        return allSnakeJointsXPos;
    }

    /**
     * @param allSnakeJointsXPos the allSnakeJointsXPos to set
     */
    public void setAllSnakeJointsXPos(int[] allSnakeJointsXPos) {
        this.allSnakeJointsXPos = allSnakeJointsXPos;
    }

    /**
     * @return the allSnakeJointsYPos
     */
    public int[] getAllSnakeJointsYPos() {
        return allSnakeJointsYPos;
    }

    /**
     * @param allSnakeJointsYPos the allSnakeJointsYPos to set
     */
    public void setAllSnakeJointsYPos(int[] allSnakeJointsYPos) {
        this.allSnakeJointsYPos = allSnakeJointsYPos;
    }

    /**
     * @return the snakeJoints
     */
    public int getSnakeJoints() {
        return snakeJoints;
    }

    /**
     * @param snakeJoints the snakeJoints to set
     */
    public void setSnakeJoints(int snakeJoints) {
        this.snakeJoints = snakeJoints;
    }

    /**
     * @return the leftDirection
     */
    public boolean isLeftDirection() {
        return leftDirection;
    }

    /**
     * @param leftDirection the leftDirection to set
     */
    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    /**
     * @return the rightDirection
     */
    public boolean isRightDirection() {
        return rightDirection;
    }

    /**
     * @param rightDirection the rightDirection to set
     */
    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    /**
     * @return the upDirection
     */
    public boolean isUpDirection() {
        return upDirection;
    }

    /**
     * @param upDirection the upDirection to set
     */
    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }

    /**
     * @return the downDirection
     */
    public boolean isDownDirection() {
        return downDirection;
    }

    /**
     * @param downDirection the downDirection to set
     */
    public void setDownDirection(boolean downDirection) {
        this.downDirection = downDirection;
    }

    /**
     * @return the appleXPos
     */
    public int getAppleXPos() {
        return appleXPos;
    }

    /**
     * @param appleXPos the appleXPos to set
     */
    public void setAppleXPos(int appleXPos) {
        this.appleXPos = appleXPos;
    }

    /**
     * @return the appleYPos
     */
    public int getAppleYPos() {
        return appleYPos;
    }

    /**
     * @param appleYPos the appleYPos to set
     */
    public void setAppleYPos(int appleYPos) {
        this.appleYPos = appleYPos;
    }
    
    /**
     * method that initialise game state timer and spawns snake
     */
    public void initGame() {

        setSnakeJoints(3);

        for (int z = 0; z < getSnakeJoints(); z++) {
            getAllSnakeJointsXPos()[z] = 50 - z * 10;
            getAllSnakeJointsYPos()[z] = 50;
        }
        
        spawnApple();

        timer = new Timer(DELAY, board);
        timer.start();
    }
    
    /**
     * method checks if snake has collision with apple , if true snake grow and new apple is spawned
     */
    public void checkAppleCollision() {

        if ((getAllSnakeJointsXPos()[0] == getAppleXPos()) && (getAllSnakeJointsYPos()[0] == getAppleYPos())) {

            setSnakeJoints(getSnakeJoints() + 1);
            spawnApple();
        }
    }

    /**
     * method that moves snake head depending on direction from input
     */
    public void move() {
        try 
        {
            for (int z = getSnakeJoints(); z > 0; z--) 
            {
                getAllSnakeJointsXPos()[z] = getAllSnakeJointsXPos()[(z - 1)];
                getAllSnakeJointsYPos()[z] = getAllSnakeJointsYPos()[(z - 1)];
            }
        }
        
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        

        if (isLeftDirection()) {
            getAllSnakeJointsXPos()[0] -= board.getFIELD_SIZE();
        }

        if (isRightDirection()) {
            getAllSnakeJointsXPos()[0] += board.getFIELD_SIZE();
        }

        if (isUpDirection()) {
            getAllSnakeJointsYPos()[0] -= board.getFIELD_SIZE();
        }

        if (isDownDirection()) {
            getAllSnakeJointsYPos()[0] += board.getFIELD_SIZE();
        }
    }

    /**
     * method checks collision with walls
     */
    public void checkCollision() {

        for (int z = getSnakeJoints(); z > 0; z--) {

            if ((z > 4) && (getAllSnakeJointsXPos()[0] == getAllSnakeJointsXPos()[z]) && (getAllSnakeJointsYPos()[0] == getAllSnakeJointsYPos()[z])) {
                inGame = false;
            }
        }

        if (getAllSnakeJointsYPos()[0] >= board.getB_HEIGHT()) {
             inGame = false;
        }

        if (getAllSnakeJointsYPos()[0] < 0) {
             inGame = false;
        }

        if (getAllSnakeJointsXPos()[0] >= board.getB_WIDTH()) {
             inGame = false;
        }

        if (getAllSnakeJointsXPos()[0] < 0) {
             inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    /**
     * method spawn apple in random position
     */
    public void spawnApple() {

        int r = (int) (Math.random() * RAND_POS);
        setAppleXPos(r * board.getFIELD_SIZE());

        r = (int) (Math.random() * RAND_POS);
        setAppleYPos(r * board.getFIELD_SIZE());
    }
    

}