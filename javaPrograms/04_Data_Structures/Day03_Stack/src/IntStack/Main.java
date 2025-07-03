package IntStack;

import java.util.Scanner;

import CharStack.cStack;

public class Main {

	public static void main(String[] args) {
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of stack : ");
		size = sc.nextInt();
//		int[] arr = new int[size];
		iStack cs = new iStack(size);
		int j = 0,num = 2 ;
		while(j<size) {
			boolean flag = true;
			for(int i = 2; i <= num/2 ; i++) {
				if(num%i==0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cs.push(num);
				j++;
			}
			num++;
		}
		System.out.println("First 10 Peime numbers are : ");
		cs.disp();
	}

}
