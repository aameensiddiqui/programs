/*
 * Palindrome
 *
 * 121
 * 3654563
 *
 * @author Amin Siddiqui
 *
 */
import java.util.Scanner;

public class PalindromeNumber
{
    public static void main(String[]args)
    {
        checkPalindrome();
    }

    static void checkPalindrome()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        int n2 = 0;
        int t = n;
        int digit = 0;
	
        while(n > 0){
            digit = n % 10;
            n = n / 10;
            n2 = n2*10+digit;
        }
        if(n2 == t ) System.out.println(n2+" yes");
        else System.out.println(n2+" no");
    }
}
