
public class problem077 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		// This approach uses dynamic programming 
		
		int[] primes = Primes(1000);		
		int target = 2; 
		           
		while (true) {
		    int[] ways = new int[target+1];
		    ways[0] = 1;
		 
		    for (int i = 0; i < primes.length; i++) {                    
		        for (int j = primes[i]; j <= target; j++) {
		            ways[j] += ways[j - primes[i]];
		        }
		    }
		                                 
		    if (ways[target] > 5000) {
		    	System.out.println(target);
		    	break;
		    }
		    target++;
		}
		
		// System.out.println(Partition(100,99)); - This is the output for the Partition function

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int [] Primes (int n){
		int[] primes = new int[n];
		int count = 0;
		
		for (int i = 2;; i++){
			if (Prime(i)) {
				primes[count] = i;
				count ++;
			}
			if (count == n) break;
		}
		
		return primes;
	}
	
	public static boolean Prime(int n){
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n%2 == 0) return false;
		for (int i = 3; i <= n/2; i++){
			if (n%i == 0) return false;
		}
		
		return true;
	}

}
