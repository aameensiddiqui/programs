/**
   3517. Smallest Palindromic Rearrangement I

   You are given a palindromic string s.

   Return the lexicographically smallest palindromic permutation of s.

   Example 1:
   Input: s = "z"
   Output: "z"
   Explanation:
   A string of only one character is already the lexicographically smallest palindrome.

   Example 2:
   Input: s = "babab"
   Output: "abbba"
   Explanation:
   Rearranging "babab" -> "abbba" gives the smallest lexicographic palindrome.

   Example 3:
   Input: s = "daccad"
   Output: "acddca"
   Explanation:
   Rearranging "daccad" -> "acddca" gives the smallest lexicographic palindrome.

   Constraints:
   1 <= s.length <= 105
   s consists of lowercase English letters.
   s is guaranteed to be palindromic.
*/
class SmallestPalindromicRearrangementI {
    private static String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n / 2; ++i)
            freq[chars[i] - 'a']++;
        for (int i = 0, j = 0; i < 26; ++i) {
            while (freq[i]-- > 0) {
                chars[j] = (char) (i + 'a');
                chars[n - 1 - j] = (char) (i + 'a');
                j++;
            }
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        Log.info(smallestPalindrome("z"));
        Log.info(smallestPalindrome("babab"));
        Log.info(smallestPalindrome("daccad"));
        Log.info(smallestPalindrome("yey"));
    }
}
