/**
   1391. Check if There is a Valid Path in a Grid

   You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:

   1 which means a street connecting the left cell and the right cell.
   2 which means a street connecting the upper cell and the lower cell.
   3 which means a street connecting the left cell and the lower cell.
   4 which means a street connecting the right cell and the lower cell.
   5 which means a street connecting the left cell and the upper cell.
   6 which means a street connecting the right cell and the upper cell.

   You will initially start at the street of the upper-left cell (0, 0). A valid path in the grid is a path
   that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1).
   The path should only follow the streets.

   Notice that you are not allowed to change any street.

   Return true if there is a valid path in the grid or false otherwise.

   Example 1:
   Input: grid = [[2,4,3],[6,5,2]]
   Output: true
   Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).

   Example 2:
   Input: grid = [[1,2,1],[1,2,1]]
   Output: false
   Explanation: As shown you the street at cell (0, 0) is not connected with any street of any other cell and
   you will get stuck at cell (0, 0)

   Example 3:
   Input: grid = [[1,1,2]]
   Output: false
   Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).

   Constraints:
   m == grid.length
   n == grid[i].length
   1 <= m, n <= 300
   1 <= grid[i][j] <= 6
 */
import java.util.*;

class CheckIfThereIsAValidPathInAGrid {
    /***
        tile   | can got to
        ----------------------
        1     ->   left, right
        2     ->   up, down
        3     ->   left, down
        4     ->   down, right
        5     ->   left, up
        6     ->   up, right

        the current tile should be able to go fowrard
        and next tile should be able to go backward

    */
    private static Map<Integer, List<String>> mpp;
    private static int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    private static String[] dirNames, opposite;
    private static int m, n;
    private static boolean dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if (r == m - 1 && c == n - 1) return true;
        if (visited[r][c]) return false;
        visited[r][c] = true;
        for (int i = 0; i < dirs.length; ++i) {
            int[] d = dirs[i];
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                List<String> curr = mpp.get(grid[r][c]);
                List<String> next = mpp.get(grid[nr][nc]);
                String forward  = dirNames[i];
                String backward = opposite[i];
                if (curr.contains(forward) && next.contains(backward)) {
                    if (dfs(nr, nc, grid, visited)) return true;
                }
            }
        }
        return false;
    }
    private static boolean hasValidPath(int[][] grid) {
        mpp = new HashMap<>();
        mpp.put(1, new ArrayList<>(Arrays.asList("left", "right")));
        mpp.put(2, new ArrayList<>(Arrays.asList("up", "down")));
        mpp.put(3, new ArrayList<>(Arrays.asList("left", "down")));
        mpp.put(4, new ArrayList<>(Arrays.asList("down", "right")));
        mpp.put(5, new ArrayList<>(Arrays.asList("left", "up")));
        mpp.put(6, new ArrayList<>(Arrays.asList("up", "right")));

        dirNames = new String[] {"left", "right", "up", "down"};
        opposite = new String[] {"right", "left", "down", "up"};

        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, grid, visited);
    }
    public static void main(String[] args) {
        Log.info(hasValidPath(new int[][] {{2,4,3},{6,5,2}}));
        Log.info(hasValidPath(new int[][] {{1,2,1},{1,2,1}}));
        Log.info(hasValidPath(new int[][] {{1,1,2}}));
        Log.info(hasValidPath(new int[][] {{1}}));
    }
}
/**
    private static Map<String, Map<Integer, List<Integer>>> mpp;
    private static Map<String, String> translate;
    private static int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    private static int m, n;
    private static boolean dfs(int r, int c, int pr, int pc, int[][] grid, boolean[] visited) {
        if (r == m - 1 && c == n - 1) return true;
        if (visited[r * n + c]) return false;
        visited[r * n + c] = true;
        for (int[] d : dirs) {
            // nikalo direction
            String direction = translate.get(d[0] +","+d[1]);
            // mpp se lagnewala map nikalo
            Map<Integer, List<Integer>> map = mpp.get(direction);
            // m se required list nikalo
            List<Integer> list;
            if (map.containsKey(grid[r][c]))
                list = map.get(grid[r][c]);
            else continue;

            int nr = r + d[0];
            int nc = c + d[1];
            if (nr != pr || nc != pc) {
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {

                    for (int i = 0; i < list.size(); ++i) {
                        if (list.get(i) == grid[nr][nc]) {
                            if (nr == m-1 && nc == n-1)
                                return true;
                            else {
                                if (dfs(nr, nc, r, c, grid, visited))
                                    return true;
                            }
                        }
                    }

                }
            }
        }
        return false;
    }
    private static boolean hasValidPath(int[][] grid) {

        translate = new HashMap<>();
        translate.put("0,-1", "left");
        translate.put("0,1",  "right");
        translate.put("-1,0", "up");
        translate.put("1,0",  "down");
        mpp = new HashMap<>();
        // for left
        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        leftMap.put(1, new ArrayList<>(Arrays.asList(1,4,6)));
        leftMap.put(3, new ArrayList<>(Arrays.asList(1,4,6)));
        leftMap.put(5, new ArrayList<>(Arrays.asList(1,4,6)));
        mpp.put("left", leftMap);

        // for right
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        rightMap.put(1, new ArrayList<>(Arrays.asList(1,3,5)));
        rightMap.put(4, new ArrayList<>(Arrays.asList(1,3,5)));
        rightMap.put(6, new ArrayList<>(Arrays.asList(1,3,5)));
        mpp.put("right", rightMap);

        // for up
        Map<Integer, List<Integer>> upMap = new HashMap<>();
        upMap.put(2, new ArrayList<>(Arrays.asList(2,3,4)));
        upMap.put(5, new ArrayList<>(Arrays.asList(2,3,4)));
        upMap.put(6, new ArrayList<>(Arrays.asList(2,3,4)));
        mpp.put("up", upMap);

        // for down
        Map<Integer, List<Integer>> downMap = new HashMap<>();
        downMap.put(2, new ArrayList<>(Arrays.asList(2,5,6)));
        downMap.put(3, new ArrayList<>(Arrays.asList(2,5,6)));
        downMap.put(4, new ArrayList<>(Arrays.asList(2,5,6)));
        mpp.put("down", downMap);

        m = grid.length;
        n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        return dfs(0, 0, -1, -1, grid, visited);
    }
*/
