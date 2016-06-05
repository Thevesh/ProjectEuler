import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class problem070 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		Set<Integer> temp = new HashSet<Integer>();
		
		for (int i = 2000; i <= 5000; i++){
			if (Prime(i)) temp.add(i);
		}
		
		Integer[] primes = temp.toArray(new Integer[temp.size()]);
		Arrays.sort(primes);
		
		
		long result = 0;
		long phiBest = 0;
		double bestRatio = Double.POSITIVE_INFINITY;
		 
		long limit = 10000000;
		 
		for (int i = 0; i < primes.length; i++) {
		    for (int j = i+1; j < primes.length; j++) {
		    	
		        long n = primes[i] * primes[j];
		        if (n > limit) break;
		 
		        long phi = (primes[i] - 1) * (primes[j] - 1);
		        double ratio = ((double) n) / phi;
		        
		        int compare = Double.compare(bestRatio, ratio);
		        
		        if (Permuto(n, phi) && compare > 0) {
			            result = n;
			            phiBest = phi;
			            bestRatio = ratio;
		        }
		    }
		}
		
		System.out.println(result);
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Permuto(long m, long n) {
        int[] arr = new int[10];

        long temp = n;
        while (temp > 0) {
            arr[(int) (temp % 10)]++;
            temp /= 10;
        }

        temp = m;
        while (temp > 0) {
            arr[(int) (temp % 10)]--;
            temp /= 10;
        }


        for (int i = 0; i < 10; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
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
