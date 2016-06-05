
public class problem026 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		int result = 0;
		int resultTemp = 0;
		int number = 0;
		
		for (int i = 2; i < 100000; i++) {
			resultTemp = LongDiv(i);
			if (resultTemp > result) {
				result = resultTemp;
				number = i;
			}
		}
		
		
		System.out.println("The fraction 1 / " + number + " has a recurring decimal that is " + result + " digits long.");

		double duration = (System.nanoTime() - start)/1000000000;		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	
	public static boolean testInt (int n) {
		if (n == 0 || n == 1) return false;
		if (n == 2) return true;
		if (n != 2 & n % 2 == 0) return false;
		for (long i = 3; i*i <= n; i+=2) {
				if (n % i == 0) return false;
			}
		return true;
		}
	
	public static int LongDiv (int n){
		int result = 1;
		int test = 10%n;
		if (n%2 == 0) return 0;
		if(!testInt(n)) return 0;
		if (test == 0) return 0;
		if (test == 1) return 1;
		while (test != 0 && test != 1){
			result++;
			test = (test*10)%n;
		}
		return result;
	}
	
}