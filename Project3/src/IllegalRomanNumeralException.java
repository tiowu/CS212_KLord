/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {
   /**
    * class constructor that takes in a parameter 
    * @param errorMessage display message when error occurs  
    */
   public IllegalRomanNumeralException(String errorMessage) {
      super(errorMessage);
   }
}
