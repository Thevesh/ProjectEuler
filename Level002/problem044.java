
public class problem044 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (long i = 2;; i++){
			if (result != 0 && (Pentagon(i) - Pentagon(i-1)) >= result) {
				break;
			}
			for (long j = i-1; j >= 1; j--){
				long pen1 = Pentagon(i);
				long pen2 = Pentagon(j);
				long diff = pen1 - pen2;
				if (result != 0 && diff >= result) break;
				
				long sum = pen1 + pen2;
				
				if (PenTest(sum) && PenTest(diff)){
					if (result == 0) result = diff;
					if (result > 0 && diff < result) result = diff;
					break;
				}
			}
		}
		
		System.out.println(result);
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long Pentagon(long n){
		return (n*((3*n)-1))/2;
	}
	
	public static boolean PenTest (long n){
		// 3n^2 - n = 2(x) - We need to test whether the solution is an integer.
		double a = 3.0;
		double b = -1.0;
		double c = -2.0*((double)n);
		
		double disc = Math.sqrt(Math.pow(b, 2) - 4.0*a*c);
		double sol1 = (-b + disc)/(2.0*a);
		double sol2 = (-b - disc)/(2.0*a);
		
		if (sol1 < 0 && sol2 < 0) return false;
		
		if (sol1 > 0 && sol1%1.0 == 0) {
			return true;
		}
		if (sol2 > 0 && sol2%1.0 == 0) {
			return true;
		}
		
		return false;
	}
}
