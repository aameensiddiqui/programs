/**
   953. Verifying an Alien Dictionary

   In an alien language, surprisingly, they also use English lowercase letters, but possibly
   in a different order. The order of the alphabet is some permutation of lowercase letters.

   Given a sequence of words written in the alien language, and the order of the alphabet,
   return true if and only if the given words are sorted lexicographically in this alien language.

   Example 1:
   Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
   Output: true
   Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

   Example 2:
   Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
   Output: false
   Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the
   sequence is unsorted.

   Example 3:
   Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
   Output: false
   Explanation: The first three characters "app" match, and the second string is shorter (in size).
   According to lexicographical rules "apple" > "app", because 'l' > '0', where '0' is defined as
   the blank character which is less than any other character (More info).

   Constraints:
   1 <= words.length <= 100
   1 <= words[i].length <= 20
   order.length == 26
   All characters in words[i] and order are English lowercase letters.
*/
class VerifyingAnAlienDictionary {
    private static boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int i = 0; i < order.length(); ++i) orderIndex[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length - 1; ++i) {
            String w1 = words[i], w2 = words[i + 1];
            for (int j = 0; j < w1.length(); ++j) {
                if (j == w2.length()) return false;
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (orderIndex[w1.charAt(j) - 'a'] >
                        orderIndex[w2.charAt(j) - 'a']) return false;
                    break;
                }
            }
        }
        return true;
    }
    public static void main(String[]args) {
        Log.info(isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Log.info(isAlienSorted(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        Log.info(isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
