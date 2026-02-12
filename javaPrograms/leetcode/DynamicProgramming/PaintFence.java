/**
   Paint Fence

   You are painting a fence of n posts with k different colors.
   You must paint the posts following these rules:

   Every post must be painted exactly one color.
   There cannot be three or more consecutive posts with the same color.
   Given the two integers n and k, return the number of ways you can
   paint the fence.

   Example 1:
   Input: n = 3, k = 2
   Output: 6
   Explanation: All the possibilities are shown.
   Note that painting all the posts red or all the posts green is invalid
   because there cannot be three posts in a row with the same color.

   Example 2:
   Input: n = 1, k = 1
   Output: 1

   Example 3:
   Input: n = 7, k = 2
   Output: 42

   Constraints:
   1 <= n <= 50
   1 <= k <= 10⁵
   The testcases are generated such that the answer is in the range
   [0, 2³¹ - 1] for the given n and k.
*/
import java.util.*;

class PaintFence {
    /*
      Bottom-Up, Constant Space
      Since the recurrence only depends on the previous two values,
      we do not need to store the entire array. We can use two variables
      to track totalWays(i - 1) and totalWays(i - 2), updating them as
      we iterate.

      This optimization reduces space complexity from O(n) to O(1).
      tc : O(n) , where n is number of fence posts
      sc : O(1)

     */
    private static int numWays(int n, int k) {
        if (n == 1) return k;
        int two = k;
        int one = k * k;
        for (int i = 3; i <= n; ++i) {
            int cur = (k - 1) * (one + two);
            two = one;
            one = cur;
        }
        return one;
    }
    public static void main(String[]args) {
        log.info(numWays(1,1)); // 1
        log.info(numWays(3,2)); // 6
        log.info(numWays(7,2)); // 42
        log.info(numWays(1,2)); // 2
    }
}
/**
    // Bottom-Up Dynamic Programming (Tabulation)
    // The same recurrence can be computed iteratively instead of recursively.
    // We fill an array from the base cases up to n, which avoids recursion overhead
    // and stack depth issues.

    // This approach is often more efficient in practice since it avoids function
    // call overhead and naturally iterates through states in order.
    // tc : O(n) , where n is number of fence posts
    // sc : O(n)

    private static int numWays(int n, int k) {
        int[] totalWays = new int[n + 1];
        if (n == 1) return k;
        if (n == 2) return k * k;
        totalWays[1] = k;
        totalWays[2] = k * k;
        for (int i = 3; i <= n; ++i) {
            totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);
        }
        return totalWays[n];
    }
*/
/**
    // Top-Down Dynamic Programming (Recursion + Memoization)
    // The constraint is that no more than two consecutive posts can have the same color.
    // For each post, we can either paint it a different color from the previous post,
    // or paint it the same color (but only if the two previous posts are different).

    // This leads to a recurrence: totalWays(i) = (k - 1) * (totalWays(i - 1) + totalWays(i - 2)).
    // The first term handles painting post i differently from post i - 1 (k - 1 choices).
    // The second term handles painting post i the same as post i - 1,
    // which requires post i - 1 to be different from post i - 2.
    // tc : O(n) , where n is number of fence posts
    // sc : O(n)

    private static Map<Integer, Integer> memo;
    private static int totalWays(int i, int k) {
        if (i == 1) return k;
        if (i == 2) return k * k;
        if (memo.containsKey(i)) return memo.get(i);
        memo.put(i, (k - 1) * (totalWays(i - 1, k) + totalWays(i - 2, k)));
        return memo.get(i);
    }
    private static int numWays(int n, int k) {
        memo = new HashMap<>();
        return totalWays(n, k);
    }
*/
