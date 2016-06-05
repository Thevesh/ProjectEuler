import java.util.ArrayList;
import java.util.List;

public class problem037 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		long count = 0;
		
		for (long i = 10; ; i++){
			if (!Prime(i)) continue;
			else {
				List<Long> Numbers = Truncate(i);
				if (PrimeList(Numbers)){
					System.out.println(i);
					result += i;
					count ++;
				}
			}
			if (count == 11) break;
		}
		
		System.out.println(result);
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean PrimeList (List<Long> list){
		int length = list.size();
		for (int i = 0; i < length; i++){
			if (!Prime((long)list.get(i))) return false;
		}
		return true;
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
	
	public static List<Long> Truncate(long n) {
		List <Long> Numbers = new ArrayList <Long>();
		int length = String.valueOf(n).length();
		for (int i = 1; i <= length; i ++){
			Numbers.add((long) (n/(Math.pow(10, i-1))));
		}
		for (int i = length; i > 1; i --){
			Numbers.add((long) (n%(Math.pow(10, i-1))));
		}
		return Numbers;
	}

}
