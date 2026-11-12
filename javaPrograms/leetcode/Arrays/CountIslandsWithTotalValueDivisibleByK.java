import java.util.*;

class CountIslandsWithTotalValueDivisibleByK {
    private static int bfs(int x, int y, int n, int m, int[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        long sum = 0;
        visited[x][y] = true;
        int[] dirx = new int[] {0, 1, 0, -1};
        int[] diry = new int[] {-1, 0, 1, 0};
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            //Log.info("x = " + x + " y = " + y);
            sum += grid[x][y];
            for (int i = 0; i < 4; ++i) {
                int r = x + dirx[i];
                int c = y + diry[i];
                if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] > 0 && !visited[r][c]) {
                    visited[r][c] = true;
                    q.offer(new int[] {r, c});
                }
            }
        }
        return sum;
    }
    private static int countIslands(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long total = bfs(i, j, n, m, grid, visited);
                    if (total % k == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Log.info("Hello, World!");
        Log.info(countIslands(new int[][] {
                    {0,2,1,0,0},
                    {0,5,0,0,5},
                    {0,0,1,0,0},
                    {0,1,4,7,0},
                    {0,2,0,0,8}}, 5));
        Log.info(countIslands(new int[][] {
                    {3,0,3,0},
                    {0,3,0,3},
                    {3,0,3,0}}, 3));
    }
}
