/**
   153. Find Minimum in Rotated Sorted Array

   Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
   For example, the array nums = [0,1,2,4,5,6,7] might become:

   [4,5,6,7,0,1,2] if it was rotated 4 times.
   [0,1,2,4,5,6,7] if it was rotated 7 times.
   Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
   [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

   Given the sorted rotated array nums of unique elements, return the minimum element of
   this array.

   You must write an algorithm that runs in O(log n) time.

   Example 1:
   Input: nums = [3,4,5,1,2]
   Output: 1
   Explanation: The original array was [1,2,3,4,5] rotated 3 times.

   Example 2:
   Input: nums = [4,5,6,7,0,1,2]
   Output: 0
   Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

   Example 3:
   Input: nums = [11,13,15,17]
   Output: 11
   Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

   Constraints:
   n == nums.length
   1 <= n <= 5000
   -5000 <= nums[i] <= 5000
   All the integers of nums are unique.
   nums is sorted and rotated between 1 and n times.
*/
/**
   All elements in the sorted array are unique.
   After rotating the array by some value k, the array is split into two sorted segments:
   Currently, the array is partially sorted, so it does not seem possible to perform a binary
   search to find the desired element.
   However, there is a pattern that we can observe.
   Observation in the rotated sorted array:
   Every element in the left segment is greater than the last element of the array,
   While every element in the right segment is less than or equal to the last element.
   The minimum value is exactly the first element in the right segment.
   Binary Array Reduction
   The array can be reduced into two regions:
   1 -> elements <= last element (true condition).
   0 -> elements >  last element (false condition).
   This effectively transforms the problem into finding the leftmost 1 in a binary array.
   Binary Search
   An index position is valid if:
   nums[index] <= last element
   Since the minimum element corresponds to the first valid position:
   We can solve the problem using a standard lower-bound (left - bound) search in O(log n) time.
*/
class FindMinimumInRotatedSortedArray {
    private static int findMin(int[] nums) {
        int n = nums.length - 1;
        int e = nums[n];
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) >> 1;
            if (nums[m] > e) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
    public static void main(String[] args) {
        Log.info(findMin(new int[] {3,4,5,1,2}));
        Log.info(findMin(new int[] {4,5,6,7,0,1,2}));
        Log.info(findMin(new int[] {11,15,13,17}));
    }
}
