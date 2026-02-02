/**
   837. New 21 Game

   Alice plays the following game, loosely based on the card game "21".

   Alice starts with 0 points and draws numbers while she has less than
   k points. During each draw, she gains an integer number of points
   randomly from the range [1, maxPts], where maxPts is an integer.
   Each draw is independent and the outcomes have equal probabilities.

   Alice stops drawing numbers when she gets k or more points.

   Return the probability that Alice has n or fewer points.

   Answers within 10-5 of the actual answer are considered accepted.

   Example 1:
   Input: n = 10, k = 1, maxPts = 10
   Output: 1.00000
   Explanation: Alice gets a single card, then stops.

   Example 2:
   Input: n = 6, k = 1, maxPts = 10
   Output: 0.60000
   Explanation: Alice gets a single card, then stops.
   In 6 out of 10 possibilities, she is at or below 6 points.

   Example 3:
   Input: n = 21, k = 17, maxPts = 10
   Output: 0.73278

   Constraints:
   0 <= k <= n <= 104
   1 <= maxPts <= 104
*/
import java.util.*;

class New21Game {
    private static double[] dp;
    public static double new21Game(int n, int k, int maxPts) {
        dp = new double[k + maxPts];
        Arrays.fill(dp, -1.0);
        return dfs(0, n, k, maxPts);
    }
    private static double dfs(int score, int n, int k, int maxPts) {
        if (score == k - 1)
            return Math.min(n - k + 1, maxPts) / (double) maxPts;
        if (score > n) return 0.0;
        if (score >= k) return 1.0;
        if (dp[score] != -1.0) return dp[score];
        dp[score] = dfs(score + 1, n, k, maxPts);
        dp[score] -= (dfs(score + 1 + maxPts, n, k, maxPts) - dfs(score + 1, n, k, maxPts)) / maxPts;
        return dp[score];
    }
    public static void main(String[]args) {
        log.info(new21Game(10, 1, 10));        // 0.1
        log.info(new21Game(6, 1, 10));         // 0.6
        log.info(new21Game(21, 17, 10));       // 0.73278
        log.info(new21Game(9301, 9224, 7771)); // 0.01847
    }
}
/**
    private static double[] dp;
    private static double new21Game(int n, int k, int maxPts) {
        dp = new double[k];
        Arrays.fill(dp, -1.0);
        return dfs(0, n, k, maxPts);
    }
    private static double dfs(int score, int n, int k, int maxPts) {
        if (score >= k) return score <= n ? 1.0 : 0.0;
        if (dp[score] != -1.0) return dp[score];
        double prob = 0;
        for (int i = 1; i <= maxPts; ++i) {
            prob += dfs(score + i, n, k, maxPts);
        }
        dp[score] = prob / maxPts;
        return dp[score];
    }
*/
