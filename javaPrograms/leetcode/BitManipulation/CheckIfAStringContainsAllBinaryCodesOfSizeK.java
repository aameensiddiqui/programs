/**
   1461. Check If a String Contains All Binary Codes of Size K

   Given a binary string s and an integer k, return true if every binary code of
   length k is a substring of s. Otherwise, return false.

   Example 1:
   Input: s = "00110110", k = 2
   Output: true
   Explanation: The binary codes of length 2 are "00", "01", "10" and "11".
   They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
   Example 2:
   Input: s = "0110", k = 1
   Output: true
   Explanation: The binary codes of length 1 are "0" and "1", it is clear that both
   exist as a substring.

   Example 3:
   Input: s = "0110", k = 2
   Output: false
   Explanation: The binary code "00" is of length 2 and does not exist in the array.

   Constraints:
   1 <= s.length <= 5 * 105
   s[i] is either '0' or '1'.
   1 <= k <= 20
*/
class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    private static boolean hasAllCodes(String s, int k) {
        int r = 1 << k;
        int m = r - 1, hash = 0;
        boolean[] seen = new boolean[r];
        for (int i = 0; i < s.length(); ++i) {
            hash = ((hash << 1) & m) | (s.charAt(i) & 1);
            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                r--;
                if (r == 0) return true;
            }
        }
        return false;
    }
    public static void main(String[]args) {
        Log.info(hasAllCodes("00110110", 2));
        Log.info(hasAllCodes("0110", 1));
        Log.info(hasAllCodes("0110", 2));
    }
}
