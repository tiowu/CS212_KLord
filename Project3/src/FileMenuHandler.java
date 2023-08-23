/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import javax.swing.*;
import java.io.File;
import java.awt.event.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener{//actionlistener interface implementation makes this class able to respond to menu item clickings
   private JFrame myFrame;
   /**
    * object of handler class needs JFrame too
    * @param myFrame JFrame parameter
    */
   public FileMenuHandler(JFrame myFrame) {
      this.myFrame = myFrame;
   }
   /**
    * when different menu items are clicked on, this method will respond by performing desired actions based on menu names
    */
   public void actionPerformed(ActionEvent event) {
      
      String menuName = event.getActionCommand();
      
      if(menuName.equals("Open")) {
         openFile();  
      }
      else if(menuName.equals("Quit")) {
         System.exit(0);
      }
   }
   /**
    * display GUI window for users to select input file to read from
    */
   private void openFile() {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      File f = chooser.getSelectedFile();
      readSource(f.getAbsolutePath());
   }
   /**
    * read the entire contents of the user-selected file and display the content in both sorted and unsorted order while catching IllegalRomanNumeralExceptions if any
    * @param chosenFile an file object selected by the user
    */
   private void readSource(String inputFilePath) {
      SortedRomanNumeralList SortedList = new SortedRomanNumeralList();
      UnsortedRomanNumeralList UnsortedList = new UnsortedRomanNumeralList();

      TextFileInput input = new TextFileInput(inputFilePath);//create an object to read lines from the input file direct path
      String line = input.readLine();       
      StringTokenizer myTokens = new StringTokenizer(line, ","); //tokenize and store words seperated by delimiter ","
      RomanNumeral temp;
      String tokenTemp = "";
      
      while(line != null) 
      {
         if(myTokens.countTokens() != 0) {         
            try {
               tokenTemp = myTokens.nextToken();
               temp = new RomanNumeral(tokenTemp);
               SortedList.add(temp);     
               UnsortedList.append(temp);
            }
            catch (IllegalRomanNumeralException irne) {
               System.out.println("An illegal roman numeral, " + tokenTemp + ", is in the chosen file.");
            }
            catch (IllegalArgumentException iae) {
               System.out.println("An exception has occurred");
            }
            //try-catch blocks ensure handling of IllegalRomanNumeralExceptions, namely the illegal roman numerals in the input file before notifying users 
         }
         else {
            line = input.readLine();
            if(line == null) //
               break;
            try {
               myTokens = new StringTokenizer(line, ",");
               tokenTemp = myTokens.nextToken();
               temp = new RomanNumeral(tokenTemp);
               SortedList.add(temp);     
               UnsortedList.append(temp);  
            }
            catch (IllegalRomanNumeralException irne) {
               System.out.println("An illegal roman numeral, " + tokenTemp + ", is in the chosen file.");
            }
            catch (IllegalArgumentException iae) {
               System.out.println("An exception has occurred");
            }    
            //try-catch blocks ensure handling of IllegalRomanNumeralExceptions, namely the illegal roman numerals in the input file before notifying users 
         }
      }
      input.close(); 
      RomanNumeralGUI rnGUI = new RomanNumeralGUI("Roman Numerals from Input File", 600, 250);
      rnGUI.printToGUI(SortedList, UnsortedList, rnGUI);
   }
}
