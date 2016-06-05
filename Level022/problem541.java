
import java.math.BigInteger;

import org.apache.commons.math3.fraction.BigFraction;
public class problem541 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		BigFraction f = BigFraction.getReducedFraction(3, 2);
		
		for (long i = 3; ; i++){
			BigFraction a = BigFraction.getReducedFraction(1, (int) i);
			f = f.add(a);
			BigInteger denom = f.getDenominator();
			BigInteger target = BigInteger.valueOf(137);
			BigInteger compare = denom.mod(target);
			BigInteger zero = BigInteger.ZERO;
			if (compare.compareTo(zero) != 0) {
				System.out.println("Found : " + i);
			}
		}
	}
	
	

}
