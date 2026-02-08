/**
   1189. Maximum Number of Balloons

   Given a string text, you want to use the characters of text to form
   as many instances of the word "balloon" as possible.

   You can use each character in text at most once. Return the maximum
   number of instances that can be formed.

   Example 1:
   Input: text = "nlaebolko"
   Output: 1

   Example 2:
   Input: text = "loonbalxballpoon"
   Output: 2

   Example 3:
   Input: text = "leetcode"
   Output: 0

   Constraints:
   1 <= text.length <= 104
   text consists of lower case English letters only.
*/
import java.util.*;

class MaxNumberOfBalloons {
    private static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (char c : text.toCharArray()) {
            if ("balon".indexOf(c) != -1)
                mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }
        if (mpp.size() < 5) return 0;
        mpp.put('l', mpp.get('l') / 2);
        mpp.put('o', mpp.get('o') / 2);
        return Collections.min(mpp.values());
    }
    public static void main(String[]args) {
        Log.info(maxNumberOfBalloons("nlaebolko"));
        Log.info(maxNumberOfBalloons("loonbalxballpoon"));
        Log.info(maxNumberOfBalloons("leetcode"));
    }
}
