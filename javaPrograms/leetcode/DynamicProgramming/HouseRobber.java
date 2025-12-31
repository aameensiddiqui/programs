/**
   198. House Robber

   You are a professional robber planning to rob houses along a street.
   Each house has a certain amount of money stashed, the only constraint
   stopping you from robbing each of them is that adjacent houses have
   security systems connected and it will automatically contact the police
   if two adjacent houses were broken into on the same night.

   Given an integer array nums representing the amount of money of each
   house, return the maximum amount of money you can rob tonight without
   alerting the police.

   Example 1:
   Input: nums = [1,2,3,1]
   Output: 4
   Explanation:
   rob house 1 (money = 1) and then
   rob house 3 (money = 3).
   Total amount you can rob = 1 + 3 = 4.

   Example 2:
   Input: nums = [2,7,9,3,1]
   Output: 12
   Explanation:
   rob house 1 (money = 2),
   rob house 3 (money = 9) and
   rob house 5 (money = 1).
   Total amount you can rob = 2 + 9 + 1 = 12.

   Constraints:
   1 <= nums.length <= 100
   0 <= nums[i] <= 400
*/
import java.util.Arrays;

class HouseRobber {
    private static int solve(int[] nums, int[] dp, int i) {
        if (i < 0) return 0;
        if (i == 0) return nums[0];
        if (dp[i] != -1) return dp[i];
        int pick    = nums[i] + solve(nums, dp, i - 2);
        int notpick = solve(nums, dp, i - 1);
        return dp[i] = Math.max(pick, notpick);
    }
    private static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, dp, nums.length - 1);
    }
    public static void main(String[]args) {
        log.info(rob(new int[]{1,2,3,1}));
        log.info(rob(new int[]{2,7,9,3,1}));
    }
}
