/**
   3741. Minimum Distance Between Three Equal Elements II

   You are given an integer array nums.
   A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
   The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x)
   denotes the absolute value of x.
   Return an integer denoting the minimum possible distance of a good tuple.
   If no good tuples exist, return -1.

   Example 1:
   Input: nums = [1,2,1,1,3]
   Output: 6
   Explanation:
   The minimum distance is achieved by the good tuple (0, 2, 3).
   (0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1.
   Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.

   Example 2:
   Input: nums = [1,1,2,3,2,1,2]
   Output: 8
   Explanation:
   The minimum distance is achieved by the good tuple (2, 4, 6).
   (2, 4, 6) is a good tuple because nums[2] == nums[4] == nums[6] == 2.
   Its distance is abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8.

   Example 3:
   Input: nums = [1]
   Output: -1
   Explanation:
   There are no good tuples. Therefore, the answer is -1.

   Constraints:
   1 <= n == nums.length <= 105
   1 <= nums[i] <= n
*/
import java.util.*;

class MinimumDistanceBetweenThreeEqualElementsII {
    private static int minimumDistance(int[] nums) {
        /*
         * For any three equal elements at indices a < b < c, the distance simplifies
         * to 2*(c-a) - the middle index cancels out. So we only need to minimize the
         * gap between the first and last positions of any consecutive triple.
         *
         * As we scan the array, we maintain two arrays - prev1 and prev2 - tracking
         * the last and second-to-last index where each value was seen. When the same
         * value appears a third time, prev2 holds the oldest position of the three,
         * and the current index is the newest. The distance is 2*(current - prev2).
         * After each occurrence, we slide the window forward by shifting prev1 into
         * prev2 and storing the current index in prev1.
         *
         * This works because values are bounded by n, so each value can be used
         * directly as an array index - no hashing needed.
         */
        int n = nums.length, res = Integer.MAX_VALUE;
        int[] prev1 = new int[n + 1];
        int[] prev2 = new int[n + 1];
        Arrays.fill(prev1, -1);
        Arrays.fill(prev2, -1);
        for (int i = 0; i < n; ++i) {
            int val = nums[i];
            if (prev2[val] != -1) res = Math.min(res, (i - prev2[val]));
            prev2[val] = prev1[val];
            prev1[val] = i;
        }
        return res == Integer.MAX_VALUE ? -1 : 2 * res;
    }
    public static void main(String[] args) {
        Log.info(minimumDistance(new int[] {1,2,1,1,3}));       // 6
        Log.info(minimumDistance(new int[] {1,1,2,3,2,1,2}));   // 8
        Log.info(minimumDistance(new int[] {1}));               // -1
        Log.info(minimumDistance(new int[] {225,369,173,31,309,58,82,280,222,291,104,11,226,362,363,42,
                                            273,179,226,260,180,250,359,45,247,134,32,46,161,17,229,60,
                                            74,214,67,35,74,153,361,317,241,154,237,71,138,26,356,271,
                                            119,238,262,243,221,233,124,294,213,272,36,235,14,151,238,
                                            21,182,202,215,227,322,203,98,122,190,182,375,176,186,17,152,
                                            185,88,211,184,196,282,280,206,26,32,346,250,42,111,331,195,
                                            197,365,307,228,316,285,295,107,128,376,158,187,30,137,253,
                                            241,249,356,96,248,105,303,145,305,49,152,140,40,357,307,213,
                                            337,359,306,300,50,313,207,307,60,37,156,13,127,278,279,257,
                                            63,313,373,362,327,199,187,51,289,369,305,340,80,329,247,355,
                                            76,222,318,208,225,209,234,21,276,199,366,318,365,206,111,255,
                                            232,21,63,41,178,195,186,67,242,110,320,40,210,238,263,276,216,
                                            187,293,290,202,32,7,275,16,109,139,251,171,311,172,378,296,298,
                                            71,35,67,225,158,303,14,148,326,342,253,184,337,103,70,84,163,
                                            240,303,12,124,271,249,86,249,322,279,207,250,319,217,239,124,
                                            61,205,96,46,186,183,42,11,48,239,138,335,102,321,136,309,316,
                                            259,1,243,230,149,355,263,147,375,242,6,143,104,33,96,337,33,
                                            313,366,325,310,304,299,11,343,81,318,192,214,299,38,119,74,217,
                                            76,143,124,354,75,156,21,169,320,143,170,203,111,100,222,295,
                                            167,98,330,137,365,129,252,127,309,292,101,100,45,51,231,44,305,
                                            11,45,158,84,312,159,205,257,132,107,67,173,320,239,246,79,48,
                                            275,204,264,20,245,105,245,161,157,79,262,104,180,349,111,2,35,
                                            259,84,181,84,168,329,272,323,173,157,239,46,165,45,191,316,6,338,141})); // 64
    }
}
/**
    private static int minimumDistance(int[] nums) {
        int n = nums.length, res = Integer.MAX_VALUE;
        Map<Integer, Long> last = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int val = nums[i];
            int pos = i + 1;
            long pck = last.getOrDefault(val, 0L);
            int old = (int) (pck & 0xFFFFF);
            int cur = (int) (pck >> 20);
            last.put(val, (long) cur | ((long) pos << 20));
            if (old > 0) res = Math.min(res, (pos - old) << 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
*/
