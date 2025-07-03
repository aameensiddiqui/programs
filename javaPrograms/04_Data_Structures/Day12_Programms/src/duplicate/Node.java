package duplicate;

public class Node {
	int data ;
	Node link;
	
	public Node() {
		data = 100;
		link = null;
	}
	public Node(int data) {
		this.data = data;
		link = null;
	}
	
	public String toString() {
		return data+" ";
	}
}
