/**
   3. Longest Substring Without Repeating Characters

   Given a string s, find the length of the longest substring without duplicate characters.

   Example 1:
   Input: s = "abcabcbb"
   Output: 3
   Explanation: The answer is "abc", with the length of 3.
   Note that "bca" and "cab" are also correct answers.

   Example 2:
   Input: s = "bbbbb"
   Output: 1
   Explanation: The answer is "b", with the length of 1.

   Example 3:
   Input: s = "pwwkew"
   Output: 3
   Explanation: The answer is "wke", with the length of 3.
   Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

   Constraints:
   0 <= s.length <= 5 * 104
   s consists of English letters, digits, symbols and spaces.
 */
import java.util.*;
class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = Integer.MIN_VALUE;
        int l = 0, r = 0;
        int[]arr = new int[128];
        while(r < s.length()) {
            l = Math.max(l, arr[s.charAt(r)]);
            ans = Math.max(ans, r-l+1);
            arr[s.charAt(r)] = r+1;
            r++;
        }
        return ans;
    }
    public static void main(String[]args) {
        log.info(lengthOfLongestSubstring("abcabcbb"));
        log.info(lengthOfLongestSubstring("bbbbb"));
        log.info(lengthOfLongestSubstring("pwwkew"));
        log.info(lengthOfLongestSubstring(" "));
    }
    private static final Log log = new Log();
}
/**
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = Integer.MIN_VALUE;
        int l = 0, r = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(r < s.length()) {
            if(mpp.containsKey(s.charAt(r)))
                l = Math.max(l, mpp.get(s.charAt(r))+1);
            mpp.put(s.charAt(r), r);
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
 */
/*
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); ++i) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); ++j) {
                if(set.contains(s.charAt(j))) {
                    ans = Math.max(ans, j-i);
                    break;
                } else {
                    set.add(s.charAt(j));
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
 */
/**
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        for(int i = 0; i < s.length(); ++i) {
            int[]arr = new int[256];
            for(int j = i; j < s.length(); ++j) {
                if(arr[s.charAt(j)] != 0) {
                    ans = Math.max(ans, j-i);
                    break;
                }
                else {
                    arr[s.charAt(j)]++;
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
 */
