import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class RobotExp {
    
   static int[][] boardNumbers = new int[4][4];
   static Color[][] boardColours = new Color[4][4];
    
   public static void main(String[] args) {
      readBoard();
      determineColor(); 
      
      int q = 0;
   }
   
   public static int[][] getBoard() {
      return boardNumbers;
   }
      
   public static void readBoard() {
      try {
            
         Robot robot = new Robot();
         // Creates the delay of 5 sec so that you can open notepad before
         // Robot start writting
            
         Color find = robot.getPixelColor(0, 0);
         int red = 0;
         int blue = 0;
         int green = 0;
              
         //-Top to bottom, left to right 
         //-Prints the sequences Left to right,
         //top to bottom
         for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 4; i++) {
               int x = 480 + (j * 120);
               int y = (307 + (i * 106));
            
               //robot.mouseMove(x - 1, y - 1);
               
                  
               find = robot.getPixelColor(x, y);
                  
                     
               boardColours[i][j] = find;               
            }
         }                 
      } catch (AWTException e) {
            e.printStackTrace();
      }
    
   }
    
   public static void determineColor() {     
      for(int x = 0; x < 4; x++) {
         for(int y = 0; y < 4; y++) {
            Color c = boardColours[x][y];
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();
            //boardNumbers[x][y] = 1;
            //left to right, top to bottom
            boardNumbers[x][y] = colorToNumber(red, green, blue);
         } 
      }
   }
   
   public static int colorToNumber(int r, int g, int b) {
      
      if((r == 234) && (g == 222) && (b == 209)) {
         return 2;
      }
      if((r == 233) && (g == 218) && (b == 188)) {
         return 4;
      }
      if((r == 237) && (g == 161) && (b == 102)) {
         return 8;
      }
      if((r == 240) && (g == 129) && (b == 80)) {
         return 16;       
      }
      
      if((r == 193) && (g == 179) && (b == 163)) {
         return 0;         
      }
      
      return -1;
      
      /*
      if((r == 233) && (g == 222) && (b == 208)) {
         return 2;
      }
      if((r == 232) && (g == 218) && (b == 185)) {
         return 4;
      }
      if((r == 234) && (g == 163) && (b == 94)) {
         return 8;
      }
      */

   }
    
}

/*

                  red = find.getRed();
                  blue = find.getBlue();
                  green = find.getGreen();
                  
                  System.out.print(red + " " + blue
                     + " " + green + "     "); 
                     
                 //Staring with green b/c it has biggest variation
                     if((g >= 205) && (g <= 211)) {
         if((r >= 230) &&  (r <= 236)) {
            if((b >= 219) &&  (b <= 225)) {
               return 2;
            }
         } 
      }
      
      if((g >= 182) && (g <= 188)) {
         if((r >= 229) &&  (r <= 235)) {
            if((b >= 215) &&  (b <= 221)) {
               return 4;
            }
         } 
      }
      
      if((g >= 91) && (g <= 97)) {
         if((r >= 231) &&  (r <= 237)) {
            if((b >= 160) &&  (b <= 166)) {
               return 8;
            }
         } 
      }

*/