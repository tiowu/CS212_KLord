// LinkedList.java
// 
// This version uses three instance variables,
// a pointer to the first node, a pointer to
// the last node, and length, to make our
// append and getLength methods more efficient
// than the would be if our only instance
// variable were a pointer to the first node.
//
// This version uses a dummy first node.  Hence
// it needs less decision-making than it would
// need if a dummy first node were not used.
//

/**
 * Encapsulates a linked list of <code>String</code>.
 */
public class MoneyList {

	/** First node in linked list - dummy node */
	private MoneyNode first = new MoneyNode(null);

	/** Last node in linked list */
	private MoneyNode last = first;

	/** Number of data items in the list. */
	private int length = 0;

	/**
	 * Gets the number of data values currently stored in this LinkedList.
	 * 
	 * @return the number of elements in the list.
	 */

	public int getLength() {
		return length;
	}

	/**
	 * Appends a String data element to this LinkedList.
	 * 
	 * @param data
	 *            the data element to be appended.
	 */
	public void append(Money m) {
		// TODO Code here for append
	   MoneyNode temp = new MoneyNode(m);
	   last.next = temp;
	   last = temp;
	   length++;
	} // method append(String)

	/**
	 * Prepends (adds to the beginning) a String data element to this
	 * LinkedList.
	 * 
	 * @param data
	 *            the data element to be prepended.
	 */
	public void prepend(Money m) {
		// TODO Code here for prepend
	   MoneyNode temp = new MoneyNode(m);
       if (length == 0) {
          last = temp;
       }
       temp.next = first.next;
       first.next = temp;
       length++;
	} // method append(String)

	/**
	 * @return String representation of elements in linked list delimited by a
	 *         space character
	 */
	public String toString() {
	   MoneyNode p = first.next;
	   String returnString = p.m + "";
	   p = p.next;
	   while (p != null) {
	      returnString += ", " + p.m;
		  p = p.next;
	   }
	   return returnString;
	}

	/**
	 * Determines whether this ShortSequenceLinkedList is equal in value to the
	 * parameter object. They are equal if the parameter is of class
	 * ShortSequenceLinkedList and the two objects contain the same short
	 * integer values at each index.
	 * 
	 * @param other
	 *            the object to be compared to this ShortSequenceLinkedList
	 * 
	 * @return <code>true</code> if the parameter object is a
	 *         ShortSequenceLinkedList containing the same numbers at each index
	 *         as this ShortSequenceLinkedList, <code>false</code> otherwise.
	 */
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((MoneyList) other).length)
			return false;

		MoneyNode nodeThis = first;
		MoneyNode nodeOther = ((MoneyList) other).first;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (nodeThis.m != nodeOther.m)
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	} // method equals
	
	public String getValue() {
	   MoneyNode p = first.next;
	   double sum = 0;
	   while(p != null) {
	      if(p.m instanceof Bill) {
	         sum += p.m.getValue() * 100;
	      }
	      else 
	         sum += p.m.getValue();
	      p = p.next;
	   }
	     
	   return "$ " + sum / 100;
	}
	
	/**
	 * because the MoneyNode only exist in this class and private, it can only be passed in this method here!!
	 */
	public void printForward() {
	   printForward(first.next);
	   System.out.println();
	}

	public void printForward(MoneyNode p) {
	   if(p != null) {
	       System.out.print(p + "\t");
	       printForward(p.next);
	   }
	   return;
	}
	
	 /**
     * because the MoneyNode only exist in this class and private, it can only be passed in this method here!!
     */
    public void printBackward() {
       printBackward(first.next);
       System.out.println();
    }

    public void printBackward(MoneyNode p) {
       if(p != null) {
          printBackward(p.next);
          System.out.print(p + "\t");
       }
       return;
    }
    
    public void recursiveSum() {
       System.out.println("$ " + recursiveSum(first.next) / 100);
    }
    
    public double recursiveSum(MoneyNode p) {
       if(p != null) {
          if(p.m instanceof Bill) {
             return p.m.getValue() * 100 + recursiveSum(p.next);
          }
          else 
             return p.m.getValue() + recursiveSum(p.next);
       }
      return 0;
    }
	
    public void recursiveQuarters() {
       double d = recursiveQuarters(first.next);
       if(d % 10 != 0) {
          System.out.println("$ " + d / 100);
       }
       else
          System.out.println("$ " + d / 100 + "0");
    }
    
    public double recursiveQuarters(MoneyNode p) {
       if(p != null) {
          if(p.m instanceof Quarter) {
             return p.m.getValue() + recursiveQuarters(p.next);
          }
          else 
             return recursiveQuarters(p.next);
       }
       return 0;
    }
    
} // class LinkedList

