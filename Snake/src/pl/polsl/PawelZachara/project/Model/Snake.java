package pl.polsl.PawelZachara.project.Model;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.Timer;
import pl.polsl.PawelZachara.project.View.Board;
/**
* @author  Paweł Zachara
* @version 1.1
* @since   2019-11-02
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
    private List<Integer> allSnakeJointsXPos;
    /**
     * array that represents snake joints y positions
     */
    private List<Integer> allSnakeJointsYPos;
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
    
     /*
    * current snake direction
    */
    private Direction snakeCurrentDirection = Direction.RIGHT;
    
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
     * @return current snake direction
     */
    public Direction getSnakeCurrentDirection()
    {
        return this.snakeCurrentDirection;
    }
    
      /**
     * @param direction direction in which snake will now go
     */
    public void setSnakeDirection(Direction direction)
    {
        this.snakeCurrentDirection = direction;
    }
    
    
    
    /**
     * @param index the index of element to get
     * @return element of list at given index
     */
    public Integer getAllSnakeJointsXPosElem(int index) {
        return allSnakeJointsXPos.get(index);
    }

        /**
     * @return list of allSnakeJoints at X positions
     */
    public List<Integer> getAllSnakeJointsXPos() {
        return allSnakeJointsXPos;
    }
    /**
     * @param index the index in list where the value will be set
     * @param value the value which will be set on given index
     */
    public void setAllSnakeJointsXPosElem(int index , int value)
    {
        this.allSnakeJointsXPos.set(index,value);
    }
    
    /**
     * @param index the index of element to get
     * @return element of list at given index
     */
    public Integer getAllSnakeJointsYPosElem(int index) {
        return allSnakeJointsYPos.get(index);
    }

     /**
     * @param index the index in list where the value will be set
     * @param value the value which will be set on given index
     */
    public void setAllSnakeJointsYPosElem(int index , int value)
    {
        this.allSnakeJointsYPos.set(index,value);
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
        
        allSnakeJointsXPos = Arrays.asList(new Integer[ALL_FIELDS]);
    
        allSnakeJointsYPos = Arrays.asList(new Integer[ALL_FIELDS]);
        
        for(Integer item : allSnakeJointsXPos)
        {
            item = 0;
        }
        
          for(Integer item : allSnakeJointsYPos)
        {
            item = 0;
        }
        
        setSnakeJoints(3);
        
        for (int z = 0; z < 3; z++) {
            allSnakeJointsXPos.set(z,50 - z *10);
            allSnakeJointsYPos.set(z,50);
        }
        
        spawnApple();

        timer = new Timer(DELAY, board);
        timer.start();
    }
    
    /**
     * method checks if snake has collision with apple , if true snake grow and new apple is spawned
     */
    public void checkAppleCollision() {

        if ((allSnakeJointsXPos.get(0) == appleXPos) && (allSnakeJointsYPos.get(0) == appleYPos)) {
            snakeJoints += 1;
            spawnApple();
        }
    }

    /**
     * method that moves snake head depending on direction from input
     */
    public void move() {
        int foo;
        try 
        {
            for (int z = snakeJoints; z > 0; z--) 
            {
                foo = allSnakeJointsXPos.get(z-1);
                allSnakeJointsXPos.set(z,foo);
                foo = allSnakeJointsYPos.get(z-1);
                allSnakeJointsYPos.set(z,foo);
            }
        }
        
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
        

        if (snakeCurrentDirection == Direction.LEFT) {
            foo =  allSnakeJointsXPos.get(0);
            allSnakeJointsXPos.set(0,foo -= board.getFIELD_SIZE());
        }

        if (snakeCurrentDirection == Direction.RIGHT) {
            foo =  allSnakeJointsXPos.get(0);
            allSnakeJointsXPos.set(0,foo += board.getFIELD_SIZE());
        }

        if (snakeCurrentDirection == Direction.UP) {
            foo =  allSnakeJointsYPos.get(0);
            allSnakeJointsYPos.set(0,foo -= board.getFIELD_SIZE());
        }

        if (snakeCurrentDirection == Direction.DOWN) {
            foo =  allSnakeJointsYPos.get(0);
            allSnakeJointsYPos.set(0,foo += board.getFIELD_SIZE());
        }
    }

    /**
     * method checks collision with walls
     */
    public void checkCollision() {

        for (int z = getSnakeJoints(); z > 0; z--) {

            if ((z > 4) && (Objects.equals(allSnakeJointsXPos.get(0), allSnakeJointsXPos.get(z))) && (Objects.equals(allSnakeJointsYPos.get(0), allSnakeJointsYPos.get(z)))) {
                inGame = false;
            }
        }

        if (allSnakeJointsYPos.get(0) >= board.getB_HEIGHT()) {
             inGame = false;
        }

        if (allSnakeJointsYPos.get(0) < 0) {
             inGame = false;
        }

        if (allSnakeJointsXPos.get(0) >= board.getB_WIDTH()) {
             inGame = false;
        }

        if (allSnakeJointsXPos.get(0) < 0) {
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
        setAppleXPos((int) (Math.random() * RAND_POS) * board.getFIELD_SIZE());
        setAppleYPos((int) (Math.random() * RAND_POS) * board.getFIELD_SIZE());
    }
    
}