/**
   1590. Make Sum Divisible by P

   Given an array of positive integers nums, remove the smallest subarray
   (possibly empty) such that the sum of the remaining elements is divisible
   by p. It is not allowed to remove the whole array.

   Return the length of the smallest subarray that you need to remove, or -1
   if it's impossible.

   A subarray is defined as a contiguous block of elements in the array.

   Example 1:
   Input: nums = [3,1,4,2], p = 6
   Output: 1
   Explanation: The sum of the elements in nums is 10, which is not divisible by 6.
   We can remove the subarray [4], and the sum of the remaining elements is 6,
   which is divisible by 6.

   Example 2:
   Input: nums = [6,3,5,2], p = 9
   Output: 2
   Explanation: We cannot remove a single element to get a sum divisible by 9.
   The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

   Example 3:
   Input: nums = [1,2,3], p = 3
   Output: 0
   Explanation: Here the sum is 6. which is already divisible by 3.
   Thus we do not need to remove anything.

   Constraints:
   1 <= nums.length <= 105
   1 <= nums[i] <= 109
   1 <= p <= 109
*/
import java.util.HashMap;

class MakeSumDivisibleByP {
    private static int minSubarray(int[]nums, int p) {
        int sum = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; ++i) sum = (sum + nums[i]) % p;
        int target = sum % p;
        if(target == 0) return 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        
        int minLen = n;
        int currSum = 0;
        
        for(int i = 0; i < n; ++i) {
            currSum = (currSum + nums[i]) % p;
            int needed = (currSum - target + p) % p;
            if(mpp.containsKey(needed)) minLen = Math.min(minLen, i - mpp.get(needed));
            mpp.put(currSum, i);
        }
        return minLen == n ? -1 : minLen;
    }
    public static void main(String[]args) {
        IO.println(minSubarray(new int[]{6,3,5,2}, 9));                                    // 2
        IO.println(minSubarray(new int[]{1,2,3}, 3));                                      // 0
        IO.println(minSubarray(new int[]{3,1,4,2}, 6));                                    // 1
        IO.println(minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));           // 0
        IO.println(minSubarray(new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26)); // 3
    }
}
/**
    private static int minSubarray(int[]nums, int p) {
        long sum = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; ++i) sum += nums[i];
        if(sum % p == 0) return 0;

        int minLen = n;
        
        for(int i = 0; i < n; ++i) {
            long s = 0;
            for(int j = i; j < n; ++j) {
                s += nums[j];              
                if((sum - s) % p == 0) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        return minLen == n ? -1 : minLen;
    }

*/
