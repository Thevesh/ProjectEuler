
public class problem002 {

	public static void main(String[] args) {
	      		

		    long sum = 0;
			long fibono;
			for (long i = 1; i < 45; i++){
				fibono = Fibonacci(i);
				if (fibono > 4000000){
					break;
				}
				if (fibono%2 == 0){
					sum += fibono;
				}
				
			}
			
			System.out.println(sum);
		
	     }
	     
		public static long Fibonacci (long n) {
			if (n == 1){
				return 1;
			}
			if (n == 2){
				return 2;
			}
			return Fibonacci(n-1) + Fibonacci(n-2);
		}

		

	}


