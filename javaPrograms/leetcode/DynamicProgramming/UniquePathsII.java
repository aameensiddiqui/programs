/**
   63. Unique Paths II

   You are given an m x n integer array grid. There is a robot initially located at
   the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right
   corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
   any point in time.

   An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot
   takes cannot include any square that is an obstacle.

   Return the number of possible unique paths that the robot can take to reach the
   bottom-right corner.

   The testcases are generated so that the answer will be less than or equal to 2 * 109.

   Example 1:
   Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
   Output: 2
   Explanation: There is one obstacle in the middle of the 3x3 grid above.
   There are two ways to reach the bottom-right corner:
   1. Right -> Right -> Down -> Down
   2. Down -> Down -> Right -> Right

   Example 2:
   Input: obstacleGrid = [[0,1],[0,0]]
   Output: 1

   Example 3:
   Input: obstacleGrid = [[0,0],[0,1]]
   Output: 0
*/
import java.util.Arrays;

class UniquePathsII {
    // We can avoid using any extra space by reusing the input grid itself to store the
    // path counts. The key insight is that once we process a cell, we no longer need
    // its original value (which was just 0 or 1 for obstacle). We transform grid so
    // each cell holds the number of paths from that cell to the destination.
    // Obstacles get converted to 0 since no path passes through them.
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        obstacleGrid[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) continue;
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else {
                    int down = (i + 1 < m) ? obstacleGrid[i + 1][j] : 0;
                    int right = (j + 1 < n) ? obstacleGrid[i][j + 1] : 0;
                    obstacleGrid[i][j] = down + right;
                }
            }
        }
        return obstacleGrid[0][0];
    }
    public static void main(String[] args) {
        log.info(uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
        log.info(uniquePathsWithObstacles(new int[][] {{0,1},{0,0}}));
        log.info(uniquePathsWithObstacles(new int[][] {{0,0},{0,1}}));
    }
}
/**
    // Looking at the bottom-up approach, we notice that each cell only depends on the
    // cell directly below it and the cell to its right. Since we process row by
    // row from bottom to top, we only need to keep track of one row at a time.
    // The value dp[c] before updating represents the count from the row below,
    // and dp[c+1] after updating represents the count from the right.
    // This reduces space from O(m * n) to O(n).
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else {
                    dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }
*/
/**
    // Instead of solving recursively from the start, we can build the solution iteratively
    // from the destination back to the start. Each cell stores the number of ways to
    // reach the destination from that cell. For any cell, this count is the sum of the
    // counts from the cell below and the cell to the right. Obstacles simply have a
    // count of 0 since no path can go through them.
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] += dp[i + 1][j];
                    dp[i][j] += dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
*/
/**
    // we want to count all possible paths from the top-left corner to the bottom-right
    // corner, but some cells are blocked by obstacles. At any cell, we can only move right
    // or down. This naturally leads to a recursive approach: the number of paths from
    // a cell equals the sum of paths from the cell below and the cell to the right.
    // If we hit an obstacle or go out of bounds, that path contributes 0.
    // Since many subproblems overlap (the same cell gets visited through different routes),
    // we use memoization to avoid redundant calculations.
    private static int[][] memo;
    private static int dfs(int i, int j, int m, int n, int[][] og) {
        if (i == m || j == n || og[i][j] == 1) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (i == m - 1 && j == n - 1) return 1;
        return memo[i][j] = dfs(i + 1, j, m, n, og) + dfs(i, j + 1, m, n, og);
    }
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int[] r : memo) Arrays.fill(r, -1);
        return dfs(0, 0, m, n, obstacleGrid);
    }
*/
