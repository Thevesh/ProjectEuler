import java.math.BigInteger;

public class problem016 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();

		int result = 0;

		String number = BigInteger.valueOf(2).pow(1000).toString();

		for(char a : number.toCharArray()){
			result = result + Character.getNumericValue(a);
		}
		
		System.out.println(result);
		
		double end = System.nanoTime();
		double duration = (end - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	

}
