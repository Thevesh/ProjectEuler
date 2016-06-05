
public class problem006 {

	public static void main(String[] args) {
		
		long n = 100;
		
		long squaresum = (long)Math.pow((double)(n+1)*(n/2),2.0);
		long sumsquare = (n*(n+1)*((2*n)+1))/6;
		
		System.out.println(squaresum);
		System.out.println(sumsquare);
		System.out.println(squaresum - sumsquare);
		

		long start = System.nanoTime();
		long end = System.nanoTime();
		double duration = ((double)end - (double)start)/1000000000;
		
		System.out.println(duration);
		
		
	}
	
}
