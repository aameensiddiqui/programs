/**
   200. Number of Islands

   Given an m x n 2D binary grid grid which represents a map of '1's (land) and
   '0's (water), return the number of islands.

   An island is surrounded by water and is formed by connecting adjacent lands
   horizontally or vertically. You may assume all four edges of the grid are all
   surrounded by water.

   Example 1:
   Input: grid = [
   ["1","1","1","1","0"],
   ["1","1","0","1","0"],
   ["1","1","0","0","0"],
   ["0","0","0","0","0"]
   ]
   Output: 1

   Example 2:
   Input: grid = [
   ["1","1","0","0","0"],
   ["1","1","0","0","0"],
   ["0","0","1","0","0"],
   ["0","0","0","1","1"]
   ]
   Output: 3

   Constraints:
   m == grid.length
   n == grid[i].length
   1 <= m, n <= 300
   grid[i][j] is '0' or '1'.
*/
class NumberOfIslands {
    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int numIslands(char[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        int islands = 0;
        for (int r = 0; r < ROW; ++r) {
            for (int c = 0; c < COL; ++c) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    private static void dfs(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for (int dir[] : directions) dfs(r + dir[0], c + dir[1], grid);
    }
    public static void main(String[]args) {
        log.info(numIslands(new char[][] {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                    }));
        log.info(numIslands(new char[][] {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                    }));
    }
}
