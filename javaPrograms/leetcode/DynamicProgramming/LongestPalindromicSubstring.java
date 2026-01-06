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
        int n = s.length(), resLen = 0, resIdx = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (resLen < (j-i+1)) {
                        resIdx = i;
                        resLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(resIdx, resLen+resIdx);
    }
    public static void main(String[]args) {
        log.info(longestPalindrome("babad"));
        log.info(longestPalindrome("cbbd"));
        log.info(longestPalindrome("a"));
        log.info(longestPalindrome("bb"));

    }
}
/**
    private static String longestPalindrome(String s) {
        int resLen = 0, n = s.length();
        String ans = "";
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int l = i, r = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    ++l; --r;
                }
                if (l >= r && resLen < (j - i + 1)) {
                    resLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
*/
/**
    private static boolean isPal(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            str.append(s.charAt(i));
        }
        log.info("str="+str);
        String newS = str.toString();
        return newS.equals(s);
    }
    private static String longestPalindrome(String s) {
        int n = s.length();
        if (s.length() < 2) return s;
        int maxLen = 0;
        String ans = "";

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n + 1; ++j) {
                if (isPal(s.substring(i, j))) {
                    if (s.substring(i, j).length() > maxLen) {
                        ans = s.substring(i, j);
                        maxLen = s.substring(i, j).length();
                    }
                }
            }
        }
        return ans;
    }
*/
