import java.util.ArrayList;
import java.util.Collections;
public class problem004 {

	public static void main(String[] args) {		
		
		ArrayList<Integer> Palindromes = new ArrayList<Integer>();
		
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				if (Palindrome(Integer.toString(i*j))) {
				Palindromes.add(i*j);
				break; 
				}
			}	
		}
		
		System.out.println(Collections.max(Palindromes));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean Palindrome(String x) {
	    return x.equals(new StringBuilder(x).reverse().toString());
	}
	
}
