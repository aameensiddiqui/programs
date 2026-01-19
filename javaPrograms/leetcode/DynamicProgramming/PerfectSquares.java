/**
   279. Perfect Squares

   Given an integer n, return the least number of perfect square numbers that
   sum to n.

   A perfect square is an integer that is the square of an integer; in other
   words, it is the product of some integer with itself. For example, 1, 4, 9,
   and 16 are perfect squares while 3 and 11 are not.

   Example 1:
   Input: n = 12
   Output: 3
   Explanation: 12 = 4 + 4 + 4.

   Example 2:
   Input: n = 13
   Output: 2
   Explanation: 13 = 4 + 9.

   Constraints:
   1 <= n <= 104
*/
import java.util.*;

class PerfectSquares {
    // dp (bottom-up)
    private static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int target = 1; target <= n; ++target) {
            for (int i = 1; (i*i) <= target; ++i) {
                dp[target] = Math.min(dp[target], 1 + dp[target - (i*i)]);
            }
        }
        return dp[n];
    }
    public static void main(String[]args) {
        log.info(numSquares(12));
        log.info(numSquares(13));
        log.info(numSquares(56)); // 3
    }
}
/**
    //
    //  Lagrange's four square theorem states that every positive integer can be
    //  expressed as the sum of at most four perfect squares. Using additional
    //  number theory, we can determine the exact answer in constant time. If n
    //  is a perfect square, the answer is 1. If n can be written as the sum of
    //  two squares, the answer is 2. If n is of the form 4^k(8m+7), the answer
    //  is 4. Otherwise, the answer is 3.
    //
    private static boolean isSq(int num) {
        int s = (int) Math.sqrt(num);
        return (s * s) == num;
    }
    private static int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        if (isSq(n)) return 1;
        for (int i = 1; (i * i) <= n; ++i) {
            if (isSq(n - (i * i))) return 2;
        }
        return 3;
    }
*/
/**
    // dp (top-down)
    private static Map<Integer, Integer> memo = new HashMap<>();
    private static int dfs(int target) {
        if (target == 0) return 0;
        if (memo.containsKey(target)) return memo.get(target);
        int res = target;
        for (int i = 1; (i * i) <= target; ++i) {
            res = Math.min(res, 1 + dfs(target - (i * i)));
        }
        memo.put(target, res);
        return res;
    }
    private static int numSquares(int n) {
        return dfs(n);
    }
*/
/**
    // recursive
    private static int dfs(int target) {
        if (target == 0) return 0;
        int res = target;
        for (int i = 1; (i * i) <= target; ++i) {
            res = Math.min(res, 1 + dfs(target - (i * i)));
        }
        return res;
    }
    private static int numSquares(int n) {
        return dfs(n);
    }
*/
