/**
   343. Integer Break

   Given an integer n, break it into the sum of k positive integers,
   where k >= 2, and maximize the product of those integers.

   Return the maximum product you can get.

   Example 1:
   Input: n = 2
   Output: 1
   Explanation: 2 = 1 + 1, 1 × 1 = 1.

   Example 2:
   Input: n = 10
   Output: 36
   Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

   Constraints:
   2 <= n <= 58
*/
import java.util.*;

class IntegerBreak {
    /*
      Instead of trying all pairs of splits, we can think of this as a
      bounded knapsack problem where we repeatedly subtract values from
      the number. We pick a value i (from 1 to n-1) and multiply it with
      the optimal product of the remaining. By allowing repeated use of
      the same value, we explore all combinations more efficiently.
      O(n^2)
     */
    private static int dfs(int num, int i) {
        if (Math.min(num, i) == 0) return 1;
        if (i > num) return dfs(num, num);
        return Math.max(i * dfs(num - i, i), dfs(num, i - 1));
    }
    private static int integerBreak(int n) {
        return dfs(n, n - 1);
    }
    public static void main(String[]args) {
        log.info(integerBreak(2));  // 1
        log.info(integerBreak(10)); // 36
        log.info(integerBreak(20)); // 1458
    }
}
/**
    // bottom-up O(n^2)
    private static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int num = 2; num <= n; ++num) {
            dp[num] = num == n ? 0 : num;
            for (int i = 1; i < num; ++i) {
                dp[num] = Math.max(dp[num], dp[i] * dp[num - i]);
            }
        }
        return dp[n];
    }
*/
/**
    // top-down O(n^2)
    private static Map<Integer, Integer> dp;
    private static int dfs(int num, int ori) {
        if (dp.containsKey(num)) return dp.get(num);
        int res = num == ori ? 0 : num;
        for (int i = 1; i < num; ++i) {
            res = Math.max(res, dfs(i, ori) * dfs(num - i, ori));
        }
        dp.put(num, res);
        return res;
    }
    private static int integerBreak(int n) {
        dp = new HashMap<>();
        dp.put(1, 1);
        return dfs(n, n);
    }
*/
/**
    // O(n^n)
    private static int dfs(int num, int ori) {
        if (num == 1) return 1;
        int res = num == ori ? 0 : num;
        for (int i = 1; i < num; ++i) {
            res = Math.max(res, dfs(i, ori) * dfs(num - i, ori));
        }
        return res;
    }
    private static int integerBreak(int n) {
        return dfs(n, n);
    }
*/
