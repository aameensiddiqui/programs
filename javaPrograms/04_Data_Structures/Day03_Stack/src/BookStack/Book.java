package BookStack;

class Book{
	private int noOfPages ;
	private String bName;
	
	public Book() {
		noOfPages = 10;
		bName = "Sample";
	}
	
	public Book(int noOfPages , String bName) {
		this.noOfPages = noOfPages;
		this.bName = bName ;
	}
	
	public String toString() {
		return "Book name is : "+ bName + " No of Pages : "+noOfPages;
	}
}
