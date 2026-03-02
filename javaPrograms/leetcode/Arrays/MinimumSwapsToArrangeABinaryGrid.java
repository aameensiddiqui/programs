/**
   1536. Minimum Swaps to Arrange a Binary Grid

   Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.

   A grid is said to be valid if all the cells above the main diagonal are zeros.

   Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.

   The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

   Example 1:
   Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
   Output: 3

   Example 2:
   Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
   Output: -1
   Explanation: All rows are similar, swaps have no effect on the grid.

   Example 3:
   Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
   Output: 0

   Constraints:
   n == grid.length == grid[i].length
   1 <= n <= 200
   grid[i][j] is either 0 or 1
*/
class MinimumSwapsToArrangeABinaryGrid {
    /*
      to make the grid valid, every row i must have at least (n - i - 1) trailing zeros
      because:
      row 0 -> needs n - 1 zeros
      row 1 -> needs n - 2 zeros
      row 2 -> needs n - 3 zeros
      ...
      last row -> needs 0 zeros
      so instead of swapping the whole grid, we:
      count trailing zeros in each row.
      try to place a valid row at each position.
      if a valid row is below, bring it up using adjacent swaps.
      count swaps.
      if no row satisfies requirement -> return -1
     */
    private static int minSwaps(int[][] grid) {
        int n = grid.length, swaps = 0;
        int[] zeros = new int[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; --j) {
                cnt++;
            }
            zeros[i] = cnt;
        }
        for (int i = 0; i < n; ++i) {
            int needed0 = n - i - 1;
            int j = i;
            while (j < n && zeros[j] < needed0) ++j;
            if (j == n) return -1;
            while (j > i) {
                int tmp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = tmp;
                --j; ++swaps;
            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        Log.info(minSwaps(new int[][] {{0,0,1},{1,1,0},{1,0,0}}));
        Log.info(minSwaps(new int[][] {{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}}));
        Log.info(minSwaps(new int[][] {{1,0,0},{1,1,0},{1,1,1}}));
    }
}
