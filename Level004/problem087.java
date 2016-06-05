import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class problem087 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long target = 50000000L;
		long limit = (long) Math.sqrt(target);
		
		Set<Long> temp = new HashSet<Long>();
		
		for (long i = 1; i <= limit; i++){
			if (Prime(i)) temp.add(i);
		}
		
		Long[] Primes = temp.toArray(new Long[temp.size()]);
		Arrays.sort(Primes);
		
		int limit2 = Primes.length;
		Set<Long> result = new HashSet<Long>();
		
		for (int i = 0; i < limit2; i++){
			long a = (long) Math.pow(Primes[i], 2);
			
			for (int j = 0; j < limit2; j++){
				long b = (long) Math.pow(Primes[j], 3);
				if ((a+b) > target) break;
				
				for (int k = 0; k<= limit2; k++){
					long c = (long) Math.pow(Primes[k], 4);
					if ( (a+b+c) > target) break;
					else result.add(a+b+c);
				}
			}
		}
		
		System.out.println(result.size());

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Prime(long n){
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n%2 == 0) return false;
		for (int i = 3; i <= n/2; i++){
			if (n%i == 0) return false;
		}
		
		return true;
	}

}
