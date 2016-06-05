import java.math.BigInteger;

public class problem038 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (long i = 100; i <= 9999; i++) {
			String number = String.valueOf(i);
			if (number.contains("0")) continue;
			if (!Unique(number)) continue;
			if (i%5 == 0) continue;
			else {
				String test = String.valueOf(Concatenate(i));
				if (Pandigital(test) && Concatenate(i) > result) {
					result = Concatenate(i);
				}
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static long Concatenate (long n){
		StringBuilder temp = new StringBuilder();
		for (long i = 1; ; i++) {
			long length = temp.toString().length();
			long add = String.valueOf(n*i).length();
			if (length + add <= 9) {
				temp.append(n*i);
			}
			if (length + add > 9) break;
		}
		return (long)Integer.parseInt(temp.toString());
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
	
	public static boolean Unique (String str){
		 BigInteger checker = BigInteger.ZERO;
		    for (int i = 0; i < str.length(); i++) {
		        int value = str.charAt(i);
		        if (checker.testBit(value)) return false;
		        checker = checker.setBit(value);
		    }
		    return true;
	}

}
