package doubleEndedQueue;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DoubleEndedQueue deq = new DoubleEndedQueue();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			
			System.out.println("1. Insert in Queue from front");
			System.out.println("2. Insert in Queue from rear");
			System.out.println("3. Delete from front");
			System.out.println("4. Delete from rear");
			System.out.println("5. to CHECK qUEUE eMPTY OR NOT");
			System.out.println("6. To dsplay Queue");
			System.out.println("0. To exit from Program");
			
			System.out.print("Enter Your Choise : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:{
				System.out.print("Enter data to insert from front : ");
				int data = sc.nextInt();
				deq.enQueueFront(data);
				break;
			}
			case 2:{
				System.out.print("Enter data to insert from rear : ");
				int data = sc.nextInt();
				deq.enQueueRear(data);
				break;
			}
			case 3:{
				int pop;
				try {
					pop = deq.deQueueFront();					
					System.out.println("Deleted element from front is "+pop);
				}catch(QueueException de){
					System.out.println(de);
				}
				break;
			}
			case 4:{
				int pop;
				try {
					pop = deq.deQueueRear();					
					System.out.println("Deleted element from rear is "+pop);
				}catch(QueueException de){
					System.out.println(de);
				}
				break;
			}
			case 5:{
				if(deq.isEmpty()) {
					System.out.println("Queue is Empty");
				}else {
					System.out.println("Queue contains elements");
				}
				break;
			}
			case 6:{
				try {
					deq.disp();
				}catch(QueueException de){
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
