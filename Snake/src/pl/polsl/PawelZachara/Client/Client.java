//package pl.polsl.PawelZachara.Client;
//
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import pl.polsl.PawelZachara.Server.Direction;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Admin
// */
//public class Client {
//    
//    static Direction inputInfo;
//    /*
//    inner private class used for getting input 
//     */
//    private class TAdapter extends KeyAdapter {
//        
//        /**
//         * overrided method that is called when key get pressed
//         *
//         * @param event event from pressed key
//         */
//        @Override
//        public void keyPressed(KeyEvent event) {
//
//            int key = event.getKeyCode();
//            
//            
//            
//            if ((key == KeyEvent.VK_LEFT) && !(snake.getSnakeCurrentDirection() == Direction.RIGHT)) {
//                
//                snake.setSnakeDirection(Direction.LEFT);
//            }
//
//            if ((key == KeyEvent.VK_RIGHT) && !(snake.getSnakeCurrentDirection() == Direction.LEFT)) {
//                snake.setSnakeDirection(Direction.RIGHT);
//            }
//
//            if ((key == KeyEvent.VK_UP) && !(snake.getSnakeCurrentDirection() == Direction.DOWN)) {
//                snake.setSnakeDirection(Direction.UP);
//            }
//
//            if ((key == KeyEvent.VK_DOWN) && !(snake.getSnakeCurrentDirection() == Direction.UP)) {
//                snake.setSnakeDirection(Direction.DOWN);
//            }
//        }
//    }
//    
//    
//    
//    private class InputPackage
//    {
//        private Direction snakeCurrentDirection;
//        
//        InputPackage(Direction direction)
//        {
//            snakeCurrentDirection = direction;
//        }
//    }
//}
