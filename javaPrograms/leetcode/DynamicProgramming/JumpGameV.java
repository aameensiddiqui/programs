/**
   1340. Jump Game V

   Given an array of integers arr and an integer d. In one step you can jump from index i to index:

   i + x where: i + x < arr.length and  0 < x <= d.
   i - x where: i - x >= 0 and  0 < x <= d.
   In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for
   all indices k between i and j (More formally min(i, j) < k < max(i, j)).

   You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.

   Notice that you can not jump outside of the array at any time.

   Example 1:
   Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
   Output: 4
   Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
   Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9.
   You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
   Similarly You cannot jump from index 3 to index 2 or index 1.

   Example 2:
   Input: arr = [3,3,3,3,3], d = 3
   Output: 1
   Explanation: You can start at any index. You always cannot jump to any index.

   Example 3:
   Input: arr = [7,6,5,4,3,2,1], d = 1
   Output: 7
   Explanation: Start at index 0. You can visit all the indicies.
   Constraints:
   1 <= arr.length <= 1000
   1 <= arr[i] <= 105
   1 <= d <= arr.length
*/
class JumpGameV {
    private static int[] dp;
    private static int n;
    private static int dfs(int id, int d, int[] arr) {
        if (dp[id] != 0) return dp[id];
        int mx = 1;
        for (int i = id + 1;
             i <= Math.min(n - 1, id + d) && arr[id] > arr[i];
             ++i) {
            mx = Math.max(mx, 1 + dfs(i, d, arr));
        }
        for (int i = id - 1;
             i >= Math.max(0, id - d) && arr[id] > arr[i];
             --i) {
            mx = Math.max(mx, 1 + dfs(i, d, arr));
        }
        return dp[id] = mx;
    }
    private static int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new int[n];
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dfs(i, d, arr));
        }
        return ans;
    }
    public static void main(String[] args) {
        log.info(maxJumps(new int[] {6,4,14,6,8,13,9,7,10,6,12}, 2));
        log.info(maxJumps(new int[] {3,3,3,3,3}, 3));
        log.info(maxJumps(new int[] {7,6,5,4,3,2,1}, 1));
    }
}
/**
   We use dp[i] to represent the maximum number of indices that can be visited starting from position i.
   We can write the following state transition equation:

   dp[i] = max(dp[j]) + 1

   where j must satisfy the following three conditions:

   0 <= j < arr.length, meaning that j must lie within the bounds of the array arr;

   i - d <= j <= i + d, meaning that the distance between i and j cannot exceed the given value d;

   Every element between arr[i] and arr[j] must be smaller than arr[i], as required by the problem statement.

   For any position i, according to the second condition, we only need to scan at most d elements on both
   sides to find all valid positions j. Then, we can use the dp[j] values of these positions to perform state
   transitions and compute dp[i].

   However, an important problem remains: how do we ensure that all valid positions j have already been processed
   before computing dp[i]? In other words, how can we guarantee that the required dp[j] values have already been
   calculated?

   Traditional dynamic programming approaches cannot guarantee this because the valid positions j may appear on
   both sides of position i. Therefore, we use memoized search.

   With memoized search, whenever we need dp[j]:

   if it has already been computed, we directly reuse the stored value;

   otherwise, we temporarily pause the computation of dp[i], recursively compute dp[j], and then use the result to
   update dp[i].

   Now we need to determine whether this recursive process can always terminate within finite time. If it cannot
   terminate, that would imply the existence of a cycle. For example, while computing dp[i], we may need dp[j];
   while computing dp[j], we may need dp[k]; and eventually, some state may depend on dp[i] again, forming a cycle.

   However, such a cycle cannot occur in this problem. According to the third condition, arr[j] must always be smaller
   than arr[i]. This means that each recursive step always moves to a strictly smaller value. Therefore, revisiting the
   same state is impossible, and the search process must terminate.

   As a result, we can compute all dp values using memoized search with the same time complexity as standard dynamic
   programming.
*/
