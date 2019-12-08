package Properties;

import javax.swing.*;
import java.io.*;
import java.net.*;
import pl.polsl.PawelZachara.NumberConversion.Client.NewJPanel;

/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

/**
 * 
 * class implementing client behaviour
 */
public class Client {
 /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
    
        /**
         * Creating a window in JFrame:
         */
        JFrame frame = new JFrame("Roman numerals to arabic calculator");
        frame.setBounds(0, 0, 500, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setContentPane(new NewJPanel());
        frame.setVisible(true);
        
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        NewJPanel panel = new NewJPanel();
        
        
        Socket clientSocket = new Socket("localhost", 8888);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        sentence = panel.textInput;
        outToServer.writeBytes(sentence);
        modifiedSentence = inFromServer.readLine();
   
        clientSocket.close();
    }    
}
