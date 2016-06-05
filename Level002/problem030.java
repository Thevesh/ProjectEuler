
public class problem030 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		
		for (int i = 2; i < 1000000; i++){
			int[] digits = Split(i);
			long sum = 0;
			for (int j = digits.length - 1; j >= 0; j--){
				sum += digits[j];
			}
			if (sum == i) {
				System.out.println(i);
				result += i;
			} 
		}

		System.out.println("Total sum : " + result);
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int[] Split (int n){
		int length = (int) Math.log10(n) + 1;
		int[] digits = new int[length];
		int index = length - 1;
		int number = n;
		while (number > 0) {
			digits[index] = (int) Math.pow((number%10),5);
			number = number / 10;
			index --;
		}
		return digits;
	}

}
