package dynamicStack;

public class StackException extends RuntimeException{
	String str;
	
	public StackException() {
		this.str = "Stack is empty";
	}
	
	public StackException(String str) {
		this.str = str;
	}
	
	public String toString() {
		return str;
	}
}
