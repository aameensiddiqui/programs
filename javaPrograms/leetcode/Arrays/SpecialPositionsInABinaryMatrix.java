/**
   1582. Special Positions in a Binary Matrix

   Given an m x n binary matrix mat, return the number of special positions in mat.

   A position (i, j) is called special if mat[i][j] == 1 and all other elements in
   row i and column j are 0 (rows and columns are 0-indexed).

   Example 1:
   Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
   Output: 1
   Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other
   elements in row 1 and column 2 are 0.

   Example 2:
   Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
   Output: 3
   Explanation: (0, 0), (1, 1) and (2, 2) are special positions.

   Constraints:
   m == mat.length
   n == mat[i].length
   1 <= m, n <= 100
   mat[i][j] is either 0 or 1.
*/
class SpecialPositionsInABinaryMatrix {
    private static boolean isSpecial(int i, int j, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        // column
        for (int x = 0; x < n; ++x)
            if (x != i && mat[x][j] == 1) return false;
        // row
        for (int x = 0; x < m; ++x)
            if (x != j && mat[i][x] == 1) return false;
        return true;
    }
    private static int numSpecial(int[][] mat) {
        int cnt = 0;
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1 && isSpecial(i, j, mat))
                    cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Log.info(numSpecial(new int[][] {{1,0,0},
                                         {0,0,1},
                                         {1,0,0}}
                )
            ); // 1
        Log.info(numSpecial(new int[][] {{1,0,0},
                                         {0,1,0},
                                         {0,0,1}}
                )
            ); // 3
        Log.info(numSpecial(new int[][] {{0,0,0,0,0,0,0,0,0,0},
                                         {0,1,0,0,0,0,1,0,0,0},
                                         {1,0,0,1,0,0,0,1,0,0},
                                         {0,0,0,0,0,1,0,0,0,1}}
                )
            ); // 0
        Log.info(numSpecial(new int[][] {{0,0,0,0,0,0,0,0},
                                         {0,1,0,0,0,0,0,0},
                                         {0,0,0,0,0,0,0,0},
                                         {0,0,0,0,0,0,0,0},
                                         {1,0,0,0,0,0,0,1},
                                         {0,0,0,0,0,0,1,0},
                                         {0,0,0,0,0,0,0,1}}
                )
            ); // 2
    }
}
/**
    private static boolean isSpecial(int i, int j, int[][] mat) {
        int ti = i - 1, tj = j - 1;
        int n = mat.length, m = mat[0].length;

        while (ti >= 0) {
            if (mat[ti][j] == 1) return false;
            ti--;
        }
        ti = i + 1;
        while (ti < n) {
            if (mat[ti][j] == 1) return false;
            ti++;
        }

        while (tj >= 0) {
            if (mat[i][tj] == 1) return false;
            tj--;
        }
        tj = j + 1;
        while (tj < m) {
            if (mat[i][tj] == 1) return false;
            tj++;
        }
        return true;
    }
    private static int numSpecial(int[][] mat) {
        int cnt = 0;
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1 && isSpecial(i, j, mat))
                    cnt++;
            }
        }
        return cnt;
    }
*/
