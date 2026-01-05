/**
   5. Longest Palindromic Substring

   Given a string s, return the longest palindromic substring in s.

   Example 1:
   Input: s = "babad"
   Output: "bab"
   Explanation: "aba" is also a valid answer.

   Example 2:
   Input: s = "cbbd"
   Output: "bb"

   Constraints:
   1 <= s.length <= 1000
   s consist of only digits and English letters.
*/
class LongestPalndromicSubstring {
    private static String longestPalindrome(String s) {
        int resLen = 0, resInd = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (resLen < (j-i+1)) {
                        resInd = i;
                        resLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(res, resLen+resInd);
    }
    public static void main(String[]args) {
        log.info(longestPalindrome("babad"));
        log.info(longestPalindrome("cbbd"));
    }
}
