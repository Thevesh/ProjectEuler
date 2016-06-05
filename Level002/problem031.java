public class problem031 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		int target  = 200;
		int ways = 0;
		 
		for (int a = target; a >= 0; a -= 200) {
		    for (int b = a; b >= 0; b -= 100) {
		        for (int c = b; c >= 0; c -= 50) {
		            for (int d = c; d >= 0; d -= 20) {
		                for (int e = d; e >= 0; e -= 10) {
		                    for (int f = e; f >= 0; f -= 5) {
		                        for (int g = f; g >= 0; g -= 2) {
		                            ways++;
		                        
		                        }
		                    }
		                }
		            }
		        }
		    }
		}
		
		System.out.println(ways);

		double duration = (System.nanoTime() - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	
	public static int countWays(int total, int[] set, int size) {
		if (total < 0) return 0;
		if (total == 0) return 1;
		if (size == 1) return 1;
		else return countWays(total,set,(size-1)) + countWays((total-set[size-1]),set,size);
	}

}
