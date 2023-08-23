/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

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
    * provide functionality to the user by adding graphical user interface elements such as menu bar and menu items in dropdown menus
    */
   public void createMenu() {
      JMenuBar myMenuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu convertMenu = new JMenu("Convert");
      JMenuItem myItem;
      
      FileMenuHandler fmh = new FileMenuHandler(this); //the handler needs a RomanNumeralGUI to display whatever actions that follows
      ConvertMenuHandler cmh = new ConvertMenuHandler(this);
      
      myItem = new JMenuItem("Open");
      myItem.addActionListener(fmh);//define what will happens by passing in a handler object
      fileMenu.add(myItem);
      
      fileMenu.addSeparator();
      
      myItem = new JMenuItem("Quit");
      myItem.addActionListener(fmh);//define what will happens by passing in a handler object
      fileMenu.add(myItem);
      
      myItem = new JMenuItem("Roman to Arabic");
      myItem.addActionListener(cmh);//define what will happens by passing in a handler object
      convertMenu.add(myItem);
      
      setJMenuBar(myMenuBar);
      myMenuBar.add(fileMenu);
      myMenuBar.add(convertMenu);
   }
   /**
    * custom GUI method to print out roman numerals and their corresponding arabic values in sorted order using TreeMap
    * @param Tmap a treemap filled with roman numerals as keys and arabic values as values
    * @param myGUI declared GUI object to be modified 
    */
   public void printToGUI(Map<RomanNumeral, Integer> Tmap, RomanNumeralGUI myGUI) {
      
      myGUI.setLayout(new GridLayout(1, 2));
      Container myContentPane = myGUI.getContentPane();
      TextArea romanArea = new TextArea();
      TextArea SortedArabicArea = new TextArea();
      
      myContentPane.add(romanArea);
      myContentPane.add(SortedArabicArea);
      romanArea.append("Sorted Roman Numerals \n");
      SortedArabicArea.append("Sorted Arabic Values \n");
     
      Set set = Tmap.entrySet();//extract a collection of key-value pairs 
      Iterator i = set.iterator();
      Map.Entry<RomanNumeral, Integer> me;
      while(i.hasNext()) {//Print the map iteratively
         me = (Map.Entry)i.next();//Take a key-value pair from the map
         romanArea.append(me.getKey().getRomanNum() + "\n");//Print the roman nummeral in the Key
         SortedArabicArea.append(me.getValue() + "\n");
      }
   }
}