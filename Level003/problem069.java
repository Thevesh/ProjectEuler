
public class problem069 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		// Summation taken from https://en.wikipedia.org/wiki/Euler%27s_totient_function
		// We simply have to minimize product p in 1 - 1/p to obtain a maximum for n / phi(n)
		
		int count  = 0;
		int[] primes = new int[200];
		
		for (int i = 1;; i++){
			if (Prime(i)){
				primes[count] = i;
				count ++;
			}
			if (count == 200) break;
		}
		
		int result = primes[0];
		int target = 1000000;
		for (int i = 1; i < primes.length; i++){
			if (result * primes[i] <= target){
				result *= primes[i];
			}
			if (result * primes[i] > target) break;
		}
		
		System.out.println(result);
		
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
