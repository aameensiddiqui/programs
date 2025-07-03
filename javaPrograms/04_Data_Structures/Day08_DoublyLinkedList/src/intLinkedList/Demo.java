package intLinkedList;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		int ch;
		do {
			System.out.println("1. Create LinkedList");
			
			System.out.println("2. Add at the end of LinkedList");
			
			System.out.println("3. Display LinkedList");
			
			System.out.println("4. Total Number of Nodes LinkedList");
			
			System.out.println("5. Insert At position");
			
			System.out.println("6. Delete Data ");
			
			System.out.println("7. To print list reverse ");
			
			System.out.println("8. to Modify data ");
			
			System.out.println("9. reverse ");

			System.out.println("0. To exit");
			
			System.out.print("Enter Your Choice : ");
			
			ch = sc.nextInt();
			
			switch(ch) {
			
			case 1:{
				System.out.println("Create LinkedList");
				System.out.print("Enter Size : ");
				int size = sc.nextInt();
				ll.createList(size);
				break;
			}
			
			case 2:{
				System.out.print("Enter data to add at end : ");
				int data = sc.nextInt();
				ll.addAtEnd(data);
				break;
			}
			
			case 3:{
				System.out.println("Displaying LinkedList");
				ll.disp();
				System.out.println();
				break;
			}
			
			case 4:{
				int cnt = ll.size();
				System.out.println("Total Number of Nodes are "+cnt);
			}
			
			case 5:{
				System.out.print("Enter position to add data : ");
				int pos = sc.nextInt();
				System.out.print("Enter data : ");
				int data = sc.nextInt();
				ll.insertAtPos(pos, data);
				break;
			}
			
			case 6:{
				System.out.print("Enter data to delete : ");
				int data = sc.nextInt();
				ll.deleteData(data);
				break;
			}
			
			case 7:{
				System.out.print("Printing reverse list : ");
				ll.printReverse(ll.head);
				break;
			}
			
			case 8:{
				System.out.print("Enter data to modify : ");
				int data = sc.nextInt();
				System.out.print("Enter data change : ");
				int data1 = sc.nextInt();
				ll.modify(data, data1);
				break;
			}
			
			case 9:{
				ll.reverse();
				break;
			}
			
			case 0:{
				break;
			}
			}
		}while(ch!=0);
	}
}
