import java.math.BigInteger;

public class problem053 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long sum = 0;
		
		for(long i = 23; i <= 100; i++){
			sum += MilTest(i);
		}
		
		System.out.println(sum);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long MilTest (long n){
		long test = 0;
		
		for (long i = 1; i <= n; i++){
			if (Combino(n,i) > 1000000) {
				test = i;
				break;
			}
		}
		return (n+1) - (2*test);
	}
	
	public static long Combino(long m, long n){
		BigInteger a = Factorial(BigInteger.valueOf(m));
		BigInteger b = Factorial(BigInteger.valueOf(n));
		BigInteger c = Factorial(BigInteger.valueOf(m-n));
		BigInteger result = a.divide((b.multiply(c)));
		long finale = result.longValue();
		return finale;
	}
	
	public static BigInteger Factorial (BigInteger n){
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
		else return n.multiply(Factorial(n.subtract(BigInteger.ONE)));
	}

}
