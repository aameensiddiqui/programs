/**
   695. Max Area of Island

   You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
   connected 4-directionally (horizontal or vertical.) You may assume all four edges of the
   grid are surrounded by water.

   The area of an island is the number of cells with a value 1 in the island.

   Return the maximum area of an island in grid. If there is no island, return 0.

   Example 1:
   Input: grid = [
   [0,0,1,0,0,0,0,1,0,0,0,0,0],
   [0,0,0,0,0,0,0,1,1,1,0,0,0],
   [0,1,1,0,1,0,0,0,0,0,0,0,0],
   [0,1,0,0,1,1,0,0,1,0,1,0,0],
   [0,1,0,0,1,1,0,0,1,1,1,0,0],
   [0,0,0,0,0,0,0,0,0,0,1,0,0],
   [0,0,0,0,0,0,0,1,1,1,0,0,0],
   [0,0,0,0,0,0,0,1,1,0,0,0,0]
   ]
   Output: 6
   Explanation: The answer is not 11, because the island must be connected 4-directionally.

   Example 2:
   Input: grid = [[0,0,0,0,0,0,0,0]]
   Output: 0

   Constraints:
   m == grid.length
   n == grid[i].length
   1 <= m, n <= 50
   grid[i][j] is either 0 or 1.
*/
class MaxAreaOfIsland {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int maxAreaOfIsland(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        int area = 0;
        for (int r = 0; r < ROW; ++r) {
            for (int c = 0; c < COL; ++c) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, dfs(r, c, grid));
                }
            }
        }
        return area;
    }
    private static int dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int res = 1;
        for (int[] dir : directions) {
            res += dfs(r + dir[0], c + dir[1], grid);
        }
        return res;
    }
    public static void main(String[]args) {
        log.info(maxAreaOfIsland(new int[][] {
                    {0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                    {0,1,0,0,1,1,0,0,1,1,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,1,1,0,0,0,0}
                }));
        log.info(maxAreaOfIsland(new int[][] {{0,0,0,0,0,0,0,0}}));
    }
}
