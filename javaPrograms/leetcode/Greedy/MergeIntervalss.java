/**
   56. Merge Intervals

   Given an array of intervals where intervals[i] = [starti, endi], merge all
   overlapping intervals, and return an array of the non-overlapping intervals
   that cover all the intervals in the input.

   Example 1:
   Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
   Output: [[1,6],[8,10],[15,18]]
   Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

   Example 2:
   Input: intervals = [[1,4],[4,5]]
   Output: [[1,5]]
   Explanation: Intervals [1,4] and [4,5] are considered overlapping.

   Example 3:
   Input: intervals = [[4,7],[1,4]]
   Output: [[1,7]]
   Explanation: Intervals [1,4] and [4,7] are considered overlapping.

   Constraints:
   1 <= intervals.length <= 104
   intervals[i].length == 2
   0 <= starti <= endi <= 104
 */
import java.util.*;

int[][] merge(int[][]intervals) {

    List<int[]> list = new ArrayList<>();

    if(intervals[0].length == 0 || intervals == null)
        return list.toArray(new int[0][]);

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    int start = intervals[0][0];
    int end   = intervals[0][1];

    for(int[]i : intervals) {
        if(i[0] <= end) end = Math.max(end, i[1]);
        else {
            list.add(new int[]{start, end});
            start = i[0];
            end   = i[1];
        }
    }
    list.add(new int[]{start, end});

    return list.toArray(new int[0][]);
}
void main() {
    Log log = new Log();
    int[][]arr = {{4,7},{2,6},{8,10},{15,18}};
    log.info((Object) merge(arr));
}
