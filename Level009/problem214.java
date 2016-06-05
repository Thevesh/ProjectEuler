public class problem214 {

	public static void main(String[] args) {
		
		// Recognize that the summation of Fn is the Euler totient function: https://en.wikipedia.org/wiki/Euler%27s_totient_function

		double start = System.nanoTime();
		
		int limit = 40000000;
		int[] Phi = new int[limit+1];
		
		for (int i = 0; i <= limit; i++){
			if(Prime(i)) Phi[i] = i-1;
			else Phi[i] = i;
		}
		
		
		for (int i = 2; i <= limit; i++){
			if (Phi[i] == i-1){
				for (int j = i+i; j <= limit; j+= i){
					Phi[j] = Phi[j] / i * (i - 1) ;
				}
			}
		}
		

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
