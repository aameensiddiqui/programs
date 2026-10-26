/*
  1254. Number of Closed Islands
  Medium
  Given a 2D grid consists of 0s (land) and 1s (water).
  An island is a maximal 4-directionally connected group of 0s and a closed
  island is an island totally (all left, top, right, bottom) surrounded by 1s.

  Return the number of closed islands.

  Example 1:
  Input: grid = [
      [1,1,1,1,1,1,1,0],
      [1,0,0,0,0,1,1,0],
      [1,0,1,0,1,1,1,0],
      [1,0,0,0,0,1,0,1],
      [1,1,1,1,1,1,1,0]
      ]
  Output: 2
  Explanation:
  Islands in gray are closed because they are completely surrounded by water (group of 1s).

  Example 2:
  Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
  Output: 1

  Example 3:
  Input: grid = [
      [1,1,1,1,1,1,1],
      [1,0,0,0,0,0,1],
      [1,0,1,1,1,0,1],
      [1,0,1,0,1,0,1],
      [1,0,1,1,1,0,1],
      [1,0,0,0,0,0,1],
      [1,1,1,1,1,1,1]
      ]
  Output: 2

  Constraints:

  1 <= grid.length, grid[0].length <= 100
  0 <= grid[i][j] <= 1
 */
import java.util.Queue;
import java.util.LinkedList;

class NumberOfClosedIslands {
    private static int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && !visited[i][j] && bfs(i, j, m, n, grid, visited))
                    cnt++;
            }
        }
        return cnt;
    }
    private static boolean bfs(int x, int y, int m, int n, int[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        boolean isClosed = true;
        visited[x][y] = true;

        int[] dirx = new int[] {0, 1, 0, -1};
        int[] diry = new int[] {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];

            for (int i = 0; i < 4; ++i) {
                int r = x + dirx[i];
                int c = y + diry[i];
                if (r < 0 || r >= m || c < 0 || c >= n)
                    isClosed = false;
                else if (grid[r][c] == 0 && !visited[r][c]) {
                    q.offer(new int[] {r, c});
                    visited[r][c] = true;
                }
            }
        }
        return isClosed;
    }

    public static void main(String[] args) {
        //Log.info("Hello, World!");
        Log.info(closedIsland(new int[][] {
                    {1,1,1,1,1,1,1,0},
                    {1,0,0,0,0,1,1,0},
                    {1,0,1,0,1,1,1,0},
                    {1,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,0}
                }));

        Log.info(closedIsland(new int[][] {
                    {0,0,1,0,0},
                    {0,1,0,1,0},
                    {0,1,1,1,0}
                }));
        Log.info(closedIsland(new int[][] {
                    {1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,1},
                    {1,0,1,1,1,0,1},
                    {1,0,1,0,1,0,1},
                    {1,0,1,1,1,0,1},
                    {1,0,0,0,0,0,1},
                    {1,1,1,1,1,1,1}
                }));
    }
}
