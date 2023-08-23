import java.util.StringTokenizer;//import the part of util package that pertains to tokenization of string type

public class TwoDimArray {

	public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		printArray(myArray);
		System.out.println();
		printArrayEven(myArray);
		System.out.println();
		printArray(fillArray("twodimension8.txt"));
	    System.out.println();
	    printArrayEven(fillArray("twodimension8.txt"));

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
		      else System.out.print("* \t");
		   }
		   System.out.println();
		}
	}
	
	public static int[][] fillArray (String myFile){
	  
	   int matrix[][];
	   TextFileInput input = new TextFileInput(myFile);
	   String line = input.readLine();
	   
	   StringTokenizer myTokens = new StringTokenizer(line, ",");
	   int rows = Integer.parseInt(myTokens.nextToken());
	   int cols = Integer.parseInt(myTokens.nextToken());

	   System.out.println(myTokens.countTokens());
	   
	   matrix = new int[rows][cols];
	   for(int r = 0; r < rows; r++) {
	      line = input.readLine();	      
	      myTokens = new StringTokenizer(line, ",");
	      
	      for(int c = 0; c < cols; c++) 
	      {   
	         matrix[r][c] = Integer.valueOf(myTokens.nextToken());//valueOf == parseInt
	      }
	   }
	   input.close();
	   return matrix;
	}
}
