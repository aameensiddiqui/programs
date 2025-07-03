package customerQueue;

import java.util.Scanner;

import normalQueue.iQueue;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of Queue : ");
		int size = sc.nextInt();

		cQueue cq = new cQueue(size);
		int ch;
		do {
			System.out.println("1. Push in queue");
			System.out.println("2. Pop from queue");
			System.out.println("3. display queue");
			System.out.println("0. Exit from loop");
			
			System.out.print("Enter Your Choice : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:{
				System.out.print("Enter c_id : ");
				int c_id = sc.nextInt();
				System.out.print("Enter Name : ");
				String name = sc.next();
				Customer c = new Customer(c_id,name);
				cq.enQueue(c);
				break;
			}
			case 2:{
				Customer a = cq.deQueue();
				System.out.println(a + " is removed");
				break;
			}
			case 3:{
				cq.disp();
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
