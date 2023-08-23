/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

public class RomanNumeralNode {
   
   //instance variables of this class
   RomanNumeral data;
   RomanNumeralNode next;
   
   /**
    * default constructor 
    */
   public RomanNumeralNode() {
      data = null;
      next = null;
   }
   
   /**
    * one-argument constructor & set pointer to next node to null
    * @param d give data the content of RomanNumeral type
    */
   public RomanNumeralNode(RomanNumeral d) {
      data = d;
      next = null;
   }
   
   /**
    * two-argument constructor 
    * @param d  give data the content of RomanNumeral type
    * @param rnn  give next the reference to another node of the same class
    */
   public RomanNumeralNode (RomanNumeral d, RomanNumeralNode rnn) {
      data = d;
      next = rnn;
   }
}
