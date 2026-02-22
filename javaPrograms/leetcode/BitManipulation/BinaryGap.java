/**
   868. Binary Gap

   Given a positive integer n, find and return the longest distance between any two
   adjacent 1's in the binary representation of n. If there are no two adjacent 1's,
   return 0.

   Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The
   distance between two 1's is the absolute difference between their bit positions.
   For example, the two 1's in "1001" have a distance of 3.

   Example 1:
   Input: n = 22
   Output: 2
   Explanation: 22 in binary is "10110".
   The first adjacent pair of 1's is "10110" with a distance of 2.
   The second adjacent pair of 1's is "10110" with a distance of 1.
   The answer is the largest of these two distances, which is 2.
   Note that "10110" is not a valid pair since there is a 1 separating the two 1's
   underlined.

   Example 2:
   Input: n = 8
   Output: 0
   Explanation: 8 in binary is "1000".
   There are not any adjacent pairs of 1's in the binary representation of 8, so we
   return 0.

   Example 3:
   Input: n = 5
   Output: 2
   Explanation: 5 in binary is "101".

   Constraints:
   1 <= n <= 109
*/
class BinaryGap {
    /*
      we need to remember the last value seen.
      we'll store last, the last value added to the virtual array A.
      if n has the ith bit set, a candidate answer is i - last,
      and then the new last value added to A would be last = i.
     */
    private static int binaryGap(int n) {
        int last = -1, res = 0;
        for (int i = 0; i < 32; ++i) {
            if (((n >> i) & 1) > 0) {
                if (last >= 0) {
                    res = Math.max(res, i - last);
                }
                last = i;
            }
        }
        return res;
    }
    public static void main(String[]args) {
        Log.info(binaryGap(22));
        Log.info(binaryGap(8));
        Log.info(binaryGap(5));
        Log.info(binaryGap(13));
    }
}
/**
    private static int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        // Log.info(s); 1101
        int res = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            // Log.info(i + " " + s.charAt(i));
            if (s.charAt(i) == '1') {
                int j = i + 1, gap = 0;
                while (j < s.length() && s.charAt(j) == '0') {
                    ++gap; ++j;
                }
                if (j < s.length() && s.charAt(j) == '1') {
                    res = Math.max(gap + 1, res);
                }
            }
        }
        return res;
    }
*/
