
public class problem014 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		long result = 1;
		long number = 0;
		for (long i = 1; i < 1000000; i++){
			if (Collatz(i) > result) {
				result = Collatz(i);
				number = i;
			}
		}
		
		System.out.println(result);
		System.out.println(number);
		
		double end = System.nanoTime();
		double duration = (end - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long Collatz (long n){
		if (n == 1) return 1;
		if (n%2 == 0) {
			return 1 + Collatz(n/2);			
		}
		if (n%2 == 1){
			return 1 + Collatz(1 + (3*n));
		}
		else return 0;
	}

}
