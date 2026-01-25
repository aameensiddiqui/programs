/**
   3442. Maximum Difference Between Even and Odd Frequency I

   You are given a string s consisting of lowercase English letters.

   Your task is to find the maximum difference diff = freq(a1) - freq(a2)
   between the frequency of characters a1 and a2 in the string such that:

   a1 has an odd frequency in the string.
   a2 has an even frequency in the string.
   Return this maximum difference.

   Example 1:
   Input: s = "aaaaabbc"
   Output: 3

   Explanation:
   The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
   The maximum difference is 5 - 2 = 3.

   Example 2:
   Input: s = "abcabcab"
   Output: 1

   Explanation:
   The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
   The maximum difference is 3 - 2 = 1.

   Constraints:
   3 <= s.length <= 100
   s consists only of lowercase English letters.
   s contains at least one character with an odd frequency and one with an even
   frequency.
*/
import java.util.*;

class MaxDiffEvenOddFreq {
    private static int maxDifference(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int oddMax = Integer.MIN_VALUE, evenMin = Integer.MAX_VALUE;
        for (int num : arr) {
            if ((num & 1) == 1) oddMax = Math.max(oddMax, num);
            else if (num > 0) evenMin = Math.min(evenMin, num);
        }
        return (oddMax - evenMin);
    }
    public static void main(String[]args) {
        Log.info(maxDifference("aaaaabbc")); //  3
        Log.info(maxDifference("abcabcab")); //  1
        Log.info(maxDifference("tzt"));      // -1
    }
}
/**
    private static int maxDifference(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int res = Integer.MIN_VALUE;
        for (int odd : arr) {
            if (odd == 0 || (odd & 1) != 1) continue;
            for (int even : arr) {
                if (even == 0 || (even & 1) == 1) continue;
                res = Math.max(res, odd - even);
            }
        }
        return res;
    }
*/
