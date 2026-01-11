import java.util.Arrays;

class LongestIncreasingSubsequence {
    // dp (bottom-up) - II (tc: O(n^2) sc: O(n))
    private static int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        for (int i = nums.length; i >= 0; --i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] < nums[j])
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
            }
        }
        Arrays.sort(LIS);
        // return LIS[nums.length - 1];
        return Arrays.stream(LIS).max().getAsInt();
    }
    public static void main(String[]args) {
        log.info(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        log.info(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        log.info(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
/**
    // dp (bottom-up) - I (tc: O(n^2) sc: O(n^2))
    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i - 1; j >= -1; --j) {
                int LIS = dp[i + 1][j + 1];
                if (j == -1 || nums[j] < nums[i])
                    LIS = Math.max(LIS, 1 + dp[i + 1][i + 1]);
                dp[i][j + 1] = LIS;
            }
        }
        return dp[0][0];
    }
*/
/**
    // dp (top-down) - II (tc: O(n^2) sc: O(n))
    private static int[] memo;
    private static int dfs(int[] nums, int i) {
        if (i == nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        int LIS = 1;
        for (int j = i + 1; j < nums.length; ++j) {
            if (nums[i] < nums[j])
                LIS = Math.max(LIS, 1 + dfs(nums, j));
        }
        memo[i] = LIS;
        return LIS;
    }
    private static int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int LIS = 1;
        for (int i = 0; i < nums.length; ++i)
            LIS = Math.max(LIS, dfs(nums, i));
        return LIS;
    }
*/
/**
    // dp (top-down) - I (tc: O(n^2) sc: O(n^2))
    private static int[][] memo;
    private static int dfs(int[] nums, int i, int j) {
        if (i == nums.length) return 0;
        if (memo[i][j + 1] != -1) return memo[i][j + 1];
        int LIS = dfs(nums, i + 1, j);
        if (j == -1 || nums[j] < nums[i])
            LIS = Math.max(LIS, 1 + dfs(nums, i + 1, i));
        memo[i][j + 1] = LIS;
        return LIS;
    }
    private static int lengthOfLIS(int[] nums) {
        memo = new int[nums.length][nums.length + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(nums, 0, -1);
    }
*/
/**
    // recursive solution (tc: O(2^n) sc: O(n))
    private static int dfs(int[] nums, int i, int j) {
        if (i == nums.length) return 0;
        int LIS = dfs(nums, i + 1, j);
        if (j == -1 || nums[j] < nums[i])
            LIS = Math.max(LIS, 1 + dfs(nums, i + 1, i));
        return LIS;
    }
    private static int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, -1);
    }
*/
