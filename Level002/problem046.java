
public class problem046 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (long i = 5; ; i += 2){
			long check = 1;
			if (Prime(i)) continue;
			else {
			for (long j = 1; j*j < i; j ++) {
					long a = i - (2*j*j);
					if (Prime(a)) {
						check = 0;
						break;
					}
				
				}
			}
			if (check == 1) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Prime (long n) {
		if (n < 0 || n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}

}
