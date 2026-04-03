/**
   221. Maximal Square

   Given an m x n binary matrix filled with 0's and 1's, find the largest square containing
   only 1's and return its area.

   Example 1:
   Input: matrix = [['1','0','1','0','0'],
                    ['1','0','1','1','1'],
                    ['1','1','1','1','1'],
                    ['1','0','0','1','0']]
   Output: 4

   Example 2:
   Input: matrix = [['0','1'],['1','0']]
   Output: 1

   Example 3:
   Input: matrix = [['0']]
   Output: 0

   Constraints:
   m == matrix.length
   n == matrix[i].length
   1 <= m, n <= 300
   matrix[i][j] is '0' or '1'.
*/
import java.util.Arrays;

class MaximalSquare {
    /**
     * The bottom-up DP only needs the current row and the next row to compute values.
     * We can reduce space by using a single 1D array. As we process each row from right
     * to left, we keep track of the previous diagonal value in a variable prev. This
     * allows us to update the array in place while still having access to all three
     * neighbors needed for the recurrence.
     */
    private static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSquare = 0;
        int[] dp = new int[n + 1];

        for (int r = m - 1; r >= 0; --r) {
            int prevDiagonal = 0;
            for (int c = n - 1; c >= 0; --c) {
                int temp = dp[c];
                dp[c] = 0;
                if (matrix[r][c] == '1')
                    dp[c] = 1 + Math.min(temp, Math.min(dp[c + 1], prevDiagonal));
                maxSquare = Math.max(maxSquare, dp[c]);
                prevDiagonal = temp;
            }
        }
        return maxSquare * maxSquare;
    }
    public static void main(String[] args) {
        log.info(maximalSquare(new char[][] {{'1','0','1','0','0'},
                                             {'1','0','1','1','1'},
                                             {'1','1','1','1','1'},
                                             {'1','0','0','1','0'}}));
        log.info(maximalSquare(new char[][] {{'0','1'},
                                             {'1','0'}}));
        log.info(maximalSquare(new char[][] {{'0'}}));
    }
}
/**
    private static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSquare = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int r = m - 1; r >= 0; --r) {
            for (int c = n - 1; c >= 0; --c) {
                int right    = dp[r + 1][c];
                int down     = dp[r][c + 1];
                int diagonal = dp[r + 1][c + 1];
                dp[r][c] = 0;
                if (matrix[r][c] == '1')
                    dp[r][c] = 1 + Math.min(right, Math.min(down, diagonal));
                maxSquare = Math.max(maxSquare, dp[r][c]);
            }
        }
        return maxSquare * maxSquare;
    }
*/
/**
    private static int m, n;
    private static int[][] dp;
    private static int dfs(int r, int c, char[][] matrix) {
        if (r >= m || c >= n) return 0;
        if (dp[r][c] != -1) return dp[r][c];
        int right    = dfs(r + 1, c,     matrix);
        int down     = dfs(r,     c + 1, matrix);
        int diagonal = dfs(r + 1, c + 1, matrix);
        dp[r][c] = 0;
        if (matrix[r][c] == '1')
            dp[r][c] = 1 + Math.min(right, Math.min(down, diagonal));
        return dp[r][c];
    }
    private static int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        dfs(0, 0, matrix);
        int maxSquare = 0;
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                maxSquare = Math.max(maxSquare, dp[r][c]);
        return maxSquare * maxSquare;
    }
*/
