package circularQueue;

import java.util.Scanner;

import normalQueue.iQueue;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of Queue : ");
		int size = sc.nextInt();

		CircularQueue iq = new CircularQueue(size);
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
				System.out.print("Enter data to push : ");
				int data = sc.nextInt();
				iq.enQueue(data);
				break;
			}
			case 2:{
				System.out.println("pop");
				int a = iq.deQueue();
				System.out.println("deleted element is "+a);
				break;
			}
			case 3:{
				iq.disp();
				break;
			}
			case 0:{
				break;
			}
			}
		}while(ch!=0);
	}

}
