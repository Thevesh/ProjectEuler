
public class problem017 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		long result = 0;
		for (int i =1; i < 1001; i++){
			result += NumLength(i);
		}
		
		System.out.println(result);
		
		double end = System.nanoTime();
		double duration = (end - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int [] ones = {0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8};
	public static int [] tens = {0,0,6,6,5,5,5,7,6,6};
	public static int [] hundreds = {0,13,13,15,14,14,13,15,15,14};
	
	public static int NumLength (int n) {
		if (n < 20) return ones[n];
		if (n < 100) return tens[n/10] + ones[n%10];
		if (n > 99 && n < 1000 && n % 100 == 0) return hundreds[n/100] - 3;
		if (n < 1000) return hundreds[n/100] + NumLength(n - (100*(n/100)));
		if (n == 1000) return 11;
		else return 0;
	}

}
