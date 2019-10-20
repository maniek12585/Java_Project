package pl.polsl.PawelZachara.lab.projekt.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics2D;



/**
 *
 * Class implementing Window and all events associated with it
 */
public class GameWindow extends JPanel {
          
    private JDialog inputDialog;
    private JDialog errorDialog;
    private JTextField inputField;
    private GameArea gameArea = new GameArea();
    private char inputInfo;
    private JLabel playerNameLabel = new JLabel();
    private JFrame window = new JFrame();
    
    //snake current Pos temp for know
    
    /**
     * Creates new form Window
     */
    public GameWindow() {
        initComponents();
        window.setVisible(true);
    }
     
    public GameArea getGameArea()
    {
        return gameArea;
    }
    
    public void Draw(int x,int y)
    {
        gameArea.Draw(gameArea.getG2d(), x, y);
    }
    
    public char getInputInfo()
    {
        return inputInfo;
    }
    
    private void initComponents() {

        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Snake");
        

        
        window.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        
        
        inputDialog = CreateInputDialogBox("What is your name");
        errorDialog = CreateErrorDialogBox();

        gameArea = new GameArea();
        gameArea.setBackground(new java.awt.Color(0, 0, 0));
        gameArea.setPreferredSize(new java.awt.Dimension(600, 600));


        playerNameLabel.setFont(new java.awt.Font("Arial", 0, 24));
        playerNameLabel.setText("PlayerName");


        window.setContentPane(gameArea);

        
        
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
   
        playerNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        window.getContentPane().add(playerNameLabel);
        
        gameArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        window.pack();
        
        
    }     
    
    private JDialog CreateInputDialogBox(String inputQuestion)
    {
        JDialog dialogBox = new JDialog();
        this.inputField = new JTextField();
        JLabel nameQuestion = new JLabel();
        JButton okButton = new JButton();
        
        dialogBox.setAlwaysOnTop(true);
        
        dialogBox.setPreferredSize(new java.awt.Dimension(299, 150));
        
        
        inputField.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        inputField.setAlignmentX(javax.swing.SwingConstants.TOP);

        nameQuestion.setFont(new java.awt.Font("Tahoma", 0, 14));
        nameQuestion.setText(inputQuestion);
        nameQuestion.setAlignmentX(javax.swing.SwingConstants.CENTER);

        
        okButton.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        okButton.setText("Play");
        okButton.addActionListener(this::okButtonActionPerformed);
        okButton.setAlignmentX(javax.swing.SwingConstants.BOTTOM);
       
        
        dialogBox.setLayout(new BoxLayout(dialogBox.getContentPane(), BoxLayout.Y_AXIS));
   
        nameQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogBox.getContentPane().add(nameQuestion);
        
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogBox.getContentPane().add(inputField);
        
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogBox.getContentPane().add(okButton);
        
        dialogBox.pack();
        return dialogBox;
    }
    
    private JDialog CreateErrorDialogBox()
    {
        JDialog dialogBox = new JDialog();
        JLabel errorLabel = new JLabel();
        JButton errorButton = new JButton();
        
        dialogBox.setSize(new java.awt.Dimension(200, 200));

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        errorLabel.setText("DefaultError");
        errorLabel.setToolTipText("");
        errorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        errorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        errorButton.setText("Ok");
        
        dialogBox.setLayout(new BoxLayout(dialogBox.getContentPane(), BoxLayout.Y_AXIS));
   
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogBox.getContentPane().add(errorLabel);
        
        errorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogBox.getContentPane().add(errorButton);
        
        dialogBox.pack();
        
        return dialogBox;
    }
                                  
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        inputDialog.setVisible(true); 
    }                                 

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {         
      
        if(!"".equals(inputField.getText()))
        {
            playerNameLabel.setText("Player Name : " + inputField.getText());
            inputDialog.setVisible(false);
            inputDialog.dispose();
        }
    }
    
    
}
      

    
        

            
