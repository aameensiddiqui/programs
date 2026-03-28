/**
   494. Target Sum

   You are given an integer array nums and an integer target.

   You want to build an expression out of nums by adding one of the symbols '+' and '-'
   before each integer in nums and then concatenate all the integers.

   For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate
   them to build the expression "+2-1".
   Return the number of different expressions that you can build, which evaluates to target.

   Example 1:
   Input: nums = [1,1,1,1,1], target = 3
   Output: 5
   Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
   -1 + 1 + 1 + 1 + 1 = 3
   +1 - 1 + 1 + 1 + 1 = 3
   +1 + 1 - 1 + 1 + 1 = 3
   +1 + 1 + 1 - 1 + 1 = 3
   +1 + 1 + 1 + 1 - 1 = 3

   Example 2:
   Input: nums = [1], target = 1
   Output: 1

   Constraints:
   1 <= nums.length <= 20
   0 <= nums[i] <= 1000
   0 <= sum(nums[i]) <= 1000
   -1000 <= target <= 1000
*/

import java.util.Arrays;

class TargetSum {
    private static int totalSum;
    private static int[][] dp;
    private static int backtrack(int i, int total, int[] nums, int target) {
        if (i == nums.length) return total== target ? 1 : 0;
        if (dp[i][total+ totalSum] != Integer.MIN_VALUE)
            return dp[i][total+ totalSum];
        return dp[i][total+ totalSum] =
            backtrack(i + 1, total+ nums[i], nums, target) +
            backtrack(i + 1, total- nums[i], nums, target);
    }
    private static int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        dp = new int[nums.length][2 * totalSum + 1];
        for (int[] arr : dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return backtrack(0, 0, nums, target);
    }
    public static void main(String[]args) {
        log.info(findTargetSumWays(new int[] {1,1,1,1,1}, 3));
        log.info(findTargetSumWays(new int[] {1}, 1));
    }
}
/**
    private static int backtrack(int i, int total, int[] nums, int target) {
        if (i == nums.length) return total == target ? 1 : 0;
        return backtrack(i + 1, total+ nums[i], nums, target) +
            backtrack(i + 1, total- nums[i], nums, target);
    }
    private static int findTargetSumWays(int[] nums, int target) {
        return backtrack(0, 0, nums, target);
    }
*/
