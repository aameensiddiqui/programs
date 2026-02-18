/**
   693. Binary Number with Alternating Bits

   Given a positive integer, check whether it has alternating bits:
   namely, if two adjacent bits will always have different values.

   Example 1:
   Input: n = 5
   Output: true
   Explanation: The binary representation of 5 is: 101

   Example 2:
   Input: n = 7
   Output: false
   Explanation: The binary representation of 7 is: 111.

   Example 3:
   Input: n = 11
   Output: false
   Explanation: The binary representation of 11 is: 1011.

   Constraints:
   1 <= n <= 231 - 1
*/
class BinaryNumWithAlternatingBits {
    /*
      We can get the last bit and the rest of the bits via n % 2 and n / 2.
      Let's remember cur, the last bit of n.
      If the last bit ever equals the last bit of the remaining,
      then two adjacent bits have the same value, and the answer is False.
      Otherwise, the answer is True.
      Also note that instead of n % 2 and n / 2,
      we could have used operators n & 1 and n >>= 1 instead.
     */
    private static boolean hasAlternatingBits(int n) {
        int cur = n & 1; // gets the last bit (1 or 0)
        n >>= 1;         // removes the last bit (right shift)
        while (n > 0) {
            // if the current bit is equal to last bit return false
            if (cur == (n & 1)) return false;
            cur = n & 1;
            n >>= 1;
        }
        return true;
    }
    public static void main(String[]args) {
        Log.info(hasAlternatingBits(5));
        Log.info(hasAlternatingBits(7));
        Log.info(hasAlternatingBits(11));
    }
}
/**
    private static boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
*/
/**
    private static boolean hasAlternatingBits(int n) {
        String b = Integer.toBinaryString(n);
        for (int i = 0; i < b.length() - 1; ++i)
            if (b.charAt(i) == b.charAt(i + 1))
                return false;
        return true;
    }
*/
