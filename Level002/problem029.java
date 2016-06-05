import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class problem029 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		long a = 2;
		long b = 100;
		
		List <BigInteger> powers = new ArrayList <BigInteger>();
		
		for (long i = a; i <= b; i++){
			for (long j = a; j <= b; j++) {
				BigInteger test = BigInteger.valueOf(i).pow((int) j);
				if (!powers.contains(test)) powers.add(test);
			}
		}
		
		long result = powers.size();
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
