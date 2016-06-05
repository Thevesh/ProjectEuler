 import java.math.BigInteger;

import org.apache.commons.math3.fraction.Fraction;

public class problem057 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int count = 0;
		
		BigInteger num = BigInteger.valueOf(3);
		BigInteger den = BigInteger.valueOf(2);
		for (int i = 2; i <= 1000; i++){
			BigInteger temp = num.add(den.multiply(BigInteger.valueOf(2)));
			num = temp;
			den = num.subtract(den);
			if (String.valueOf(num).length() > String.valueOf(den).length()) count ++;
		}
		
		System.out.println(num);
		System.out.println(den);
		System.out.println(count);
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
