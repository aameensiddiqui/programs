/**
   64. Minimum Path Sum

   Given a m x n grid filled with non-negative numbers, find a path from top
   left to bottom right, which minimizes the sum of all numbers along its path.

   Note: You can only move either down or right at any point in time.

   Example 1:
   Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
   Output: 7
   Explanation: Because the path 1 -> 3 -> 1 -> 1 -> 1 minimizes the sum.

   Example 2:
   Input: grid = [[1,2,3],[4,5,6]]
   Output: 12

   Constraints:
   m == grid.length
   n == grid[i].length
   1 <= m, n <= 200
   0 <= grid[i][j] <= 200
*/
import java.util.Arrays;

class MinimumPathSum {
    private static int[][] memo;
    private static int dfs(int i, int j, int m, int n, int[][] grid) {
        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (i == m || j == n) return Integer.MAX_VALUE;
        if (memo[i][j] != -1) return memo[i][j];
        return memo[i][j] = grid[i][j] + Math.min(dfs(i + 1, j, m, n, grid),
                                                  dfs(i, j + 1, m, n, grid));
    }
    private static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int[] r : memo) Arrays.fill(r, -1);
        return dfs(0, 0, m, n, grid);
    }
    public static void main(String[] args) {
        log.info(minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}})); // 7
        log.info(minPathSum(new int[][] {{1,2,3},{4,5,6}})); // 12
        log.info(minPathSum(new int[][] {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},
                                         {0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},
                                         {8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},
                                         {1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},
                                         {8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},
                                         {4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},
                                         {6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},
                                         {8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},
                                         {9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},
                                         {0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},
                                         {4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},
                                         {2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},
                                         {0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},
                                         {0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},
                                         {6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},
                                         {7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},
                                         {3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},
                                         {5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}})); // 83
    }
}
