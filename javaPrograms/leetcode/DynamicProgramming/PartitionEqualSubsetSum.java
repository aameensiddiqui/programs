/**
   416. Partition Equal Subset Sum

   Given an integer array nums, return true if you can partition the array into
   two subsets such that the sum of the elements in both subsets is equal or
   false otherwise.

   Example 1:
   Input: nums = [1,5,11,5]
   Output: true
   Explanation: The array can be partitioned as [1, 5, 5] and [11].

   Example 2:
   Input: nums = [1,2,3,5]
   Output: false
   Explanation: The array cannot be partitioned into equal sum subsets.

   Constraints:
   1 <= nums.length <= 200
   1 <= nums[i] <= 100
*/
import java.util.*;

class PartitionEqualSubsetSum {
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = nums.length - 1; i >= 0; --i) {
            Set<Integer> nextDP = new HashSet<>();
            for (int t : dp) {
                if (t + nums[i] == target) return true;
                nextDP.add(t + nums[i]);
                nextDP.add(t);
            }
            dp = nextDP;
        }
        return false;
    }
    public static void main(String[]args) {
        log.info(canPartition(new int[]{1,5,11,5})); // true
        log.info(canPartition(new int[]{1,2,3,5}));  // false
        log.info(canPartition(new int[]{2,2,3,5}));  // false
        log.info(canPartition(new int[]{1,5,11,5})); // true
        log.info(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,100,100,100,100,100,100,
                                        100,100,100,100,100,100,99,97})); // false
    }
}
/**
    private static Boolean[][] memo;
    private static boolean dfs(int[] nums, int i, int target) {
        log.info("*********************");
        log.info((Object[]) memo);
        if (i == nums.length) return target == 0;
        if (target < 0) return false;
        if (memo[i][target] != null) return memo[i][target];
        memo[i][target] = dfs(nums, i + 1, target) || dfs(nums, i + 1, target - nums[i]);
        return memo[i][target];
    }
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        memo = new Boolean[nums.length][sum / 2 + 1];
        return dfs(nums, 0, sum / 2);
    }
*/
/**
    // recursive brute
    private static boolean dfs(int[] nums, int i, int target) {
        if (i == nums.length) return target == 0;
        if (target < 0) return false;
        return dfs(nums, i + 1, target) || dfs(nums, i + 1, target - nums[i]);
    }
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        return dfs(nums, 0, sum / 2);
    }
*/
