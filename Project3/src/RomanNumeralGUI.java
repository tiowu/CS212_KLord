/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.*;
import java.awt.*;

public class RomanNumeralGUI extends JFrame //Ensure this class inherits JFrame's functionality
{  
   /**
    * RomanNumeralGUI constructor that takes 3 parameters for the basic GUI settings 
    * @param title the name of the GUI
    * @param width the width of the GUI
    * @param height the height of the GUI
    */
   public RomanNumeralGUI(String title, int width, int height) {
      setTitle(title);
      setSize(width, height);
      setLocation(400, 300);
      createMenu();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true); // show contentPane of RomanNumeralGUI
   }
   /**
    * custom GUI method to print out roman numerals and their corresponding arabic values in sorted and unsorted order
    * @param SortedL filled up list of SortedRomanNumeralList type 
    * @param UnsortedL  filled up list of UnsortedRomanNumeralList type 
    * @param myGUI declared GUI object to be modified 
    */
   public void printToGUI(SortedRomanNumeralList SortedL, UnsortedRomanNumeralList UnsortedL, RomanNumeralGUI myGUI) {
      
      myGUI.setLayout(new GridLayout(1, 3));
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
   }
   /**
    * provide functionality to the user by adding graphical user interface elements such as menu bar and menu items in dropdown menus
    */
   public void createMenu() {
      JMenuBar myMenuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu convertMenu = new JMenu("Convert");
      JMenuItem myItem;
      
      FileMenuHandler fmh = new FileMenuHandler(this);
      ConvertMenuHandler cmh = new ConvertMenuHandler(this);
      
      myItem = new JMenuItem("Open");
      myItem.addActionListener(fmh);
      fileMenu.add(myItem);
      
      fileMenu.addSeparator();
      
      myItem = new JMenuItem("Quit");
      myItem.addActionListener(fmh);
      fileMenu.add(myItem);
      
      myItem = new JMenuItem("Roman to Arabic");
      myItem.addActionListener(cmh);
      convertMenu.add(myItem);
      
      setJMenuBar(myMenuBar);
      myMenuBar.add(fileMenu);
      myMenuBar.add(convertMenu);
   }
}