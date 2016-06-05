import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class problem062 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int check = 0;
		int target = 5;
		int limit = 1;
		
		for (int i = 1;; i++){
			BigInteger[] numbers = Cubes(i,limit);
			Arrays.sort(numbers);
			limit += numbers.length;
			
			for (int j = 0; j < numbers.length; j++){

				Set<BigInteger> result = new HashSet<BigInteger>();
				result.add(numbers[j]);
				
				for (int k = 0; k < numbers.length; k++){
					if (k == j) continue;
					if (Compare(numbers[j], numbers[k])) result.add(numbers[k]);
				}
				
				if (result.size() == target) {
					check = target;
					System.out.println(Collections.min(result));
					break;
				}
			}
			
				if (check == target) break;
		}
		
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static BigInteger[] Cubes (int m, int n){
		Set<BigInteger> result = new HashSet<BigInteger>();
		
		for (int i = n;; i++){
			BigInteger check = BigInteger.valueOf(i).pow(3);
			if (String.valueOf(check).length() == m){
				result.add(check);
			}
			if (String.valueOf(check).length() > m)	break;
		}
		
		BigInteger[] output = result.toArray(new BigInteger[result.size()]);
		
		return output;
	}
	
	public static boolean Compare(BigInteger m, BigInteger n){
		String str1 = String.valueOf(m);
		String str2 = String.valueOf(n);
		int length1 = str1.length();
		int length2 = str2.length();
		if (length1 != length2) return false;
		
		int[] a = new int[length1];
		int[] b = new int[length2];
		
		for (int i = 0; i < length1; i++){
			a[i] = str1.charAt(i);
			b[i] = str2.charAt(i);
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		return Arrays.equals(a,b);
	}
}
