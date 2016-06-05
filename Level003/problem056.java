import java.math.BigInteger;

public class problem056 {

	public static void main(String[] args) {
		
		long sum = 0;
		long result = 0;

		double start = System.nanoTime();
		
		for (int i = 99; i > 1; i--){
			for (int j = 99; j > 1; j--) {
				if ((Power(i,j).bitLength())*9 < result) break;
				sum = DigitSum(Power(i,j));
				if (sum >= result) result = sum;
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long DigitSum(BigInteger m){
		String number = m.toString();
		long result = 0;
		
		for(char a : number.toCharArray()){
			result = result + Character.getNumericValue(a);
		}
		
		return result;
	}
	
	public static BigInteger Power(int m, int n){
		return BigInteger.valueOf(m).pow(n);
	}

}
