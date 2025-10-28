/**
   219. Contains Duplicate II

   Given an integer array nums and an integer k, return true if there are
   two distinct indices i and j in the array such that
   nums[i] == nums[j]
   and
   abs(i - j) <= k.

   Example 1:
   Input: nums = [1,2,3,1], k = 3
   Output: true

   Example 2:
   Input: nums = [1,0,1,1], k = 1
   Output: true

   Example 3:
   Input: nums = [1,2,3,1,2,3], k = 2
   Output: false

   Constraints:
   1 <= nums.length <= 105
   -109 <= nums[i] <= 109
   0 <= k <= 105
 */
import java.util.Map;
import java.util.HashMap;
class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[]nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(mpp.containsKey(nums[i]) && i - mpp.get(nums[i]) <= k)
                return true;
            mpp.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[]args) {
        int[]arr1 = {1, 2, 3, 1};       int k1 = 3;
        int[]arr2 = {1, 0, 1, 1};       int k2 = 1;
        int[]arr3 = {1, 2, 3, 1, 2, 3}; int k3 = 2;
        log.info(containsNearbyDuplicate(arr1, k1));
        log.info(containsNearbyDuplicate(arr2, k2));
        log.info(containsNearbyDuplicate(arr3, k3));
    }
    private static final Log log = new Log();
}
/**
    public static boolean containsNearbyDuplicate(int[]nums, int k) {
        boolean contains = false;
        for(int i = 0; i < nums.length; ++i) {
            for(int j = i+1; j < nums.length; ++j) {
                if(nums[i] == nums[j] && Math.abs(j - i) <= k) {
                    contains = true;
                    //log.info("nums[i]="+nums[i]+"----nums[j]="+nums[j]);
                    //log.info("i="+i+"----j="+j);
                    break;
                }
            }
        }
        return contains;
    }
 */
