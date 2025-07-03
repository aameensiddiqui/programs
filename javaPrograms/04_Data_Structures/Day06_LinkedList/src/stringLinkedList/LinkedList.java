package stringLinkedList;

public class LinkedList {
	Node head;
	
	public LinkedList(){
		head = null;
	}
	public LinkedList(String data) {
		head = new Node(data);
	}

	public void createLinkedList(String str) {
		for(int i = 1 ;i<= 10 ; i++) {
			addAtEnd(str);
		}
	}
	
	public void addAtEnd(String data) {
		Node record = new Node(data);
		if(head==null) {
			head = record;
		}else {
			Node move;
			for(move = head;move.link!=null;move=move.link);
			move.link=record;
		}
	}
	
	public void addAtBeg(String data) {
		Node record = new Node(data);
		if(head==null) {
			head = record;
		}else {
			record.link = head;
			head = record;
		}
	}
	
	public boolean addAtPos(int pos,String data) {
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
				System.out.print(move + " ");
			}
			System.out.println();
		}
	}
	
	public int search(String data) {
		int index = -1;
		if(head==null) {
			return -1;
		}else {
			Node move;
			int i = 1;
			for(move=head;move.link!=null;move=move.link) {
				if(move.data.equalsIgnoreCase(data)) {
					index = i;
					break;
				}else {
					i++;
				}
			}
		}
		return index;
	}
	
	public boolean modify(String data1,String data2) {
		boolean b = false;
		if(head == null) {
			return b;
		}else{
			Node move;
			for(move=head;move.link!=null;move=move.link) {
				if(move.data.equalsIgnoreCase(data1)) {
					move.data = data2;
					b=true;
					break;
				}
			}
		}
		return b;
	}
	
	public boolean modify(int pos,String data,int dummy) {
		boolean b = false;
		if(head == null || pos<=0 || pos>totalNodes()) {
			return b;
		}else{
			Node move;
			int i =1;
			for(move=head;move!=null;move=move.link) {
				if(pos==i) {
					System.out.println("Check5");
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
	
	public Node firstNode() {
		return head;
	}
	
	public Node lastNode() {
		Node move;
		for(move=head;move.link!=null;move=move.link);
		return move;
	}
}
