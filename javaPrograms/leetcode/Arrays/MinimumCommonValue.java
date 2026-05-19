/**
   2540. Minimum Common Value

   Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum
   integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

   Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one
   occurrence of that integer.

   Example 1:
   Input: nums1 = [1,2,3], nums2 = [2,4]
   Output: 2
   Explanation: The smallest element common to both arrays is 2, so we return 2.

   Example 2:
   Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
   Output: 2
   Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest,
   so 2 is returned.

   Constraints:
   1 <= nums1.length, nums2.length <= 105
   1 <= nums1[i], nums2[j] <= 109
   Both nums1 and nums2 are sorted in non-decreasing order.
*/
class MinimumCommonValue {
    private static boolean bs(int t, int[] a) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            int m = (l + h) >> 1;
            if (a[m] == t) return true;
            else if (a[m] < t) l = m + 1;
            else h = m - 1;
        }
        return false;
    }
    private static int getCommon(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return getCommon(nums2, nums1);
        for (int n : nums2) if (bs(n, nums1)) return n;
        return -1;
    }
    public static void main(String[] args) {
        Log.info(getCommon(new int[] {1,2,3}, new int[] {2,4}));
        Log.info(getCommon(new int[] {1,2,3,6}, new int[] {2,3,4,5}));
        Log.info(getCommon(new int[] {1,2}, new int[] {2,4}));
    }
}
/**
    private static int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        if (nums1[nums1.length - 1] < nums2[0] ||
            nums2[nums2.length - 1] < nums1[0])
            return -1;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
        }
        return -1;
    }
*/
