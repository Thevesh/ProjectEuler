import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class problem079 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		// This is just removing the duplicate entries. 
		
		Set<String> Tries = new HashSet<String>();
		
		for (int i = 0; i < Entries.length; i++){
			Tries.add(Entries[i]);
		}
		
		// Now we cast it to a string. From now on, we only play with this.
		
		String[] passcodes = Tries.toArray(new String[Tries.size()]);
		int[][] result = new int[10][10];
		
		for (int i = 0; i < passcodes.length; i++){
			int a = Integer.valueOf(passcodes[i].charAt(0) - 48);
			int b = Integer.valueOf(passcodes[i].charAt(1) - 48);
			int c = Integer.valueOf(passcodes[i].charAt(2) - 48);
			
			result[a][b] = 1;
			result[b][c] = 1;
		}
		
		for (int i = 0; i <result.length; i++) {
	    	System.out.print("For digit " + i + " : ");
		    for (int j = 0; j < result[i].length; j++) {
		        System.out.print(result[i][j] + " ");
		    }
		    System.out.print("\n");
		}
		

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	private static String[] Entries = {
			"319", "680", "180", "690", "129", "620", "762", "689", "762", "318", "368", "710", "720", "710", "629", "168", "160", "689", "716", "731", "736", "729", "316", "729", "729", "710", "769", "290", "719", "680", "318", "389", "162", "289", "162", "718", "729", "319", "790", "680", "890", "362", "319", "760", "316", "729", "380", "319", "728", "716"
			};

}
