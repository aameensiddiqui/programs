package CharStack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of stack : ");
		size = sc.nextInt();
//		char[] arr = new char[size];
		cStack cs = new cStack(size);
		int ch;
		do {
			System.out.println("1. Push element");
			System.out.println("2. Pop element");
			System.out.println("3. Peek element");
			System.out.println("4. Disp element");
			System.out.println("0. Exit");
			
			System.out.print("Enter Your Choice : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:{
				if(!cs.isFull()) {
					System.out.print("Enter Element to Push : ");
					char chh = sc.next().charAt(0);
					cs.push(chh);
				}else {
					System.out.println("Stack Over Flow");
				}
				break;
			}
			case 2:{
				if(!cs.isEmpty()) {
					char chh = cs.pop();
					System.out.println("Popped element is : "+chh);
				}else {
					System.out.println("Stack UnderFlow");
				}
				break;
			}
			case 3:{
				if(!cs.isEmpty()) {
					char chh = cs.peek();
					System.out.println("Peek element in a array is : "+chh);
				}else {
					System.out.println("Stack UnderFlow");
				}
				break;
			}
			case 4:{
				if(!cs.isEmpty()) {
					System.out.println("Displaying elements in array");
					cs.disp();
				}else {
					System.out.println("Stack UnderFlow");
				}
				break;
			}
			case 0:{
				break;
			}
			}
		}while(ch!=0);
	}

}
