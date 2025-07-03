package dynamicQueue;

import java.util.Scanner;

public class Demo extends RuntimeException{

	public static void main(String[] args) {
		dQueue dq = new dQueue();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			
			System.out.println("1. Insert in Queue");
			System.out.println("2. dELETE eLEMENT FROM qUEUE");
			System.out.println("3. to CHECK qUEUE eMPTY OR NOT");
			System.out.println("4. To dsplay Queue");
			
			System.out.print("Enter Your Choise : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:{
				int data = sc.nextInt();
				dq.enQueue(data);
				break;
			}
			case 2:{
				int pop;
				try {
					pop = dq.deQueue();					
					System.out.println("Deleted element is "+pop);
				}catch(DynamicException de){
					System.out.println(de);
				}
				break;
			}
			case 3:{
				if(dq.isEmpty()) {
					System.out.println("Queue is Empty");
				}else {
					System.out.println("Queue contains elements");
				}
				break;
			}
			case 4:{
				try {
					dq.disp();
				}catch(DynamicException de){
					System.out.println(de);
				}
				break;
			}
			case 0:{
				break;
			}
			}
		}while(ch!=0);
		sc.close();
	}

}
