package priorityQueue;

public class pQueue {
	public int front;
	public int rear;
	public int size;
	public Element[] eArr;
	
	public pQueue(int size) { 
		eArr = new Element[size];
		rear = front = -1;
	}
	
	public void enQueue(Element data) {
		if(isFull()) {
			throw new PrioException("Queue is Full");
		}
		if(front==-1) {
			front=0;
		}
		rear++;
		eArr[rear] = data;
		
		for(int i = 0 ;i < size ;i++) {
			boolean flag = true;
			for(int j = 0 ; i < size-1-i ; j++) {
				if(eArr[j].prio < eArr[j+1].prio) {
					Element temp;
					temp = eArr[j];
					eArr[j] = eArr[j+1];
					eArr[j+1] = temp;
					flag = true;
				}
				if(flag) {
					return ;
				}
			}
		}
	}
	
	public Element deQueue() {
		Element data ;
		if(isEmpty()) {
			throw new PrioException("Queue is Empty");
		}
		data = eArr[front];
		if(front==rear) {
			front = -1;
			rear = -1;
		}else {
			front+=1;
		}
		return data;
	}
	
	public boolean isFull() {
		if(rear==size-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(front==-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void disp() {
		if(!isEmpty()) {
			for(int i =front ; i <= rear ; i++) {
				System.out.println(eArr[i]);
			}
		}else {
			throw new PrioException("Queue is Empty");
		}
	}
}
