/**
   1267. Count Servers that Communicate

   You are given a map of a server center, represented as a m * n integer matrix grid,
   where 1 means that on that cell there is a server and 0 means that it is no server.
   Two servers are said to communicate if they are on the same row or on the same column.

   Return the number of servers that communicate with any other server.

   Example 1:
   Input: grid = [[1,0],[0,1]]
   Output: 0
   Explanation: No servers can communicate with others.

   Example 2:
   Input: grid = [[1,0],[1,1]]
   Output: 3
   Explanation: All three servers can communicate with at least one other server.

   Example 3:
   Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
   Output: 4
   Explanation: The two servers in the first row can communicate with each other.
   The two servers in the third column can communicate with each other.
   The server at right bottom corner can't communicate with any other server.

   Constraints:
   m == grid.length
   n == grid[i].length
   1 <= m <= 250
   1 <= n <= 250
   grid[i][j] == 0 or 1
*/
class CountServersThatCommunicate {
    // O(n * m)
    private static int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rcnt = new int[m];
        int[] ccnt = new int[n];

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] == 1) {
                    rcnt[r]++;
                    ccnt[c]++;
                }
            }
        }
        int ans = 0;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] == 1 &&
                    Math.max(rcnt[r], ccnt[c]) > 1)
                    ans++;
            }
        }
        return ans;
    }
    public static void main(String[]args) {
        log.info(countServers(new int[][] {{1,0},{0,1}}));                             // 0
        log.info(countServers(new int[][] {{1,0},{1,1}}));                             // 3
        log.info(countServers(new int[][] {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}})); // 4
        log.info(countServers(new int[][] {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}}));     // 3
    }
}
/**
    // mine O(n * m * (m + n))
    private static int func(int i, int j, int[][] grid) {
        for (int r = 0; r < grid.length; ++r) {
            if (r == i) continue;
            if (grid[r][j] == 1) return 1;
        }
        for (int c = 0; c < grid[0].length; ++c) {
            if (c == j) continue;
            if (grid[i][c] == 1) return 1;
        }
        return 0;
    }
    private static int countServers(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) ans += func(i, j, grid);
            }
        }
        return ans;
    }
*/
