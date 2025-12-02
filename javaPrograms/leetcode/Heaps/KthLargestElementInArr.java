/**
   215. Kth Largest Element in an Array

   Given an integer array nums and an integer k, return the kth largest element in the array.

   Note that it is the kth largest element in the sorted order, not the kth distinct element.

   Can you solve it without sorting?

   Example 1:
   Input: nums = [3,2,1,5,6,4], k = 2
   Output: 5

   Example 2:
   Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
   Output: 4

   Constraints:
   1 <= k <= nums.length <= 105
   -104 <= nums[i] <= 104
*/
import java.util.*;

class KthLargestElementInArr {
    public static int findKthLargest(int[]nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; ++i) pq.add(nums[i]);
        for(int i = k; i < nums.length; ++i) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[]args) {
        IO.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));       // 5
        IO.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }
}
/**
    public static int findKthLargest(int[]nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
*/
/**
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, k);
    }

    private int quickselect(int[] nums, int k) {
        int targetIdx = nums.length - k;

        int i = 0;
        int j = nums.length - 1;
        while (j >= i) {
            int pivotIdx = partition(nums, i, j);
            if (pivotIdx == targetIdx) {
                return nums[pivotIdx];
            } else if (pivotIdx > targetIdx) {
                j = pivotIdx - 1;
            } else {
                i = pivotIdx + 1;
            }
        }

        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pivot = nums[lo];
        while (true) {
            while (i < hi && nums[++i] < pivot);
            while (j > lo && nums[--j] > pivot);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}

// 1 4 5 6 3 | 2
//   ^
*/
