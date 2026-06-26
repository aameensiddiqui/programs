/**
   3739. Count Subarrays With Majority Element II

   You are given an integer array nums and an integer target.
   Return the number of subarrays of nums in which target is the majority element.
   The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.

   Example 1:
   Input: nums = [1,2,2,3], target = 2
   Output: 5
   Explanation:
   Valid subarrays with target = 2 as the majority element:
   nums[1..1] = [2]
   nums[2..2] = [2]
   nums[1..2] = [2,2]
   nums[0..2] = [1,2,2]
   nums[1..3] = [2,2,3]
   So there are 5 such subarrays.

   Example 2:
   Input: nums = [1,1,1,1], target = 1
   Output: 10
   Explanation:
   All 10 subarrays have 1 as the majority element.

   Example 3:
   Input: nums = [1,2,3], target = 4
   Output: 0
   Explanation:
   target = 4 does not appear in nums at all. Therefore, there cannot be any subarray where 4 is the
   majority element. Hence the answer is 0.

   Constraints:
   1 <= nums.length <= 105
   1 <= nums[i] <= 109
   1 <= target <= 109
*/
import java.nio.file.Files;
import java.nio.file.Paths;

class CountSubarraysWithMajorityElementII {
    private static long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int cnt = n;
        long ans = 0;
        long presum = 0;
        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                presum += pre[cnt];
                cnt++;
                pre[cnt]++;
            } else {
                cnt--;
                presum -= pre[cnt];
                pre[cnt]++;
            }
            ans += presum;
        }
        return ans;
    }
    public static void main(String[] args) {
        Log.info(countMajoritySubarrays(new int[] {1,2,2,3}, 2));
        Log.info(countMajoritySubarrays(new int[] {1,1,1,1}, 1));
        Log.info(countMajoritySubarrays(new int[] {1,2,3}, 4));
        try {
            String arrayElements = Files.readString(Paths.get("CountSubarraysWithMajorityElementII_INPUT_FILE.txt"));
            int[] arr = java.util.Arrays.stream(arrayElements.split(","))
                .map(String::trim)
                //.filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
            //Log.info(arr);
            //Log.info("[" + arrayElements + "]");
            Log.info(countMajoritySubarrays(arr, 972301370)); // 2165788632
        } catch (Exception e) {
            Log.info(e);
        }
    }
}
/**
   Approach: Prefix Sum
   Intuition
   This problem is a data-enhanced version of 3737. Count Subarrays With Majority Element I.

   Let the length of the array nums be n. We transform the array by treating elements equal to target as +1 and
   all other elements as -1. Under this transformation, target is the majority element of a subarray nums[l..r]
   if and only if the sum of the transformed subarray is greater than 0.

   Let s be the prefix sum array of the transformed array, where s has length n+1. Then the transformed sum of
   subarray nums[l..r] is

   s[r+1] - s[l].

   The condition that this sum is greater than 0 is equivalent to

   s[r+1] > s[l].

   Therefore, the problem reduces to the following: for each r, count the number of indices l satisfying

   0 <= l <= r

   and

   s[l] < s[r+1].

   A naive approach checks all possible l for each r, resulting in a time complexity of O(n^2), which is too slow.

   Notice that every prefix sum lies in the integer range [-n,n]. We use a counting array pre, where pre[v] records
   how many times the prefix sum value v has appeared so far. Then, for the current prefix sum s[r+1], the number
   of valid indices l is exactly the sum of all entries in pre corresponding to values strictly smaller than s[r+1],
   which is a prefix sum of pre.

   Computing this prefix sum from scratch for every r would still be too expensive. The key observation is that
   between consecutive positions, the prefix sum changes by only +1 or -1. Therefore, the upper bound of the
   prefix-sum query also changes by only one position. This allows us to maintain the result incrementally using a
   variable presum, updating it in O(1) time per step:

   When the current transformed value is +1, we have s[r+1] = s[r]+1. The query range expands by one value, so we
   add pre[s[r]] to presum.
   When the current transformed value is -1, we have s[r+1] = s[r]-1. The query range shrinks by one value, so we
   subtract pre[s[r+1]] from presum.
   After updating presum, we record the current prefix sum s[r+1] in pre and add presum to the answer.

   In the implementation, we use a variable cnt to represent the current prefix sum. Since prefix sums may be
   negative and arrays do not support negative indices, all prefix-sum values are shifted by n when stored in pre.
 */
