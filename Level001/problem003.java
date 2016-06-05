
public class problem003 {

	public static void main(String[] args) {
		
		long target = 600851475143L;
		
		System.out.println(Decompose(target));

		double start = System.nanoTime();

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

	public static long Decompose (long n){
		long result = 0;
		for (long i = 2; ; i++){
			if (n == i) {
				result = i;
				break;
			}
			else {
				while (n%i == 0) n /= i;
			}
		}
		return result;
	}
}
