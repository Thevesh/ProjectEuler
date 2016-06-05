
public class problem051 {

	public static void main(String[] args) {

		double start = System.nanoTime();

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long Permuplace (long n){
		int length = String.valueOf(n).length();
		int[] Digits = new int[length];
		for (int i = length -1; i >=0 ; i--){
			Digits[length-i-1] = (int) String.valueOf(n).charAt(i);
		}
		
		
	}
	public static boolean Prime (long n) {
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}

}
