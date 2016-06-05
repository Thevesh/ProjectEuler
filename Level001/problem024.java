import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem024 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
	
		String string = "0123456789";
		List<String> Results = Permutations(string);
	
		String[] numbers = new String [Results.size()];
		for (long i = 0; i < Results.size(); i++) {
			numbers[(int) i] = Results.get((int) i);
		}
		
		Arrays.sort(numbers);
		
		System.out.println(numbers[999999]);
		
		double duration = (System.nanoTime() - start)/1000000000;		
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	

	public static List<String> Permutations(String str) {
		List<String> Result = new ArrayList<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			Result.add("");
			return Result;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		List<String> words = Permutations(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				Result.add(CharAdd(newString, firstChar, i));
			}
		}
		return Result;
	}
 
	public static String CharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
 
}


