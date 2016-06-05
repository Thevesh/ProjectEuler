import java.math.BigInteger;

public class problem104 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger cut = BigInteger.valueOf(1000000000);
		
		int k = 2;
		boolean found = false;
			
			while (!found){
			k++;
			BigInteger c = a.add(b);
			
			BigInteger tail = c.mod(cut);
			if (Pandigital(tail)){
				int digits = String.valueOf(c).length();
				BigInteger head = c.divide(BigInteger.TEN.pow(digits-9));
				if (Pandigital(head)) found = true;
			}
				a = b;
				b = c;
		}
			
			System.out.println(k);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	
	public static boolean Pandigital(BigInteger n){
		String str = String.valueOf(n);

		if (str.contains("0")) return false;
		if(str.contains("55")) return false;
		String[] numbers = {"1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < 9; i++){
			if (!str.contains(numbers[i])) return false;
		}
		
		return true;
	}

}
