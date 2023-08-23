import javax.swing.*;

public class lab6 {

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Invalid number, bye!");
			System.exit(1);
		}	

		System.out.println("no errors!");
		
		int [] numbers = new int[14];	
		
		intArrayFromFile(args[0], numbers);
		
		for(int x : numbers){
			System.out.print(" " + x);
		}

		System.out.println("\n" + "Sum is " + calSum(numbers) + "\n" + "Average is " + avg(numbers));

	}
	
	public static int[] intArrayFromFile(String filename, int [] nums){
		TextFileInput in = new TextFileInput(filename);
		
		String line = in.readLine();
		
		int size = Integer.parseInt(line);
		
		for(int i = 0; i < size; i++){
			line = in.readLine();
			nums[i] = Integer.parseInt(line);
		}
		in.close();
		return nums;
	}
	
	public static double calSum(int [] nums){
		double sum = 0.0;
		
		for(int x: nums){
			sum += x;
		}		
		return sum;
	}
	
	public static double avg(int [] nums){
		return calSum(nums) / nums.length;
	}
}



