public class problem010 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long sum = 0;
		for (long i = 2; i < 2000000; i++){
			if (Boolean.TRUE.equals(PrimeTest(i))) {
				sum += i;
			}
		}
		
		
		System.out.println(sum);
	
		long end = System.currentTimeMillis();
		double duration = ((double)end - (double)start)/1000;

		System.out.println("Your code took " + duration + " seconds to execute.");
		
		
	}
	

	// Your code took 848.832 seconds to execute. - No Sieve.
	
	
	
	public static boolean PrimeTest (long n) {
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i < n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}
}


