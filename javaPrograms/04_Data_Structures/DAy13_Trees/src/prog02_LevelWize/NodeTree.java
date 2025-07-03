package prog02_LevelWize;

public class NodeTree {
	public int data;
	public NodeTree left;
	public NodeTree right;
	
	public NodeTree(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public String toString() {
		return "[" + data + "]" ;
	}
}
