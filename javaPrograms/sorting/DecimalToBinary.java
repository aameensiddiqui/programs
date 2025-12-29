/*
 * Decimal to Binary
 * 13 --> 1101
 *
 *       quo rem
 * 13/2  6   1
 *  6/2  3   0
 *  3/2  1   1
 *  1/2  0   1
 *
 */

import java.util.Scanner;
import java.lang.StringBuilder;

public class DecimalToBinary
{
    public static void main(String[]args)
    {
        convert();
    }

    static void convert()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Decimal:  ");
        int n = scan.nextInt();
        scan.close();

        StringBuilder s = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        String rem = "";

        if(n == 0) return;
        while((n/2) != 0) {
            rem = String.valueOf(n % 2);
            s.append(rem);
            n = n / 2;
        }
        if(n/2 == 0)s.append("1");
        
        for(int i = s.length()-1; i >= 0; --i) {
            ans.append(s.charAt(i));
        }
        System.out.println("Binary: "+ans.toString());
    }
}
/*
class Solution {
    public String addBinary(String a, String b) {
        int x = binToDec(a);
        int y = binToDec(b);
        int sum = x + y;
        return decToBin(sum);
    }

    public int binToDec(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            sum = sum * 2 + (s.charAt(i) - '0');
        }
        return sum;
    }

    public String decToBin(int x) {
        if (x == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % 2);
            x = x / 2;
        }
        return sb.reverse().toString();
    }
}

 */
