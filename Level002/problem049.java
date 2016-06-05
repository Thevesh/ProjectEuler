import java.util.ArrayList;
import java.util.List;

public class problem049 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 1488; i <= 3339; i++){
			int a = i;
			int b = i + 3330;
			int c = b + 3330;
			if (!Prime(a) || !Prime(b) || !Prime(c)) continue;
			else {
				if (Permuto(a,b,c)) {
					result.append(String.valueOf(a));
					result.append(String.valueOf(b));
					result.append(String.valueOf(c));
					break;
				}
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Prime (int n) {
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}
	
	public static boolean Permuto (int a, int b, int c){
		int k1 = String.valueOf(a).length();
		int k2 = String.valueOf(b).length();
		int k3 = String.valueOf(c).length();
		if (k1 != k2 || k2 != k3) return false;
		
		List<Integer> digits = new ArrayList <Integer>();
		
		for (int i = 0; i < k1; i++){
			digits.add((int) String.valueOf(a).charAt(i));
		}
		
		for (int i = 0; i < k2; i++){
			int test = (int) String.valueOf(b).charAt(i);
			if (!digits.contains(test)) digits.add(test);
		}
		
		for (int i = 0; i < k3; i++){
			int test = (int) String.valueOf(c).charAt(i);
			if (!digits.contains(test)) digits.add(test);
		}
		
		int size = digits.size();
		if (size == k1) return true;
		else return false;
	}

}
