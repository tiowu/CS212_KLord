/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 *
 */
 
public class SortedRomanNumeralList extends RomanNumeralList{
   /**
    * Default constructor to create a "dummy" node as the head node of the list 
    */
   public SortedRomanNumeralList() {
      super();
   }
   /**
    * add a RomanNumeral data element to this linkedList in an ascending order
    * @param r a RomanNumeral data element to be added
    */
   public void add(RomanNumeral r) {
      RomanNumeralNode rnn = new RomanNumeralNode(r); //the list node to be added to the list 
      RomanNumeralNode p = new RomanNumeralNode(); //declare proxy node for while loop iteration
      p = first;
      while(p.next != null && p.next.data.compareTo(rnn.data) == -1 ) 
      {
         p = p.next;
      }
      rnn.next = p.next;
      p.next = rnn;
      if(p == last) //when the proxy node is equal to the last node in the list, we set the instance variable "last" to be current last node;
         last = rnn;
      len++;
   }
}