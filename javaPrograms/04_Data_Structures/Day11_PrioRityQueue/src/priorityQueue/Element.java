package priorityQueue;

public class Element {
	public int data;
	public int prio;
	
	public Element() {
		data = 0;
		prio = 1;
	}
	
	public Element(int data,int prio) {
		this.data = data;
		this.prio = prio;
	}
	
	public String toString() {
		return "[" +data+ "]"+"[" + prio +"]";
	}
}
