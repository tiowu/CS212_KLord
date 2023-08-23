/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.*;
import java.awt.event.*;

public class ConvertMenuHandler implements ActionListener{
   private JFrame myFrame;
   /**
    * object of handler class needs JFrame too
    * @param myFrame JFrame parameter
    */
   public ConvertMenuHandler(JFrame myFrame) {
      this.myFrame = myFrame;
   }
   /**
    *  when "Roman to Arabic" menu item is clicked on, this method will respond by prompting user for a roman numeral input for conversion. 
    *  If invalid entry entered, error message will be printed to the console instead of GUI 
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      String userInput;
      
      if(menuName.equals("Roman to Arabic")) {
         userInput = JOptionPane.showInputDialog(null, "Enter a roman numeral: ");
         try {
            RomanNumeral rn = new RomanNumeral(userInput);
            JOptionPane.showMessageDialog(null, "Its Arabic Value is " + rn.getArabicNum());

         }
         catch (IllegalRomanNumeralException irne) {
            //JOptionPane.showMessageDialog(null, "The roman numeral, " + userInput + ", you entered is illegal.");
            //irne.printStackTrace();
            System.out.println(irne.getMessage());
         }
         catch (IllegalArgumentException iae) {
            System.out.println("An exception has occurred");
         }
         //try-catch blocks ensure handling of IllegalRomanNumeralExceptions, namely an illegal roman numeral that users enter before notifying users 
      }
   }
}
