/**
    290. Word Pattern

    Given a pattern and a string s, find if s 
    follows the same pattern.

    Here follow means a full match, such that there is a 
    bijection between a letter in pattern and a 
    non-empty word in s. 
    Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one 
    letter in pattern.
    No two letters map to the same word, and no 
    two words map to the same letter.
 

    Example 1:
    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true
    Explanation:

    The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".

    Example 2:
    Input: pattern = "abba", s = "dog cat cat fish"
    Output: false

    Example 3:
    Input: pattern = "aaaa", s = "dog cat cat dog"
    Output: false

    Constraints:
    1 <= pattern.length <= 300
    pattern contains only lower-case English letters.
    1 <= s.length <= 3000
    vs contains only lowercase English letters and spaces ' '.
    s does not contain any leading or trailing spaces.
    All the words in s are separated by a single space.
*/
import java.util.*;
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mpp = new HashMap<>();
        String[]str = s.trim().split("\\s+");
        if(str.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            if(mpp.containsKey(ch)) {
                if(!mpp.get(ch).equals(str[i]))
                    return false;
            } else {
                if(mpp.containsValue(str[i])) return false;
                mpp.put(ch, str[i]);
            }
        }
        return true;
    }
    public static void main(String[]args) {
        String pattern1 = "abba";
        String pattern2 = "abba";
        String pattern3 = "aaaa";
        String pattern4 = "abba";
        String s1 = "dog cat cat dog";
        String s2 = "dog cat cat fish";
        String s3 = "dog cat cat dog";
        String s4 = "dog dog dog dog";
        System.out.println(wordPattern(pattern1, s1));
        System.out.println(wordPattern(pattern2, s2));
        System.out.println(wordPattern(pattern3, s3));
        System.out.println(wordPattern(pattern4, s4));
    }
}
