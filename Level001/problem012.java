
public class problem012 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		int sum = 1;
		long triangle = 0;
		long result = 0;
		for (long i = 2; ; i++){
			triangle = Triangulate(i);
			for (long j = 1; j <= triangle/2; j++){
				if (triangle % j == 0) sum++;
			}
			if (sum > 500) {
				result = triangle;
				break;
			}
			else sum = 1;
		}
		
		System.out.println(result);
		
		double duration = (System.nanoTime() - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long Triangulate(long n){
		if (n == 1) return 1;
		else {
			return n + Triangulate(n-1);
		}
	}
	
	

}
