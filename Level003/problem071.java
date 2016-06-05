import org.apache.commons.math3.fraction.Fraction;

public class problem071 {

	// Trick to solving this problem comes from Farey sequence analysis: https://en.wikipedia.org/wiki/Farey_sequence
	// We are going to utilize ac - bd = 1. In this case: 3*den - 7*num = 1;
	// Our search starts at the top, and need only span a small range. We choose between 0.45x and 0.40x. 3/7 lies between.
	// Result should be the first fraction we find.
	
	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		
		for (int i = 1000000; i > 1; i--){
			for (int j = (i/20)*9; j > (i/20)*8; j--){
				if ( (3*i) - (7*j) == 1) {
					result = j;
					System.out.println(Fraction.getReducedFraction(j, i));
					break;
				}
			}
			if (result > 0) break;
		}
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
