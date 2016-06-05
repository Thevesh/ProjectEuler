
public class problem021 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();

		long limit = 10000;
		
		long[] DivisorSums = new long[9999];
		for (long i = 1; i < limit; i ++){
			DivisorSums[(int)(i-1)] = DivisorSum(i);
		}
		
		long result = 0;
		for (long i = 1; i < limit; i++ ) {
			long test1 = DivisorSums[(int)(i-1)];
			for (long j = 1; j < limit; j++){
				long test2 = DivisorSums[(int)(j-1)];
				if (test1 == j && test2 == i && i != j) {
					result += i;
					break;
				}
			}	
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	
	
	public static long DivisorSum (long n){
		long sum = 0;
		for (long i = 1; 2*i <= n; i++ ){
			if (n%i == 0) sum += i;
		}
		return sum;
	}

}
