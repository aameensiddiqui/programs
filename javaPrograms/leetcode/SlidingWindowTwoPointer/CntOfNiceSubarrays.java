/**
   1248. Count Number of Nice Subarrays

   Given an array of integers nums and an integer k.
   A continuous subarray is called nice if there are k odd numbers on it.

   Return the number of nice sub-arrays.

   Example 1:
   Input: nums = [1,1,2,1,1], k = 3
   Output: 2
   Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

   Example 2:
   Input: nums = [2,4,6], k = 1
   Output: 0
   Explanation: There are no odd numbers in the array.

   Example 3:
   Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
   Output: 16

   Constraints:
   1 <= nums.length <= 50000
   1 <= nums[i] <= 10^5
   1 <= k <= nums.length
 */
import java.util.Map;
import java.util.HashMap;
class CntOfNiceSubarrays {
    public static int numberOfSubarrays(int[]nums, int k) {
        int cnt = 0, oddCnt = 0;
        int[]map = new int[nums.length+1];
        map[0] = 1;
        for(int num : nums) {
            oddCnt += num & 1;
            if(oddCnt >= k) cnt += map[oddCnt - k];
            map[oddCnt]++;
        }
        return cnt;
    }
    public static void main(String[]args) {
        int[]arr1 = {1, 1, 2, 1, 1}; int k1 = 3;
        int[]arr2 = {2, 4, 6}; int k2 = 1;
        int[]arr3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2}; int k3 = 2;
        log.info(numberOfSubarrays(arr1, k1));
        log.info(numberOfSubarrays(arr2, k2));
        log.info(numberOfSubarrays(arr3, k3));
    }
    private static final Log log = new Log();
}
/**
    public static int cntAtMost(int[]nums, int k) {
        int cnt = 0, l = 0;
        for(int r = 0; r < nums.length; ++r) {
            if(nums[r] % 2 == 1) k--;
            while(k < 0) {
                if(nums[l] % 2 == 1) k++;
                l++;
            }
            cnt += (r - l + 1);
        }
        return cnt;
    }
    public static int numberOfSubarrays(int[]nums, int k) {
        return cntAtMost(nums, k) - cntAtMost(nums, k-1);
    }
 */
/**
    public static int numberOfSubarrays(int[]nums, int k) {
        int cnt = 0;
        int oddCnt = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for(int num : nums) {
            if(num % 2 == 1) oddCnt++;
            if(freq.containsKey(oddCnt - k)) cnt += freq.get(oddCnt - k);
            freq.put(oddCnt, freq.getOrDefault(oddCnt, 0)+1);
        }
        return cnt;
    }
 */
/**
    public static int numberOfSubarrays(int[]nums, int k) {
        int cnt = 0;
        for(int i = 0; i < nums.length; ++i) {
            int oddCnt = 0;
            for(int j = i; j < nums.length; ++j) {
                if(nums[j] % 2 != 0) oddCnt++;
                if(oddCnt > k) break;
                if(oddCnt == k) cnt++;
            }
        }
        return cnt;
    }
 */
