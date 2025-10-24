/**
   1004. Max Consecutive Ones III

   Given a binary array nums and an integer k, return the maximum number of
   consecutive 1's in the array if you can flip at most k 0's.

   Example 1:
   Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
   Output: 6
   Explanation: [1,1,1,0,0,1,1,1,1,1,1]
   Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

   Example 2:
   Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
   Output: 10
   Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
   Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

   Constraints:
   1 <= nums.length <= 105
   nums[i] is either 0 or 1.
   0 <= k <= nums.length
*/
class MaximumConsicutiveOnes {
    public static int longestOnes(int[]nums, int k) {
        int r = 0, l = 0;
        int maxLen = 0;
        int zeros = 0;
        int len = 0;
        while(r < nums.length) {
            if(nums[r] == 0) zeros++;
            while(zeros > k) {
                if(nums[l] == 0) zeros--;
                l++;
            }
            if(zeros <= k) {
                len = r-l+1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[]args) {
        int[]arr1 = {1,1,1,0,0,0,1,1,1,1,0};                 int k1 = 2;
        int[]arr2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}; int k2 = 3;
        log.info(longestOnes(arr1, k1));
        log.info(longestOnes(arr2, k2));
    }
    private static final Log log = new Log();
}
/**
public static int longestOnes(int[]nums, int k) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; ++i) {
            int zeros = 0;
            for(int j = i; j < nums.length; ++j) {
                if(nums[j] == 0) zeros++;
                if(zeros > k) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
 */
/**
    public static int longestOnes(int[]nums, int k) {
        int maxLen = 0, len = 0;
        for(int i = 0; i < nums.length; ++i) {
            int zeros = 0;
            for(int j = i; j < nums.length; ++j) {
                if(nums[j] == 0) zeros++;
                if(zeros <= k) {
                    len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
 */
