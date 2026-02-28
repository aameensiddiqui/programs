/**
   1680. Concatenation of Consecutive Binary Numbers

   Given an integer n, return the decimal value of the binary string formed by
   concatenating the binary representations of 1 to n in order, modulo 109 + 7.

   Example 1:
   Input: n = 1
   Output: 1
   Explanation: "1" in binary corresponds to the decimal value 1.

   Example 2:
   Input: n = 3
   Output: 27
   Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
   After concatenating them, we have "11011", which corresponds to the decimal
   value 27.

   Example 3:
   Input: n = 12
   Output: 505379714
   Explanation: The concatenation results in "1101110010111011110001001101010111100".
   The decimal value of that is 118505380540.
   After modulo 109 + 7, the result is 505379714.

   Constraints:
   1 <= n <= 105
 */
class ConcatinationOfConsecutiveBinaryNums {
    private static int concatinatedBinary(int n) {
        int bits = 0, MOD = 1_000_000_007;
        long res = 0;
        for (int i = 1; i <= n; ++i) {
            // check if i is power of two
            // every power of two increases bits by 1
            if ((i & (i - 1)) == 0) bits++;

            // add bits number of zeros to res
            // by left shifting res bits no. of times
            // | adds i
            res = ((res << bits) | i) % MOD;
        }
        return (int) res;
    }
    public static void main(String[] args) {
        Log.info(concatinatedBinary(1));
        Log.info(concatinatedBinary(3));
        Log.info(concatinatedBinary(12));
    }
}
