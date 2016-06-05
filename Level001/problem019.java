
public class problem019 {

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		
		int sum = 0;
		for (int i = 1901; i <= 2000; i++) {
			for (int j = 1; j <= 12; j++) {
				if (Day(i,j,1) == 0) {
					sum += 1;
				};
			}
		}
		
		System.out.println(sum);
		
		double end = System.nanoTime();
		double duration = (end - start)/1000000000;
		
		System.out.println("Your code took " + duration + " seconds to execute.");
	}
	
	public static int Day(int x, int y, int z){
		
		int x1,a,b,c,d,e,f,g,h;
		int day;

		if (y==1||y==2)	{
			a = y + 10;
			x1 = x - 1;
		}
		
		else {
			a = y -2;
			x1 = x;
		}

		b = z;
		c = (int)(x1%100);
		d = (int)(x1/100);
		e = (int)(((13*a)-1)/5);
		f = (int)(c/4);
		g = (int)(d/4);
		h = (int)(e + f + g + b + c + (5*d));
		day = h%7;
		
		return day;
		
	}

}
