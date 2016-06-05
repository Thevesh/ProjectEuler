import java.math.BigInteger;

public class problem063 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (long i = 1; i < 10; i++){
			for (int j = 1;; j++){
				BigInteger n = BigInteger.valueOf(i).pow(j);
				long ll = String.valueOf(n).length();
				BigInteger l = BigInteger.valueOf(ll);
				if ((l.subtract(BigInteger.valueOf(j)).equals(BigInteger.ZERO))) result++;
				else break;
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
