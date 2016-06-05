import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class problem061 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int[][] num = new int[6][];
		
		for (int i = 3; i < 9; i++){
			num[i-3] = new int[Figurate(i).size()];
			int index = 0;
			for (int n: Figurate(i)){
				num[i-3][index++] = n;
			}
		}
		
		int result = 0;
		
		int index = 0;
		int[] permutos = new int[120];
				
		for (int i = 1; i <=5; i++){
			for (int j = 1; j <= 5; j++){
				if (j == i) continue;
				for (int k = 1; k<= 5; k++){
					if (k == j || k == i) continue;
					for (int l = 1; l <= 5; l++){
						if (l == k || l == j || l == i) continue;
						for (int m = 1; m <= 5; m++){
							if (m == l || m == k || m == j || m == i) continue;
							permutos[index] = (i*10000) + (j*1000) + (k*100) + (l*10) + m;
							index ++;
						}
					}
				}
			}
		}
		
		for (int g = 0; g < 120; g++) {
			
			int ref = permutos[g];
			int a = 0;
			int b = ref/10000;
			int c = (ref%10000)/1000;
			int d = (ref%1000)/100;
			int e = (ref%100)/10;
			int f = ref%10;
			
			
		
		for (int i = 0; i < num[a].length; i++){
			for (int j = 0; j < num[b].length; j++){
				if (num[a][i]%100 == num[b][j]/100){
					for (int k = 0; k < num[c].length; k++){
						if (num[b][j]%100 == num[c][k]/100){
							for (int l = 0; l < num[d].length; l++){
								if (num[c][k]%100 == num[d][l]/100){
									for (int m = 0; m < num[e].length; m++){
										if (num[d][l]%100 == num[e][m]/100){
											for (int n = 0; n < num[f].length; n++){
												if (num[e][m]%100 == num[f][n]/100 && num[f][n]%100 == num[a][i]/100){
													System.out.println(num[a][i]);
													System.out.println(num[b][j]);
													System.out.println(num[c][k]);
													System.out.println(num[d][l]);
													System.out.println(num[e][m]);
													System.out.println(num[f][n]);
							result = num[a][i] + num[b][j] + num[c][k] + num[d][l] + num[e][m] + num[f][n];
							
							if (result != 0) break;
						}}}}}}}}}}}}				
				
								
		System.out.println(result);
		
		
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static Set<Integer> Figurate (int n){
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i = 1;; i++){
			if (Shape(n,i) > 9999) break;
			if (Shape(n,i) > 999) numbers.add(Shape(n,i));
		}
		
		return numbers;
	}

	public static int Shape (int sides, int n){
		int number = 0;
		switch (sides) {

        case 3:
            //Triangle numbers
            number = n * (n + 1) / 2;
            break;
        case 4:
            // Square numbers
            number = n * n;
            break;
        case 5:
            // Pentagonal numbers
            number = n * (3 * n - 1) / 2;
            break;
        case 6:
            //Hexagonal numbers
            number = n * (2*n - 1);
            break;
        case 7:
            //Heptagonal numbers
            number = n * (5 * n - 3) / 2;
            break;
        case 8:
            //Octagonal numbers
            number = n * (3 * n - 2);
            break;
    }
		
		return number;
	}
}
