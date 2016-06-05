
public class problem112 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int bouncies = 0;
		int i = 99;
		
			while (100*bouncies < 99*i){
				i++;
				if(Bouncy(i)) bouncies++;
			}
			
		System.out.println(i);
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Bouncy (int n){
		boolean up = false;
		boolean down = false;
		
		int last = n%10;
		n /= 10;
		
		while (n > 0){
			int next = n%10;
			n /= 10;
			
			if (next > last) down = true;
			if (last > next) up = true;
			
			last = next;
			if (up && down) return true;
		}
		
		return false;
	}

}
