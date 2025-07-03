package prog02;

import prog01.Main;

public class Prime {
	
	public static boolean isPrime(int num) {
		boolean flag = true;
		for(int i = 2 ; i <= num/2 ;i++) {
			if(num%i==0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		int cnt = 0;
		int num = 2;
		while(cnt<10) {
			if(Main.isPrime(num)) {
				System.out.println(num+" is prime number");
				cnt++;
			}
			num++;
		}

	}

}
