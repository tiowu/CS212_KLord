/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 *
 */
import java.util.StringTokenizer;//import the part of util package that pertains to tokenization of string-type input

public class Project2 {
   
   public static void main(String[] args) 
   {
      RomanNumeralGUI myGUI = new RomanNumeralGUI();
      SortedRomanNumeralList SortedList = new SortedRomanNumeralList();
      UnsortedRomanNumeralList UnsortedList = new UnsortedRomanNumeralList();
      fillLists(SortedList, UnsortedList, "input.txt"); //calling fillLists to extract Strings in data source and store them in 2 linkedLists, sorted and unsorted.
      myGUI.printToGUI(SortedList, UnsortedList, myGUI); //calling RomanNumeralGUI print method with input file, sorted, and unsorted lists passed in as parameters 
   }//main
   /**
    * Convert Strings in file to RomanNumeral data type and store them in separate link lists - a critical method 
    * @param SortedList a RomanNumerallist extended link list that can store and sort roman numerals in an ascending order 
    * @param UnsortedList a RomanNumerallist extended link list that stores roman numerals 
    * @param myFile a text file as our data source in this project 
    */
   public static void fillLists(SortedRomanNumeralList SortedList, UnsortedRomanNumeralList UnsortedList, String myFile) 
   {
      TextFileInput input = new TextFileInput(myFile);//create an object to read lines from the input file
      String line = input.readLine();      
      StringTokenizer myTokens = new StringTokenizer(line, ","); //tokenize and store words seperated by delimiter ","
      RomanNumeral temp;
      
      while(line != null) 
      {
         if(myTokens.countTokens() != 0) {
            temp = new RomanNumeral(myTokens.nextToken());
            SortedList.add(temp);     
            UnsortedList.append(temp);
         }
         else {
            line = input.readLine();
            if(line == null) //
               break;
            myTokens = new StringTokenizer(line, ",");
            temp = new RomanNumeral(myTokens.nextToken());
            SortedList.add(temp);     
            UnsortedList.append(temp);         
         }
      }
      input.close(); 
    }//fillLists
   
/* an inefficient way to fill lists
 public static void fillLists(SortedRomanNumeralList SortedList, UnsortedRomanNumeralList UnsortedList, String myFile) 
 {
    int len = 8;
    String [] romanNumArray = new String [len];
    RomanNumeral [] romanArr = new RomanNumeral[len];
    
    TextFileInput input = new TextFileInput(myFile);//create an object to read lines from the input file
    String line = input.readLine();
    StringTokenizer myTokens = new StringTokenizer(line, ",");//tokenize and store roman numerals seperated by delimiter ","  

    for(int i = 0; i < len; i++) {
       if(myTokens.countTokens() != 0) {
          romanNumArray[i] = myTokens.nextToken();
          romanArr[i] = new RomanNumeral(romanNumArray[i]);
          UnsortedList.append(romanArr[i]); 
          SortedList.add(romanArr[i]);
       }
       else {
          line = input.readLine();
          myTokens = new StringTokenizer(line, ",");
          romanNumArray[i] = myTokens.nextToken();
          romanArr[i] = new RomanNumeral(romanNumArray[i]);
          UnsortedList.append(romanArr[i]); 
          SortedList.add(romanArr[i]);
       }   
    }
    input.close(); 
 }
*/
}//project 2
