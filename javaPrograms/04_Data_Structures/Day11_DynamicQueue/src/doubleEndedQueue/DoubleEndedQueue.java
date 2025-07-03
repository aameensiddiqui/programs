package doubleEndedQueue;

public class DoubleEndedQueue {
	public Node front;
	public Node rear;
	
	public DoubleEndedQueue() {
		front = rear = null;
	}
	
	public DoubleEndedQueue(int data) {
		Node newNode = new Node(data);
		front=rear=newNode;
	}
	
	public void enQueueFront(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			front=rear=newNode;
		}else {
			newNode.next = front;
			front=newNode;
		}
	}
	
	public void enQueueRear(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			front=rear=newNode;
		}else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public int deQueueFront() {
		int data = -99999 ;
		if(isEmpty()) {
			throw new QueueException();
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
	
	public int deQueueRear() {
		int data = -99999 ;
		if(isEmpty()) {
			throw new QueueException();
		}else {
			data = rear.data;
			if(front==rear) {
				front = null;
				rear=null;
			}else {
				Node move = front;
				while(move.next!=rear) {
					move=move.next;
				}
				move.next=null;
				rear = move;
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
