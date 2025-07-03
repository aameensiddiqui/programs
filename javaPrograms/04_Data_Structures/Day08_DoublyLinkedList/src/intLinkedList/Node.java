package intLinkedList;

public class Node {
	Node prev;
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		prev=null;
		next = null;
	}

	public String toString() {
		return data+" " ;
	}
}
