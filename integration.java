public class integration{
	public static void main(String[] args){
		System.out.println("Hello World!");
		System.out.println(calculate(1, 4));
		int[] grades = {1, 2, 3};
		for(int i = 0; i < 3; i++){
			System.out.println(grades[i]);
		}
		
	}
	public static double calculate(double a, double b){	
		double sum = 0;
		double delta = 0.00000001;
		double x = a;
		while(x <= b){
			sum += (x * 2) * delta;
			x += delta;
		}
		return sum;
	}
}
