/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Scanner;

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
    * read the entire contents of the user-selected file and display the content in both sorted order while catching IllegalRomanNumeralExceptions if any
    * @param chosenFile an file object selected by the user
    * @throws FileNotFoundException 
    */
   private void readSource(String inputFilePath) 
   {
      //declare the TreeMap object to store roman numerals from the input file and pass in an Comparator as argument for sorting
      Map<RomanNumeral, Integer> Tmap = new TreeMap<RomanNumeral, Integer>(new RomanNumeralComparator());
      Scanner input = null;
      try {
         input = new Scanner(new File(inputFilePath));//create an object to read lines from the input file direct path
      }
      catch(FileNotFoundException fnfe){
         System.out.println("File not found!");
      }
      catch(IOException io){
         io.printStackTrace();
      }
      String line = input.nextLine();       
      StringTokenizer myTokens = new StringTokenizer(line, ","); //tokenize and store words seperated by delimiter ","
      RomanNumeral temp;
      String tokenTemp = "";
      
      while(input.hasNextLine()) 
      {
         if(myTokens.countTokens() != 0) {         
            try {
               tokenTemp = myTokens.nextToken();
               temp = new RomanNumeral(tokenTemp);
               Tmap.put(temp, temp.getArabicNum());     
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
            line = input.nextLine();
            if(line == null) //
               break;
            try {
               myTokens = new StringTokenizer(line, ",");
               tokenTemp = myTokens.nextToken();
               temp = new RomanNumeral(tokenTemp);
               Tmap.put(temp, temp.getArabicNum());     
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
      
      myFrame.setLayout(new GridLayout(1, 2));
      Container myContentPane = myFrame.getContentPane();
      TextArea romanArea = new TextArea();
      TextArea SortedArabicArea = new TextArea();
      myContentPane.add(romanArea);
      myContentPane.add(SortedArabicArea);
      romanArea.append("Sorted Roman Numerals: \n");
      SortedArabicArea.append("Sorted Arabic Values: \n");
     
      Set set = Tmap.entrySet();//extract a collection of key-value pairs 
      Iterator i = set.iterator();
      Map.Entry<RomanNumeral, Integer> me;
      while(i.hasNext()) {//Print the map iteratively
         me = (Map.Entry)i.next(); //Take a key-value pair from the map
         romanArea.append(me.getKey().getRomanNum() + "\n");//Print the roman nummeral in the Key
         SortedArabicArea.append(me.getValue() + "\n"); //Print the value
      }
      myFrame.setVisible(true);
   }
}
