package prog07;

public class Palindrome {

	public static int reverse(int num) {
		int sum = 0 ;
		while(num!=0) {
			int rem = num%10;
			sum = sum*10 + rem;
			num = num/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int num = 210012;
		int rNum = Palindrome.reverse(num);
		if(num==rNum) {
			System.out.println("Is palindrome number");
		}else {
			System.out.println("Is not palindrome number");
		}

	}

}
