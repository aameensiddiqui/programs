package customerQueue;

public class Customer {
	private int c_id ;
	private String name ;
	
	public Customer() {
		c_id = 100;
		name = "NA";
	}
	public Customer(int c_id,String name) {
		this.c_id = c_id;
		this.name = name;
	}
	public String toString() {
		return c_id+" "+name;
	}
}
