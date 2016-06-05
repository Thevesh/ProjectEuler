import java.util.ArrayList;
import java.util.List;

public class problem007 {

	public static void main(String[] args) {
		
		List <Integer> primes = new ArrayList <Integer> ();
		
		primes.add(2);
		
		for (int i = 3;; i+=2){
			if (Boolean.TRUE.equals(PrimeTest(i))) primes.add(i);
			if (primes.size() == 10001) break;
		}
		
		System.out.println(primes.get(10000));
		System.out.println("");
		

		long start = System.nanoTime();
		Timer();
		long end = System.nanoTime();
		double duration = ((double)end - (double)start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");
		
		
	}
	
	private static void Timer() {
	}
	
	
	public static boolean PrimeTest (long n) {
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}

}
