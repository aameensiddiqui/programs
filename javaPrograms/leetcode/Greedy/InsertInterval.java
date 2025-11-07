/**
   57. Insert Interval

   You are given an array of non-overlapping intervals intervals where
   intervals[i] = [starti, endi] represent the start and the end of the
   ith interval and intervals is sorted in ascending order by starti.
   You are also given an interval newInterval = [start, end] that represents
   the start and end of another interval.

   Insert newInterval into intervals such that intervals is still sorted
   in ascending order by starti and intervals still does not have any
   overlapping intervals (merge overlapping intervals if necessary).

   Return intervals after the insertion.

   Note that you don't need to modify intervals in-place.
   You can make a new array and return it.

   Example 1:
   Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
   Output: [[1,5],[6,9]]

   Example 2:
   Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
   Output: [[1,2],[3,10],[12,16]]
   Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

   Constraints:
   0 <= intervals.length <= 104
   intervals[i].length == 2
   0 <= starti <= endi <= 105
   intervals is sorted by starti in ascending order.
   newInterval.length == 2
   0 <= start <= end <= 105
*/
import java.util.*;

int[][] insert(int[][]intervals, int[]newInterval) {
    int i = 0, n = intervals.length;
    if(n == 0) return new int[][] {newInterval};
    List<int[]> list = new ArrayList<>();

    // left
    while(i < n && intervals[i][1] < newInterval[0]) {
        list.add(intervals[i]);
        i++;
    }

    // mid to change
    // if we don't have any overlaps add directly
    if(i == n || intervals[i][0] > newInterval[1]) list.add(newInterval);
    else {
        int start = Math.min(newInterval[0], intervals[i][0]);
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
    }

    // right
    while(i < n) {
        list.add(intervals[i]);
        i++;
    }
    return list.toArray(new int[list.size()][]);
}
void main() {
    int[][]intervals1 = {{1, 3}, {6, 9}};
    int[]newInterval1 = {2, 5};
    int[][]intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[]newInterval2 = {4, 8};

    Log log = new Log();
    log.info("Before: -----------------------------", (Object)intervals1, newInterval1);
    log.info("After: ------------------------------");
    log.info((Object)insert(intervals1, newInterval1));
    log.info("Before: -----------------------------", (Object)intervals2, newInterval2);
    log.info("After: ------------------------------");
    log.info((Object)insert(intervals2, newInterval2));
}
/**
   int[][] insert(int[][]intervals, int[]newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0, n = intervals.length;

        // left
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // mid to change
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        // right
        while(i < n) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
   }
 */
