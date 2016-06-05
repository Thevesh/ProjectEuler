
public class problem039 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int result = 0;
		int number = 0; 
		
		for (int i = 1; i <= 1000; i++) {
			int temp = Pythagoras (i);
			if (temp >= result) {
				result = temp;
				temp  = 0;
				number = i;
			}
		}
		
		System.out.println("There are " + result + " solutions for p = " + number);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

	public static int Pythagoras (int p) {
		    int result = 0;
		    for (int a = 1; a <= p; a++) {
				for (int b = a; b <= p; b++) {
					int c = p - a - b;
					if (b <= c && a * a + b * b == c * c)
						result++;
				}
			}
		    return result;
		}
	
}
