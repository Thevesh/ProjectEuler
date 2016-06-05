import java.util.List;
import java.util.ArrayList;

public class problem001 {
	
	public static void main (String args[]) {
	
	
	List <Integer> thrive = new ArrayList <Integer> (); {
	
	for (int i = 1; i < 1000; i++){
		if ((i%3) == 0 || (i%5) == 0){
			thrive.add(i);
		}
	}
	
	int sum = 0;
	for (int i = 0; i < thrive.size(); i++){
		sum += thrive.get(i);
	}
	
	System.out.println(sum);
	
	

}
}
}
