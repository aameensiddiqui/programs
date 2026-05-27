/**
   3121. Count the Number of Special Characters II

   You are given a string word. A letter c is called special if it appears both in lowercase
   and uppercase in word, and every lowercase occurrence of c appears before the first uppercase
   occurrence of c.

   Return the number of special letters in word.

   Example 1:
   Input: word = "aaAbcBC"
   Output: 3
   Explanation:
   The special characters are 'a', 'b', and 'c'.

   Example 2:
   Input: word = "abc"
   Output: 0
   Explanation:
   There are no special characters in word.

   Example 3:
   Input: word = "AbBCab"
   Output: 0

   Explanation:
   There are no special characters in word.

   Constraints:
   1 <= word.length <= 2 * 105
   word consists of only lowercase and uppercase English letters.
*/
/*
have a hashmap<Char, List<Int>>
{a, [0,1]}
 */
import java.util.Arrays;

class CountTheNumberOfSpecialCharactersII {
    private static int numberOfSpecialChars(String word) {
        int[] lLow = new int[26];
        int[] fUpp = new int[26];
        Arrays.fill(lLow, -1);
        Arrays.fill(fUpp, -1);
        int cnt = 0;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lLow[ch - 'a'] = i;
            } else {
                if (fUpp[ch - 'A'] == -1) fUpp[ch - 'A'] = i;
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (lLow[i] != -1 && fUpp[i] != -1) {
                if (lLow[i] < fUpp[i]) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Log.info(numberOfSpecialChars("aaAbcBC")); // 3
        Log.info(numberOfSpecialChars("abc"));     // 0
        Log.info(numberOfSpecialChars("AbBCab"));  // 0
        Log.info(numberOfSpecialChars("deE"));     // 1
    }
}
