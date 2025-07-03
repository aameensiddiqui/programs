package SortedList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		int ch;
		do {
			System.out.println("1. Create LinkedList of multiplication of 5");
			
			System.out.println("2. Add at the end of LinkedList");
			
			System.out.println("3. Add at the begening of LinkedList");
			
			System.out.println("4. Add at the Pos of LinkedList");
			
			System.out.println("5. Total Nodes Present in the LinkedList");
			
			System.out.println("6. Display LinkedList");
			
			System.out.println("7. To search Element in LinkedList");
			
			System.out.println("8. To Modify Specific element in LinkedList");
			
			System.out.println("9. To Modify at the position of LinkedList");
			
			System.out.println("10. To Delete LinkedList");
			
			System.out.println("11. Sorted List");
			
			System.out.println("12. Split Even Odd");
			
			System.out.println("13. Merge List With called One");
			
			System.out.println("14. Merge Two given list");
			
			System.out.println("15. Print Linked List Reverse");
			
			System.out.println("16. Add Balanced Data");
			
			System.out.println("17. Delete node using data as input (first Occurence)");
			
			System.out.println("18. Sort LinkedList");
			
			System.out.println("19. Reverse LinkedList inPlace");
			
			System.out.println("20. Disp data at pos");
			
			System.out.println("21. Disp data at pos from reverse");
			
			System.out.println("22. Average of elements are ");
			
			System.out.println("0. To exit");
			
			System.out.print("Enter Your Choice : ");
			
			ch = sc.nextInt();
			
			switch(ch) {
			
			case 1:{
				System.out.println("Create LinkedList");
				System.out.print("Enter Num : ");
				int num = sc.nextInt();
				ll.createLinkedList(num);
				break;
			}
			
			case 2:{
				System.out.print("Enter data to add at end : ");
				int data = sc.nextInt();
				ll.addAtEnd(data);
				break;
			}
			
			case 3:{
				System.out.print("Enter data to add at Beg : ");
				int data = sc.nextInt();
				ll.addAtBeg(data);
				break;
			}
			
			case 4:{
				System.out.print("Enter position to add data : ");
				int pos = sc.nextInt();
				System.out.print("Enter data to add at Position : ");
				int data = sc.nextInt();
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
				int data = sc.nextInt();
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
				int data1 = sc.nextInt();
				System.out.print("Enter data : ");
				int data2 = sc.nextInt();
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
				int data = sc.nextInt();
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
				int[] arr = {10,15,12,11,19,17,16,5,1,4,3,20};
				LinkedList sl = new LinkedList();
				for(int i = 0 ;i<arr.length ; i++) {
					Node n = new Node(arr[i]);
					sl.sortedList(n);
				}
				sl.display();
				break;
			}
			
			case 12:{
				for(int i = 1 ;i <= 12 ;i++) {
					ll.addAtEnd(i);
				}
				ll.display();
				ll.split();
				break;
			}
			
			case 13:{
				LinkedList l1 = new LinkedList();
				l1.createLinkedList(10);
				ll.merge(l1);
				break;
			}
			
			case 14:{
				LinkedList l1 = new LinkedList();
				l1.createLinkedList(10);
				LinkedList l2 = new LinkedList();
				l2.createLinkedList(20);
				
				LinkedList lll = ll.merge(l1, l2);
				lll.display();
				break;
			}
			
			case 15:{
				ll.printReverse(ll.head);
				break;
			}
			
			case 16:{
				System.out.print("Enter Data To add Balanced : ");
				int data = sc.nextInt();
				ll.addBalanced(data);
				break;
			}
			
			case 17:{
				System.out.print("Enter Data To delete : ");
				int data = sc.nextInt();
				ll.delete(data,0);
				break;
			}
			
			case 18:{
				ll.sort();
				break;
			}
			
			case 19:{
				ll.reverse();
				break;
			}
			
			case 20:{
				System.out.print("Enter position : ");
				int pos = sc.nextInt();
				int num = ll.display(pos);
				System.out.println("Data at Pos is "+ num);
				break;
			}
			
			case 22:{
				float avg = ll.avg(ll.head);
				System.out.println("Average is : "+ avg);
				break;
			}
			case 0:{
				break;
			}
			
			}
		}while(ch!=0);

	}
}
