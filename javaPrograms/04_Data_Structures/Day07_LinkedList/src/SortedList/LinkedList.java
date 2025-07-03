// Delete at Beg
// Delete At End


package SortedList;

public class LinkedList {
	Node head;
	
	public LinkedList(){
		head = null;
	}
	public LinkedList(int data) {
		head = new Node(data);
	}

	// 1. Create LinkedList of 5
	public void createLinkedList(int num) {
		for(int i = 1 ;i<= 10 ; i++) {
			addAtEnd(num*i);
		}
	}

	public float avg(Node head) {
		int cnt = 0;
		float sum = 0;
		
		if(head==null) {
			return 0.0f;
		}
		Node move = head;
		while(move!=null) {
			sum+=move.data;
			cnt++;
			move=move.link;
		}
		return (float)sum/cnt ;
	}
	
	// 2. Insert At End
	public void addAtEnd(int data) {
		Node record = new Node(data);
		if(head==null) {
			head = record;
		}else {
			Node move;
			for(move = head;move.link!=null;move=move.link);
			move.link=record;
		}
	}
	
	// 3. Add at beg
	public void addAtBeg(int data) {
		Node record = new Node(data);
		if(head==null) {
			head = record;
		}else {
			record.link = head;
			head = record;
		}
	}
	
	
	// 4. add at position
	public boolean addAtPos(int pos,int data) {
		boolean b = false;
		if(pos<=0 || pos>totalNodes()+1) {
			return b;
		}else{
			Node n1 = new Node(data);
			if(pos==1 && head==null) {
				head = n1;
				b = true;
			}else if(pos==1){
				n1.link = head;
				head = n1;
				b = true;
			}else{
				Node m1 = head;
				for(int i = 1 ; i<pos-1 ;i++) {
					m1=m1.link;
				}
				n1.link = m1.link;
				m1.link = n1;
				b = true;
			}
		}
		return b;
	}

	// 5. Total Number of Nodes
	public int totalNodes() {
		int cnt=0;
		if(head==null) {
			return cnt;
		}else {
			Node move;
			for(move = head; move!=null;move=move.link) {
				cnt++;
			}
		}
		return cnt;
	}
	
	// 6. Displau LinkedList
	public void display() {
		Node move;
		if(head==null) {
			System.out.println("linkedList is Empty");
		}else {			
			for(move=head ; move!=null ; move=move.link) {
				System.out.println(move);
			}
		}
	}
	
	// 7. Search Data
	public int search(int data) {
		int index = -1;
		if(head==null) {
		
		}else {
			Node move;
			int i = 1;
			for(move=head;move.link!=null;move=move.link) {
				if(move.data==data) {
					index = i;
					break;
				}else {
					i++;
				}
			}
		}
		return index;
	}
	
	// 8. Modify data
	public boolean modify(int data1,int data2) {
		boolean b = false;
		if(head == null) {
			return b;
		}else{
			Node move;
			for(move=head;move.link!=null;move=move.link) {
				if(move.data==data1) {
					move.data = data2;
					b=true;
					break;
				}
			}
		}
		return b;
	}
	
	// 9. Modify At Position
	public boolean modify(int pos,int data,int dummy) {
		boolean b = false;
		if(head == null || pos<=0 || pos>totalNodes()) {
			return b;
		}else{
			Node move;
			int i =1;
			for(move=head;move.link!=null;move=move.link) {
				if(pos==i) {
					move.data = data;
					b = true;
					break;
				}
				i++;
			}
		}
		return b;
	}
	
	// 10. Delete at position
	public boolean delete(int pos) {
		boolean b = false;
		if(head == null || pos<=0 || pos>totalNodes()) {
			return b;
		}else{
			if(pos==1) {
				head= head.link;
				b=true;
			}else {				
				Node move1=head;
				for(int i = 1 ; i<pos-1 ;i++) {
					move1=move1.link;
				}
				Node del = move1.link;
				move1.link = del.link;
				del.link = null;
				b=true;
			}
		}
		return b;
	}
	
