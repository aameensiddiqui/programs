/**
   62. Unique Paths

   There is a robot on an m x n grid. The robot is initially located at
   the top-left corner (i.e., grid[0][0]). The robot tries to move to the
   bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
   either down or right at any point in time.

   Given the two integers m and n, return the number of possible unique
   paths that the robot can take to reach the bottom-right corner.

   The test cases are generated so that the answer will be less than or
   equal to 2 * 109.

   Example 1:
   Input: m = 3, n = 7
   Output: 28

   Example 2:
   Input: m = 3, n = 2
   Output: 3
   Explanation: From the top-left corner, there are a total of 3 ways to
   reach the bottom-right corner:
   1. Right -> Down -> Down
   2. Down -> Down -> Right
   3. Down -> Right -> Down

   Constraints:
   1 <= m, n <= 100
*/
import java.util.Arrays;

class UniquePaths {
    // from any cell, you can reach the destination by moving:
    // right
    // down
    // the number of ways to reach a cell equals:
    // ways from the cell below + ways from the cell to the right
    // instead of using a full 2D table, we notice that:
    // each row only depends on the row below it
    // so a single 1D array is enough
    // we keep updating this array from right to left, accumulating paths.
    private static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
    public static void main(String[]args) {
        log.info(uniquePaths(3, 7));
        log.info(uniquePaths(3, 2));
    }
}
/**
    // each cell only depends on:
    // the cell to the right (same row)
    // the cell below (previous row)
    // so instead of storing the entire 2D grid,
    // we can keep just one row at a time.
    // we update the row from right to left, using values from:
    // the current row (newRow[j + 1])
    // the previous row (row[j])
    // this reduces space while keeping the same logic.
    private static int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        for (int i = 0; i < m - 1; ++i) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int j = n - 2; j >= 0; --j) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }
*/
/**
    // bottom up approach
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 14];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                log.info((Object[]) dp);
                log.info("--------------------------------------------------");
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
*/
/**
    // memoisation
    private static int[][] memo;
    private static int dfs(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        return memo[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }
    private static int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(0, 0, m, n);
    }
*/
/**
    private static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        long res = 1;
        int j = 1;
        for (int i = m; i < m + n - 1; ++i) {
            res *= i;
            res /= j;
            j++;
        }
        return (int) res;
    }
*/
/**
    private static int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private static int dfs(int i, int j, int m, int n) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }
        if (i >= m || j >= n) return 0;
        return dfs(i, j + 1, m, n) +
            dfs(i + 1, j, m, n);
    }
*/
