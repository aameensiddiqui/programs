/**
   1081. Smallest Subsequence of Distinct Characters

   Given a string s, return the lexicographically smallest subsequence of s that contains
   all the distinct characters of s exactly once.

   Example 1:
   Input: s = "bcabc"
   Output: "abc"

   Example 2:
   Input: s = "cbacdcbc"
   Output: "acdb"

   Constraints:
   1 <= s.length <= 1000
   s consists of lowercase English letters.
*/
import java.util.Stack;

class SmallestSubsequenceOfDistinctCharacters {
    private static String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        String res = "";

        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int x = ch - 'a';
            freq[x]--;
            if (seen[x]) continue;

            while (!stack.isEmpty()) {
                char sp = stack.peek();
                if (sp <= ch) break;
                if (freq[sp - 'a'] == 0) break;
                seen[sp - 'a'] = false;
                stack.pop();
            }

            stack.push(ch);
            seen[x] = true;
        }
        for (char c : stack) res += c;
        return res;
    }
    public static void main(String[] args) {
        Log.info(smallestSubsequence("bcabc"));
        Log.info(smallestSubsequence("cbacdcbc"));
        Log.info(smallestSubsequence("nfrgpdkaawogejjtsiilzbwduusydlijrbyfvacgeguvccpdvhfdxzygnd"+
                                     "xzpzwaffxgvijhyblrrjtlinysreitegavkrtbzeyzrokwhtwzegxsjbbw"+
                                     "qczlfxndsnfxjnxhsezsmxtvkcxevrboxjqrthujosysfwpgrbpozbvugd"+
                                     "jvgpeutulqusssruktnghecvwq")); // "abcdeifhmkoxjqrsygpzlutnvw"
    }
}
/**
    private static String smallestSubsequence(String s) {
        int[] freq = new int[27];
        boolean[] seen = new boolean[27];
        Stack<Character> stack = new Stack<>();
        String res = "";

        for (char ch : s.toCharArray()) freq[ch & 31]++;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int x = ch & 31;
            freq[x]--;
            if (seen[x]) continue;

            while (!stack.isEmpty()) {
                char sp = stack.peek();
                if (sp <= ch) break;
                if (freq[sp & 31] == 0) break;
                seen[sp & 31] = false;
                stack.pop();
            }

            stack.push(ch);
            seen[x] = true;
        }
        for (char c : stack) res += c;
        return res;
    }
*/
