
public class problem058 {

	public static void main(String[] args) {
		
		
		int primes = 0;
		
			for (int i = 3; ; i += 2){
				
				int a = (int) Math.pow(i,2);
				int b = a - (i-1);
				int c = b - (i-1);
				int d = c - (i-1);
				if (Prime(a)) primes++;
				if (Prime(b)) primes++;
				if (Prime(c)) primes++;
				if (Prime(d)) primes++;
				

				int total = (4 * (i-1) / 2) + 1;
				double check = (double)primes / (double)total;
				if (check < 0.1) {
					System.out.println(i);
					break;
				}
		}

		double start = System.nanoTime();

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
