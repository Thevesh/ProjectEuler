
public class problem075 {
	
	// To solve this problem, we make use of Euclid's method for generating primitive triples: https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
	// In specific: a = k(m2 - n2); b = 2mn, c = k(m2 + n2)
	// Since m > n, and c is formed by m2 + n2, check only up to root(limit/2) -> Actual limit should be smaller.

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int limit = 1500000;
		int[] triangles = new int[limit+1];
		 
		int result =0;
		int max = (int)Math.sqrt(limit / 2);
		 
		for (long m = 2; m < max; m++) {
		    for (long n = 1; n < m; n++) {
		    	
		        if (((n + m) % 2) == 1 && GCD(n, m) == 1) {
		            long a = m * m + n * n;
		            long b = m * m - n * n;
		            long c = 2 * m * n;
		            long p = a + b + c;
		            
		            while(p <= limit){
		                triangles[(int) p]++;
		                if (triangles[(int) p] == 1) result++; // Add to final result tally.
		                if (triangles[(int) p] == 2) result--; // Subtracts wrongly added case.
		                
		                p += a + b + c; // This iterates through all multiples of this primitive set.
		            }
		        }
		    }
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

	
	public static long GCD (long a, long b) {
        long y, x;

        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }

        while (x % y != 0) {
            long temp = x;
            x = y;
            y = temp % x;
        }

        return y;
    }      
}


