/**
   3532. Path Existence Queries in a Graph I

   You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.

   You are also given an integer array nums of length n sorted in non-decreasing order, and an integer
   maxDiff.

   An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j]
   is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).

   You are also given a 2D integer array queries. For each queries[i] = [ui, vi], determine whether there
   exists a path between nodes ui and vi.

   Return a boolean array answer, where answer[i] is true if there exists a path between ui and vi in the
   ith query and false otherwise.

   Example 1:
   Input: n = 2, nums = [1,3], maxDiff = 1, queries = [[0,0],[0,1]]
   Output: [true,false]
   Explanation:
   Query [0,0]: Node 0 has a trivial path to itself.
   Query [0,1]: There is no edge between Node 0 and Node 1 because |nums[0] - nums[1]| = |1 - 3| = 2,
   which is greater than maxDiff.
   Thus, the final answer after processing all the queries is [true, false].

   Example 2:
   Input: n = 4, nums = [2,5,6,8], maxDiff = 2, queries = [[0,1],[0,2],[1,3],[2,3]]
   Output: [false,false,true,true]
   Explanation:
   The resulting graph is:
   Query [0,1]: There is no edge between Node 0 and Node 1 because |nums[0] - nums[1]| = |2 - 5| = 3,
   which is greater than maxDiff.
   Query [0,2]: There is no edge between Node 0 and Node 2 because |nums[0] - nums[2]| = |2 - 6| = 4,
   which is greater than maxDiff.
   Query [1,3]: There is a path between Node 1 and Node 3 through Node 2 since
   |nums[1] - nums[2]| = |5 - 6| = 1 and |nums[2] - nums[3]| = |6 - 8| = 2, both of which are within
   maxDiff.
   Query [2,3]: There is an edge between Node 2 and Node 3 because |nums[2] - nums[3]| = |6 - 8| = 2,
   which is equal to maxDiff.
   Thus, the final answer after processing all the queries is [false, false, true, true].

   Constraints:
   1 <= n == nums.length <= 105
   0 <= nums[i] <= 105
   nums is sorted in non-decreasing order.
   0 <= maxDiff <= 105
   1 <= queries.length <= 105
   queries[i] == [ui, vi]
   0 <= ui, vi < n
*/
class PathExistenceQueriesInAGraphI {
    private static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        boolean[] res = new boolean[queries.length];
        int compNo = 0, index = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > maxDiff) compNo++;
            component[i] = compNo; 
        }
        for (int[] q : queries) {
            res[index++] = component[q[0]] == component[q[1]];
        }
        return res;
    }
    public static void main(String[] args) {
        log.info(pathExistenceQueries(2, new int[] {1,3}, 1, new int[][] {{0,0},{0,1}}));
        log.info(pathExistenceQueries(4, new int[] {2,5,6,8}, 2, new int[][] {{0,1},{0,2},{1,3},{2,3}}));
    }
}
/**
    private static boolean[][] dp;
    private static boolean func(int a, int b, int n) {
        // ???????
    }
    private static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[n];
        dp = new boolean[n][n];
        List<Integer> list = new ArrayList<>();
        for (int[] arr : queries) {
            if (!list.contains(arr[0])) list.add(arr[0]);
            if (!list.contains(arr[1])) list.add(arr[1]);
        }
        for (int i = 1; i < list.size(); ++i) {
            if (Math.abs(nums[list.get(i)] - nums[list.get(i - 1)]) <= maxDiff) {
                dp[list.get(i)][list.get(i - 1)] = true;
            }
        }
        // now iterate queries to check if mpp has those values
        // check if the values between them also are mpp
        int index = 0;
        for (int[] q : queries) {
            if (q[0] == q[1]) {
                res[index] = true;
            } else if (dp[q[0]][q[1]] || dp[q[1]][q[0]]) {
                res[index] = true;
            } else if (Math.abs(q[1] - q[0]) > 1 && func(q[0], q[1], n)) {
                res[index] = true;
            } else {
                res[index] = false;
            }
            index++;
        }
        return res;
    }
*/
