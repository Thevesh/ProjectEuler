
public class problem092 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		
		for (int i = 1; i <= 10000000; i++){
			if (Squagit(i) == 89) result ++;
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Squagit (int n){
		if (n == 89) return 89;
		if (n == 1) return 1;
		
		String str = String.valueOf(n);
		int length = str.length();
		int nova = 0;
		for (int i = 0; i < length; i++){
			int toS = Integer.valueOf(String.valueOf(str.charAt(i)));
			nova += Math.pow(toS, 2);
		}
		
		if (nova == 89) return 89;
		if (nova == 1) return 1;
		else return Squagit (nova);
	}

}
