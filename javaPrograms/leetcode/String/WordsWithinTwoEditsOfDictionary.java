/**
   2452. Words Within Two Edits of Dictionary

   You are given two string arrays, queries and dictionary. All words in each array comprise of
   lowercase English letters and have the same length.

   In one edit you can take a word from queries, and change any letter in it to any other letter.
   Find all words from queries that, after a maximum of two edits, equal some word from dictionary.

   Return a list of all words from queries, that match with some word from dictionary after a maximum
   of two edits. Return the words in the same order they appear in queries.

   Example 1:
   Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
   Output: ["word","note","wood"]
   Explanation:
   - Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
   - Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
   - It would take more than 2 edits for "ants" to equal a dictionary word.
   - "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
   Thus, we return ["word","note","wood"].

   Example 2:
   Input: queries = ["yes"], dictionary = ["not"]
   Output: []
   Explanation:
   Applying any two edits to "yes" cannot make it equal to "not". Thus, we return an empty array.

   Constraints:
   1 <= queries.length, dictionary.length <= 100
   n == queries[i].length == dictionary[j].length
   1 <= n <= 100
   All queries[i] and dictionary[j] are composed of lowercase English letters.
*/
import java.util.*;

class WordsWithinTwoEditsOfDictionary {
    private static boolean hasMatch(String q, String[] dictionary) {
        for (String d : dictionary) {
            int cnt = 2;
            for (int i = 0; i < d.length(); ++i) {
                if (q.charAt(i) != d.charAt(i)) cnt--;
                if (cnt < 0) break;
            }
            if (cnt >= 0) return true;
        }
        return false;
    }
    private static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (String q : queries) {
            if (hasMatch(q, dictionary)) list.add(q);
        }
        return list;
    }
    public static void main(String[] args) {
        Log.info(twoEditWords(new String[] {"word","note","ants","wood"}, new String[] {"wood","joke","moat"}));
        // ["word","note","wood"]
        Log.info(twoEditWords(new String[] {"yes"}, new String[] {"not"}));
        // []
        Log.info(twoEditWords(new String[] {"tsl","sri","yyy","rbc","dda","qus","hyb","ilu","ahd"},
                              new String[] {"uyj","bug","dba","xbe","blu","wuo","tsf","tga"}));
        // ["tsl","yyy","rbc","dda","qus","hyb","ilu"]
    }
}
/**
    private static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        int cnt = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt > 2 ? false : true;
    }
    private static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queries.length; ++i) {
            for (int j = 0; j < dictionary.length; ++j) {
                if (compare(queries[i], dictionary[j])) {
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }
*/
