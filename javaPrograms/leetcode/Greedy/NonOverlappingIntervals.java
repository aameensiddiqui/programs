/**
   435. Non-overlapping Intervals

   Given an array of intervals intervals where intervals[i] = [starti, endi],
   return the minimum number of intervals you need to remove to make the rest
   of the intervals non-overlapping.

   Note that intervals which only touch at a point are non-overlapping.
   For example, [1, 2] and [2, 3] are non-overlapping.

   Example 1:
   Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
   Output: 1
   Explanation: [1,3] can be removed and the rest of the intervals are
   non-overlapping.

   Example 2:
   Input: intervals = [[1,2],[1,2],[1,2]]
   Output: 2
   Explanation: You need to remove two [1,2] to make the rest of the intervals
   non-overlapping.

   Example 3:
   Input: intervals = [[1,2],[2,3]]
   Output: 0
   Explanation: You don't need to remove any of the intervals since they're already
   non-overlapping.

   Constraints:
   1 <= intervals.length <= 105
   intervals[i].length == 2
   -5 * 104 <= starti < endi <= 5 * 104
 */
int eraseOverlapIntervals(int[][]intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int prevEnd = intervals[0][1];
    int cnt = 0;
    for(int i = 1; i < intervals.length; ++i) {
        if(intervals[i][0] < prevEnd) cnt++;
        else prevEnd = intervals[i][1];
    }
    return cnt;
}
void main() {
    Log log = new Log();
    int[][]arr1 = {{1,2},{2,3},{3,4},{1,3}};       // 1
    int[][]arr2 = {{1,2},{2,3}};                   // 0
    int[][]arr3 = {{1,3},{1,4},{3,5},{3,4},{4,5}}; // 2
    int[][]arr4 = {{1,100},{11,22},{1,11},{2,12}}; // 2
    
    log.info((Object)eraseOverlapIntervals(arr1));
    log.info((Object)eraseOverlapIntervals(arr2));
    log.info((Object)eraseOverlapIntervals(arr3));
    log.info((Object)eraseOverlapIntervals(arr4));
}
