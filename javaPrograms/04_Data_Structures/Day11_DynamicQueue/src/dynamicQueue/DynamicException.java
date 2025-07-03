package dynamicQueue;

public class DynamicException extends RuntimeException{
	public String str = "";
	
	public DynamicException() {
		str = "Queue is Empty";
	}
	
	public String toString() {
		return str;
	}
}
