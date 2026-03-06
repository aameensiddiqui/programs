/**
   1784. Check if Binary String Has at Most One Segment of Ones

   Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains
   at most one contiguous segment of ones. Otherwise, return false.

   Example 1:
   Input: s = "1001"
   Output: false
   Explanation: The ones do not form a contiguous segment.

   Example 2:
   Input: s = "110"
   Output: true

   Constraints:
   1 <= s.length <= 100
   s[i]​​​​ is either '0' or '1'.
   s[0] is '1'.
*/
class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    private static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
    public static void main(String[] args) {
        Log.info(checkOnesSegment("1001")); // F
        Log.info(checkOnesSegment("110"));  // T
        Log.info(checkOnesSegment("1"));    // T
        Log.info(checkOnesSegment("10"));   // T
        Log.info(checkOnesSegment("111"));  // T
    }
}
/**
    // NAH
    private static boolean checkOnesSegment(String s) {
        if (s.length() == 1) return true;
        if (s.length() == 2) {
            int b = Integer.parseInt(s);
            return Integer.bitCount(b) >= 1;
        }
        int cnt = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == '1' && s.charAt(i) == '1') cnt++;
            Log.info(cnt);
        }
        if (cnt == 1) return true;
        else return false;
    }
*/
