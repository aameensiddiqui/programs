/**
   345. Reverse Vowels of a String

   Given a string s, reverse only all the vowels in the string and return it.

   The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
   and upper cases, more than once.

   Example 1:
   Input: s = "IceCreAm"
   Output: "AceCreIm"
   Explanation:
   The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

   Example 2:
   Input: s = "leetcode"
   Output: "leotcede"

   Constraints:
   1 <= s.length <= 3 * 105
   s consist of printable ASCII characters.
 */
class ReverseVowels {
    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[]chars = s.toCharArray();
        int l = 0, r = chars.length-1;
        while (l < r) {
            while (l < r && vowels.indexOf(chars[l]) == -1) l++;
            while (l < r && vowels.indexOf(chars[r]) == -1) r--;
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
    public static void main(String[]args) {
        log.info(reverseVowels("IceCreAm")); // AceCreIm
        log.info(reverseVowels("leetcode")); // leotcede
    }
    private static final Log log = new Log();
}
