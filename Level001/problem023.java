
public class problem023 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		long limit = 28123;
		double limit2 = 28123;
		long sumO = (long)((limit2/2)*(limit2+1));
		
		
		// add abundance test to an array
		
		boolean [] isAbundant = new boolean [(int) (limit +1) ];
		isAbundant[0] = false;
		for (int i = 1; i <= limit; i++){
			long sum = 0;
			for (int j = 1; j <= i/2; j++){
				if (i%j == 0) sum += j;
			}
			if (sum > i ) isAbundant[i] = true;
			else isAbundant[i] = false;
		}
		
		// sum up numbers that can't be expressed as sum of two abundants
		
		long sumT = 0;
		for (int i = 1; i <= limit; i++) {
			for (int j = 1; j <= i-1; j++) {
				if (isAbundant[j] && isAbundant[i-j]) {
					sumT += i;
					break;
				}
			}
		}
		
		System.out.println(sumO - sumT); 

		double duration = (System.nanoTime() - start)/1000000000;		
		System.out.println("Your code took " + duration + " seconds to execute.");
		
	}
}

