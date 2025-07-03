package prog04;

public class Amstrong {
	
	public static int cntDigits(int num) {
		int cnt=0;
		while(num!=0) {
			cnt++;
			num=num/10;
		}
		return cnt;
	}
	
	static public int power(int base,int index) {
		int result = 1;
		for(int i = 1 ; i <= index ; i++) {
			result = result * base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 10000 ; i++) {
			int num = i,sum = 0;
			int digCnt = Amstrong.cntDigits(i);
			while(num!=0) {
				int rem = num%10;
				sum = sum + power(rem,digCnt);
				num = num/10;
			}
			if(sum == i) {
				System.out.println(i);
			}
		}
	}

}
