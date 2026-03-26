/**
   2864. Maximum Odd Binary Number

   You are given a binary string s that contains at least one '1'.

   You have to rearrange the bits in such a way that the resulting binary number is the
   maximum odd binary number that can be created from this combination.

   Return a string representing the maximum odd binary number that can be created from
   the given combination.

   Note that the resulting string can have leading zeros.

   Example 1:
   Input: s = "010"
   Output: "001"
   Explanation: Because there is just one '1', it must be in the last position.
   So the answer is "001".

   Example 2:
   Input: s = "0101"
   Output: "1001"
   Explanation: One of the '1's must be in the last position. The maximum number that can
   be made with the remaining digits is "100". So the answer is "1001".

   Constraints:
   1 <= s.length <= 100
   s consists only of '0' and '1'.
   s contains at least one '1'.
*/
import java.util.Arrays;

class MaximumOddBinaryNumber {
    // better to use two pointers and use the same greedy approach
    // of having 1s first then the 0s and last 1
    // by moving all 1s to the left then swap 1 to the last position
    private static String maximumOddBinaryNumber(String s) {
        int n = s.length(), left = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '1') {
                char t = arr[i];
                arr[i] = arr[left];
                arr[left++] = t;
            }
        }
        char t = arr[left - 1];
        arr[left - 1] = arr[n - 1];
        arr[n - 1] = t;
        return new String(arr);
    }
    public static void main(String[]args) {
        Log.info(maximumOddBinaryNumber("010"));
        Log.info(maximumOddBinaryNumber("0101"));
    }
}
/**
    // greedy
    // We do not actually need to sort. The optimal answer has a simple structure:
    // place all but one 1 at the beginning, followed by all 0s, and end with a single 1.
    // We just need to count the 1s. If there are count ones,
    // the result is (count - 1) ones, then (n - count) zeros, then one 1.
    private static String maximumOddBinaryNumber(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) if (s.charAt(i) == '1') cnt++;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cnt - 1; ++i) str.append("1");
        for (int i = 0; i < s.length() - cnt; ++i) str.append("0");
        str.append("1");
        return str.toString();
    }
*/
/**
    private static void reverse(char[] arr, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }
    private static String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        Arrays.sort(arr);
        reverse(arr, n);

        int i = n - 1, cnt = 0;
        while (i >= 0 && arr[i] == '0') --i;

        char t = arr[i];
        arr[i] = arr[n - 1];
        arr[n - 1] = t;

        return new String(arr);
    }
*/
