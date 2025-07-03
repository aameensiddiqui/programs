package prog02_LevelWize;

public class NodeQueue {
	public NodeTree data;
	public NodeQueue next;
	
	public NodeQueue() {
		data=null;
		next=null;
	}
	public NodeQueue(NodeTree data) {
		this.data = data;
		next = null;
	}
}