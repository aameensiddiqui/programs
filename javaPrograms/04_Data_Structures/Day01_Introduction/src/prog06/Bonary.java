package prog06;

public class Bonary {

	static public int power(int base,int index) {
	int result = 1;
	for(int i = 1 ; i <= index ; i++) {
		result = result * base;
	}
	return result;
}
	
	public static void main(String[] args) {
		int num = 1101 ;
		int i = 0,sum = 0 ;
		while(num!=0) {
			if(num%10==1)
				sum = sum + power(2,i);
			i++;
			num=num/10;
		}
		System.out.println("Decimal Digit of Binary is : "+sum);
	}

}
