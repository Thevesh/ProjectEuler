
public class problem064 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int limit = 10000;
		int result = 0;
		
		// algorithm obtained from https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
		 
		for (int n = 2; n <= limit; n++){
			int a0 = (int) Math.sqrt(n);
		    if (a0 * a0 == n) continue; // This checks if n is a perfect square
		 
		    int period = 0;
		    int d = 1;
		    int m = 0;
		    int a = a0;
		 
		    while(a != 2*a0){
		        m = (d*a) - m;
		        d = (n - (m * m)) / d;
		        a = (a0 + m) / d;
		        period++;
		    }
		 
		    if (period % 2 == 1) result++;
		}
			
		System.out.println(result);
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
