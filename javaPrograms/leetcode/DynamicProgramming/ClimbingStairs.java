/**
   70. Climbing Stairs

   You are climbing a staircase. It takes n steps to reach the top.

   Each time you can either climb 1 or 2 steps. In how many distinct
   ways can you climb to the top?

   Example 1:
   Input: n = 2
   Output: 2
   Explanation: There are two ways to climb to the top.
   1. 1 step + 1 step
   2. 2 steps

   Example 2:
   Input: n = 3
   Output: 3
   Explanation: There are three ways to climb to the top.
   1. 1 step + 1 step + 1 step
   2. 1 step + 2 steps
   3. 2 steps + 1 step

   Constraints:
   1 <= n <= 45
*/
class ClimbingStairs {
    private static int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = n - 2; i >= 0; --i) {
            // for (int i = 2; i <= n; ++i) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
    public static void main(String[]args) {
        log.info(climbStairs(1));  // 1
        log.info(climbStairs(2));  // 2
        log.info(climbStairs(3));  // 3
        log.info(climbStairs(5));  // 8
        log.info(climbStairs(45)); // 1836311903
    }
}
/**
   private static int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
 */
