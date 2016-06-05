import java.util.ArrayList;
import java.util.List;

public class problem050 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int limit = 1000000;
		
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 1; i <= limit; i++){
			if (Prime(i)) primes.add(i);
		}
		
		long maxSum = 0;
		int maxRun = -1;
		for (int i = 0; i < primes.size(); i++) {  // For each index of a starting prime number
			int sum = 0;
			for (int j = i; j < primes.size(); j++) {  // For each end index (inclusive)
				sum += primes.get(j);
				if (sum > limit)
					break;
				else if (j - i > maxRun && sum > maxSum && Prime(sum)) {
					maxSum = sum;
					maxRun = j - i;
				}
			}
		}
		
		System.out.println(maxRun);
		System.out.println(maxSum);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Prime (int n) {
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}

}
