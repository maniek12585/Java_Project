/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.PawelZachara.lab.projekt.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
class GameArea extends JPanel
{
        private Graphics2D g2d;
        private int xPos,yPos;

        
        public void setXPos(int x)
        {
            xPos = x;
        }
        public void setYPos(int y)
        {
            yPos = y;
        }   
        public Graphics2D getG2d()
        {
            return g2d;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            Draw(g,xPos,yPos);

        }
        
        public void Draw(Graphics g,int x,int y)
        {
            g2d.setColor(new Color(161, 243, 126));
            g2d.fillRect(xPos, yPos, 20, 20);
        
        }
        
        public GameArea()
        {
            g2d = (Graphics2D)this.getGraphics();
            System.out.print(g2d);
        }
        
    
}
