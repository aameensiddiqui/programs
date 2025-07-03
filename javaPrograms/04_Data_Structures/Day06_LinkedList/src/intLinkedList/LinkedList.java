package intLinkedList;

public class LinkedList {
	Node head;

	public LinkedList(){
		head = null;
	}
	public LinkedList(int data) {
		head = new Node(data);
	}

	public void createLinkedList(int num) {
		for(int i = 1 ;i<= 10 ; i++) {
			//			System.out.println("Hello "+i);
			addAtEnd(num*i);
		}
	}

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

	public void addAtBeg(int data) {
		Node record = new Node(data);
		if(head==null) {
			head = record;
		}else {
			record.link = head;
			head = record;
		}
	}

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
				Node m2 = head;
				for(int i = 1 ; i<pos-1 ;i++) {
					m1=m1.link;
					m2=m2.link;
				}
				m2=m2.link;
				m1.link = n1;
				n1.link = m2;
				b = true;
			}
		}
		return b;
	}

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
				Node move2=head;
				for(int i = 1 ; i<pos-1 ;i++) {
					move1=move1.link;
					move2=move2.link;
				}
				move2 = move2.link;
				move1.link = move2.link;
				move2.link = null;
				b=true;
			}
		}
		return b;
	}
}
