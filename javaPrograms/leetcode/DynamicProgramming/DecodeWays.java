/**
   91. Decode Ways

   You have intercepted a secret message encoded as a string of numbers.
   The message is decoded via the following mapping:

   "1"  -> 'A'
   "2"  -> 'B'
   .
   .
   "25" -> 'Y'
   "26" -> 'Z'

   However, while decoding the message, you realize that there are many different
   ways you can decode the message because some codes are contained in other codes
   ("2" and "5" vs "25").

   For example, "11106" can be decoded into:

   "AAJF" with the grouping (1, 1, 10, 6)
   "KJF" with the grouping (11, 10, 6)
   The grouping (1, 11, 06) is invalid because "06" is not a valid code
   (only "6" is valid).
   Note: there may be strings that are impossible to decode.

   Given a string s containing only digits, return the number of ways to decode it.
   If the entire string cannot be decoded in any valid way, return 0.

   The test cases are generated so that the answer fits in a 32-bit integer.

   Example 1:
   Input: s = "12"
   Output: 2
   Explanation:
   "12" could be decoded as "AB" (1 2) or "L" (12).

   Example 2:
   Input: s = "226"
   Output: 3
   Explanation:
   "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

   Example 3:
   Input: s = "06"
   Output: 0

   Explanation:
   "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
   In this case, the string is not a valid encoding, so return 0.

   Constraints:
   1 <= s.length <= 100
   s contains only digits and may contain leading zero(s).
*/
import java.util.*;

class DecodeWays {
    // space optimized dp
    private static int numDecodings(String s) {
        int dp = 0, dp1 = 1, dp2 = 0;
        for (int i = s.length()-1; i >= 0; --i) {
            if (s.charAt(i) == '0') dp = 0;
            else {
                dp = dp1;
                if (i < s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                    dp += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }
        return dp1;
    }
    public static void main(String[]args) {
        log.info(numDecodings("12"));
        log.info(numDecodings("06"));
        log.info(numDecodings("102"));
        log.info(numDecodings("226"));
        log.info(numDecodings("111111111111111111111111111111111111111111111"));
    }
}
/**
    // iterative dp (bottom-up)
    private static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for (int i = s.length()-1; i >= 0; --i) {
            if (s.charAt(i) == '0') dp[0] = 0;
            else {
                dp[i] = dp[i+1];
                if (i < s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
*/
/**
    // use of dp (memoization) in recursive approach
    // tc: O(n) sc: O(n)
    private static int dfs(Map<Integer, Integer> dp, int i, String s) {
        if (dp.containsKey(i)) return dp.get(i);
        if (s.charAt(i) == '0') return 0;
        int res = dfs(dp, i+1, s);
        if (i < s.length()-1) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
                res += dfs(dp, i+2, s);
            }
        }
        dp.put(i, res);
        return res;
    }
    private static int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(dp, 0, s);
    }
*/
/**
    // brute force recursive approach
    // tc: O(2^n) sc: O(n)
    private static int dfs(int i, String s) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        int res = dfs(i+1, s);
        if (i < s.length()-1) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
                res += dfs(i+2, s);
            }
        }
        return res;
    }
    private static int numDecodings(String s) {
        return dfs(0, s);
    }
*/
