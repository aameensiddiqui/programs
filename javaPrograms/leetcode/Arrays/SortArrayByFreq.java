/**
   1636. Sort Array by Increasing Frequency

   Given an array of integers nums, sort the array in increasing order based on the
   frequency of the values. If multiple values have the same frequency, sort them in
   decreasing order.

   Return the sorted array.

   Example 1:
   Input: nums = [1,1,2,2,2,3]
   Output: [3,1,1,2,2,2]
   Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

   Example 2:
   Input: nums = [2,3,1,3,2]
   Output: [1,3,3,2,2]
   Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

   Example 3:
   Input: nums = [-1,1,-6,4,5,-6,1,4,1]
   Output: [5,-1,4,4,-6,-6,1,1,1]

   Constraints:
   1 <= nums.length <= 100
   -100 <= nums[i] <= 100
*/
import java.util.*;

class SortArrayByFreq {
    private static int[] frequencySort(int[] nums) {
        LinkedHashMap<Integer, Integer> mpp = new LinkedHashMap<>();
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }
        // Log.info(mpp);
        List<Map.Entry<Integer, Integer>> sortedList = mpp.entrySet()
            .stream()
            .map(Map.Entry::copyOf)
            .sorted((a, b) -> {
                    if (!a.getValue().equals(b.getValue()))
                        return a.getValue() - b.getValue();
                    else return 4b.getKey() - a.getKey();
                })
            .toList();
        sortedList.forEach(e -> mpp.putLast(e.getKey(), e.getValue()));
        Log.info(mpp);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : mpp.entrySet()) {
            int num   = e.getKey();
            int times = e.getValue();
            for (int j = 0; j < times; ++j) {
                list.add(num);
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            nums[i] = list.get(i);
        }
        return nums;
    }
    public static void main(String[]args) {
        Log.info((int[]) frequencySort(new int[]{1,1,2,2,2,3}));
        Log.info((int[]) frequencySort(new int[]{2,3,1,3,2}));
    }
}
/**
   public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int freqA = count.get(a), freqB = count.get(b);
            if (freqA != freqB) return Integer.compare(freqA, freqB);
            return Integer.compare(b, a);
        });

        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }
*/
