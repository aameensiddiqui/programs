package doubleEndedQueue;

public class QueueException extends RuntimeException{
	public String str = "";
	
	public QueueException() {
		str = "Queue is Empty";
	}
	
	public String toString() {
		return str;
	}
}
