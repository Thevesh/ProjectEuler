public class problem073 {

	// For this problem, use the algorithm for the next term in a Farey sequence of size n: https://en.wikipedia.org/wiki/Farey_sequence#Next_term
	// Once we determine that the term to the right of 1/3 in F12000 is 4000/11999, it becomes childishly simple to implement.
	// We determine the term to the right of 1/3 via (ac - bd = 1). This is a follow on from problem 71, and uses the same algorithm.
	
	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int limit = 12000;
		int a = 1;
		int b = 3;
		int c = 0;
		int d = 0;
		
		for (int i = 12000; i > 1; i--){
			for (int j = i/2; j > 1; j--){
				if ( (1*i) - (3*j) == -1) {
					c = j;
					d = i;
					break;
				}
			}
			if (c > 0) break;
		}
		
		int result = 0;

		while (!(c == 1 && d == 2)) {
		    result++;
		    int k = (limit + b) / d;
		    int e = k * c - a;
		    int f = k * d - b;
		    a = c;
		    b = d;
		    c = e;
		    d = f;
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
