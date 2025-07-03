package BookStack;

public class bStack {
	int top;
	Book[] barr;
	int size;
	public bStack() {
		top = -1;
		size = 3;
		barr = new Book[size];
	}
	public bStack(int size) {
		this.top = -1;
		this.size = size;
		barr = new Book[this.size];
	}
	
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		if(top==size-1) {
			return true;
		}
		return false;
	}
	
	public Book peek() {
		Book b = null ;
		if(!isEmpty()) {
			b = barr[top];
		}
		return b;
	}
	
	public Book pop() {
		Book b = null ;
		if(!isEmpty()) {
			b = barr[top];
			top--;
		}
		return b;
	}
	
	public void push(Book a) {
		if(!isFull()) {
			top++;
			barr[top] = a ;
		}
	}
	
	public void disp() {
		if(!isEmpty()) {
			for(int i = top ; i >=0 ; i--) {
				System.out.println(barr[i]);
			}
		}
	}
}