	// 11. Sorted List While Inserting
	public void sortedList(Node n) {
		boolean b = false;
		Node move = head;
		if(head==null) {
			head = n;
		}else if(move.data > n.data) {
			n.link = move;
			head = n;
		}
		else {
			while(move.link != null) {
				if(move.data > n.data) {
					n.link = move;
					move = n;
					b = true;
					break;
				}else if(move.data < n.data && move.link.data > n.data ) {					
					n.link = move.link;
					move.link = n;
					b = true;
					break;
				}else if(move.link.data < n.data) {
					b = false;
				}
				move= move.link;
			}
			if(!b) {
				move.link = n;
			}
		}
	}
	
	
	// 12. Split LinkedList
	public void split() {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		Node move = head;
		while(move!=null) {
			if(move.data%2 == 0) {
				l1.addAtEnd(move.data);
			}else {
				l2.addAtEnd(move.data);
			}
			move = move.link;
		}
		System.out.println("Even Nodes");
		l1.display();
		System.out.println("odd Nodes");
		l2.display();
	}
	
	// 13. Merge List with called one
	public LinkedList merge(LinkedList l1) {
		Node move = l1.head;
		while(move.link != null) {
			move = move.link;
		}
		move.link = head;
		return l1;
	}
	
	// 14 Merge Two given Lists
	public LinkedList merge(LinkedList l1,LinkedList l2) {
		Node move = l1.head;
		while(move.link != null) {
			move = move.link;
		}
		move.link = l2.head;
		return l1;
	}
	
	// 15. Reversed LinkedList Print
	public void printReverse(Node head) {
		if(head!=null) {
			printReverse(head.link);
			System.out.println(head);
		}
	}
	
	// 16. AddBalanced		20 10 10 20
	public void addBalanced(int data) {
		addAtBeg(data);
		addAtEnd(data);
	}
	
	// 17. Delete data if present (First Occurrence)
	public void delete(int data,int dummy) {
		if(head == null) {
			System.out.println("Linked List Is Empty");
		}else {
			Node move = head;
			boolean b = false;
			if(move.data==data) {
				b = true;
				head = move.link;
				move=null;
			}else if(move.link==null && move.data!=data) {
				b = false;
			}else {
				while(move.link != null) {
					if(move.link.data==data) {
						b = true;
						Node del = move.link;
						move.link = del.link;
						del=null;
						break;
					}
					move=move.link;
				}
			}
			if(!b) {
				System.out.println("Data Not found in array");
			}
		}
	}
	
	// 18. sort LinkedList
	public void sort() {
		if(head==null) {
			System.out.println("LinkedList is empty");
		}else if(head.link==null) {
			System.out.println("LinkedList only Contains One Node");
		}else {
			Node temp = head;
			while(temp.link!=null) {
				Node tag = temp.link;
				while(tag!=null) {
					if(temp.data > tag.data) {
						int temp1 = tag.data;
						tag.data = temp.data;
						temp.data = temp1;
					}
					tag=tag.link;
				}
				temp = temp.link;
			}
		}
	}
	
	// 19. Reverse LinkedList in place
	public void reverse() {
		if(head==null) {
			System.out.println("LinkedList is Empty");
		}else if(head.link==null) {
			System.out.println("LinkedList Reverse Is not Possible");
		}else {
			Node p1 = null;
			Node p2 = head;
			Node p3;
			while(p2!=null) {
				p3=p2.link;
				p2.link = p1;
				p1 = p2;
				p2 = p3;
			}
			head = p1;
		}
	}
	
	// 20. Display nth element
	public int display(int pos) {
		int data = -1;
		Node move = head;
		if(pos<=0 && pos>totalNodes()) {
			return -1;
		}else if(pos==1){
			if(head==null) {
				return data;
			}else {
				return head.data;
			}
		}else {
			for(int i = 1; i<pos-1 ; i++) {
				move=move.link;
			}
		}
		data=move.link.data;
		return data;
	}
	
	// 21. Disp element from last
//	public int display(int pos,int dumm) {
//		int data = -1;
//		Node move = head;
//		if(pos<=0 && pos>totalNodes()) {
//			return -1;
//		}
//	}
	

	// 21. Display nth element reverse
}
