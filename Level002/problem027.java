
public class problem027 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int sum = 0;
		int sumTemp = 0;
		int A = 0;
		int B = 0;
		
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				for (int n = 0; ; n++) {
					int test = Quadratic(n,a,b);
					if (test < 0) break;
					if (PrimeTest(test)) sumTemp ++;
					else break;
				}
				if (sumTemp > sum) {
					sum = sumTemp;
					sumTemp = 0;
					A = a; B = b;
				}
				else sumTemp = 0;
			}
		}
		
		System.out.println(A);
		System.out.println(B);
		System.out.println(A*B);
		System.out.println(sum);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Quadratic(int n, int a, int b){
		return (n*(a+n)) + b;
	}
	
	public static boolean PrimeTest (int n) {
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}

}
