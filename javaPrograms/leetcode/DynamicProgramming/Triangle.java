/**
   120. Triangle

   Given a triangle array, return the minimum path sum from top to bottom.

   For each step, you may move to an adjacent number of the row below.
   More formally, if you are on index i on the current row, you may move
   to either index i or index i + 1 on the next row.

   Example 1:
   Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
   Output: 11
   Explanation: The triangle looks like:
   (2)
   (3) 4
    6 (5) 7
    4 (1) 8 3
   The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (in brackets above).

   Example 2:
   Input: triangle = [[-10]]
   Output: -10

   Constraints:
   1 <= triangle.length <= 200
   triangle[0].length == 1
   triangle[i].length == triangle[i - 1].length + 1
   -104 <= triangle[i][j] <= 104
*/
import java.util.*;

class Triangle {
    // dp bottom up
    /*
      Working bottom-up with space optimization is cleaner because we process
      elements left to right, and each cell only depends on cells to its right
      in the row below. This means we can safely overwrite values as we go
      without corrupting data we still need.

      We start with the bottom row and repeatedly update each position with the
      minimum path sum from that point down. The final answer ends up in dp[0].
     */
    private static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int r = n - 2; r >= 0; --r) {
            for (int c = 0; c < triangle.get(r).size(); ++c) {
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c], dp[c + 1]);
            }
        }
        return dp[0];
    }
    public static void main(String[]args) {
        List<List<Integer>> triangle1 = List.of(
                                               List.of(2),
                                               List.of(3, 4),
                                               List.of(6, 5, 7),
                                               List.of(4, 1, 8, 3)
                                               );
        log.info(minimumTotal(triangle1)); // 11

        List<List<Integer>> triangle2 = List.of(
                                               List.of(-10)
                                               );

        log.info(minimumTotal(triangle2)); // -10

        List<List<Integer>> triangle3 = List.of(
                                               List.of(-1),
                                               List.of(2, 3),
                                               List.of(1, -1, -3)
                                               );
        log.info(minimumTotal(triangle3)); // -1

        List<List<Integer>> triangle4 = List.of(
                                                List.of(0),
                                                List.of(0,0),
                                                List.of(0,0,0),
                                                List.of(0,0,0,0),
                                                List.of(0,0,0,0,0),
                                                List.of(0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
                                                List.of(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
                                                );
        log.info(minimumTotal(triangle4)); // -1
    }
}
/**
    // recursive
    private static int dfs(int row, int col, List<List<Integer>> triangle) {
        if (row >= triangle.size()) return 0;
        return triangle.get(row).get(col) + Math.min(dfs(row + 1, col, triangle), dfs(row + 1, col + 1, triangle));
    }
    private static int minimumTotal(List<List<Integer>> triangle) {
        return dfs(0, 0, triangle);
    }
*/
