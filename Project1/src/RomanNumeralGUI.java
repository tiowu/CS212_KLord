/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.JFrame;
import java.awt.*;

public class RomanNumeralGUI extends JFrame //Ensure this class inherits JFrame's functionality
{  
   /**
    * this method exists to convert roman numeral to arabic value, which is the core of this project
    * @param romanNum the roman numeral of String type
    * @return int the arabic value that is the sum of each individual roman numeral in integer form
    */
   public static int valueOf(String romanNum)
   {
      if(romanNum == null || romanNum.length() == 0)
      {
          System.out.println("Invalid Roman Numeral");
          System.exit(1);
      }//check to see if roman numerals passed in are valid before conversion
      
      int sum = 0, len = romanNum.length();
      int RomanToIntArray [] = new int [len];
        
      for(int i = len - 1; i >= 0; i--){
          if(romanNum.charAt(i) == 'I')
             RomanToIntArray[i] = 1;
          else if(romanNum.charAt(i) == 'V')
             RomanToIntArray[i] = 5;
          else if(romanNum.charAt(i) == 'X')
             RomanToIntArray[i] = 10;
          else if(romanNum.charAt(i) == 'L')
             RomanToIntArray[i] = 50;
          else if(romanNum.charAt(i) == 'C')
             RomanToIntArray[i] = 100;
          else if(romanNum.charAt(i) == 'D')
             RomanToIntArray[i] = 500;
          else if(romanNum.charAt(i) == 'M')
             RomanToIntArray[i] = 1000;
      }
      
      sum = RomanToIntArray[len - 1];//set sum to the rightmost integer in the array to ensure a correct result
      
      for(int i = len - 1; i > 0; i--){
          if(RomanToIntArray[i] > RomanToIntArray[i - 1])
             sum = sum - RomanToIntArray[i - 1];
          else 
             sum = sum + RomanToIntArray[i - 1];
      } //iterate through each letter in a roman numeral to tally the total arabic value 
      
      return sum;
   }
   
   /**
    * this method is to print out numbers on a custom GUI
    * @param myGUI custom GUI with JFrame functionality
    * @param romanNumArray String array to store roman numerals from the input file 
    */
   public static void printToGUI(RomanNumeralGUI myGUI, String [] romanNumArray) 
   {
      myGUI.setSize(500, 250);
      myGUI.setLocation(500, 300);
      myGUI.setTitle("Roman to Integer");
      myGUI.setLayout(new GridLayout(1, 2));
      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container myContentPane = myGUI.getContentPane();
      TextArea romanArea = new TextArea();
      TextArea arabicArea = new TextArea();
      myContentPane.add(romanArea);
      myContentPane.add(arabicArea);
      
      for(int i = 0; i < romanNumArray.length; i++) {
         if(romanNumArray[i] == null || romanNumArray[i].length() == 0)
         {
            romanArea.append("Invalid Roman Numeral" + "\n");
            arabicArea.append("-1" + "\t" + "\n");
         }   
         else
         {
            romanArea.append(romanNumArray[i] + "\n");
            arabicArea.append(valueOf(romanNumArray[i]) + "\n");
         }      
      }
      //print romanNum on the right side of Pane and arabicNum on the left side
      
      myGUI.setVisible(true); // show contentPane of RomanNumeralGUI
   }
}