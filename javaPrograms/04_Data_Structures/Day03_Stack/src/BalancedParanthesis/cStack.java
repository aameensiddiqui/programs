package BalancedParanthesis;

public class cStack {
	int top;
	char[] arr;
	int size;
	public cStack() {
		top = -1;
		size = 3;
		arr = new char[size];
	}
	public cStack(int size) {
		this.top = -1;
		this.size = size;
		arr = new char[this.size];
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
	
	public char peek() {
		char a = '`';
		if(!isEmpty()) {
			a = arr[top];
		}
		return a;
	}
	
	public char pop() {
		char a = '`';
		if(!isEmpty()) {
			a = arr[top];
			top--;
		}
		return a;
	}
	
	public void push(char a) {
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
