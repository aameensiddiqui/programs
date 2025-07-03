package intLinkedList;

import java.util.Scanner;

public class LinkedList {
	Node head ;

	public LinkedList() {
		head=null;
	}

	public LinkedList(int data){
		head = new Node(data); 
	}

	public void addAtEnd(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head = newNode;
		}
		else {
			Node move = head;
			while(move.next!=null) {
				move=move.next;
			}
			move.next = newNode;
			newNode.prev = move;
		}
	}

	public void createList(int size) {
		Scanner sc = new Scanner(System.in);
		int data;
		for(int i = 1 ;i<= size;i++) {			
			System.out.print("Enter data at : "+i+" ");
			data = sc.nextInt();
			//			Node newNode = new Node(data);
			addAtEnd(data);
		}
	}

	public void disp() {
		if(head==null) {
			System.out.println("LnkedList is Empty");
		}else {
			Node move = head;
			while(move!=null) {
				System.out.print(move);
				move=move.next;
			}
		}
	}

	public int size() {
		int cnt =0;
		if(head==null) {
			return cnt;
		}else {
			Node move = head;
			while(move!=null) {
				cnt++;
				move=move.next;
			}
		}
		return cnt;
	}

	public void insertAtPos(int pos,int data) {
		Node newNode = new Node(data);
		if(pos==1) {
			if(head==null) {
				head = newNode;
			}else {
				head.prev = newNode;
				newNode.next = head;
				head=newNode;
			}
		}else {
			Node move = head;
			for(int i = 1;i<pos-1;i++) {
				move = move.next;
			}
			newNode.prev = move;
			newNode.next = move.next;
			if(newNode.next!=null) {
				newNode.next.prev = newNode;
			}
			move.next = newNode;
		}
	}

	public void deleteData(int data) {
		if(head==null) {
			System.out.println("LinkedList is empty");
		}else {
			Node move = head;
			if(move.next==null) {
				if(move.data==data) {
					head=null;
				}else {
					System.out.println("Element not present in List");
				}
			}else if(head.data==data){
				head = head.next;
				head.prev = null;
			}else {				
				while(move.next.data!=data && move.next!=null) {
					move=move.next;
				}
				if(move.next==null) {
					System.out.println("Element not present in List");
				}else{
					move.next.prev = null;
					move.next=move.next.next;
					if(move.next!=null)
						move.next.prev = move;
				}
			}
		}
	}

	public void printReverse(Node head) {
		if(head==null) {
			return ;
		}
		printReverse(head.next);
		System.out.println(head.data);
	}

	public void modify(int data,int data1) {
		Boolean b = false;
		if(head==null) {
			System.out.println("Link List is empty");
		}else if(head.data==data) {
			head.data = data1;
		}else if(head.next==null){
			System.out.println("Data to modify is not present");
		}else {
			Node move = head;
			while(move.next.data!=data && move.next!=null) {
				move=move.next;
			}
			if(move.next==null) {
				System.out.println("Data to modify is not present");
			}else {
				b=true;
				move.next.data = data1;
			}
		}
		if(b) {
			System.out.println("Data is modified");
		}
	}
	
	public void reverse() {
		if(head==null) {
			return ;
		}
		if(head.next==null) {
			return ;
		}
		Node n1 = head.prev;
		while(head!=null){
			head.prev = head.next;
			head.next = n1;
			n1=head;
			head=head.prev;
		}
		head=n1;
	}
}
