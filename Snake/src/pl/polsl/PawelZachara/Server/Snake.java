package pl.polsl.PawelZachara.Server;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Paweł Zachara
 * @version 1.1
 * @since 2019-11-02
 */
public class Snake extends JPanel {

    /**
     * number of snake joints
     */
    private int snakeJoints;
    /**
     * number of all field on board
     */
    private final int allFields = 900;
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
    private final int appleRandomSpawnPos = 29;
    /**
     * delay used for setting game speed
     */
    private final int delay = 140;
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
    * variable that tells if the game is on or off;
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
     * reference to player
     */
    private Player player;

    /**
     * Snake class constructor initialise calling initGame method and setting
     * board reference
     *
     * @param board
     */
    public Snake(Board board,Player player) {
        this.board = board;
        this.player = player;
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
    public Direction getSnakeCurrentDirection() {
        return this.snakeCurrentDirection;
    }

    /**
     * @param direction direction in which snake will now go
     */
    public void setSnakeDirection(Direction direction) {
        this.snakeCurrentDirection = direction;
    }

    /**
     * @return appleSpawnPosition
     */
    public int getAppleRandomSpawnPos() {
        return appleRandomSpawnPos;
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
     * @return list of allSnakeJoints at Y positions
     */
    public List<Integer> getAllSnakeJointsYPos() {
        return allSnakeJointsYPos;
    }

    /**
     * @param index the index in list where the value will be set
     * @param value the value which will be set on given index
     */
    public void setAllSnakeJointsXPosElem(int index, int value) {
        this.allSnakeJointsXPos.set(index, value);
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
    public void setAllSnakeJointsYPosElem(int index, int value) {
        this.allSnakeJointsYPos.set(index, value);
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
     * @return the timer
     */
    public Timer getTimer() {
        return timer;
    }
    
    /**
     * method that initialise game state timer and spawns snake
     * @param player
     */
    public void initGame() {

        allSnakeJointsXPos = Arrays.asList(new Integer[allFields]);

        allSnakeJointsYPos = Arrays.asList(new Integer[allFields]);

        for (Integer item : allSnakeJointsXPos) {
            item = 0;
        }

        for (Integer item : allSnakeJointsYPos) {
            item = 0;
        }

        setSnakeJoints(3);

        for (int z = 0; z < 3; z++) {
            allSnakeJointsXPos.set(z, 50 - z * 10);
            allSnakeJointsYPos.set(z, 50);
        }

        spawnApple();

        timer = new Timer(delay, board);
        getTimer().start();
    }

    /**
     * method checks if snake has collision with apple , if true snake grow and
     * new apple is spawned
     */
    public void checkAppleCollision() {

        if ((allSnakeJointsXPos.get(0) == appleXPos) && (allSnakeJointsYPos.get(0) == appleYPos)) {
            snakeJoints += 1;
            int currentScore = player.getScore();
            currentScore++;
            player.setScore(currentScore);
            spawnApple();
        }
    }

    /**
     * method that moves snake head depending on direction from input
     */
    public void move() {
        int foo;
        
        for (int z = snakeJoints; z > 0; z--) 
        {
            foo = allSnakeJointsXPos.get(z - 1);
            allSnakeJointsXPos.set(z, foo);
            foo = allSnakeJointsYPos.get(z - 1);
            allSnakeJointsYPos.set(z, foo);
        }

        if (snakeCurrentDirection == Direction.LEFT) {
            foo = allSnakeJointsXPos.get(0);
            allSnakeJointsXPos.set(0, foo -= board.getFieldSize());
        }

        if (snakeCurrentDirection == Direction.RIGHT) {
            foo = allSnakeJointsXPos.get(0);
            allSnakeJointsXPos.set(0, foo += board.getFieldSize());
        }

        if (snakeCurrentDirection == Direction.UP) {
            foo = allSnakeJointsYPos.get(0);
            allSnakeJointsYPos.set(0, foo -= board.getFieldSize());
        }

        if (snakeCurrentDirection == Direction.DOWN) {
            foo = allSnakeJointsYPos.get(0);
            allSnakeJointsYPos.set(0, foo += board.getFieldSize());
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

        if (allSnakeJointsYPos.get(0) >= board.getBoardHeight()) {
            inGame = false;
        }

        if (allSnakeJointsYPos.get(0) < 0) {
            inGame = false;
        }

        if (allSnakeJointsXPos.get(0) >= board.getBoardWidth()) {
            inGame = false;
        }

        if (allSnakeJointsXPos.get(0) < 0) {
            inGame = false;
        }

        if (!inGame) {
            getTimer().stop();
        }
    }

    /**
     * method spawn apple in random position
     */
    public void spawnApple() {

        appleXPos = (int) (Math.random() * appleRandomSpawnPos) * board.getFieldSize();
        appleYPos = (int) (Math.random() * appleRandomSpawnPos) * board.getFieldSize();

    }


}
