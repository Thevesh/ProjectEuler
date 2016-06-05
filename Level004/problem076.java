
public class problem076 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		// This approach uses dynamic programming 
		
		int target = 45;
		int[] ways = new int[target + 1];
		ways[0] = 1;

		for (int i = 1; i <= 99; i++) {
		    for (int j = i; j <= target; j++) {
		        ways[j] += ways[j - i];
		    }
		}
		
		System.out.println(ways[target]);
		
		// System.out.println(Partition(100,99)); - This is the output for the Partition function

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Partition (int number,int limit){
		if (limit == 0) return 0;
		if (number == 0) return 1;
		if (number < 0) return 0;
		else return Partition(number-limit,limit) + Partition(number,limit-1);
	}

}
