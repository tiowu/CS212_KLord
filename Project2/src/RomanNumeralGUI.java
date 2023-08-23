/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.JFrame;
import java.awt.*;

public class RomanNumeralGUI extends JFrame //Ensure this class inherits JFrame's functionality
{  
   /**
    * custom GUI method to print out roman numerals and their corresponding arabic values in sorted and unsorted order
    * @param SortedL filled up list of SortedRomanNumeralList type 
    * @param UnsortedL  filled up list of UnsortedRomanNumeralList type 
    * @param myGUI declared GUI object to be modified 
    */
   public static void printToGUI(SortedRomanNumeralList SortedL, UnsortedRomanNumeralList UnsortedL, RomanNumeralGUI myGUI) 
   {
      //set GUI basic settings
      myGUI.setSize(700, 250);
      myGUI.setLocation(400, 300);
      myGUI.setTitle("Roman to Integer in Unsorted and Sorted Order");
      myGUI.setLayout(new GridLayout(1, 3));
      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      Container myContentPane = myGUI.getContentPane();
      TextArea romanArea = new TextArea();
      TextArea SortedArabicArea = new TextArea();
      TextArea UnsortedArabicArea = new TextArea();
      myContentPane.add(romanArea);
      myContentPane.add(SortedArabicArea);
      myContentPane.add(UnsortedArabicArea);
      romanArea.append("Original RomanNumerals \n");
      SortedArabicArea.append("Unsorted Arabic Values \n");
      UnsortedArabicArea.append("Sorted Arabic Values \n");
      
      RomanNumeralNode u = new RomanNumeralNode(); //declare proxy node for while loop iteration
      RomanNumeralNode s = new RomanNumeralNode(); //declare proxy node for while loop iteration
      u = UnsortedL.first;
      s = SortedL.first;
      //iterate over the sorted and unsorted link lists and add their listNodes into 3 separate columns in the display GUI window
      while(u.next != null) {
         romanArea.append(u.next.data.getRomanNum() + "\n");
         SortedArabicArea.append(u.next.data.getArabicNum() + "\n");
         UnsortedArabicArea.append(s.next.data.getArabicNum() + "\n");
         u = u.next;
         s = s.next;
      }
      myGUI.setVisible(true); // show contentPane of RomanNumeralGUI
   }
}