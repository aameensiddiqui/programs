/**
   463. Island Perimeter

   You are given row x col grid representing a map where grid[i][j] = 1
   represents land and grid[i][j] = 0 represents water.

   Grid cells are connected horizontally/vertically (not diagonally).
   The grid is completely surrounded by water, and there is exactly one
   island (i.e., one or more connected land cells).

   The island doesn't have "lakes", meaning the water inside isn't connected
   to the water around the island. One cell is a square with side length 1.
   The grid is rectangular, width and height don't exceed 100.
   Determine the perimeter of the island.

   Example 1:
   Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
   Output: 16
   Explanation: The perimeter is the 16 yellow stripes in the image above.

   Example 2:
   Input: grid = [[1]]
   Output: 4

   Example 3:
   Input: grid = [[1,0]]
   Output: 4

   Constraints:
   row == grid.length
   col == grid[i].length
   1 <= row, col <= 100
   grid[i][j] is 0 or 1.
   There is exactly one island in grid.
*/
class IslandPerimeter {
    private static int islandPerimeter(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        // log.info("m="+m+" n="+n);

        int perimeter = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int neighbours = 0;
                    if (i-1 >= 0 && (grid[i-1][j] == 1)) neighbours++;
                    if (j-1 >= 0 && (grid[i][j-1] == 1)) neighbours++;
                    if (i+1 <  n && (grid[i+1][j] == 1)) neighbours++;
                    if (j+1 <  m && (grid[i][j+1] == 1)) neighbours++;
                    perimeter += (4 - neighbours);
                }
            }
        }
        return perimeter;
    }
    public static void main(String[]args) {
        log.info(islandPerimeter(new int[][] {{0,1,0,0},
                                              {1,1,1,0},
                                              {0,1,0,0},
                                              {1,1,0,0}})); // 16

        log.info(islandPerimeter(new int[][] {{1,1,0,0},
                                              {1,0,0,0},
                                              {1,1,1,0},
                                              {0,0,1,1}})); // 18

        log.info(islandPerimeter(new int[][] {{1}}));       // 4

        log.info(islandPerimeter(new int[][] {{1,0}}));     // 4
    }
}
/**
      [ ]
   [ ][x][ ] = 4 neighbours -> 0 perimeter
      [ ]

      [ ]
   [ ][x][ ] = 3 neighbours -> 1 perimeter

   [ ][x][ ] = 2 neighbours -> 2 perimeter

   [ ][x]    = 1 neighbour  -> 3 perimeter

      [x]    = 0 neighbours -> 4 perimeter

*/
