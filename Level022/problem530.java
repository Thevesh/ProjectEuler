
public class problem530 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		long limit = 1000000000000000L;
		long result = 0;
		
		for (long i = 1; i*i <= limit; i++){
			result += VSum(i,limit);
		}
		
		System.out.println(result);
		
		double duration = (System.nanoTime() - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	
	public static long VSum (long m, long n) {
		if (m == 1) {
			return 1 + (n-m)*2;
		}
		if (m > 1) {
		long square = (long) Math.pow(m, 2);
		long length = n - square;
		long interval = square;
		long cycle = (2*m) + (2*(m-1));
		long result = m;
		long k = length / interval;
		result = result + (k * cycle);
		long k2 = (length%interval)/m;
		result = result + (2*k2);
		return result;
		}
		return 0;
	}
}
