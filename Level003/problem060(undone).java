
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class problem060 {

	public static void main(String[] args) {

		double start = System.nanoTime();

		Set<Integer> primes = new HashSet<Integer>();
		for (int i = 1; i < 10000; i++){
			if(Prime(i)) primes.add(i);
		}
		
		
		Integer[] L1 = primes.toArray(new Integer[primes.size()]);
		Arrays.sort(L1);
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Concat(int m, int n){
		int l = String.valueOf(n).length();
		
		return (int) (m*(Math.pow(10, l))) + n;
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
