import java.util.ArrayList;
import java.util.List;

public class problem047 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (long i = 4; ; i++){
			if (Quadractor(i) && Quadractor (i+1) && Quadractor(i+2) && Quadractor (i+3)){
				result = i;
				break;
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Quadractor (long n){
		return Factors(n) == 4;
	}

	public static long Factors (long n){
		long count = 0;
		for (long i = 2; i <= n; i++){
			if (n%i == 0){
				do n/=i; 
				while (n%i ==0);
				count ++;
			}
		}
		return count;
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
