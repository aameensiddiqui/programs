/**
   152. Maximum Product Subarray

   Given an integer array nums, find a subarray that has the largest product, and return the product.

   The test cases are generated so that the answer will fit in a 32-bit integer.

   Note that the product of an array with a single element is the value of that element.

   Example 1:
   Input: nums = [2,3,-2,4]
   Output: 6
   Explanation: [2,3] has the largest product 6.

   Example 2:
   Input: nums = [-2,0,-1]
   Output: 0
   Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

   Constraints:
   1 <= nums.length <= 2 * 104
   -10 <= nums[i] <= 10
   The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
*/
class MaxProductSubarray {
    // Kadane's Algorithm
    private static int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;
        for (int n : nums) {
            int temp = curMax * n;
            curMax = Math.max(n, Math.max(n * curMax, n * curMin));
            curMin = Math.min(n, Math.min(temp, n * curMin));
            res = Math.max(res, curMax);
        }
        return res;
    }
    public static void main(String[]args) {
        log.info(maxProduct(new int[]{2,3,-2,4})); // 6
        log.info(maxProduct(new int[]{-2,0,-1}));  // 0
        log.info(maxProduct(new int[]{-2}));       // -2
        log.info(maxProduct(new int[]{-4,-3,-2})); // 12
    }
}
/**
    // O(n^2)
    private static int maxProduct(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            int cur = nums[i];
            res = Math.max(res, cur);
            for (int j = i + 1; j < nums.length; ++j) {
                cur *= nums[j];
                res = Math.max(res, cur);
            }
        }
        return res;
    }
*/
/**
// testing setting of ssh key correct or not
class MaximumProductSubArray {
    public static int maxProd(int[]arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        long res = Long.MIN_VALUE;
        long pre = 1, stuff = 1;
        for(int i = 0; i < n-1; ++i) {
            if(pre == 0) pre = 1;
            if(stuff == 0) stuff = 1;
            pre *= arr[i];
            stuff *= arr[n-i-1];
            res = Math.max(res, Math.max(pre, stuff));
        }
        return (int)res;
    }
    public static void main(String[]args) {
        Log log = new Log();
        int[]arr = {1, 2, 3, 4, 5, 0};
        //int[]arr = {2, 3, -2, 4};
        //int[]arr = {-2, 0, -1};
        //int[]arr = {-2};
        log.info(maxProd(arr));
    }
}
/////////////////////////////////////////////
    public static int maxProd(int[]arr) {
        if(arr.length == 1) return arr[0];
        long res = Long.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                long pro = 1;
                for(int k = i; k <= j; ++k) {
                    pro *= arr[k];
                    res = Math.max(pro, res);
                }
            }
        }
        return (int)res;
    }
*/
