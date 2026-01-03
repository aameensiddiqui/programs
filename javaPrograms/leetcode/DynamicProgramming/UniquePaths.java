/**
   62. Unique Paths

   There is a robot on an m x n grid. The robot is initially located at
   the top-left corner (i.e., grid[0][0]). The robot tries to move to the
   bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
   either down or right at any point in time.

   Given the two integers m and n, return the number of possible unique
   paths that the robot can take to reach the bottom-right corner.

   The test cases are generated so that the answer will be less than or
   equal to 2 * 109.

   Example 1:
   Input: m = 3, n = 7
   Output: 28

   Example 2:
   Input: m = 3, n = 2
   Output: 3
   Explanation: From the top-left corner, there are a total of 3 ways to
   reach the bottom-right corner:
   1. Right -> Down -> Down
   2. Down -> Down -> Right
   3. Down -> Right -> Down

   Constraints:
   1 <= m, n <= 100
*/
class UniquePaths {
    private static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        long res = 1;
        int j = 1;
        for (int i = m; i < m + n - 1; ++i) {
            res *= i;
            res /= j;
            j++;
        }
        return (int) res;
    }
    public static void main(String[]args) {
        log.info(uniquePaths(3, 7));
        log.info(uniquePaths(3, 2));
    }
}
/**
    private static int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private static int dfs(int i, int j, int m, int n) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }
        if (i >= m || j >= n) return 0;
        return dfs(i, j + 1, m, n) +
            dfs(i + 1, j, m, n);
    }
*/
