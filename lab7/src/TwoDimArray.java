
public class TwoDimArray {

	public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		printArray(myArray);
		System.out.println();
		printArrayEven(myArray);
		
		System.out.println();
		printArray(fillArray("twodimesion.txt"));
		
	}
	private static void printArray (int[][] theArray) {
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}
	private static void display (int num){
		System.out.print(num + "\t");
	}
	private static void printArrayEven(int[][] theArray){
		for(int i = 0; i < theArray.length; i++) {
		   for(int j = 0; j < theArray[i].length; j++) {
		      if(theArray[i][j] % 2 == 0)
		         display(theArray[i][j]);
		      else System.out.print("*" + " ");
		   }
		   System.out.println();
		}
	}
	
	public static int[][] fillArray (String myFile){
	  
	   int matrix[][] = null;
	   TextFileInput input = new TextFileInput(myFile);
	   int rows = Integer.parseInt(input.readLine());
	   int cols = Integer.parseInt(input.readLine());
	   matrix = new int[rows][cols];
	   for(int r = 0; r < rows; r++) {
	      for(int c = 0; c < cols; c++) {
	         matrix[r][c] = Integer.parseInt(input.readLine());
	      }
	   }
	   input.close();
	   return matrix;
	   
	}
}
