public class Lab25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 3, 5, 9, 4, 10, 33, 12, 19, 4, 16, 23, 30 };
		int[] intArray1 = { 1, 2, 4, 5, 5, 6, 7, 8, 9, 100 };

		System.out.println(largest(intArray, 0));
		System.out.println(sum(intArray, 0));
		System.out.println(isSorted(intArray, 0));
		System.out.println(isSorted(intArray, 8));
		System.out.println(isSorted(intArray1, 0));
	}

	public static int largest(int[] myArray, int index) {
		if(index == myArray.length - 1) {
		   return myArray[index];
		}
		int curr = myArray[index];
		int temp = largest(myArray, index + 1);
		if(curr >= temp)
		   return curr;
		else 
		   return temp;
	}

	public static int sum(int[] myArray, int index) {
	   if(index == myArray.length - 1) {
	        return myArray[index];
	   }
	   return myArray[index] + sum(myArray, index + 1);
	}

	public static boolean isSorted(int[] myArray, int index) {
	   if(index == myArray.length - 1) {
          return true;
	   }
		return myArray[index] <= myArray[index + 1] && isSorted(myArray, index + 1);
	}

}