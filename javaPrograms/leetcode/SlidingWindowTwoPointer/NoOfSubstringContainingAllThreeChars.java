/**
   1358. Number of Substrings Containing All Three Characters

   Given a string s consisting only of characters a, b and c.

   Return the number of substrings containing at least one occurrence of all
   these characters a, b and c.

   Example 1:
   Input: s = "abcabc"
   Output: 10
   Explanation: The substrings containing at least one occurrence of the
   characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
   "bcabc", "cab", "cabc" and "abc" (again). 

   Example 2:
   Input: s = "aaacb"
   Output: 3
   Explanation: The substrings containing at least one occurrence of the
   characters a, b and c are "aaacb", "aacb" and "acb". 

   Example 3:
   Input: s = "abc"
   Output: 1

   Constraints:
   3 <= s.length <= 5 x 10^4
   s only consists of a, b or c characters.
 */
class NoOfSubstringContainingAllThreeChars {
    public static int numberOfSubstrings(String s) {
        int cnt = 0, l = 0;
        int[]freq = new int[3];
        for(int r = 0; r < s.length(); ++r) {
            freq[s.charAt(r) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                cnt += (s.length() - r);
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return cnt;
    }
    public static void main(String[]args) {
        log.info(numberOfSubstrings("abcabc"));
        log.info(numberOfSubstrings("aaabc"));
        log.info(numberOfSubstrings("abc"));
    }
    private static final Log log = new Log();
}
/**
    public static int numberOfSubstrings(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); ++i) {
            int[]freq = new int[3];
            for(int j = i; j < s.length(); ++j) {
                freq[s.charAt(j) - 'a']++;
                if(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) cnt++;
            }
        }
        return cnt;
    }
 */
