/**
   3120. Count the Number of Special Characters I

   You are given a string word. A letter is called special if it appears both in lowercase and
   uppercase in word.

   Return the number of special letters in word.

   Example 1:
   Input: word = "aaAbcBC"
   Output: 3
   Explanation:
   The special characters in word are 'a', 'b', and 'c'.

   Example 2:
   Input: word = "abc"
   Output: 0
   Explanation:
   No character in word appears in uppercase.

   Example 3:
   Input: word = "abBCab"
   Output: 1
   Explanation:
   The only special character in word is 'b'.

   Constraints:
   1 <= word.length <= 50
   word consists of only lowercase and uppercase English letters.
*/
class CountTheNumberOfSpecialCharactersI {
    private static int numberOfSpecialChars(String word) {
        int low = 0, upp = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch))
                low |= (1 << (ch - 'a'));
            else
                upp |= (1 << (ch - 'A'));
        }
        return Integer.bitCount(low & upp);
    }
    public static void main(String[] args) {
        Log.info(numberOfSpecialChars("aaAbcBC")); // 3
        Log.info(numberOfSpecialChars("abc"));     // 0
        Log.info(numberOfSpecialChars("abBCab"));  // 1
        Log.info(numberOfSpecialChars("CCc"));     // 1
    }
}
/**
    private static int numberOfSpecialChars(String word) {
        boolean[] arr = new boolean['z' + 1];
        int cnt = 0;
        for (char ch : word.toCharArray())
            arr[ch] = true;
        for (int i = 0; i < 26; ++i)
            if (arr[i + 'a'] && arr[i + 'A'])
                cnt++;
        return cnt;
    }
*/
/**
    // my solution
    private static int numberOfSpecialChars(String word) {
        int[] arr = new int[26];
        int cnt = 0;
        for (char ch : word.toCharArray()) {
            if (ch < 97 && arr[ch - 'A'] == 0) arr[ch - 'A']++;
        }
        for (char ch : word.toCharArray()) {
            if (ch >= 97 && arr[ch - 'a'] == 1) {
                arr[ch - 'a']++;
                cnt++;
            }
        }
        Log.info("cnt = " + cnt);
        Log.info(arr);
        return cnt;
    }
*/
