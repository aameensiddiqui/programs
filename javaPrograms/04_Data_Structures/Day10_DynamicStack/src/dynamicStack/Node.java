package dynamicStack;

public class Node {
	Node next ;
	int data;
	
	Node(int data){
		this.data = data;
		next = null;
	}
	
	public String toString() {
		return data+ " ";	
	}
}
