/**
   1914. Cyclically Rotating a Grid

   You are given an m x n integer matrix grid​​​, where m and n are both even integers,
   and an integer k.

   The matrix is composed of several layers, which is shown in the below image, where
   each color is its own layer:

   A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix.
   To cyclically rotate a layer once, each element in the layer will take the place of the
   adjacent element in the counter-clockwise direction. An example rotation is shown below:

   Return the matrix after applying k cyclic rotations to it.

   Example 1:
   Input: grid = [[40,10],[30,20]], k = 1
   Output: [[10,20],[40,30]]
   Explanation: The figures above represent the grid at every state.

   Example 2:
   Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
   Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
   Explanation: The figures above represent the grid at every state.

   Constraints:
   m == grid.length
   n == grid[i].length
   2 <= m, n <= 50
   Both m and n are even integers.
   1 <= grid[i][j] <= 5000
   1 <= k <= 109
*/

/**
   Approach: Enumerate Each Layer
   Intuition
   For a matrix grid of size m×n, the number of layers is min(m / 2, n / 2).
   We can simulate the cyclic rotation operation by enumerating each layer
   from the outside to the inside.

   For convenience, we traverse the elements of each layer in a counterclockwise
   direction starting from the top-left corner. We divide this traversal into four
   parts, where each part processes one edge of the layer while excluding the last
   element to avoid duplication.

   We store the row indices, column indices, and values of these elements in the
   corresponding arrays r, c, and val, respectively. Let total denote the number
   of elements in the current layer, which is equal to the length of val.
   If we perform total rotations, the layer remains unchanged.
   Therefore, the effective number of rotations is kk = k mod total.

   After rotation, the value at the ith position in the traversal corresponds to
   the value at index (i - kk + total)modtotal in the val array. Adding total before
   taking the modulus ensures that the index remains non-negative.

   Finally, we iterate over the stored coordinates and update the corresponding
   positions in grid. Once all layers are processed, grid represents the rotated
   matrix.
*/
import java.util.*;

class CyclicallyRotatingAGrid {
    private static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int nlayer = Math.min(m / 2, n / 2);
        for (int layer = 0; layer < nlayer; ++layer) {
            // store indexes
            List<Integer> r = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            // store values
            List<Integer> v = new ArrayList<>();
            // left
            for(int i = layer; i < m - layer - 1; ++i) {
                r.add(i);
                c.add(layer);
                v.add(grid[i][layer]);
            }
            // down
            for(int i = layer; i < n - layer - 1; ++i) {
                r.add(m - layer - 1);
                c.add(i);
                v.add(grid[m - layer - 1][i]);
            }
            // right
            for(int i = m - layer - 1; i > layer; --i) {
                r.add(i);
                c.add(n - layer - 1);
                v.add(grid[i][n - layer - 1]);
            }
            // up
            for(int i = n - layer - 1; i > layer; --i) {
                r.add(layer);
                c.add(i);
                v.add(grid[layer][i]);
            }
            int total = v.size();
            int kk = k % total;
            for (int i = 0; i < total; ++i) {
                int idx = (i + total - kk) % total;
                grid[r.get(i)][c.get(i)] = v.get(idx);
            }
        }
        return grid;
    }
    public static void main(String[] args) {
        Log.info((Object[]) rotateGrid(new int[][] {{40,10},{30,20}}, 1));
        Log.info((Object[]) rotateGrid(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 2));
        Log.info((Object[]) rotateGrid(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 2));
    }
}
