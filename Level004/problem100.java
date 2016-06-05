
public class problem100 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		// (b/t)(b-1/t-1) = 1/2
		// (b2-b)/(t2-t) = 1/2
		// 2b2 - 2b = t2 - t
		// 2b2 - t2 - 2b + t = 0 --> Let b = x, t = y for the Diophantine
				
		// Conditions: Xn+1 = 3Xn + 2Yn -2 ; Yn+1 = 4Xn + 3Yn - 3
				
		long b1 = 15;
		long t1 = 21;
		long min = 1000000000000L;
				
		while (t1 < min){
			long b2 = 3*b1 + 2*t1 - 2;
			long t2 = 4*b1 + 3*t1 - 3;
			b1 = b2;
			t1 = t2;			
		}
				
		System.out.println(b1);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
