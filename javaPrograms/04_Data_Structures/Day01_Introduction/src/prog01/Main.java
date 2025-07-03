package prog01;

public class Main {
	
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
		
		for(int i = 1 ; i <= 100 ; i++) {
			if(i==1) {
				System.out.println(i+" is nither prime nor composite");
				continue;
			}
			if(Main.isPrime(i)) {
				System.out.println(i+" is prime number");
			}else {
				System.out.println(i+" is not prime number");
			}
		}
		
	}

}
