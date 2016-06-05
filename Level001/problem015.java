import java.math.BigInteger;

public class problem015 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		System.out.println(Robo(21,21));
		
		double end = System.nanoTime();
		double duration = (end - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	
	public static BigInteger Robo (long m, long n){
		return Combino((m+n-2),(n-1));
	}
	
	public static BigInteger Combino (long m, long n){
		return Factorial(m).divide((Factorial(n).multiply(Factorial(m-n))));
	}
	
	public static BigInteger Factorial (long n){
		BigInteger end = BigInteger.valueOf(1);
		for (long i = 1; i <= n; i++){
			end = end.multiply(BigInteger.valueOf(i));
		}
		return end;
	}

}
