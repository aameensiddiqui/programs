/**
   136. Single Number

   Given a non-empty array of integers nums, every element appears twice except
   for one. Find that single one.

   You must implement a solution with a linear runtime complexity and use only
   constant extra space.

   Example 1:
   Input: nums = [2,2,1]
   Output: 1

   Example 2:
   Input: nums = [4,1,2,1,2]
   Output: 4

   Example 3:
   Input: nums = [1]
   Output: 1

   Constraints:
   1 <= nums.length <= 3 * 104
   -3 * 104 <= nums[i] <= 3 * 104
   Each element in the array appears twice except for one element which appears
   only once.
*/
import java.util.*;

class SingleNumber {
    private static int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) x ^= num;
        return x;
    }
    public static void main(String[] args) {
        Log.info(singleNumber(new int[] {2,2,1}));
        Log.info(singleNumber(new int[] {4,1,2,1,2}));
        Log.info(singleNumber(new int[] {1}));
    }
}
/**
    private static int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) seen.remove(num);
            else seen.add(num);
        }
        return seen.iterator().next();
    }
*/
/**
    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> e : mpp.entrySet())
            if (e.getValue() == 1) return e.getKey();
        return -1;
    }
*/
