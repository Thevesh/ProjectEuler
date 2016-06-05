import java.math.BigInteger;

public class problem048 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		BigInteger temp = BigInteger.ZERO;
		for(long i = 1; i <= 1000; i++){
			temp = temp.add(XX(i));
		}
		
		String number = temp.toString();
		long length = number.length();
		
		StringBuilder result = new StringBuilder();
		for (long i = length - 10; i < length; i++ ) {
			char digit = number.charAt((int)i);
			result.append(digit);
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static BigInteger XX (long m) {
		BigInteger result = BigInteger.valueOf(m).pow((int) m);
		return result;
	}

}
