package priorityQueue;

public class PrioException extends RuntimeException{ 
	String str = "" ;
	
	public PrioException(String str) {
		this.str = str;
	}
	
	public String toString() {
		return str;
	}
}
