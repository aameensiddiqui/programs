package stringLinkedList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		int ch;
		do {
			System.out.println("1. Create LinkedList of 10 Strings");
			System.out.println("2. Add at the end of LinkedList");
			System.out.println("3. Add at the begening of LinkedList");
			System.out.println("4. Add at the Pos of LinkedList");
			System.out.println("5. Total Nodes Present in the LinkedList");
			System.out.println("6. Display LinkedList");
			System.out.println("7. To search Element in LinkedList");
			System.out.println("8. To Modify Specific element in LinkedList");
			System.out.println("9. To Modify at the position of LinkedList");
			System.out.println("10. To Delete LinkedList");
			System.out.println("11. To Print First Node");
			System.out.println("12. TO Print Last Node");
			System.out.println("0. To exit");
			
			System.out.print("Enter Your Choice : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:{
				System.out.println("Create LinkedList");
				ll.createLinkedList("Hello");
				break;
			}
			case 2:{
				System.out.print("Enter data to add at end : ");
				String data = sc.next();
				ll.addAtEnd(data);
				break;
			}
			case 3:{
				System.out.print("Enter data to add at Beg : ");
				String data = sc.next();
				ll.addAtBeg(data);
				break;
			}
			case 4:{
				System.out.print("Enter position to add data : ");
				int pos = sc.nextInt();
				System.out.print("Enter data to add at Position : ");
				String data = sc.next();
				ll.addAtPos(pos,data);
				break;
			}
			case 5:{
				int cnt = ll.totalNodes();
				System.out.println("Total Number of nodes are "+cnt);
				break;
			}
			case 6:{
				ll.display();
				break;
			}
			case 7:{
				System.out.print("Enter data to search in linkedList : ");
				String data = sc.next();
				int b = ll.search(data);
				if(b==-1) {
					System.out.println(data+" is not present in LinkedList");
				}else {
					System.out.println(data+" is present in LinkedList at node "+b);
				}
				break;
			}
			case 8:{
				System.out.print("Enter data which you want to change : ");
				String data1 = sc.next();
				System.out.print("Enter data : ");
				String data2 = sc.next();
				boolean b = ll.modify(data1,data2);
				if(b) {
					System.out.println("Data Modified Successfully");
				}else {
					System.out.println("Data which you want to modify is not present in linkedList");
				}
				break;
			}
			
			case 9:{
				System.out.print("Enter position where you want to change  data : ");
				int pos = sc.nextInt();
				System.out.print("Enter data : ");
				String data = sc.next();
				boolean b = ll.modify(pos,data,0);
				if(b) {
					System.out.println("Data Modified Successfully");
				}else {
					System.out.println("Data which you want to modify is not present in linkedList");
				}
				break;
			}
			case 10:{
				System.out.print("Enter position to delete : ");
				int pos = sc.nextInt();
				boolean b = ll.delete(pos);
				if(b) {
					System.out.println("Element deleted from linkedlist");
				}else {
					System.out.println("Element not deleted from linkedList");
				}
				break;
			}
			case 11:{
				System.out.println(ll.firstNode());
				break;
			}
			case 12:{
				System.out.println(ll.lastNode());
			}
			
			case 0:{
				break;
			}
			}
		}while(ch!=0);

	}
}
