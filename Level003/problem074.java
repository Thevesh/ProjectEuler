import java.util.HashSet;
import java.util.Set;

public class problem074 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		
		for (int i = 1; i < 1000000; i++){
			if (Factorain(i) == 60) result++;
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Factorain (int n){
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(n);
		int check = n;
		
		int count = 1;
		for (int i = 1;; i++){
			int test = Factorum(check);
			if (!numbers.contains(test)){
				numbers.add(test);
				count++;
				check = test;
			}
			if (numbers.contains(Factorum(check))) break;
		}
		
		return count;
	}

	
	public static int Factorum (int n){
		String str = String.valueOf(n);
		int length = str.length();
		int sum = 0;
		for (int i = 0; i < length; i++){
			int toF = Integer.valueOf(String.valueOf(str.charAt(i)));
			sum += Factorial(toF);
		}
		
		return sum;
	}
	
	public static int Factorial (int n){
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
