import java.math.BigDecimal;

public class problem033 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int num = 1;
		int dum = 1;
		int sum = 0;
		
		for (int i = 10; i < 100; i++) {
			for (int j = i + 1; j < 100; j++) {
				boolean check = DCF(i,j);
				if(check == true) {
					System.out.println(i + " , " + j);
					num = num * i;
					dum = dum * j;
					sum ++;
				}
			}
		}
		
		System.out.println(num + " / " + dum + "  Total = " + sum );

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean DCF (int m, int n){
		int num1 = m/10;
		int num2 = m%10;
		int dum1 = n/10;
		int dum2 = n%10;
		if (num2 == 0 || dum2 == 0) {
			return false;
		}
		BigDecimal test;
		if (num1 == dum1) test = BigDecimal.valueOf((double)num2/(double)dum2);
		else if (num1 == dum2) test = BigDecimal.valueOf((double)num2/(double)dum1);
		else if (num2 == dum1) test = BigDecimal.valueOf((double)num1/(double)dum2);
		else if (num2 == dum2) test = BigDecimal.valueOf((double)num1/(double)dum1);
		else test = BigDecimal.valueOf(0);
		BigDecimal check = BigDecimal.valueOf((double)m/(double)n);
		if (test.equals(check)) {
			return true;
		}
		return false;
		
	}

}
