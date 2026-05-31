/**
   190. Reverse Bits

   Reverse bits of a given 32 bits signed integer.

   Example 1:
   Input: n = 43261596
   Output: 964176192
   Explanation:
   Integer	Binary
   43261596	00000010100101000001111010011100
   964176192	00111001011110000010100101000000

   Example 2:
   Input: n = 2147483644
   Output: 1073741822
   Explanation:
   Integer	Binary
   2147483644	01111111111111111111111111111100
   1073741822	00111111111111111111111111111110

   Constraints:
   0 <= n <= 231 - 2
   n is even.
*/
class ReverseBits {
    /**
       The Analogy: Reversing a Base-10 Number
       Imagine you have the number 1234 and you want to reverse it to 4321. You would follow these steps:

       Pop (n/10) the last digit: 4 (1234 becomes 123).
       Push (res + n%10) it onto your result: (Result was 0, now it's 4).
       To add the next digit (3), you first shift your result (res*10) (4 becomes 40) and then add the 3 to get 43.
       The Binary Simulation
       The bit reversal works exactly the same way, but instead of using base-10 (digits 0-9), it uses base-2 (bits 0-1).

       Extract the Bit (n & 1):
       This is like taking the "last digit." In binary, & 1 tells you if the number ends in a 0 or a 1.
       Shift the Result (res << 1):
       In base-10, you multiply by 10 to move digits over. In binary, you shift left by 1 to move bits over.
       This makes the "ones" place empty so you can drop a new bit into it.
       Combine (res | bit):
       You put the bit you just extracted into that empty space you just created in the result.
       Discard the Used Bit (n >>= 1):
       You shift the original number to the right, effectively throwing away the "last digit" so you can look at
       the next one in the next loop.
     */
    private static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Log.info(reverseBits(43261596));
        Log.info(reverseBits(2147483644));
    }
}
/**
    private static int rev(int n, int len) {
        if (len == 1) return n & 1;
        int half = len >> 1;
        int mask = (1 << half) - 1;
        int loww = n & mask;
        int high = n >>> half;
        return rev(loww, half) << half | rev(high, half);
    }
    private static int reverseBits(int n) {
        return rev(n, 32);
    }
*/
/**
    private static int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        int m = s.length();
        for (int i = 0; i < 32 - m; ++i)
            s = '0' + s;
        Log.info(s);
        String newS = "";
        for (int i = s.length() - 1; i >= 0; --i)
            newS += s.charAt(i);
        Log.info(newS);
        return Integer.parseInt(newS, 2);
    }
*/
