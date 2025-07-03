/*
 * Perfect Number
 *
 * A perfect number is a positive integer
 * that is equal to the sum of its proper divisors, excluding itself.
 * for example: 6 => 1+2+3 = 6
 * The known perfect numbers are 6, 28, 496, 8128 and 33550336.
 *
 * @author Amin Siddiqui
 *
 */

import java.util.Scanner;

public class PerfectNumber
{
    public static void main(String[]args)
    {
	checkPerfect();
	// printNPerfect(10000);
    }

    static void printNPerfect(int range)
    {
	int sum = 0;
	for(int n = 1 ; n < range ; ++n){
	    sum = 0;
	    for(int i = 1 ; i < n ; ++i){
		if(n % i == 0) sum += i;
	    }
	    if(sum == n) System.out.println(n);
	}
    }

    static void checkPerfect()
    {
	Scanner scan = new Scanner(System.in);
	System.out.println("Check if a number is perfect or not");
	System.out.print("Enter a number: ");
	int n = scan.nextInt();
	int sum = 0;
	for(int i = 1 ; i < n ; ++i){
	    if(n % i == 0) sum += i;
	}
	if(sum == n) System.out.println("Yes. It's a Perfect Number.");
	else System.out.println("No. It's not a Perfect Number.");
    }
}
