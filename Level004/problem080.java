import java.math.BigInteger;

public class problem080 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		
		for (int i = 1; i <= 100; i++){
			if (i == 1 || i == 4 || i == 9 || i == 16 || i == 25 || i == 36 || i == 49 || i == 64 || i == 81 || i == 100) continue;
			result += DigitSum(Root(i,100));
		}

		System.out.println(result);
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
		
		
	
	public static int DigitSum (BigInteger n){
		String number = String.valueOf(n);
		int result = 0;
		
		for (int i = 0; i < number.length(); i++){
			result += Integer.valueOf(number.charAt(i) - 48);
		}
		
		return result;
	}
	
	public static BigInteger Root(int n, int digits) {
	    BigInteger limit = BigInteger.TEN.pow(digits+1);
	    BigInteger a = BigInteger.valueOf(5).multiply(BigInteger.valueOf(n));
	    BigInteger b = BigInteger.valueOf(5);
	 
	    while (b.compareTo(limit) == -1) {
	        if (a.compareTo(b) == 1 || a.compareTo(b) == 0) {
	            a = a.subtract(b);
	            b = b.add(BigInteger.TEN);
	        } else {
	            a = a.multiply(BigInteger.valueOf(100));
	            b = ((b.divide(BigInteger.TEN)).multiply(BigInteger.valueOf(100))).add(BigInteger.valueOf(5));
	        }
	    }
	 
	    return b.divide(BigInteger.valueOf(100));
	}

}
