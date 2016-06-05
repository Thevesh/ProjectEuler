import java.math.BigInteger;

public class problem065 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		
		BigInteger n0 = BigInteger.ONE;
		BigInteger n1 = BigInteger.valueOf(2);
		
		for (int n = 2; n <= 100; n++){
			BigInteger a0 = BigInteger.ONE;
			if (n%3 == 0) a0 = BigInteger.valueOf(n).divide(BigInteger.valueOf(3)).multiply(BigInteger.valueOf(2));
			BigInteger n2 = (a0.multiply(n1)).add(n0);
			
			n0 = n1;
			n1 = n2;

			result = DigitSum(n2);
		}
		
		System.out.println(result);		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int DigitSum (BigInteger n){
		String str = String.valueOf(n);
		int result = 0;
		for (int i = 0; i < str.length(); i++){
			result += Integer.valueOf(str.charAt(i) - 48);
		}
		return result;
	}

}
