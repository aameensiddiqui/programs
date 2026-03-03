/**
   1545. Find Kth Bit in Nth Binary String

   Given two positive integers n and k, the binary string Sn is formed as follows:

   S1 = "0"
   Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
   Where + denotes the concatenation operation, reverse(x) returns the reversed
   string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

   For example, the first four strings in the above sequence are:

   S1 = "0"
   S2 = "011"
   S3 = "0111001"
   S4 = "011100110110001"
   Return the kth bit in Sn. It is guaranteed that k is valid for the given n.

   Example 1:
   Input: n = 3, k = 1
   Output: "0"
   Explanation: S3 is "0111001".
   The 1st bit is "0".

   Example 2:
   Input: n = 4, k = 11
   Output: "1"
   Explanation: S4 is "011100110110001".
   The 11th bit is "1".

   Constraints:
   1 <= n <= 20
   1 <= k <= 2n - 1
*/
import java.lang.StringBuilder;

class FindKthBitInNthBinaryString {
    // recursive
    private static char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int len = 1 << n; // 2^n
        if (k < len / 2) return findKthBit(n - 1, k);
        else if (k > len / 2) return findKthBit(n - 1, len - k) == '0' ? '1' : '0';
        else return '1';
    }
    public static void main(String[] args) {
        Log.info(findKthBit(3, 1));        // 0
        Log.info(findKthBit(4, 11));       // 1
        Log.info(findKthBit(3, 2));        // 1
        Log.info(findKthBit(3, 7));        // 1
        Log.info(findKthBit(20, 1048575)); // 1
    }
}
/**
    private static char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        for (int i = 1; i < n && k > s.length(); ++i) {
            s.append("1");
            for (int j = s.length() - 2; j >= 0; --j) {
                char ch = s.charAt(j) == '0' ? '1' : '0';
                s.append(ch);
            }
        }
        return s.charAt(k - 1);
    }
*/
/**
    private static String fun(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        s = String.valueOf(str);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                s = s.substring(0, i) + "1" + s.substring(i + 1);
            } else
                s = s.substring(0, i) + "0" + s.substring(i + 1);
        }
        return s;
    }
    private static char findKthBit(int n, int k) {
        String s1 = "0";
        for (int i = 2; i <= n; ++i) {
            String str = s1 + "1" + fun(s1);
            s1 = str;
        }
        return s1.charAt(k - 1);
    }
*/
