/**
   680. Valid Palindrome II

   Given a string s, return true if the s can be palindrome after deleting at
   most one character from it.

   Example 1:
   Input: s = "aba"
   Output: true

   Example 2:
   Input: s = "abca"
   Output: true
   Explanation: You could delete the character 'c'.

   Example 3:
   Input: s = "abc"
   Output: false

   Constraints:
   1 <= s.length <= 105
   s consists of lowercase English letters.
*/
class ValidPalindromeII {
    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }
    private static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) ||
                    isPalindrome(s, l, r - 1);
            }
            ++l; --r;
        }
        return true;
    }
    public static void main(String[]args) {
        Log.info(validPalindrome("aba"));   // true
        Log.info(validPalindrome("abca"));  // true
        Log.info(validPalindrome("abc"));   // false
        Log.info(validPalindrome("a"));     // true
        Log.info(validPalindrome("eccer")); // true
    }
}
/**
    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }
    private static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s.substring(0, l) + s.substring(l + 1)) ||
                    isPalindrome(s.substring(0, r) + s.substring(r + 1));
            }
            ++l; --r;
        }
        return true;
    }
*/
/**
    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }
    private static boolean validPalindrome(String s) {
        if (isPalindrome(s)) return true;
        for (int i = 0; i < s.length(); ++i) {
            String str = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(str)) return true;
        }
        return false;
    }
*/
