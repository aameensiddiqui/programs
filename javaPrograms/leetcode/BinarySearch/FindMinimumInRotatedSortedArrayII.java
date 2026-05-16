/**
   154. Find Minimum in Rotated Sorted Array II

   Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
   For example, the array nums = [0,1,4,4,5,6,7] might become:

   [4,5,6,7,0,1,4] if it was rotated 4 times.
   [0,1,4,4,5,6,7] if it was rotated 7 times.
   Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
   [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

   Given the sorted rotated array nums that may contain duplicates, return the minimum element
   of this array.

   You must decrease the overall operation steps as much as possible.

   Example 1:
   Input: nums = [1,3,5]
   Output: 1

   Example 2:
   Input: nums = [2,2,2,0,1]
   Output: 0

   Constraints:
   n == nums.length
   1 <= n <= 5000
   -5000 <= nums[i] <= 5000
   nums is sorted and rotated between 1 and n times.

   Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain
   duplicates. Would this affect the runtime complexity? How and why?
 */
/**
   Same Trick + Boundary Duplicate Elimination

   Approach 1

   This is almost the exact same problem as Find Minimum in Rotated Sorted Array, but now the array
   contains duplicates.

   Here, duplicates introduce ambiguity in the binary search decision.

   Thus, regardless of the approach, the worst case degrades to O(n) because duplicates can prevent
   the search from eliminating half of the array at every step.

   When values are equal, comparisons do not provide direction, so the pointer may only advance by
   one step at a time.

   However, this does not necessarily make the implementation difficult:

   In our previous approach, we use the last element to check which segment a value belongs to.

   Every element in the left segment is greater than the last element of the array,
   While every element in the right segment is less than or equal to the last element.
   But the duplicates at the start do not help with that check because they are equal to the last element,
   so they do not tell which segment the minimum is in.

   We can still use this trick simply by eliminating duplicates at the array boundary.

   We can remove either at the beginning or at end depending on the implementation.

   To do this:

   First, perform a linear scan to skip initial values equal to the last element, since these values do
   not affect the search direction.

   Then, run the same lower-bound binary search to find the first element in the right section:

   ////////////////////////////////

   Approach 2

   Segment Pruning | Divide-and-Conquer
   Since linear search is inevitable, the only thing we can control is limiting the search to the minimum.

   We split the array into segments and check each one.

   If nums[left] < nums[right]:

   the segment is already sorted, so the minimum is nums[left].
   If nums[left] = nums[right]:

   it is ambiguous (indeterminate), so we still need to search.
   If nums[left] > nums[right]:

   the array is rotated in this segment, so we split again and continue.
   Instead of performing a linear scan within an indeterminate segment:

   The algorithm recursively divides the region into subsegments until it hits the base case of a single
   element or a strictly sorted range.

   It then aggregates the results using the minimum function.

   In the worst case (all elements equal) every segment is indeterminate:

   Therefore, no branches get pruned, forcing the algorithm to split down to 1-element segments, which
   degrades the time complexity to linear time O(n).

   Time Complexity:
   O(log n) - average case
   O(n)     - worst case
 */
class FindMinimumInRotatedSortedArrayII {
    private static int dnc(int l, int r, int[] nums) {
        if (l == r) return nums[l];
        if (nums[l] < nums[r]) return nums[l];
        int m = (l + r) >> 1;
        return Math.min(
                        dnc(l, m, nums),
                        dnc(m + 1, r, nums)
                        );
    }
    private static int findMinByDivideAndConquer(int[] nums) {
        return dnc(0, nums.length - 1, nums);
    }
    private static int findMin(int[] nums) {
        int n = nums.length - 1;
        int l = 0, r = n, e = nums[n];
        while (l < n && nums[l] == e) l++;
        while (l < r) {
            int m = (l + r) >> 1;
            if (nums[m] > e) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
    public static void main(String[] args) {
        Log.info(findMin(new int[] {1,3,5}));
        Log.info(findMin(new int[] {2,2,2,0,1}));
        Log.info(findMin(new int[] {3,1,3}));

        Log.info(findMinByDivideAndConquer(new int[] {1,3,5}));
        Log.info(findMinByDivideAndConquer(new int[] {2,2,2,0,1}));
        Log.info(findMinByDivideAndConquer(new int[] {3,1,3}));
    }
}
