/**
   3761. Minimum Absolute Distance Between Mirror Pairs

   You are given an integer array nums.

   A mirror pair is a pair of indices (i, j) such that:

   0 <= i < j < nums.length, and
   reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by
   reversing the digits of x.
   Leading zeros are omitted after reversing, for example reverse(120) = 21.
   Return the minimum absolute distance between the indices of any mirror pair.
   The absolute distance between indices i and j is abs(i - j).

   If no mirror pair exists, return -1.

   Example 1:
   Input: nums = [12,21,45,33,54]
   Output: 1
   Explanation:
   The mirror pairs are:
   (0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1],
   giving an absolute distance abs(0 - 1) = 1.
   (2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4],
   giving an absolute distance abs(2 - 4) = 2.
   The minimum absolute distance among all pairs is 1.

   Example 2:
   Input: nums = [120,21]
   Output: 1
   Explanation:
   There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].
   The minimum absolute distance is 1.

   Example 3:
   Input: nums = [21,120]
   Output: -1
   Explanation:
   There are no mirror pairs in the array.

   Constraints:
   1 <= nums.length <= 105
   1 <= nums[i] <= 109​​​​​​​
*/
import java.util.*;

class MinimumAbsoluteDistanceBetweenMirrorPairs {
    private static int reverse(int num) {
        int ans = 0;
        while (num > 0) {
            ans = (ans * 10) + (num % 10);
            num /= 10;
        }
        return ans;
    }
    private static int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (mpp.containsKey(nums[i]))
                ans = Math.min(ans, Math.abs(i - mpp.get(nums[i])));
            mpp.put(reverse(nums[i]), i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        Log.info(minMirrorPairDistance(new int[] {12,21,45,33,54}));  //  1
        Log.info(minMirrorPairDistance(new int[] {120,21}));          //  1
        Log.info(minMirrorPairDistance(new int[] {21,120}));          // -1
    }
}
/**
    private static int reverse(int num) {
        String s = String.valueOf(num);
        StringBuilder str = new StringBuilder(s);
        s = String.valueOf(str.reverse());
        num = Integer.valueOf(s);
        return num;
    }
    private static int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (mpp.containsKey(nums[i]))
                ans = Math.min(ans, Math.abs(i - mpp.get(nums[i])));
            mpp.put(reverse(nums[i]), i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
*/
/**
    // TLE
    private static int reverse(int num) {
        String s = String.valueOf(num);
        StringBuilder str = new StringBuilder(s);
        s = String.valueOf(str.reverse());
        num = Integer.valueOf(s);
        return num;
    }
    private static int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (reverse(nums[i]) == nums[j])
                    ans = Math.min(ans, Math.abs(i - j));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
*/
