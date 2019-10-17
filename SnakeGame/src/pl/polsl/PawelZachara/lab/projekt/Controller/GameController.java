/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.Controller;

import java.awt.EventQueue;
import java.awt.Window;
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

    private static String playerName;
    
    
    
    /**
     * Method that initialize game controller variables and state
    */
    public static void init(String name)
    {
        playerName = name;
        System.out.print(playerName);
    }
    
    /**
     * Method that reset game state
    */
    public static void reset()
    {
    
    }
    
    /**
     * Method that update game state
    */
    public static void update()
    {
    
    }
    
}

//CHANGE WINDOW.JAVA NA OSOBNY PLIK ZROBIC WŁASNY I PRZEKOPIOWAĆ ZAWARTOŚĆ 