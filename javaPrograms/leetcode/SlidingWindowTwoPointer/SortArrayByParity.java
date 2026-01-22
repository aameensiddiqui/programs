/**
   905. Sort Array By Parity

   Given an integer array nums, move all the even integers at the beginning
   of the array followed by all the odd integers.

   Return any array that satisfies this condition.

   Example 1:
   Input: nums = [3,1,2,4]
   Output: [2,4,3,1]
   Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also
   be accepted.

   Example 2:
   Input: nums = [0]
   Output: [0]

   Constraints:
   1 <= nums.length <= 5000
   0 <= nums[i] <= 5000
*/
import java.util.*;

class SortArrayByParity {
    private static int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            } else i++;
        }
        return nums;
    }
    public static void main(String[]args) {
        Log.info(sortArrayByParity(new int[]{3,1,2,4}));
        Log.info(sortArrayByParity(new int[]{0}));
    }
}
/**
    private static int[] sortArrayByParity(int[] nums) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int n : nums) {
            if ((n & 1) == 1) q.addFirst(n);
            else q.addLast(n);
        }
        int i = 0, j = nums.length - 1;
        while (!q.isEmpty()) {
            nums[i++] = q.pollFirst();
            if (q.isEmpty()) break;
            nums[j--] = q.pollLast();
        }
        return nums;
    }
*/
/**
    private static int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> oddd = new ArrayList<>();
        for (int n : nums) {
            if ((n & 1) == 1) even.add(n);
            else oddd.add(n);
        }
        int idx = 0;
        for (int e : even) nums[idx++] = e;
        for (int e : oddd) nums[idx++] = e;
        return nums;
    }
*/
