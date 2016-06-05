import java.util.ArrayList;
import java.util.List;

public class problem035 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		
		for (int i = 1; i < 1000000; i ++){
			if (!PrimeTest(i)) continue;
			if(PrimeTest(i)) {
				int[] numbers = Circulate(i);
				int limit = String.valueOf(i).length() -1;
				for (int j = limit; j >= 0 ; j--) {
					if (!PrimeTest(numbers[j])){
						break;
					}
					if (j == 0) result++;
				}
				
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
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
	
	public static int[] Circulate(int n){
		int length = String.valueOf(n).length();
		int factor = (int) Math.pow(10, length - 1);
		int[] result = new int[length];
		result[0] = n;
		for (int i = 1; i < length; i++){
			int a = (result[i-1])%factor;
			int b = a * 10;
			int c = (result[i-1])/factor;
			result[i] = b + c;
		}
		return result;
	}

}
