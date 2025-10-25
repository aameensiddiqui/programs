/**
   992. Subarrays with K Different Integers

   Given an integer array nums and an integer k, return the number of
   good subarrays of nums.

   A good array is an array where the number of different integers in
   that array is exactly k.

   For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
   A subarray is a contiguous part of an array.

   Example 1:
   Input: nums = [1,2,1,2,3], k = 2
   Output: 7
   Explanation: Subarrays formed with exactly 2 different integers:
   [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

   Example 2:
   Input: nums = [1,2,1,3,4], k = 3
   Output: 3
   Explanation: Subarrays formed with exactly 3 different integers:
   [1,2,1,3], [2,1,3], [1,3,4].

   Constraints:
   1 <= nums.length <= 2 * 104
   1 <= nums[i], k <= nums.length
 */
import java.util.Map;
import java.util.HashMap;

class SubarraysWithKDiffIntegers {

    public static int atMostK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) k--;
            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) k++;
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    public static void main(String[]args) {
        int[]arr1 = {1,2,1,2,3}; int k1 = 2;
        int[]arr2 = {1,2,1,3,4}; int k2 = 3;
        log.info(subarraysWithKDistinct(arr1, k1));
        log.info(subarraysWithKDistinct(arr2, k2));
    }

    private static final Log log = new Log();

}
