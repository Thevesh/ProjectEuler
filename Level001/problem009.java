
public class problem009 {

	public static void main(String[] args) {
		

		long start = System.currentTimeMillis();
		
		long result = 0;
		
		for (long i = 1; i < 1000; i++) {
			for (long j = i +1; j < 1000; j++) {
				long k = 1000 - i - j;
				if ((i*i) + (j*j) == (k*k) ) result = (i*j*k);
			}
		}
		
		System.out.println(result);;

		long end = System.currentTimeMillis();
		double duration = ((double)end - (double)start)/1000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");
		
		
	}
	

}
