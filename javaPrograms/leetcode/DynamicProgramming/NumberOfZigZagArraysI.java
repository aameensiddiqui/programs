/**
   3699. Number of ZigZag Arrays I

   You are given three integers n, l, and r.
   A ZigZag array of length n is defined as follows:
   Each element lies in the range [l, r].
   No two adjacent elements are equal.
   No three consecutive elements form a strictly increasing or strictly decreasing sequence.
   Return the total number of valid ZigZag arrays.
   Since the answer may be large, return it modulo 109 + 7.
   A sequence is said to be strictly increasing if each element is strictly greater than its previous
   one (if exists).
   A sequence is said to be strictly decreasing if each element is strictly smaller than its previous
   one (if exists).

   Example 1:
   Input: n = 3, l = 4, r = 5
   Output: 2
   Explanation:
   There are only 2 valid ZigZag arrays of length n = 3 using values in the range [4, 5]:
   [4, 5, 4]
   [5, 4, 5]

   Example 2:
   Input: n = 3, l = 1, r = 3
   Output: 10
   Explanation:
   There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:
   [1, 2, 1], [1, 3, 1], [1, 3, 2]
   [2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
   [3, 1, 2], [3, 1, 3], [3, 2, 3]
   All arrays meet the ZigZag conditions.

   Constraints:
   3 <= n <= 2000
   1 <= l < r <= 2000
*/
import java.util.Arrays;

class NumberOfZigZagArraysI {
    private static final int MOD = 1_000_000_007;
    private static int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1, sum = 0, res = 0;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; ++i) {
            sum = 0;
            if ((i & 1) == 0) {
                for (int j = 0; j < m; ++j) {
                    int tmp = dp[j];
                    dp[j] = sum;
                    sum = (sum + tmp) % MOD;
                }
            } else {
                for (int j = m - 1; j >= 0; --j) {
                    int tmp = dp[j];
                    dp[j] = sum;
                    sum = (sum + tmp) % MOD;
                }
            }
        }
        for (int i = 0; i < m; ++i) res = (res + dp[i]) % MOD;
        return (res << 1) % MOD;
    }
    public static void main(String[] args) {
        log.info(zigZagArrays(3,4,5)); // 2
        log.info(zigZagArrays(3,1,3)); // 10
    }
}
