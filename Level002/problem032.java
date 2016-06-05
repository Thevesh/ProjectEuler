import java.math.BigInteger;

public class problem032 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (long i = 99999; i > 1; i--) {
			System.out.println(i);
			String number = String.valueOf(i);
			if (!Unique(number)) continue;
			if (number.contains("0")) continue;
			if (i%5 == 0) continue;
			else {
			for (long j = 2; j*2 <= i; j++ ){
				StringBuilder test = new StringBuilder();
				long a = i;
				long b = j;
				if (i%j != 0) continue;
				long c = i/j;
				test.append(String.valueOf(a));
				test.append(String.valueOf(b));
				test.append(String.valueOf(c));
				if (Pandigital(test.toString())) {
					result += i;
					break;
				}
				else continue;
			}
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Unique (String str){
		 BigInteger checker = BigInteger.ZERO;
		    for (int i = 0; i < str.length(); i++) {
		        int value = str.charAt(i);
		        if (checker.testBit(value)) return false;
		        checker = checker.setBit(value);
		    }
		    return true;
	}
	
	public static boolean Pandigital(String str){
		if (str.length() != 9) return false;
		if (str.contains("9")){
			if (str.contains("8")){
				if (str.contains("7")){
					if (str.contains("6")){
						if (str.contains("5")){
							if (str.contains("4")){
								if (str.contains("3")){
									if (str.contains("2")){
										if (str.contains("1")){
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

}
