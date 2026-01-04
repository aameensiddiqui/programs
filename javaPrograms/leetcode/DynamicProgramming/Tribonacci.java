/**
   1137. N-th Tribonacci Number

   The Tribonacci sequence Tn is defined as follows:

   T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

   Given n, return the value of Tn.

   Example 1:
   Input: n = 4
   Output: 4
   Explanation:
   T_3 = 0 + 1 + 1 = 2
   T_4 = 1 + 1 + 2 = 4

   Example 2:
   Input: n = 25
   Output: 1389537

   Constraints:
   0 <= n <= 37
   The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
*/
import java.util.*;

class Tribonacci {
    private static int tribonacci(int n) {
        int[] t = {0,1,1};
        if (n < 3) return n == 0 ? 0 : 1;
        for (int i = 3; i <= n; ++i) t[i % 3] = t[0] + t[1] + t[2];
        return t[n % 3];
    }
    public static void main(String[]args) {
        log.info(tribonacci(0));
        log.info(tribonacci(1));
        log.info(tribonacci(2));
        log.info(tribonacci(3));
        log.info(tribonacci(4));
        log.info(tribonacci(25));
        log.info(tribonacci(35));
    }
}
/**
    private static int tri(int n, int[] dp) {
        if (n <= 2) {
            return dp[n] = n == 0 ? 0 : 1;
        }
        if (dp[n] != -1) return dp[n];
        return dp[n] = tri(n-1, dp) + tri(n-2, dp) + tri(n-3, dp);
    }
    private static int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        tri(n, dp);
        return dp[n];
        //return tri(n, dp); // better
    }
*/
