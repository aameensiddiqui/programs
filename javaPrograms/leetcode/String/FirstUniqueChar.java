/**
   387. First Unique Character in a String

   Given a string s, find the first non-repeating character in it and return
   its index. If it does not exist, return -1.

   Example 1:
   Input: s = "leetcode"
   Output: 0

   Explanation:
   The character 'l' at index 0 is the first character that does not occur
   at any other index.

   Example 2:
   Input: s = "loveleetcode"
   Output: 2

   Example 3:
   Input: s = "aabb"
   Output: -1

   Constraints:
   1 <= s.length <= 105
   s consists of only lowercase English letters.
 */
public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        int[]count = new int[26];
        int n = s.length();
        for(int i = 0; i < n; ++i) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        for(int i = 0; i < n; ++i) {
            int index = s.charAt(i) - 'a';
            if(count[index] == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[]args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));
    }
}
