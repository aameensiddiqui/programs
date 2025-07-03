package dynamicStack;

public class cStack extends StackException{
	Node top;
	
	cStack(){
		top = null;
	}
	
	cStack(int data){
		top = new Node(data);
	}
	
	void push(int data) {
		Node newNode = new Node(data);
		if(top==null) {
			top = newNode;
		}else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	int pop() {
		if(isEmpty()) {
			throw new StackException();
		}else {
			int data = top.data;
			top=top.next;
			return data;			
		}
	}
	
	boolean isEmpty() {
		if(top==null) {
			return true;
		}
		return false;
	}
	
	int peek() {
		return top.data;
	}
	
	int min() {
		int min = peek();
		if(isEmpty()) {
			throw new StackException();
		}
		Node move = top;
		while(move!=null) {
			if(move.data < min) {
				min = move.data;
			}
			move= move.next;
		}
		return min;
	}
	
	void display() {
		if(isEmpty()) {
			throw new StackException();
		}
		Node move = top;
		while(move!=null) {
			System.out.println(move);
			move=move.next;
		}
	}
}
