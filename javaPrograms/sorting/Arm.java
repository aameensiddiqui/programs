/*
 * Armstrong number / Narcissistic Number 
 *
 * It is a number that is equal to sum of its own digits
 * each raised to the the power of the number of digits.
 * for example: 153 => 1^3 + 5^3 + 3^3 = 153
 *
 * @author Amin Siddiqui
 *
 */

import java.util.Scanner;

public class Arm
{
    public static void main(String[]args)
    {
	checkArmstrong();
	//printNArmstrongNumbers(10000);
    }

    static void checkArmstrong()
    {
	Scanner scan = new Scanner(System.in);
	System.out.println("Check if a number is Armstrong number or not.");
	System.out.print("Enter a number: ");
	int i = scan.nextInt();
	if(0 <= i && i < 10){
	    System.out.println("It's an armstrong number.");
	    return;
	}
	else if (isArmstrong(i, howManyDigits(i))) System.out.println("It's an armstrong number.");
	else System.out.println("No. It's not an armstrong number.");

    }

    static void printNArmstrongNumbers(int range)
    {
	for(int i = 1 ; i < range ; ++i){
	    if (isArmstrong(i, howManyDigits(i))) System.out.println(i);
	}
    }
    
    static int howManyDigits(int n)
    {
	int t = n;
	int digits = 0;
	while(t > 0){
	    t = t / 10;
	    digits++;
	}
	return digits;
    }

    static int power(int base, int exp)
    {
	if(exp == 1) return base;
	if(exp == 0) return 0; 
	int result = 1;
	while(exp > 0){
	    result = result*base;
	    exp--;
	}
	return result;
    }
    
    static boolean isArmstrong(int n, int p)
    {
	int sum = 0;
	int temp = n;
	int digit = 0;
	boolean arm = false;
	while(n > 0){
	    digit = n % 10;
	    sum += power(digit, p);
	    n = n / 10;
	}
	return sum == temp; 
    }
}
