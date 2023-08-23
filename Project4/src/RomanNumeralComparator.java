/**
 * Student: Tao Wu
 * Lab section: Nil Patel (11D)
 */

import java.util.Comparator; //Comparator is an interface

/**
 * for user-defined objects like roman numberals, TreeMap needs this class to sort its Keys in order,
 * inside the compare method provided by the interface "Comparator", we'll use compareTo method from roman numeral class
 * providing a RomanNumeralComparator or any Comparator to a TreeMap allows it to sort the keys in a specific order 
 */
public class RomanNumeralComparator implements Comparator<RomanNumeral>{
   public int compare(RomanNumeral r, RomanNumeral c) {
      return r.compareTo(c);
   }
}
