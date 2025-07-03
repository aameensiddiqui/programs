package customerQueue;

public class cQueue {
	private int size,rear,front ;
	private Customer[] arr;
	
	public cQueue() {
		size = 3;
		rear = -1;
		front = -1;
		arr = new Customer[size];
	}
	
	public cQueue(int size) {
		this.size = size;
		rear = -1;
		front = -1;
		arr = new Customer[size];
	}

	public boolean isFull() {
		if(rear==size-1) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(front==-1) {
			return true;
		}
		return false;
	}
	
	public void enQueue(Customer data) {
		if(!isFull()) {			
			if(front==-1) {
				front = 0;
			}
			rear+=1;
			arr[rear] = data;
		}
		else {
			System.out.println("Queue Overflow");
		}
		System.out.println("Rear = "+rear);
		System.out.println("Front = "+front);
	}
	
	public Customer deQueue() {
		Customer data = null ;
		if(!isEmpty()) {
			data = arr[front];			
			if(front==rear) {
				front=-1;
				rear=-1;
			}else {
				front++;
			}
		}
		System.out.println("Queue Underflow");
		System.out.println("Rear = "+rear);
		System.out.println("Front = "+front);
		return data;
	}
	
	public void disp() {
		if(rear!=-1) {
			for(int i = front ; i<=rear ; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();			
		}else {
			System.out.println("Queue is empty");
		}
	}
}
