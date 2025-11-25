/**
   1015. Smallest Integer Divisible by K

   Given a positive integer k, you need to find the length of the smallest
   positive integer n such that n is divisible by k, and n only contains
   the digit 1.

   Return the length of n. If there is no such n, return -1.

   Note: n may not fit in a 64-bit signed integer.

   Example 1:
   Input: k = 1
   Output: 1
   Explanation: The smallest answer is n = 1, which has length 1.

   Example 2:
   Input: k = 2
   Output: -1
   Explanation: There is no such positive integer n divisible by 2.

   Example 3:
   Input: k = 3
   Output: 3
   Explanation: The smallest answer is n = 111, which has length 3.

   Constraints:
   1 <= k <= 105
 */
import java.util.*;
class SmallestIntDivisibleByK {
    public static int smallestRepunitDivByK(int k) {
        if(k == 1) return 1;
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int remainder = 0;
        for(int i = 1; i <= k; ++i) {
            remainder = (remainder * 10 + 1) % k;
            if(remainder == 0) return i;
        }
        return -1;
    }
    public static void main(String[]args) {
        IO.println(smallestRepunitDivByK(1));
        IO.println(smallestRepunitDivByK(2));
        IO.println(smallestRepunitDivByK(3));
    }
}
/**
 // double num = 1;
 // int length = 1;
 // Map<Integer, Integer> map = new LinkedHashMap<>();
 // for(int i = 1; i < 10000; ++i) {
 //     length = String.valueOf(num).length();
 //     //IO.println("---"+Double.toString(num)+"----"+(2.0 - Double.toString(num).length()));
 //     if(num % i == 0) map.put(i, ((int)Double.toString(num).length() - 2));
 //     num *= 10;
 //     num += 1;
 // }
 // IO.println(map);
 */
