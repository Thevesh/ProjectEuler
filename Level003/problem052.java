import java.util.Arrays;

public class problem052 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		for (long i = 1; ; i++){
			long a = i;
			long b = 2*i;
			long c = 3*i;
			long d = 4*i;
			long e = 5*i;
			long f = 6*i;
			if (Compare(a,b) && Compare(a,c) && Compare(a,d) && Compare(a,e) && Compare(a,f)){
				System.out.println("Found: " + i);
				break;
			}
			else continue;
		}

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Compare (long m, long n) {
		String number1 = String.valueOf(m);
		String number2 = String.valueOf(n);
		long length1 = number1.length();
		long length2 = number2.length();
		if (length1 != length2) return false;
		
		int[] digits1 = new int[(int)length1];
		int[] digits2 = new int[(int)length2];
		for (int i = 0; i < length1; i++) {
			digits1[i] = number1.charAt(i);
			digits2[i] = number2.charAt(i);
		}
		
		Arrays.sort(digits1);
		Arrays.sort(digits2);
		for (int i = 0; i < length1; i++){
			if (digits1[i] == digits2[i]) {
				if (i == length1 - 1) return true;
				else continue;
			}
			else {
				break;
			}
		}
		return false;
	}

}
