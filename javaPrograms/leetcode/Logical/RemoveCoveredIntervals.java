/**
   1288. Remove Covered Intervals

   Given an array intervals where intervals[i] = [li, ri] represent the
   interval [li, ri), remove all intervals that are covered by another
   interval in the list.

   The interval [a, b) is covered by the interval [c, d) if and only if c <= a
   and b <= d.

   Return the number of remaining intervals.

   Example 1:
   Input: intervals = [[1,4],[3,6],[2,8]]
   Output: 2
   Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

   Example 2:
   Input: intervals = [[1,4],[2,3]]
   Output: 1

   Constraints:
   1 <= intervals.length <= 1000
   intervals[i].length == 2
   0 <= li < ri <= 105
   All the given intervals are unique
*/
class RemoveCoveredIntervals {
    private static int removeCoveredA(int[][] A) {
        int n = A.length;
        int res = n;
        for (int i = 0; i < n; ++i) {
            int a = A[i][0], b = A[i][1];
            for (int j = 0; j < n; ++j) {
                if (j == i) continue;
                int c = A[j][0], d = A[j][1];
                if (c <= a && b <= d) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Log.info(removeCoveredA(new int[][] {{1,4},{3,6},{2,8}})); // 2
        Log.info(removeCoveredA(new int[][] {{1,4},{2,3}}));       // 1
        Log.info(removeCoveredA(new int[][] {{34335,39239},
                                             {15875,91969},
                                             {29673,66453},
                                             {53548,69161},
                                             {40618,93111}}));     // 2
    }
}
