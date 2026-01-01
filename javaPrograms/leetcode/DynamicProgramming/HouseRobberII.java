/**
   213. House Robber II

   You are a professional robber planning to rob houses along a street.
   Each house has a certain amount of money stashed. All houses at this
   place are arranged in a circle. That means the first house is the
   neighbor of the last one. Meanwhile, adjacent houses have a security
   system connected, and it will automatically contact the police if two
   adjacent houses were broken into on the same night.

   Given an integer array nums representing the amount of money of each
   house, return the maximum amount of money you can rob tonight without
   alerting the police.

   Example 1:
   Input: nums = [2,3,2]
   Output: 3
   Explanation:
   You cannot rob house 1 (money = 2)
   and then rob house 3 (money = 2), because they are adjacent houses.

   Example 2:
   Input: nums = [1,2,3,1]
   Output: 4
   Explanation:
   rob house 1 (money = 1)
   and then rob house 3 (money = 3).
   Total amount you can rob = 1 + 3 = 4.

   Example 3:
   Input: nums = [1,2,3]
   Output: 3

   Constraints:
   1 <= nums.length <= 100
   0 <= nums[i] <= 1000
*/
import java.util.*;

class HouseRobberII {
    private static int solve(List<Integer> arr) {
        int n = arr.size();
        if (n == 1) return arr.get(0);
        int prev = arr.get(0);
        int prev2 = 0;
        for (int i = 1; i < n; ++i) {
            int pick = arr.get(i);
            if (i > 1) pick += prev2;
            int nonPick = prev;
            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    private static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i != 0) arr2.add(nums[i]);
            if (i != n - 1) arr1.add(nums[i]);
        }
        return Math.max(solve(arr1), solve(arr2));
    }
    public static void main(String[]args) {
        log.info(rob(new int[]{2,3,2}));
        log.info(rob(new int[]{1,2,3,1}));
        log.info(rob(new int[]{1,2,3}));
    }
}
