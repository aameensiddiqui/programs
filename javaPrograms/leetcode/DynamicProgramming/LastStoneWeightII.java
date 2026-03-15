/**
   1049. Last Stone Weight II

   You are given an array of integers stones where stones[i] is the weight of the ith stone.

   We are playing a game with the stones. On each turn, we choose any two stones and smash them together.
   Suppose the stones have weights x and y with x <= y. The result of this smash is:

   If x == y, both stones are destroyed, and
   If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
   At the end of the game, there is at most one stone left.

   Return the smallest possible weight of the left stone. If there are no stones left, return 0.

   Example 1:
   Input: stones = [2,7,4,1,8,1]
   Output: 1
   Explanation:
   We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
   we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
   we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
   we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.

   Example 2:
   Input: stones = [31,26,33,21,40]
   Output: 5

   Constraints:
   1 <= stones.length <= 30
   1 <= stones[i] <= 100
*/
import java.util.*;

class LastStoneWeightII {
    // bottom up space optimized
    private static int lastStoneWeight(int[] stones) {
        int stoneSum = 0;
        for (int s : stones) stoneSum += s;
        int target = stoneSum / 2;
        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int t = target; t >= stone; --t) {
                dp[t] = Math.max(dp[t], dp[t - stone] + stone);
            }
        }
        return stoneSum - 2 * dp[target];
    }
    public static void main(String[]args) {
        log.info(lastStoneWeight(new int[] {2,7,4,1,8,1}));
        log.info(lastStoneWeight(new int[] {31,26,33,21,40}));
    }
}
/**
    // bottom up
    private static int lastStoneWeight(int[] stones) {
        int stoneSum = 0;
        for (int s : stones) stoneSum += s;
        int target = stoneSum / 2;
        int[][] dp = new int[stones.length + 1][target + 1];

        for (int i = 1; i <= stones.length; ++i) {
            for (int t = 0; t <= target; ++t) {
                if (t >= stones[i - 1]) {
                    dp[i][t] = Math.max(dp[i - 1][t],
                                        dp[i - 1][t - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][t] = dp[i - 1][t];
                }
            }
        }
        return stoneSum - 2 * dp[stones.length][target];
    }
*/
/*
    // top down
    private static int[][] dp;
    private static int dfs(int i, int total, int[] stones, int stoneSum, int target) {
        if (total >= target || i == stones.length)
            return Math.abs(total - (stoneSum - total));
        if (dp[i][total] != -1) return dp[i][total];
        return dp[i][total] = Math.min(
                                dfs(i + 1, total, stones, stoneSum, target),
                                dfs(i + 1, total + stones[i], stones, stoneSum, target)
                                );
    }
    private static int lastStoneWeight(int[] stones) {
        int stoneSum = 0;
        for (int s : stones) stoneSum += s;
        int target = (stoneSum + 1) / 2;
        dp = new int[stones.length][target + 1];
        for (int[] r : dp) Arrays.fill(r, -1);
        return dfs(0, 0, stones, stoneSum, target);
    }
*/
/**
    // recursive
    private static int dfs(int i, int total, int[] stones, int stoneSum, int target) {
        if (total >= target || i == stones.length)
            return Math.abs(total - (stoneSum - total));
        return Math.min(
                        dfs(i + 1, total, stones, stoneSum, target),
                        dfs(i + 1, total + stones[i], stones, stoneSum, target)
                        );
    }
    private static int lastStoneWeight(int[] stones) {
        int stoneSum = 0;
        for (int s : stones) stoneSum += s;
        int target = (stoneSum + 1) / 2;
        return dfs(0, 0, stones, stoneSum, target);
    }
*/
