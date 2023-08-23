/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 *
 */
 
public class RomanNumeralList{
   
   //protected instance variables so that child classes can see and use
   protected RomanNumeralNode first;
   protected RomanNumeralNode last;
   protected int len;
   /**
    * default constructor that has first and last point to the same dummy node
    */
   public RomanNumeralList(){
      RomanNumeralNode rnn = new RomanNumeralNode();
      first = rnn;
      last = rnn;
      len = 0;
   }
   /**
    * get the length of this link list
    * @return an int of the length of this link list
    */
   public int getLength(){
       return len;
   }
   
}