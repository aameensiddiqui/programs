package circularQueue;

public class CircularQueue {
	private int size,rear,front ;
	private int[] arr;
	
	public CircularQueue() {
		size = 3;
		rear = -1;
		front = -1;
		arr = new int[size];
	}
	
	public CircularQueue(int size) {
		this.size = size;
		rear = -1;
		front = -1;
		arr = new int[size];
	}

	public boolean isFull() {
		if(front ==(rear+1)%size) {
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
			rear=(rear+1)%size;
			arr[rear] = data;
			System.out.println("Rear = "+rear);
			System.out.println("Front = "+front);
		}
		else {
			int a = deQueue();
			enQueue(data);
		}
	}
	
	public int deQueue() {
		int data = -9999 ;
		if(!isEmpty()) {
			data = arr[front];			
			if(front==rear) {
				front=-1;
				rear=-1;
			}else {
				front=(front+1)%size;
			}
		}else {			
			System.out.println("Queue Underflow");
		}
		System.out.println("Rear = "+rear);
		System.out.println("Front = "+front);
		return data;
	}
	
	public void disp() {
		if(!isEmpty()) {
			if(front>rear) {
				int i;
				for(i = front ; i>rear ; i=(i+1)%size) {
					System.out.print(arr[i]+" ");
				}
				for(; i<rear ; i=(i+1)%size) {
					System.out.print(arr[i]+" ");
				}
				if(i==rear) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}else {				
				int i;
				for(i = front ; i<rear ; i=(i+1)%size) {
					System.out.print(arr[i]+" ");
				}
				if(i==rear) {
					System.out.print(arr[i]);
				}
				System.out.println();			
			}
		}else {
			System.out.println("Queue is empty");
		}
	}
}
