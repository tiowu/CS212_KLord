/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 *
 */
import java.util.Map;
import java.util.HashMap;
//import java.util.Iterator;

public class RomanNumeral implements Comparable<RomanNumeral> {// define a natural ordering of objects of this class
   
   private String romanNum; //instance variable
   private int arabicNum; //instance variable

   /**
    * constructor should set the Roman numeral instance variable, and convert the Roman numeral to Arabic and set the Arabic integer value. 
    * @param r a roman numeral of String type
    */
   public RomanNumeral(String r){
      
      char checkTemp;
      for(int i = 0; i < r.length(); i++) {
         checkTemp = r.charAt(i);
         if(checkTemp != 'I' && checkTemp != 'V' && checkTemp != 'X' && checkTemp != 'L' && checkTemp != 'C' && checkTemp != 'D' && checkTemp != 'M')
            throw new IllegalRomanNumeralException("Roman Numeral Entry, " + r + ", is invalid");
      }//check to see if there is an invalid character (e.g., not M,D,X, etc.) in the Roman numeral by throwing an IllegalRomanNumeralException
      
      romanNum = r;
      Map<Character, Integer> RNmap = new HashMap<Character, Integer>();//using HashMap for fast lookup and retrieve arabic values of corresponding roman numerals
      RNmap.put('I', 1);
      RNmap.put('V', 5);
      RNmap.put('X', 10);
      RNmap.put('L', 50);
      RNmap.put('C', 100);
      RNmap.put('D', 500);
      RNmap.put('M', 1000);
      int sum = RNmap.get(r.charAt(r.length() - 1));
      for(int i = r.length() - 1; i > 0; i--){ //iterate through each letter in a roman numeral to tally the total arabic value
         int leftNum = RNmap.get(r.charAt(i - 1));
         int rightNum = RNmap.get(r.charAt(i));
         if(rightNum > leftNum)
            sum = sum - leftNum;
         else 
            sum = sum + leftNum;
      }
      arabicNum = sum;
      
//      Iterator rr = RNmap.entrySet().iterator();
//      while(rr.hasNext()) {
//         System.out.println(rr.next());
//      }//print all entries in hashmap, but users have no control over the order in which entries are printed 
   }
   
   /**
    * set the Roman numeral instance variable, and convert the Roman numeral to Arabic and set the Arabic integer value.
    * @param r a roman numeral of String type
    */
   public void setRomanNum(String r){
      romanNum = r;
      HashMap<Character, Integer> RNmap = new HashMap<Character, Integer>();
      RNmap.put('I', 1);
      RNmap.put('V', 5);
      RNmap.put('X', 10);
      RNmap.put('L', 50);
      RNmap.put('C', 100);
      RNmap.put('D', 500);
      RNmap.put('M', 1000);
      int sum = RNmap.get(r.charAt(r.length() - 1));
      for(int i = r.length() - 1; i > 0; i--){ //iterate through each letter in a roman numeral to tally the total arabic value
         int leftNum = RNmap.get(r.charAt(i - 1));
         int rightNum = RNmap.get(r.charAt(i));
         if(rightNum > leftNum)
            sum = sum - leftNum;
         else 
            sum = sum + leftNum;
      }
      arabicNum = sum;
   }
   /**
    * extract the roman numeral of String 
    * @return the roman numeral of String 
    */
   public String getRomanNum(){
      return romanNum;
   }
   /**
    * extract an arabic value of int 
    * @return an arabic value of int 
    */
   public int getArabicNum(){
      return arabicNum;
   }
   /**
    * compares the current object with another object of the RomanNumeral type and returns a -1, 0, or 1
    * @param r an object of RomanNumeral type
    * @return -1, 0, or 1
    */
   public int compareTo(RomanNumeral r){
      if(arabicNum > r.arabicNum)
         return 1;
      else if(arabicNum < r.arabicNum)
         return -1;
      else 
         return 0;
   }
   /**
    * compares the current object with another object of the RomanNumeral type to see if they are equal 
    * @param r an object of RomanNumeral type
    * @return true or false, i.e. boolean value
    */
   public boolean equals(RomanNumeral r){
      if(this.compareTo(r) == 0)
         return true;
      else
         return false;
   }
   /**
    * Let the complier know what this object looks like as a String object 
    * The method returns a custom string representation of the object.
    */
   public String toString(){
     return "Roman Numeral -> " + romanNum + "\t Arabic Value -> " + arabicNum + "\n";
   }
}