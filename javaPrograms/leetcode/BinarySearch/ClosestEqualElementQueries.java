/**
   3488. Closest Equal Element Queries

   You are given a circular array nums and an array queries.

   For each query i, you have to find the following:

   The minimum distance between the element at index queries[i] and any other index j in the
   circular array, where nums[j] == nums[queries[i]]. If no such index exists, the answer for
   that query should be -1.
   Return an array answer of the same size as queries, where answer[i] represents the result
   for query i.

   Example 1:
   Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]
   Output: [2,-1,3]
   Explanation:
   Query 0: The element at queries[0] = 0 is nums[0] = 1.
   The nearest index with the same value is 2, and the distance between them is 2.
   Query 1: The element at queries[1] = 3 is nums[3] = 4.
   No other index contains 4, so the result is -1.
   Query 2: The element at queries[2] = 5 is nums[5] = 3.
   The nearest index with the same value is 1, and the distance between them is 3
   (following the circular path: 5 -> 6 -> 0 -> 1).

   Example 2:
   Input: nums = [1,2,3,4], queries = [0,1,2,3]
   Output: [-1,-1,-1,-1]
   Explanation:
   Each value in nums is unique, so no index shares the same value as the queried element.
   This results in -1 for all queries.

   Constraints:
   1 <= queries.length <= nums.length <= 105
   1 <= nums[i] <= 106
   0 <= queries[i] < nums.length
*/
import java.util.*;

class ClosestEqualElementQueries {
    private static List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            mpp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (int q : queries) {
            List<Integer> v = mpp.get(nums[q]);
            if (v.size() == 1) {
                ans.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(v, q);
            int res = Integer.MAX_VALUE;

            int left = v.get((pos - 1 + v.size()) % v.size());
            int d1 = Math.abs(q - left);
            res = Math.min(res, Math.min(d1, n - d1));

            int right = v.get((pos + 1) % v.size());
            int d2 = Math.abs(q - right);
            res = Math.min(res, Math.min(d2, n - d2));

            ans.add(res);
        }
        return ans;
    }
    public static void main(String[] args) {
        Log.info(solveQueries(new int[] {1,3,1,4,1,3,2}, new int[] {0,3,5}));
        Log.info(solveQueries(new int[] {1,2,3,4}, new int[] {0,1,2,3}));
    }
}
/**
    // TLE
    private static int fun(int[] nums, int x) {
        int n = nums.length;
        int res = n;
        int target = nums[x];
        for (int i = 0; i < n; ++i) {
            if (i == x) continue;
            if (nums[i] == target) {
                int dist = Math.abs(i - x);
                res = Math.min(res, Math.min(dist, n - dist));
            }
        }
        return res < n ? res : -1;
    }
    private static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.length; ++i) {
            int z = fun(nums, queries[i]);
            list.add(z);
        }
        return list;
    }
*/
