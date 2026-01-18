/**
   377. Combination Sum IV

   Given an array of distinct integers nums and a target integer target,
   return the number of possible combinations that add up to target.

   The test cases are generated so that the answer can fit in a 32-bit integer.

   Example 1:
   Input: nums = [1,2,3], target = 4
   Output: 7
   Explanation:
   The possible combination ways are:
   (1, 1, 1, 1)
   (1, 1, 2)
   (1, 2, 1)
   (1, 3)
   (2, 1, 1)
   (2, 2)
   (3, 1)
   Note that different sequences are counted as different combinations.

   Example 2:
   Input: nums = [9], target = 3
   Output: 0

   Constraints:
   1 <= nums.length <= 200
   1 <= nums[i] <= 1000
   All the elements of nums are unique.
   1 <= target <= 1000
*/
import java.util.*;

class CombinationSumIV {
    // dp bottom-up
    // O(nums.length * target)
    private static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int total = 1; total <= target; ++total) {
            dp.put(total, 0);
            for (int n : nums) {
                dp.put(total, dp.get(total) + dp.getOrDefault(total - n, 0));
            }
        }
        return dp.get(target);
    }
    public static void main(String[]args) {
        log.info(combinationSum4(new int[]{1,2,3}, 4));  // 7
        log.info(combinationSum4(new int[]{9}, 3));      // 0
        log.info(combinationSum4(new int[]{2,1,3}, 35)); // 1132436852
    }
}
/**
    // dp top-down
    // O(nums.length * target)
    private static Map<Integer, Integer> memo;
    private static int dfs(int[] nums, int total) {
        if (memo.containsKey(total)) return memo.get(total);
        int res = 0;
        for (int n : nums) {
            if (total < n) break;
            res += dfs(nums, total - n);
        }
        memo.put(total, res);
        return res;
    }
    private static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(nums, target);
    }
*/
/**
    // recursive
    // O(nums.length^target)
    private static int dfs(int[] nums, int total) {
        if (total == 0) return 1;
        int res = 0;
        for (int n : nums) {
            if (total < n) break;
            res += dfs(nums, total - n);
        }
        return res;
    }
    private static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, target);
    }
*/
