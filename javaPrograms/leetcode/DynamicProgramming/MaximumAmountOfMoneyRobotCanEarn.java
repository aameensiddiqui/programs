/**
   3418. Maximum Amount of Money Robot Can Earn

   You are given an m x n grid. A robot starts at the top-left corner of the grid (0, 0) and
   wants to reach the bottom-right corner (m - 1, n - 1). The robot can move either right or
   down at any point in time.
   The grid contains a value coins[i][j] in each cell:
   If coins[i][j] >= 0, the robot gains that many coins.
   If coins[i][j] < 0, the robot encounters a robber, and the robber steals the absolute value
   of coins[i][j] coins.
   The robot has a special ability to neutralize robbers in at most 2 cells on its path,
   preventing them from stealing coins in those cells.
   Note: The robot's total coins can be negative.
   Return the maximum profit the robot can gain on the route.

   Example 1:
   Input: coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
   Output: 8

   Explanation:
   An optimal path for maximum coins is:
   Start at (0, 0) with 0 coins (total coins = 0).
   Move to (0, 1), gaining 1 coin (total coins = 0 + 1 = 1).
   Move to (1, 1), where there's a robber stealing 2 coins. The robot uses one neutralization
   here, avoiding the robbery (total coins = 1).
   Move to (1, 2), gaining 3 coins (total coins = 1 + 3 = 4).
   Move to (2, 2), gaining 4 coins (total coins = 4 + 4 = 8).

   Example 2:
   Input: coins = [[10,10,10],[10,10,10]]
   Output: 40

   Explanation:
   An optimal path for maximum coins is:
   Start at (0, 0) with 10 coins (total coins = 10).
   Move to (0, 1), gaining 10 coins (total coins = 10 + 10 = 20).
   Move to (0, 2), gaining another 10 coins (total coins = 20 + 10 = 30).
   Move to (1, 2), gaining the final 10 coins (total coins = 30 + 10 = 40).

   Constraints:
   m == coins.length
   n == coins[i].length
   1 <= m, n <= 500
   -1000 <= coins[i][j] <= 1000
*/
/**
   Memoization Search
   The problem states that the robot can neutralize robbers in at most 2 cells,
   which is equivalent to allowing at most 2 modifications along the path.
   Compared to the Minimum Path Sum problem, this introduces an additional
   constraint on the number of allowed modifications. We can solve this using
   dynamic programming.

   Since the robot can only move right or down, and the number of allowed neutralizations
   is at most 2, we define dfs(i,j,k) as the maximum number of coins that can be collected
   when moving from (i,j) to (m - 1,n - 1) with k remaining neutralizations, where m and n are
   the number of rows and columns.

   At position (i,j), we consider two cases:

   Do not neutralize:
   We collect coins[i][j] and continue moving right or down:
   dfs(i,j,k) = max(dfs(i+1,j,k), dfs(i,j+1,k)) + coins[i][j]

   Neutralize:
   If k > 0 and coins[i][j] is negative, we can neutralize this cell, resulting in 0 coins,
   and continue:
   dfs(i,j,k)= max(dfs(i+1,j,k - 1),dfs(i,j+1,k - 1))

   We take the maximum of these two cases.

   Now consider the base cases:

   If i >= m or j >= n, the state is invalid, so we return  - infinity.

   If (i,j) is the destination (m - 1,n - 1):

   If k > 0, we may neutralize, so return max(0,coins[i][j]).
   Otherwise, return coins[i][j].
   We start from (0,0,2), that is, dfs(0,0,2), which gives the final answer.

   Note: Since coins[i][j] can be negative, the result can also be negative.
   Therefore, the memoization array should not be initialized with  -1;
   instead, we use  - infinity (or a sufficiently small value).
*/
import java.util.Arrays;

class MaximumAmountOfMoneyRobotCanEarn {
    private static int m, n;
    private static int[][][] dp;
    private static int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new int[m][n][3];
        for (int[][] layer : dp) {
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(0, 0, 2, coins);
    }
    private static int dfs(int i, int j, int k, int[][] coins) {
        if (i >= m || j >= n) return Integer.MIN_VALUE;
        if (i == m - 1 && j == n - 1)
            return k > 0 ? Math.max(coins[i][j], 0) : coins[i][j];
        if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        // don't neutralize
        int res = Math.max(
                           dfs(i + 1, j, k, coins),
                           dfs(i, j + 1, k, coins)
                           ) + coins[i][j];
        // neutralize
           if (k > 0 && coins[i][j] < 0) {
               res = Math.max(
                              res,
                              Math.max(
                                       dfs(i + 1, j, k - 1, coins),
                                       dfs(i, j + 1, k - 1, coins)
                                       )
                              );
           }
           return dp[i][j][k] = res;
    }
    public static void main(String[] args) {
        log.info(maximumAmount(new int[][] {{0,1,-1},{1,-2,3},{2,-3,4}}));
        log.info(maximumAmount(new int[][] {{10,10,10},{10,10,10}}));
    }
}
