import java.math.BigInteger;

public class problem055 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long sum = 0;
		
		for (long i = 1; i <= 10000; i++){
			BigInteger j = BigInteger.valueOf(i);
			if (Lychrel(j)) sum++;
		}
		
		System.out.println(sum);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Lychrel (BigInteger n){
		BigInteger a = n;
		BigInteger b = Reverse(a);
		BigInteger c = (a.add(b));
		
		long sum = 0;
		
		while (!Palindrome(String.valueOf(c))){
			sum ++;
			a = c;
			b = Reverse(a);
			c = a.add(b);
			if (sum > 50) {
				return true;
			}
		}
		return false;
	}
	
	public static BigInteger Reverse (BigInteger n){
		String temp = String.valueOf(n);
		String temp2 = new StringBuilder(temp).reverse().toString();
		BigInteger result = new BigInteger(temp2);
		return result;
	}
	
	public static boolean Palindrome(String str) {
	    return str.equals(new StringBuilder(str).reverse().toString());
	}

}
