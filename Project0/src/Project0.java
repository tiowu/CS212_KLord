/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.*; //import library for building graphical user interfaces 

public class Project0 {

   public static void main(String[] args) {

      while(true){ //infinite loop for continuous prompting window unless user chooses to exit  
         
         int lowerE = 0, upperE = 0;
         
         String userInput = JOptionPane.showInputDialog(null, "Type in a sentence: ");
         
         if(userInput.equalsIgnoreCase("stop")) System.exit(1);
         //terminate the program when user types in "stop" regardless of cases
         
         for(int i = 0; i < userInput.length(); i++) 
         {
            if(userInput.charAt(i) == 101) lowerE++;
            else if(userInput.charAt(i) == 69) upperE++;
         } //using for loop to iterate through each and every char in the user typed sentence and increment counter variables to keep track of numbers of e and E
         
         JOptionPane.showMessageDialog(null, "Number of lower case e's " + lowerE + "\nNumber of upper case e's " + upperE);
         //output findings via JOptionPane GUI window
      }

   }

}
