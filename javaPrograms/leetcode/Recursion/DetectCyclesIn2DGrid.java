/**
   1559. Detect Cycles in 2D Grid

   Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle
   consisting of the same value in grid.

   A cycle is a path of length 4 or more in the grid that starts and ends at the same cell.
   From a given cell, you can move to one of the cells adjacent to it - in one of the four directions
   (up, down, left, or right), if it has the same value of the current cell.

   Also, you cannot move to the cell that you visited in your last move. For example, the cycle
   (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last
   visited cell.

   Return true if any cycle of the same value exists in grid, otherwise, return false.

   Example 1:
   Input: grid = [['a','a','a','a'],['a','b','b','a'],['a','b','b','a'],['a','a','a','a']]
   Output: true
   Explanation: There are two valid cycles shown in different colors in the image below:

   Example 2:
   Input: grid = [['c','c','c','a'],['c','d','c','c'],['c','c','e','c'],['f','c','c','c']]
   Output: true
   Explanation: There is only one valid cycle highlighted in the image below:

   Example 3:
   Input: grid = [['a','b','b'],['b','z','b'],['b','b','a']]
   Output: false

   Constraints:
   m == grid.length
   n == grid[i].length
   1 <= m, n <= 500
   grid consists only of lowercase English letters.
*/
/**
   Intuition
   The goal is to find a closed loop of at least 4 cells with matching characters in a grid.

   A loop occurs when a continuous path crosses itself without simply taking a step backward.

   To prove a loop exists, we look for two conditions at the same time:

   We step into a cell that is already marked as visited.
   That visited cell is not the immediate parent cell we just came from.
   By passing the parent coordinates as we move, we prevent the algorithm from making a 180° U-turn.

   If we hit our own trail while strictly moving forward, we have completed a circuit.

   Approach
   Check every coordinate in the grid to ensure we don't miss isolated clusters of characters.

   Perform a recursive DFS to each unvisited cell.
   Use a boolean 1D Array to track visited cells.

   Algorithm
   Depth-First Search Execution

   Encountering a previously visited cell with an identical value triggers the following logic:

   Handling Invalid Cycles
   Transitioning from (r,c) to (nr,nc) and immediately returning to (r,c) creates a cycle of length 2.
   This length does not satisfy the cycle requirement of 4.
   To prevent this, an immediate reversal is strictly prohibited.
   This constraint is enforced by passing the parent coordinates (pr,pc) into the DFS state and explicitly
   blocking transitions where:
   (nr,nc) = (pr,pc)

   Detecting Valid Cycles
   A transition is made from (r,c) to an adjacent cell (nr,nc).
   The adjacent cell (nr,nc) strictly bypasses the parent constraint
   (nr,nc) = (pr,pc)

   The adjacent cell (nr,nc) is already marked as visited in the historical footprint.
   When these conditions are met simultaneously, a valid cycle with a length of at least 4 is detected
   Time Complexity: O(m * n)
   Space Complexity: O(m * n)
*/
class DetectCyclesIn2DGrid {
    private static int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    private static int m, n;
    private static boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[] visited) {
        visited[r * n + c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr != pr && nc != pc)
                if (nr >= 0 && nr < m && nc >= 0 && nc < n)
                    if (grid[nr][nc] == grid[r][c])
                        if (visited[nr * n + nc] || dfs(nr, nc, r, c, grid, visited))
                            return true;
        }
        return false;
    }
    private static boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i * n + j] && dfs(i, j, -1, -1, grid, visited))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Log.info(containsCycle(new char[][] {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}}));
        Log.info(containsCycle(new char[][] {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}}));
        Log.info(containsCycle(new char[][] {{'a','b','b'},{'b','z','b'},{'b','b','a'}}));
    }
}
