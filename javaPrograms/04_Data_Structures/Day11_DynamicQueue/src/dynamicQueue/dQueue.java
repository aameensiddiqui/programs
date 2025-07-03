package dynamicQueue;

public class dQueue extends DynamicException{
	public Node front;
	public Node rear;
	
	public dQueue() {
		front = rear = null;
	}
	
	public dQueue(int data) {
		Node newNode = new Node(data);
		front=rear=newNode;
	}
	
	public void enQueue(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			front=rear=newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public int deQueue() {
		int data = -99999 ;
		if(isEmpty()) {
			throw new DynamicException();
		}else {
			data = front.data;
			if(front==rear) {
				front = null;
				rear=null;
			}else {				
				front = front.next;
			}
		}
		return data;
	}
	
	public boolean isEmpty() {
		return front==null?true:false;
	}
	
	public void disp() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {			
			Node move = front;
			while(move!=null) {
				System.out.println(move);
				move=move.next;
			}
		}
	}
}
