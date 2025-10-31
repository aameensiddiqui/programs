/**
   448. Find All Numbers Disappeared in an Array

   Given an array nums of n integers where nums[i] is in the range [1, n],
   return an array of all the integers in the range [1, n] that do not appear in nums.

   Example 1:
   Input: nums = [4,3,2,7,8,2,3,1]
   Output: [5,6]

   Example 2:
   Input: nums = [1,1]
   Output: [2]

   Constraints:
   n == nums.length
   1 <= n <= 105
   1 <= nums[i] <= n

   https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
import java.util.*;
class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[]nums) {
        Set<Integer> st = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums) st.add(n);
        for(int i = 1; i <= nums.length; ++i) {
            if(!st.contains(i)) list.add(i);
        }
        return list;
    }
    public static void main(String[]args) {
        int[]nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        int[]nums2 = {1, 1};
        log.info(findDisappearedNumbers(nums1));
        log.info(findDisappearedNumbers(nums2));
    }
    private static final Log log = new Log();
}
