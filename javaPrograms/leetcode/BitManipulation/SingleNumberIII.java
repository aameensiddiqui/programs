/**
   260. Single Number III

   Given an integer array nums, in which exactly two elements appear only once and all
   the other elements appear exactly twice. Find the two elements that appear only once.
   You can return the answer in any order.

   You must write an algorithm that runs in linear runtime complexity and uses only
   constant extra space.

   Example 1:
   Input: nums = [1,2,1,3,2,5]
   Output: [3,5]
   Explanation:  [5, 3] is also a valid answer.

   Example 2:
   Input: nums = [-1,0]
   Output: [-1,0]

   Example 3:
   Input: nums = [0,1]
   Output: [1,0]

   Constraints:
   2 <= nums.length <= 3 * 104
   -231 <= nums[i] <= 231 - 1
   Each integer in nums will appear twice, only two integers will appear once.
*/
import java.util.*;

class SingleNumberIII {
    // most significant bit
    // This approach uses a neat trick to find the RIGHTMOST set bit.
    // The expression x & (-x) isolates the lowest set bit in x.
    // Using this on the XOR of all numbers immediately gives us a differing bit between
    // the two unique numbers without looping.

    // Algorithm
    // XOR all numbers to get a ^ b.
    // Compute diff_bit = xor & (-xor) to get the rightmost set bit.
    // Partition numbers based on whether they have this bit set.
    // XOR within each partition to find a and b.
    // Return both unique numbers.
    private static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;

        int diff_bit = xor & (-xor);

        int a = 0, b = 0;
        for (int num : nums) {
            if ((diff_bit & num) != 0) a = a ^ num;
            else b = b ^ num;
        }
        return new int[] {a, b};
    }
    public static void main(String[] args) {
        Log.info(singleNumber(new int[] {1,2,1,3,2,5}));
        Log.info(singleNumber(new int[] {1,2,1,3,2,4}));
        Log.info(singleNumber(new int[] {-1,0}));
        Log.info(singleNumber(new int[] {0,1}));
    }
}
/**
    // bitwise operator xor (least significant bit)
    // XORing all numbers gives us a ^ b where a and b are the two unique numbers.
    // Since a != b, at least one bit in the XOR result is set.
    // This bit position represents where a and b differ.
    // We can use this differing bit to partition all numbers into two groups:
    // one containing a and one containing b.
    // XORing within each group isolates the unique numbers.

    // algorithm
    // XOR all numbers to get a ^ b.
    // Find any set bit in the result by iterating until we find a bit position where the XOR is 1.
    // Partition numbers: those with this bit set go to one group, others to another.
    // XOR within each group to isolate a and b.
    // Return both unique numbers.
    private static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;

        int diff_bit = 1;
        while ((xor & diff_bit) == 0) diff_bit = diff_bit << 1;
        int a = 0, b = 0;
        for (int num : nums) {
            if ((diff_bit & num) != 0) a = a ^ num;
            else b = b ^ num;
        }
        return new int[] {a, b};
    }
*/
/**
    // sorting
    private static int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if ((i > 0 && nums[i - 1] == nums[i]) || (i + 1 < nums.length && nums[i] == nums[i + 1]))
                    continue;
                list.add(nums[i]);
        }
        return new int[] {list.get(0), list.get(1)};
    }
*/
/**
    // hashset
    private static int[] singleNumber(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int[] ans = new int[2];
        int i = 0;
        for (int num : nums) {
            if (seen.contains(num)) seen.remove(num);
            else seen.add(num);
        }
        for (int num : seen) ans[i++] = num;
        return ans;
    }
*/
/**
    // hashmap
    private static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> e : m.entrySet())
            if (e.getValue() == 1) list.add(e.getKey());
        return new int[] {list.get(0), list.get(1)};
    }
*/
