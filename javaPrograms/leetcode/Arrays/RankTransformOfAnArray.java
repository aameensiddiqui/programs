/**
   1331. Rank Transform of an Array

   Given an array of integers arr, replace each element with its rank.

   The rank represents how large the element is. The rank has the following rules:

   Rank is an integer starting from 1.
   The larger the element, the larger the rank. If two elements are equal, their rank must
   be the same.
   Rank should be as small as possible.

   Example 1:
   Input: arr = [40,10,20,30]
   Output: [4,1,2,3]
   Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest.
   30 is the third smallest.

   Example 2:
   Input: arr = [100,100,100]
   Output: [1,1,1]
   Explanation: Same elements share the same rank.

   Example 3:
   Input: arr = [37,12,28,9,100,56,80,5,12]
   Output: [5,3,4,2,8,6,7,1,3]

   Constraints:
   0 <= arr.length <= 105
   -109 <= arr[i] <= 109
*/
import java.util.HashMap;
import java.util.Arrays;
import java.util.TreeSet;

class RankTransformOfAnArray {
    private static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        System.arraycopy(arr, 0, tmp, 0, n);
        HashMap<Integer, Integer> mpp = new HashMap<>();
        Arrays.sort(tmp);
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (!mpp.containsKey(tmp[i])) {
                cnt++;
                mpp.put(tmp[i], cnt);
            }
        }
        // Log.info(mpp);
        for (int i = 0; i < n; ++i) {
            // Log.info("tmp[" + i + "] = " + tmp[i] + "    mpp.get(arr[" + i + "]) = " + mpp.get(arr[i]));
            tmp[i] = mpp.get(arr[i]);
        }
        return tmp;
    }
    public static void main(String[] args) {
        Log.info(arrayRankTransform(new int[] {40,10,20,30})); // [4,1,2,3]
        Log.info(arrayRankTransform(new int[] {100,100,100})); // [1,1,1]
        Log.info(arrayRankTransform(new int[] {37,12,28,9,100,56,80,5,12})); // [5,3,4,2,8,6,7,1,3]
    }
}
/**
    // using set
    private static int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int cnt = 1;
        for (int num : arr)
            set.add(num);
        for (int num : set)
            mpp.put(num, cnt++);
        for (int i = 0; i < arr.length; ++i)
            arr[i] = mpp.get(arr[i]);
        return arr;
    }
*/
