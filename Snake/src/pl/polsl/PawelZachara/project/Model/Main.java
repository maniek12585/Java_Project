/**
 * Simple snake game
 * 
* @author  Paweł Zachara
* @version 1.1
 *@since   2019-11-02
*/


package pl.polsl.PawelZachara.project.Model;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pl.polsl.PawelZachara.Server.Board;
import pl.polsl.PawelZachara.Server.Player;
import pl.polsl.PawelZachara.Server.Snake;


public class Main extends JFrame {

    /**
     * main window reference
     */
//    public static JFrame mainWindow;

    /**
     *Main class contructor where the interface is initialised
     */
    public Main() {
        initUI();
    }
    /**
     * method that initialise user interface
     */
    private void initUI() {
       
        String name = JOptionPane.showInputDialog(this, "What's your name ? ");

        if("".equals(name))
        {
            try {
                throw new Exception();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Pass your name", "Pass your name", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            Player player = new Player(name);
            Board board = new Board();
            board.initBoard(player);
            Snake snake = new Snake(board,player);
            board.setSnake(snake);
            board.initBoardView(snake);
            add(board);

            setResizable(false);
            pack();

            setTitle("Snake");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    /**
     * main program method where main window is initialised
     * @param args array of arguments passed from running app in terminal
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            
            JFrame window = new Main();
            window.setVisible(true);
        });
    }
}