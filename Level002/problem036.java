
public class problem036 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (int i = 1; i < 10000000; i++) {
			String test1 = String.valueOf(i);
			if (!Palindrome(test1)) continue;
			else {
			String test2 = Integer.toBinaryString(i);
			if (Palindrome(test2)) result += i;
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Palindrome(String str) {
	    return str.equals(new StringBuilder(str).reverse().toString());
	}

}
