/**
   1674. Minimum Moves to Make Array Complementary

   You are given an integer array nums of even length n and an integer limit. In one move,
   you can replace any integer from nums with another integer between 1 and limit, inclusive.

   The array nums is complementary if for all indices i (0-indexed), nums[i] + nums[n - 1 - i]
   equals the same number. For example, the array [1,2,3,4] is complementary because for all
   indices i, nums[i] + nums[n - 1 - i] = 5.

   Return the minimum number of moves required to make nums complementary.

   Example 1:
   Input: nums = [1,2,4,3], limit = 4
   Output: 1
   Explanation: In 1 move, you can change nums to [1,2,2,3] (underlined elements are changed).
   nums[0] + nums[3] = 1 + 3 = 4.
   nums[1] + nums[2] = 2 + 2 = 4.
   nums[2] + nums[1] = 2 + 2 = 4.
   nums[3] + nums[0] = 3 + 1 = 4.
   Therefore, nums[i] + nums[n-1-i] = 4 for every i, so nums is complementary.

   Example 2:
   Input: nums = [1,2,2,1], limit = 2
   Output: 2
   Explanation: In 2 moves, you can change nums to [2,2,2,2]. You cannot change any number to 3
   since 3 > limit.

   Example 3:
   Input: nums = [1,2,1,2], limit = 2
   Output: 0
   Explanation: nums is already complementary.

   Constraints:
   n == nums.length
   2 <= n <= 105
   1 <= nums[i] <= limit <= 105
   n is even.
*/
import java.util.*;

class MinimumMovesToMakeArrayComplementary {
    private static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; ++i) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            diff[2] += 2;
            diff[a + 1] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
            diff[b + limit + 1] += 1;
        }
        int minOperations = n;
        int curOperations = 0;
        for (int i = 2; i <= 2 * limit; ++i) {
            curOperations += diff[i];
            minOperations = Math.min(minOperations, curOperations);
        }
        return minOperations;
    }
    public static void main(String[] args) {
        Log.info(minMoves(new int[] {1,2,4,3}, 4));
        Log.info(minMoves(new int[] {1,2,2,1}, 2));
        Log.info(minMoves(new int[] {1,2,1,2}, 2));
    }
}
/**
    private static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        Map<Integer, Integer> sumCount = new HashMap<>();
        int[] minArr = new int[n / 2];
        int[] maxArr = new int[n / 2];
        for (int i = 0; i < n / 2; ++i) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            sumCount.merge(a + b, 1, Integer::sum);
            minArr[i] = a;
            maxArr[i] = b;
        }
        Arrays.sort(minArr);
        Arrays.sort(maxArr);
        int minOps = n;
        for (int i = 2; i <= 2 * limit; ++i) {
            int addLeft = n / 2 - lowerBound(minArr, i);
            int addRight = lowerBound(maxArr, i - limit);
            int currentOps = 
                n / 2 + 
                addLeft + 
                addRight - 
                sumCount.getOrDefault(i, 0);
            minOps = Math.min(minOps, currentOps);
        }
        return minOps;
    }
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
*/
