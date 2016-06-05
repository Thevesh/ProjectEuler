
public class problem005 {

	public static void main(String[] args) {
		
		long[] numbers = new long [20];
		for (long i = 1; i <= 20; i++) numbers[(int)(i-1)] = i;
		
		long result = setLCM(numbers,0,19);
		System.out.println(result);
		
		
		long start = System.nanoTime();
		Timer();
		long end = System.nanoTime();
		double duration = ((double)end - (double)start)/1000000000;
		
		System.out.println(duration);
				
	}
	
	private static void Timer() {
	}
	

	public static long setLCM (long[] numbers, int m, int n){
		if ((n - m) == 1) 
			return LCM (numbers[m],numbers[n]);
		else
			return LCM(setLCM(numbers,m,n-1),n);
	}
	
	public static long LCM(long p, long q){
		if (p == 0) return 0;
		else return (p*q)/GCD(p,q);
	}
	
	public static long GCD (long p, long q) {
		if (p == 0) return q;
		else return GCD (q%p,p);
	}

}
