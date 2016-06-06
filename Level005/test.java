
public class test {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		System.out.println("Hi");

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}

}
