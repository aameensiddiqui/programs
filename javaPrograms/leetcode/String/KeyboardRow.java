/**
   500. Keyboard Row

   Given an array of strings words, return the words that can be typed using letters of the
   alphabet on only one row of American keyboard like the image below.

   Note that the strings are case-insensitive, both lowercased and uppercased of the same letter
   are treated as if they are at the same row.

   In the American keyboard:

   the first row consists of the characters "qwertyuiop",
   the second row consists of the characters "asdfghjkl", and
   the third row consists of the characters "zxcvbnm".

   Example 1:
   Input: words = ["Hello","Alaska","Dad","Peace"]
   Output: ["Alaska","Dad"]
   Explanation:
   Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.

   Example 2:
   Input: words = ["omk"]
   Output: []

   Example 3:
   Input: words = ["adsdf","sfd"]
   Output: ["adsdf","sfd"]

   Constraints:
   1 <= words.length <= 20
   1 <= words[i].length <= 100
   words[i] consists of English letters (both lowercase and uppercase).
*/
import java.util.List;
import java.util.ArrayList;

class KeyboardRow {
    private static String r1 = "qwertyuiop";
    private static String r2 = "asdfghjkl";
    private static String r3 = "zxcvbnm";
    private static boolean check(String w, String r) {
        w = w.toLowerCase();
        for (char ch : w.toCharArray()) {
            if (!r.contains(String.valueOf(ch))) return false;
        }
        return true;
    }
    private static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String w : words) {
            if (check(w, r1) || check(w, r2) || check(w, r3))
                list.add(w);
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Log.info((Object) findWords(new String[] {"Hello","Alaska","Dad","Peace"}));
        Log.info((Object) findWords(new String[] {"omk"}));
        Log.info((Object) findWords(new String[] {"adsdf","sfd"}));
    }
}
