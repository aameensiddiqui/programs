public class fib{
    public static void main(String[]args){
	int a = 0;
	int b = 1;
	int c = 0;
	while(a < 1000000){
	    System.out.println(a);
	    c = a+b;
	    a = b;
	    b = c;
	}
    }
}
