
public class problem040 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		StringBuilder temp = new StringBuilder();
		for (int i = 1; i < 200000; i++){
			temp.append(i);
		}
		
		String number = temp.toString();
		
		int d1 = number.charAt(0) - 48;
		int d10 = number.charAt(9) - 48;
		int d100 = number.charAt(99) - 48;
		int d1000 = number.charAt(999) - 48;
		int d10000 = number.charAt(9999) - 48;
		int d100000 = number.charAt(99999) - 48;
		int d1000000 = number.charAt(999999) - 48;
		
		int result = d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000;
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
