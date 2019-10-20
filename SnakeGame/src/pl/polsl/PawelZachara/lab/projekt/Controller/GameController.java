/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.Controller;

import java.awt.EventQueue;
import pl.polsl.PawelZachara.lab.projekt.View.*;
import pl.polsl.PawelZachara.lab.projekt.Model.*;


/*
Cechy aplikacji do wykonania:

zdefiniowanie i rzucenie własnego wyjątku w modelu i jego obsługa w widoku (lub kontrolerze w przypadku MVC);

stosowanie sensownych komentarzy w języku angielskim do wszystkich klas. metod i pól (również prywatnych)
wygenerowanie dokumentacji w języku angielskim (javadoc) uwzględniającej autora i wersję klas oraz wszystkie ich składniki - również prywatne,
poprawne przygotowanie całości raportu w postaci zarchiwizowanego katalogu projektu NetBeans IDE.

*/
/**
 *
 * Main controller which control game state changes , snake movement and other conrol related things
 */
public class GameController 
{

    private  String playerName;
    private  GameWindow gameWindow;
    private  Map gameMap;
    private  SnakeController snakeController;
    /**
     * Method that initialize game controller variables and state
     * @param name
    */
    
    /**
     * Method that reset game state
    */
    public static void reset()
    {
    
    }
    
    /**
     * Method that update game state
    */
    public void update(int x,int y)
    {
        gameWindow.paintComponent(gameWindow,x, y);
    }
    
    
    public GameController()
    {
        gameWindow = new GameWindow();
        gameMap = new Map();
        snakeController = new SnakeController();
        snakeController.init();
        gameMap.init(600, snakeController.getSnake().getSNAKE_JOINT_SIZE());
        
        
    }
    
    public static class Main
    {
        
         public static void main(String args[]) {
            GameController gameController = new GameController();
            
            while(true)
            {
                for (int i = 0; i < 10; i++) {
                  gameController.update(i*10+100,i*5+100);               
                }
            }
            
//            EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {     
//                for (int i = 0; i < 10; i++) {
//                  gameController.update(i*10+100,i*5+100);               
//                }
//            }
//        });
        }
    }
   
}
