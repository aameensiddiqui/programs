package prog02_LevelWize;


public class Queue {
	NodeQueue front;
	NodeQueue rear;
	
	public Queue() {
		front = rear = null;
	}
	
	public Queue(NodeQueue data) {
		NodeQueue newNode = data ;
		front=rear=newNode;
	}
	
	public void enQueue(NodeQueue node) {
		NodeQueue newNode = node ;
		if(isEmpty()) {
			front=rear=newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public NodeTree deQueue() {
		NodeTree rNode;
		if(isEmpty()) {
			return null;
		}else {
			rNode = front.data;
			if(front==rear) {
				front = null;
				rear=null;
			}else {				
				front = front.next;
			}
		}
		return rNode;
	}
	
	public boolean isEmpty() {
		return front==null?true:false;
	}
}
