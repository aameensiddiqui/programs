/**
   628. Maximum Product of Three Numbers

   Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

   Example 1:
   Input: nums = [1,2,3]
   Output: 6

   Example 2:
   Input: nums = [1,2,3,4]
   Output: 24

   Example 3:
   Input: nums = [-1,-2,-3]
   Output: -6

   Constraints:
   3 <= nums.length <= 104
   -1000 <= nums[i] <= 1000
*/
import java.util.Arrays;

class MaximumProductOfThreeNumbers {
    private static int maximumProduct(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        return Math.max(
                        A[n - 1] * A[n - 2] * A[n - 3],
                        A[n - 1] * A[0] * A[1]
                        );
    }
    public static void main(String[] args) {
        Log.info(maximumProduct(new int[] {1,2,3}));             // 6
        Log.info(maximumProduct(new int[] {1,2,3,4}));           // 24
        Log.info(maximumProduct(new int[] {-1,-2,-3}));          // -6
        Log.info(maximumProduct(new int[] {-100,-98,-1,2,3,4})); // 39200
    }
}
