
public class problem085 {

	// For any grid, there are ( (m+1) choose 2 ) × ( (n+1) choose 2 ) ways to form rectangles.
	// Source: http://www.gottfriedville.net/mathprob/comb-subrect.html
	// We generate the choose2 function using triangular numbers. Much faster.
	// USe 2000 as an upper limit since it is the first n for which nC2 is > 2 million.
	
	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long resultU = 100000000000L;
		long areaU = 0;
		long resultL = -100000000000L;
		long areaL = 0;
		long l1U = 0;
		long l2U = 0;
		long l1L = 0;
		long l2L = 0;
		
		for (long m = 2000; m > 0; m--){
			for (long n = 2000; n > 0; n--){
				long check = 2000000 - (chooseTwo(m+1)*chooseTwo(n+1));
				if (check > 0){
					if (check < resultU) {
						resultU = check;
						areaU = m*n;
						l1U = m;
						l2U = n;
					}
				}
				if (check < 0){
					if (check > resultL) {
						resultL = check;
						areaL = m*n;
						l1L = m;
						l2L = n;
					}
				}
			}
		}
		
		if (Math.abs(resultL) < resultU) System.out.println(areaL + " formed by " + l1L + " x " + l2L + " with " + (2000000 - resultL) + " combinations.");
		else System.out.println(areaU + " formed by " + l1U + " x " + l2U + " with " + (resultU + 2000000) + " combinations.");

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

	
	public static long chooseTwo (long n){
		return (n)*(n-1)/2;
	}
}
