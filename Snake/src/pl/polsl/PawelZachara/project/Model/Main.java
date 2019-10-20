/**
* Snake - simple snake game 
* 
*
* @author  Paweł Zachara
* @version 1.0
* @since   2019-10-20 
*/


package pl.polsl.PawelZachara.project.Model;

import pl.polsl.PawelZachara.project.View.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main extends JFrame {

    /**
     * main window reference
     */
    public static JFrame mainWindow;

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

        if(name == "")
        {
            try {
                throw new Exception();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Pass your name", "Pass your name", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            Board board = new Board();
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
     */
    public static void main() {
        
        EventQueue.invokeLater(() -> {
            
            JFrame mainWindow = new Main();
            mainWindow.setVisible(true);
        });
    }
}