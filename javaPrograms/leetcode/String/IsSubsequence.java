/**
   392. Is Subsequence

   Given two strings s and t, return true if s is a subsequence of t,
   or false otherwise.

   A subsequence of a string is a new string that is formed from the
   original string by deleting some (can be none) of the characters
   without disturbing the relative positions of the remaining characters.
   (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

   Example 1:
   Input: s = "abc", t = "ahbgdc"
   Output: true

   Example 2:
   Input: s = "axc", t = "ahbgdc"
   Output: false

   Constraints:
   0 <= s.length <= 100
   0 <= t.length <= 104
   s and t consist only of lowercase English letters.
*/
import java.util.*;

class IsSubsequence {
    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int i = 0;
        for (int j = 0; j < t.length(); ++j) {
            if (s.charAt(i) == t.charAt(j)) {
                if (i++ == s.length()-1) return true;
            }
        }
        return false;
    }
    public static void main(String[]args) {
        IO.println(isSubsequence("abc", "ahbgdc")); // true
        IO.println(isSubsequence("axc", "ahbgdc")); // false
        IO.println(isSubsequence("acb", "ahbgdc")); // false
        IO.println(isSubsequence("aza", "abzba"));  // true
    }
}
/**
    private static boolean isSubsequence(String s, String t) {
        LinkedHashMap<Integer, Character> mpp = new LinkedHashMap<>();
        int lastIndex = -1;
        for (int i = 0; i < s.length(); ++i) {
            boolean found = false;
            for (int j = lastIndex + 1; j < t.length(); ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    mpp.put(j, t.charAt(j));
                    lastIndex = j;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    } 
*/
