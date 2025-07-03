package prog05;

public class Perfect {

	public static void main(String[] args) {
		int num = 6;
		int sum = 0;
		for(int i = 1 ; i < 6 ;i++) {
			if(num%i==0) {
				sum+=i;
			}
		}
		if(sum==num) {
			System.out.println("Perfect Number");
		}
	}

}
