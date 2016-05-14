import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.InputEvent;




public class RobotPlayer {

   static RobotExp game = new RobotExp();
   static Robot robot; 
   static int[][] board;
   
   public static void main(String[] args) {
      CreateBot();
      robot.mouseMove(1000, 365);
      robot.mousePress(InputEvent.BUTTON1_MASK);
      robot.mouseRelease(InputEvent.BUTTON1_MASK);
      robot.delay(100);
      
      robot.keyPress(KeyEvent.VK_UP);
       
      board = game.getBoard();
      
      while(1 == 1) {
      
         if(board[3][0] == 16 || board[3][0] == -1) {
            System.exit(0);
         }
      
         if(board[3][0] != 16) {
            game.readBoard();
            game.determineColor();
            board = game.getBoard();
            
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.delay(100);
         }
         
         
      }
      
      //System.out.println("Hello world");
   }
   
   public static void CreateBot() {
      try {
         robot = new Robot();
      } catch (AWTException e) {
            e.printStackTrace();
      }
   }
   //1000 365



}