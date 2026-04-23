/**
   615. Sum of Distances

   You are given a 0-indexed integer array nums. There exists an array arr of length nums.length,
   where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i.
   If there is no such j, set arr[i] to be 0.

   Return the array arr.

   Example 1:
   Input: nums = [1,3,1,1,2]
   Output: [5,0,3,4,0]
   Explanation:
   When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5.
   When i = 1, arr[1] = 0 because there is no other index with value 3.
   When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3.
   When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4.
   When i = 4, arr[4] = 0 because there is no other index with value 2.

   Example 2:
   Input: nums = [0,5,3]
   Output: [0,0,0]
   Explanation: Since each element in nums is distinct, arr[i] = 0 for all i.

   Constraints:
   1 <= nums.length <= 105
   0 <= nums[i] <= 109
*/
import java.util.*;

class SumOfDistances {
    private static long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            mpp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> e : mpp.entrySet()) {
            List<Integer> list = e.getValue();
            long total = 0, prefixTotal = 0;
            for (int num : list) total += num;
            for (int i = 0; i < list.size(); ++i) {
                arr[list.get(i)] += total - prefixTotal * 2 +
                    (long) list.get(i) *
                    (2 * i - list.size());
                prefixTotal += list.get(i);
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Log.info(distance(new int[] {1,3,1,1,2}));
        Log.info(distance(new int[] {0,5,3}));
    }
}
/**
    private static long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (mpp.containsKey(nums[i])) {
                List<Integer> list = mpp.get(nums[i]);
                list.add(i);
                mpp.put(nums[i], list);
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            mpp.putIfAbsent(nums[i], list);
        }
        // Log.info(mpp); // {1=[0, 2, 3], 2=[4], 3=[1]}

        for (Map.Entry<Integer, List<Integer>> e : mpp.entrySet()) {
            if (e.getValue().size() > 1) {
                List<Integer> list = e.getValue();
                for (int i = 0; i < list.size(); ++i) {
                    for (int j = 0; j < list.size(); ++j) {
                        if (list.get(i) == list.get(j)) continue;
                        else arr[list.get(i)] += Math.abs(list.get(i) - list.get(j));
                    }
                }
            }
        }
        return arr;
    }
*/
/**
    private static long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (nums[i] == nums[j]) {
                    arr[i] += Math.abs(i - j);
                }
            }
        }
        return arr;
    }
*/
