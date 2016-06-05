import java.math.BigInteger;

public class problem041 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		long temp = 0;
		
		for (long i = 9; i > 0; i--) {
			int[] digits = new int[(int)i];
			for (long j = 0; j < i; j++){
				digits[(int) j] = (int) (j+1);
			}
			do {
				if (Prime(Compress(digits)))
					temp = Compress(digits);
			} while (nextPermutation(digits));
			if (temp != 0 && temp > result)
				result = temp;
		}
		
		System.out.println(result);
		
		
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
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

	public static boolean Pandigital(String str){
		if (str.length() > 9) return false;
		int length = str.length();
		CharSequence[] digits = {"0","1","2","3","4","5","6","7","8","9"};
		for (int i = 1; i <= length; i++) {
			if (str.contains(digits[i])) continue;
			else return false;
		}
		return true;
	}

	public static boolean nextPermutation(int[] a) {
		int n = a.length, i, j;
		for (i = n - 2; ; i--) {
			if (i < 0)
				return false;
			if (a[i] < a[i + 1])
				break;
		}
		for (j = 1; i + j < n - j; j++) {
			int tp = a[i + j];
			a[i + j] = a[n - j];
			a[n - j] = tp;
		}
		for (j = i + 1; a[j] <= a[i]; j++);
		int tp = a[i];
		a[i] = a[j];
		a[j] = tp;
		return true;
	}
	
	public static long Compress (int[] digits){
		long result = 0;
		long length = digits.length;
		for (long i = 0; i < length; i++) {
			result = (result*10) + digits[(int)i];
		}
		return result;
	}
}
