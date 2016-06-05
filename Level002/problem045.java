
public class problem045 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long triangulo = 0;
		
		for (long i = 286; ; i++){
			triangulo = (i)*(i+1)/2;
			if (PenTest(triangulo) && HexTest(triangulo)) {
				System.out.println(triangulo);
				System.out.println(i);
				break;
			}
		}

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
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

	public static boolean HexTest (long n){
		// 3n^2 - n = 2(x) - We need to test whether the solution is an integer.
		double a = 2.0;
		double b = -1.0;
		double c = -1.0*((double)n);
		
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
