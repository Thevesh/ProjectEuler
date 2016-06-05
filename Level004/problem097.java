import java.math.BigInteger;

public class problem097 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		BigInteger a = BigInteger.valueOf(28433);
		BigInteger b = BigInteger.valueOf(2).pow(7830457);
		BigInteger c = BigInteger.ONE;
		BigInteger d = a.multiply(b);
		BigInteger e = d.add(c);
		
		String number = e.toString();
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

}
