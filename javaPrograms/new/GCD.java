import java.util.Scanner;

public class GCD
{
    public static void main(String[]args)
    {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter first number: ");   
	int a = scan.nextInt();
	System.out.print("Enter second number: ");
	int b = scan.nextInt();
	System.out.print("Greatest Common Divisor of "+a+" & "+b+" is: "+gcd(a, b)+
			 "\nLowest Common Multiple of "+a+" & "+b+" is: "+lcm(a, b)+"\n");
    }

    private static int lcm(int a, int b)
    {
	if(a == 0 || b == 0) return a + b;
	else return Math.abs(a*b)/gcd(a, b);
    }
    
    private static int gcd(int a, int b)
    {
	// int i = 0;
	// if(a < b) i = a;
	// else i = b;

	// for(i = i ; i > 0 ; --i){
	//     if(a % i == 0 && b % i == 0) return i;
	// }
	// return 1;

	/* by Euclidean algo */
	if(b == 0) return a;
	else return gcd(b, a % b);
    }
}
