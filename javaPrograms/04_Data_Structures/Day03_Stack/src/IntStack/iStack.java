package IntStack;

public class iStack {
	int top;
	int[] arr;
	int size;
	public iStack() {
		top = -1;
		size = 3;
		arr = new int[size];
	}
	public iStack(int size) {
		this.top = -1;
		this.size = size;
		arr = new int[this.size];
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
	
	public int peek() {
		int a = -99999 ;
		if(!isEmpty()) {
			a = arr[top];
		}
		return a;
	}
	
	public int pop() {
		int a = '`';
		if(!isEmpty()) {
			a = arr[top];
			top--;
		}
		return a;
	}
	
	public void push(int a) {
		if(!isFull()) {
			top++;
			arr[top] = a ;
		}
	}
	
	public void disp() {
		if(!isEmpty()) {
			for(int i = top ; i >=0 ; i--) {
				System.out.println(arr[i]);
			}
		}
	}
}
