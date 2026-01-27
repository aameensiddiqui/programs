/**
   354. Russian Doll Envelopes

   You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
   represents the width and the height of an envelope.

   One envelope can fit into another if and only if both the width and height of
   one envelope are greater than the other envelope's width and height.

   Return the maximum number of envelopes you can Russian doll (i.e., put one
   inside the other).

   Note: You cannot rotate an envelope.

   Example 1:
   Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
   Output: 3
   Explanation: The maximum number of envelopes you can Russian doll is 3
   ([2,3] => [5,4] => [6,7]).

   Example 2:
   Input: envelopes = [[1,1],[1,1],[1,1]]
   Output: 1

   Constraints:
   1 <= envelopes.length <= 105
   envelopes[i].length == 2
   1 <= wi, hi <= 105
*/
import java.util.*;

class RussianDollEnvelopes {
    // bottom up with binary search
    private static int maxEnvelopes(int[][] E) {
        int n = E.length;
        if (n == 0) return 0;
        // sorting E by width ascending, height descending for equal widths
        Arrays.sort(E, (a, b) -> a[0] != b[0]
                    ? a[0] - b[0]
                    : b[1] - a[1]
                    );
        int[] h = new int[n];
        for (int i = 0; i < n; ++i) h[i] = E[i][1];
        int LIS = 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(h[0]);
        for (int i = 1; i < n; ++i) {
            if (dp.get(dp.size() - 1) < h[i]) {
                dp.add(h[i]);
                LIS++;
                continue;
            }
            int index = Collections.binarySearch(dp, h[i]);
            if (index < 0) index = -index - 1;
            dp.set(index, h[i]);
        }
        return LIS;
    }
    public static void main(String[]args) {
        log.info(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));                                                 // 3
        log.info(maxEnvelopes(new int[][]{{1,1},{1,1},{1,1}}));                                                       // 1
        log.info(maxEnvelopes(new int[][]{{4,5},{6,7},{2,3}}));                                                       // 3
        log.info(maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}));                                           // 4
        log.info(maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}}));                   // 7
        log.info(maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}})); // 5
        log.info(maxEnvelopes(new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},
                                      {2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}})); // 5
    }
}
/**
    // bottom up
    private static int maxEnvelopes(int[][] E) {
        int n = E.length;
        if (n == 0) return 0;
        // sorting E by width ascending, height descending for equal widths
        Arrays.sort(E, (a, b) -> a[0] != b[0]
                    ? a[0] - b[0]
                    : b[1] - a[1]
                    );
        int[] h = new int[n];
        for (int i = 0; i < n; ++i) h[i] = E[i][1];
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int res = 0;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (h[i] < h[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
            res = Math.max(res, LIS[i]);
        }
        return res;
    }
*/
/**
    // top down
    private static int dfs(int[] nums, int i, int[] memo) {
        if (memo[i] != -1) return memo[i];
        int lis = 1;
        for (int j = i + 1; j < nums.length; ++j) {
            if (nums[i] < nums[j]) {
                lis = Math.max(lis, 1 + dfs(nums, j, memo));
            }
        }
        memo[i] = lis;
        return lis;
    }
    private static int maxEnvelopes(int[][] E) {
        int n = E.length;
        if (n == 0) return 0;

        // sorting E by width ascending, height descending for equal widths
        Arrays.sort(E, (a, b) -> a[0] != b[0]
                    ? Integer.compare(a[0], b[0])
                    : Integer.compare(b[1], a[1])
                    );
        int[] h = new int[n];
        for (int i = 0; i < n; ++i) h[i] = E[i][1];
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int res = 0;
        for (int i = 0; i < n; ++i) res = Math.max(res, dfs(h, i, memo));
        return res;
    }
*/
/**
   // its something...but its mine. not correct. 50/87 tests passed.
   // has major flaw. it is not storing the best chain. it allows invalid jumps.
   // suppose stack is:
   // (2, 3) -> (3, 4)
   // now we see: (4,100)
   // it fits so we push it
   // but later we see (5, 5)
   // it should have fit (3, 4) but it gets skipped.
   // hence wrong.

class Pair {
    int one;
    int two;
    Pair(int one, int two) {
        this.one = one;
        this.two = two;
    }
}
class RussianDollEnvelopes {
    private static int maxEnvelopes(int[][] E) {
        int n = E.length;
        int maxEnv = 0;
        log.info((Object) E);
        Arrays.sort(E, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        log.info((Object) E);
        maxEnv = a(E, n);
        Arrays.sort(E, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        maxEnv = Math.max(maxEnv, a(E, n));
        return maxEnv;
    }
    private static int a(int[][] E, int n) {
        int maxEnv = 0;
        for (int i = 0; i < n; ++i) {
            Stack<Pair> st = new Stack<>();
            int a = E[i][0];
            int b = E[i][1];
            st.push(new Pair(a, b));
            for (int j = i + 1; j < n; ++j) {
                // if (i == j) continue;
                Pair p = st.peek();
                // log.info("p.one = "+p.one+"    p.two = "+p.two+"     E[j][0] = "+
                // E[j][0]+"    E[j][1] = "+E[j][1]+"    st.size() = "+st.size());
                if (p.one < E[j][0] && p.two < E[j][1])
                    st.push(new Pair(E[j][0], E[j][1]));
            }
            maxEnv = Math.max(maxEnv, st.size());
        }
        return maxEnv;
    }
}
*/
/**
    private static int maxEnvelopes(int[][] E) {
        int n = E.length;
        Arrays.sort(E, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int maxEnv = 0;
        for (int i = 0; i < n; ++i) {
            Stack<Pair> st = new Stack<>();
            int a = E[i][0];
            int b = E[i][1];
            st.push(new Pair(a, b));
            for (int j = i + 1; j < n; ++j) {
                // if (i == j) continue;
                Pair p = st.peek();
                // log.info("p.one = "+p.one+"    p.two = "+p.two+"     E[j][0] = "+
                // E[j][0]+"    E[j][1] = "+E[j][1]+"    st.size() = "+st.size());
                if (p.one < E[j][0] && p.two < E[j][1])
                    st.push(new Pair(E[j][0], E[j][1]));
            }
            maxEnv = Math.max(maxEnv, st.size());
        }
        return maxEnv;
    }
*/
