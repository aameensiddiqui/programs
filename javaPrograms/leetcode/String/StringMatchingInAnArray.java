/**
   1408. String Matching in an Array

   Given an array of string words, return all strings in words that are a substring
   of another word. You can return the answer in any order.

   Example 1:
   Input: words = ["mass","as","hero","superhero"]
   Output: ["as","hero"]
   Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
   ["hero","as"] is also a valid answer.

   Example 2:
   Input: words = ["leetcode","et","code"]
   Output: ["et","code"]
   Explanation: "et", "code" are substring of "leetcode".

   Example 3:
   Input: words = ["blue","green","bu"]
   Output: []
   Explanation: No string of words is substring of another string.

   Constraints:
   1 <= words.length <= 100
   1 <= words[i].length <= 30
   words[i] contains only lowercase English letters.
   All the strings of words are unique.
*/
import java.util.*;

class StringMatchingInAnArray {
    private static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[]args) {
        Log.info(stringMatching(new String[]{"mass","as","hero","superhero"}));
        Log.info(stringMatching(new String[]{"leetcode","et","code"}));
        Log.info(stringMatching(new String[]{"blue","green","bu"}));
        Log.info(stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
        Log.info(stringMatching(new String[]{"one","two","three","four"}));
    }
}
/**
    private static boolean isSubstring(String s1, String s2) {
        for (int i = 0; i < s2.length(); ++i) {
            for (int j = i + 1; j < s2.length() + 1; ++j) {
                // Log.info("s2 = " + s2.substring(i, j));
                // Log.info("s1 = " + s1);
                // Log.info("=============");
                if (s2.substring(i, j).equals(s1)) return true;
            }
        }
        return false;
    }
    private static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int l1 = words[i].length();
                int l2 = words[j].length();
                String s1 = l1 < l2 ? words[i] : words[j];
                String s2 = l1 > l2 ? words[i] : words[j];
                if (l1 == l2) {
                    s1 = words[i];
                    s2 = words[j];
                }
                if (isSubstring(s1, s2) && !ans.contains(s1)) {
                    ans.add(s1);
                }
            }
        }
        return ans;
    }
*/
