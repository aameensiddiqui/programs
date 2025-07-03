package prog03;

public class Fibonacci {

	public static void main(String[] args) {
		int term = 10;
		int a = 0;
		int b = 1;
		for(int i = 0 ;  i < term ; i++) {
			System.out.println(a);
			b = a + b;
			a = b - a;
		}
	}

}
