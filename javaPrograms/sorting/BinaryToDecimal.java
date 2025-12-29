/*
 * Binary to Decimal
 *  1     1     0     1
 * 2^3 + 2^2 + 2^1 + 2^0
 * 8*1 + 4*1 + 2*0 + 1*1
 *  8  +  4  +  0  +  1   = 13
 *
 */

import java.util.Scanner;

public class BinaryToDecimal
{
    public static void main(String[]args)
    {
        convert();
    }

    static void convert()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Binary:  ");
        String n = scan.next();
        scan.close();
	
        int len = n.length();
        int sum = 0;
	
        for(int cnt = 0 ; cnt < len ; ++cnt){

            char ch = n.charAt(len - cnt - 1);

            if(ch != '0' && ch != '1'){
                System.out.println("Invalid binary number");
                return;
            }
	    
            sum += power(2, cnt) * (ch - '0');
        }
        System.out.println("Decimal: "+sum);
    }

    static int power(int base, int exp)
    {
        int result = 1;
        while(exp > 0){
            result = result*base;
            --exp;
        }
        return result;
    }
}
