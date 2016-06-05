
public class problem034 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		for (int i = 3; i < 1000000; i++){
			if (Curious(i)) result += i;
		}
		
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Curious(int n){
		int[] digits = Digitize(n);
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += Factorial(digits[i]);
		}
		if (sum == n) return true;
		else return false;
	}
	
	public static int[] Digitize (int n){
		int length = String.valueOf(n).length();
		int[] result = new int [length];
		int number = n;
		for (int i = length - 1; i >= 0; i-- ) {
			result[i] = number%10;
			number = number/10;
		}
		return result;
	}
	
	public static int Factorial(int n){
		if (n == 0) return 1;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 6;
		if (n == 4) return 24;
		if (n == 5) return 120;
		if (n == 6) return 720;
		if (n == 7) return 5040;
		if (n == 8) return 40320;
		if (n == 9) return 362880;
		else return 0;
	}
}
