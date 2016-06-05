import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class problem043 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		long result = 0;
		List<Long> Numeros1 = new ArrayList<Long>();
		List<Long> Numeros2 = new ArrayList<Long>();
		
		for (long a = 1; a < 10; a++) {
			for (long b = 1; b < 10; b++){
				if(b == a) continue;
				for (long c = 1; c <10; c++) {
					if (c==a || c == b) continue;
					for (long d = 1; d < 10; d++) {
						if (d == a || d == b || d == c) continue;
						for (long e = 1; e < 10; e++) {
							if (e == a || e == b  || e == c || e == d) continue;
							for (long f = 1; f < 10; f++) {
								if (f == a || f == b  || f == c || f == d || f == e) continue;
								for (long g = 1; g < 10; g++) {
									if (g == a || g == b || g == c || g == d || g == e || g == f) continue;
									for (long h = 1; h < 10; h++) {
										if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) continue;
										for (long i = 1; i < 10; i++) {
											if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i == h) continue;
											long temp1 = (a*100000000) + (b*10000000) + (c*1000000) + (d*100000) + (e*10000) + (f*1000) + (g*100) + (h*10) + i;
											System.out.println(temp1);
											Numeros1.add(temp1);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for (long a = 1; a < 10; a++) {
			for (long b = 0; b < 10; b++){
				if(b == a) continue;
				for (long c = 0; c <10; c++) {
					if (c==a || c == b) continue;
					for (long d = 0; d < 10; d++) {
						if (d == a || d == b || d == c) continue;
						for (long e = 0; e < 10; e++) {
							if (e == a || e == b  || e == c || e == d) continue;
							for (long f = 0; f < 10; f++) {
								if (f == a || f == b  || f == c || f == d || f == e) continue;
								for (long g = 0; g < 10; g++) {
									if (g == a || g == b || g == c || g == d || g == e || g == f) continue;
									for (long h = 0; h < 10; h++) {
										if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) continue;
										for (long i = 0; i < 10; i++) {
											if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i == h) continue;
											for (long j = 0; j < 10; j++){
												if (j == a || j == b || j == c || j == d || j == e || j == f || j == g || j == h || j == i) continue;
												long temp2 = (a*1000000000) + (b*100000000) + (c*10000000) + (d*1000000) + (e*100000) + (f*10000) + (g*1000) + (h*100) + (i*10) + j;
												System.out.println(temp2);
												Numeros2.add(temp2);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < Numeros1.size(); i++){
			if(Diviso1(Numeros1.get(i))) {
				result += Numeros1.get(i);
			}
		}
		
		for (int i = 0; i < Numeros2.size(); i++){
			if(Diviso1(Numeros2.get(i))) {
				result += Numeros2.get(i);
			}
		}
		
		System.out.println(result);

		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static boolean Diviso1 (long n) {
		long a = (n/1000000);
		long b = ((((n/100000))%1000));
		long c = (((((n/10000))%10000)%1000));
		long d = (((((n/1000))%100000)%10000)%1000);
		long e = ((((((n/100))%1000000)%100000)%10000)%1000);
		long f = (((((((n/10))%10000000)%1000000)%100000)%10000)%1000);
		long g = ((((((((n/1))%100000000)%10000000)%1000000)%100000)%10000)%1000);

		if (a%2 == 0) {
			if (b%3 == 0) {
				if (c%5 == 0) {
					if (d%7 == 0) {
						if (e%11 == 0) {
							if (f%13 == 0) {
								if (g%17 == 0) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean Diviso2 (long n){
		long a = (n/1000000)%1000;
		long b = ((((n/100000)%10000)%1000));
		long c = (((((n/10000)%100000)%10000)%1000));
		long d = (((((n/1000)%1000000)%100000)%10000)%1000);
		long e = ((((((n/100)%10000000)%1000000)%100000)%10000)%1000);
		long f = (((((((n/10)%100000000)%10000000)%1000000)%100000)%10000)%1000);
		long g = ((((((((n/1)%1000000000)%100000000)%10000000)%1000000)%100000)%10000)%1000);

		if (a%2 == 0) {
			if (b%3 == 0) {
				if (c%5 == 0) {
					if (d%7 == 0) {
						if (e%11 == 0) {
							if (f%13 == 0) {
								if (g%17 == 0) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
		
	public static boolean Pandigital(long n){
		String str = String.valueOf(n);
		if (str.contains("9")){
			if (str.contains("8")){
				if (str.contains("7")){
					if (str.contains("6")){
						if (str.contains("5")){
							if (str.contains("4")){
								if (str.contains("3")){
									if (str.contains("2")){
										if (str.contains("1")){
											if (str.contains("0")) {
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean Unique (String str){
		 BigInteger checker = BigInteger.ZERO;
		    for (int i = 0; i < str.length(); i++) {
		        int value = str.charAt(i);
		        if (checker.testBit(value)) return false;
		        checker = checker.setBit(value);
		    }
		    return true;
	}
}
