/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import java.util.StringTokenizer;//import the part of util package that pertains to tokenization of string-type input

public class Project1
{
   static RomanNumeralGUI myGUI = new RomanNumeralGUI();;
   
   public static void main(String[] args)
   {
      myGUI.printToGUI(myGUI, fillArray("input.txt"));
   }
   //calling RomanNumeralGUI print method with input file passed in as parameter 
   
   public static String[] fillArray(String myFile) 
   {
      int len = 8;
      String [] romanNumArray = new String [len];
      
      TextFileInput input = new TextFileInput(myFile);//create an object to read lines from the input file
      String line = input.readLine();

      StringTokenizer myTokens = new StringTokenizer(line, ",");//tokenize and store words seperated by delimiter ","  
      
      for(int i = 0; i < len; i++) {
         if(myTokens.countTokens() != 0) {
            romanNumArray[i] = myTokens.nextToken();
         }
         else {
            line = input.readLine();
            myTokens = new StringTokenizer(line, ",");
            romanNumArray[i] = myTokens.nextToken();
         }   
      }//store each roman numeral in the String numeral one by one into an string array by using .nextToken() method and .readLine()
      
      input.close(); 
      return romanNumArray;
   }
}