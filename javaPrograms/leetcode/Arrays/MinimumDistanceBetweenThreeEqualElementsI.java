/**
   3740. Minimum Distance Between Three Equal Elements I

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
   1 <= n == nums.length <= 100
   1 <= nums[i] <= n
*/
class MinimumDistanceBetweenThreeEqualElementsI {
    /*
     * For any three equal elements at indices a < b < c, the distance formula
     * |a-b| + |b-c| + |c-a| always simplifies to 2*(c-a) -> the middle index cancels out.
     * So we only care about the first and last positions of any triple, and to minimize
     * the gap, we always want three consecutive occurrences of the same value.
     *
     * As we scan the array, we track the last two positions seen for each value.
     * Since n <= 100, every index fits in 8 bits,
     * so we pack both positions into one integer (lower 8 bits = older position,
     * upper bits = newer position).
     e.g. old pos = 3, new pos = 7
     binary = (7 >> 8) | 3
              [new pos]  [old pos]
     binary = 00000111 _ 00000011
            = 0000011100000011 = 1795
     * When the same value appears a third time, we have a complete consecutive triple
     * and compute the distance as 2 * (current - oldest). We keep a running minimum.
     */
    private static int minimumDistance(int[] nums) {
        int n = nums.length;
        int res = 200;
        int[] last2 = new int[n];
        for (int i = 0; i < n; ++i) {
            // as values are from 1 to n, we store them such that the indexing starts at 0.
            // like val 1 will be stored at pos last2[0]. 22 at last2[21].
            int val = nums[i] - 1;
            int pos = i + 1; // to avoid using 0
            int pck = last2[val];
            int old = pck & 255; // extracts lower 8 bits (old pos)
            int cur = pck >> 8;  // extracts upper 8 bits (new pos)
            last2[val] = cur | (pos << 8);
            if (old > 0) res = Math.min(res, (pos - old) << 1); // 2 * (k - i)
        }
        return res == 200 ? -1 : res;
    }
    public static void main(String[] args) {
        Log.info(minimumDistance(new int[] {1,2,1,1,3}));
        Log.info(minimumDistance(new int[] {1,1,2,3,2,1,2}));
        Log.info(minimumDistance(new int[] {1}));
    }
}
/**
      // |i - j| + |j - k| + |i - k|
      // (j - i) + (k - j) + (k - i)
      // j - i + k - j + k - i
      // j - j - i - i + k + k
      // 2(k - i)
    private static int minimumDistance(int[] nums) {
        int n = nums.length;
        int res = n + 1;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                if (nums[i] != nums[j]) continue;
                for (int k = j + 1; k < n; ++k) {
                    if (nums[j] == nums[k]) {
                        res = Math.min(
                            res,
                            k - i
                        );
                        break;
                    }
                }
            }
        }
        return res == n + 1 ? -1 : res * 2;
    }
*/
/**
    private static int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                if (nums[i] != nums[j]) continue;
                for (int k = j + 1; k < n; ++k) {
                    if (nums[j] == nums[k]) {
                        res = Math.min(
                            res,
                            Math.abs(i - j) + Math.abs(j - k) + Math.abs(i - k)
                        );
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
*/
