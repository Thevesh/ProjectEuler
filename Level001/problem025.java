import java.math.BigInteger;

public class problem025 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		long result = 0;
		BigInteger number = BigInteger.ZERO;
		
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		for(long i = 3; ; i++){
			number = a.add(b);
			if (String.valueOf(number).length() > 999) {
				result = i;
				break;
			}
			else {
				a = b;
				b =  number;
			}
		}
		
		System.out.println(result);
		
		double end = System.nanoTime();
		double duration = (end - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
}
