/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 *
 */
 
public class UnsortedRomanNumeralList extends RomanNumeralList{
   
   /**
    * Default constructor to create a "dummy" node as the head of the list 
    */
   public UnsortedRomanNumeralList() {
      super();
   }
   /**
    * append a RomanNumeral data element to the last place of this linkedList
    * @param r parameter - RomanNumeral object passed in to be added to the end of the list
    */
   public void append(RomanNumeral r) {
      RomanNumeralNode rnn = new RomanNumeralNode(r);
      last.next = rnn;
      last = rnn;
      len++;
   }
   
}