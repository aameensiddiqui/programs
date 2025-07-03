package normalQueue;

public class iQueue {
	private int size,rear,front ;
	private int[] arr;
	
	public iQueue() {
		size = 3;
		rear = -1;
		front = -1;
		arr = new int[size];
	}
	
	public iQueue(int size) {
		this.size = size;
		rear = -1;
		front = -1;
		arr = new int[size];
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
	
	public void enQueue(int data) {
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
	
	public int deQueue() {
		int data = -9999 ;
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
