/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 *
 */
 
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
            throw new IllegalRomanNumeralException("Invalid Roman Numeral Entry");
      }//check to see if there is an invalid character (e.g., not M,D,X, etc.) in the Roman numeral by throwing an IllegalRomanNumeralException
      
      romanNum = r;
      int RomanToIntArray [] = new int [r.length()];
      
      for(int i = r.length() - 1; i >= 0; i--)
      {
          if(r.charAt(i) == 'I')
             RomanToIntArray[i] = 1;
          else if(r.charAt(i) == 'V')
             RomanToIntArray[i] = 5;
          else if(r.charAt(i) == 'X')
             RomanToIntArray[i] = 10;
          else if(r.charAt(i) == 'L')
             RomanToIntArray[i] = 50;
          else if(r.charAt(i) == 'C')
             RomanToIntArray[i] = 100;
          else if(r.charAt(i) == 'D')
             RomanToIntArray[i] = 500;  
          else if(r.charAt(i) == 'M')
             RomanToIntArray[i] = 1000;         
      }
      int sum = RomanToIntArray[r.length() - 1];
      
      //iterate through each letter in a roman numeral to tally the total arabic value
      for(int i = r.length() - 1; i > 0; i--){
         if(RomanToIntArray[i] > RomanToIntArray[i - 1])
            sum = sum - RomanToIntArray[i - 1];
         else
            sum = sum + RomanToIntArray[i - 1];
      }
      arabicNum = sum;
   }
   
   /**
    * set the Roman numeral instance variable, and convert the Roman numeral to Arabic and set the Arabic integer value.
    * @param r a roman numeral of String type
    */
   public void setRomanNum(String r){
      romanNum = r;
      int RomanToIntArray [] = new int [r.length()];
      
      for(int i = r.length() - 1; i >= 0; i--)
      {
          if(r.charAt(i) == 'I')
             RomanToIntArray[i] = 1;
          else if(r.charAt(i) == 'V')
             RomanToIntArray[i] = 5;
          else if(r.charAt(i) == 'X')
             RomanToIntArray[i] = 10;
          else if(r.charAt(i) == 'L')
             RomanToIntArray[i] = 50;
          else if(r.charAt(i) == 'C')
             RomanToIntArray[i] = 100;
          else if(r.charAt(i) == 'D')
             RomanToIntArray[i] = 500;  
          else if(r.charAt(i) == 'M')
             RomanToIntArray[i] = 1000;         
      }
      int sum = RomanToIntArray[r.length() - 1];
      
      //iterate through each letter in a roman numeral to tally the total arabic value
      for(int i = r.length() - 1; i > 0; i--){
         if(RomanToIntArray[i] > RomanToIntArray[i - 1])
            sum = sum - RomanToIntArray[i - 1];
         else
            sum = sum + RomanToIntArray[i - 1];
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