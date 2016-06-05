
public class problem028 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int length = 1001;
		long result = 0;
		
		for (int i = length; i > 1; i -=2) {
			result += SpiralSum(i);
		}
		
		System.out.println(result + 1);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Spiral(long n){
		int result = 0;
		if (n == 1) result += 9;
		else result += (n*8) + Spiral(n-1);
		return result;
	}
	
	public static int SpiralSum (int m){
		int vertex4 = Spiral((m-1)/2);
		int vertex3 = vertex4 - m + 1;
		int vertex2 = vertex3 - m + 1;
		int vertex1 = vertex2 - m + 1; 
		int result = vertex4 + vertex3 + vertex2 + vertex1;
		return result;
	}

}
