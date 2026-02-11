/**
   368. Largest Divisible Subset

   Given a set of distinct positive integers nums, return the largest subset
   answer such that every pair (answer[i], answer[j]) of elements in this
   subset satisfies:

   answer[i] % answer[j] == 0, or
   answer[j] % answer[i] == 0
   If there are multiple solutions, return any of them.

   Example 1:
   Input: nums = [1,2,3]
   Output: [1,2]
   Explanation: [1,3] is also accepted.

   Example 2:
   Input: nums = [1,2,4,8]
   Output: [1,2,4,8]

   Constraints:
   1 <= nums.length <= 1000
   1 <= nums[i] <= 2 * 109
   All the integers in nums are unique.
*/
import java.util.*;

class LargestDivisibleSubset {
    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; ++i) dp.add(new ArrayList<>());
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; --i) {
            dp.get(i).clear();
            dp.get(i).add(nums[i]);
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] % nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.addAll(dp.get(j));
                    if (tmp.size() > dp.get(i).size()) dp.set(i, tmp);
                }
            }
            if (dp.get(i).size() > res.size()) res = dp.get(i);
        }
        return res;
    }
    public static void main(String[]args) {
        log.info(largestDivisibleSubset(new int[]{1,2,3}));
        log.info(largestDivisibleSubset(new int[]{1,2,4,8}));
        log.info(largestDivisibleSubset(new int[]{1,2,45,15,5}));
        log.info(largestDivisibleSubset(new int[]{3,4,16,8}));
    }
}
/**
    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[n];
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] % nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.addAll(dp[j]);
                    if (tmp.size() > dp[i].size()) dp[i] = tmp;
                }
            }
            if (dp[i].size() > res.size()) res = dp[i];
        }
        return res;
    }
*/
/**
    private static List<Integer>[][] cache;
    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        cache = new ArrayList[n][n + 1];
        return dfs(0, -1, nums);
    }
    private static List<Integer> dfs(int i, int prevIndex, int[] nums) {
        if (i == nums.length) return new ArrayList<>();
        if (cache[i][prevIndex + 1] != null) return cache[i][prevIndex + 1];
        List<Integer> res = dfs(i + 1, prevIndex, nums);
        if (prevIndex == -1 || nums[i] % nums[prevIndex] == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            tmp.addAll(dfs(i + 1, i, nums));
            if (tmp.size() > res.size()) res = tmp;
        }
        cache[i][prevIndex + 1] = res;
        return res;
    }
*/
