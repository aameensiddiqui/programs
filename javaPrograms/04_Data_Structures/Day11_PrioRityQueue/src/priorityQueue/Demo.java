package priorityQueue;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		pQueue pq = new pQueue(5);
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			
			System.out.println("1. Insert in Queue");
			System.out.println("2. dELETE eLEMENT FROM qUEUE");
			System.out.println("3. to CHECK qUEUE eMPTY OR NOT");
			System.out.println("4. to CHECK qUEUE is full or not");
			System.out.println("5. To dsplay Queue");
			
			System.out.print("Enter Your Choise : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:{
				System.out.print("Enter data in Element object : ");
				int data = sc.nextInt();
				System.out.print("Enter Priority for Element object : ");
				int prio = sc.nextInt();
				
				Element obj = new Element(data,prio);
				pq.enQueue(obj);
				break;
			}
			case 2:{
				Element pop;
				try {
					pop = pq.deQueue();					
					System.out.println(pop);
				}catch(PrioException pe){
					System.out.println(pe);
				}
				break;
			}
			case 3:{
				if(pq.isEmpty()) {
					System.out.println("Queue is Empty");
				}else {
					System.out.println("Queue contains elements");
				}
				break;
			}
			
			case 4:{
				if(pq.isFull()) {
					System.out.println("Queue is Full");
				}else {
					System.out.println("Queue is Not Full");
				}
				break;
			}
			
			case 5:{
				try {
					pq.disp();
				}catch(PrioException pe){
					System.out.println(pe);
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
