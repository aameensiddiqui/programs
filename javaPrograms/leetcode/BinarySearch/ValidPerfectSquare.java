/**
   367. Valid Perfect Square

   Given a positive integer num, return true if num is a perfect square
   or false otherwise.

   A perfect square is an integer that is the square of an integer.
   In other words, it is the product of some integer with itself.

   You must not use any built-in library function, such as sqrt.

   Example 1:
   Input: num = 16
   Output: true
   Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

   Example 2:
   Input: num = 14
   Output: false
   Explanation: We return false because 3.742 * 3.742 = 14 and 3.742
   is not an integer.

   Constraints:
   1 <= num <= 231 - 1
*/
class ValidPerfectSquare {
    private static boolean isPerfectSquare(int num) {
        long l = 1, h = (num >> 1) + 1;
        while (l <= h) {
            long m = (l + h) >> 1;
            long p = m * m;
            if (p < num) l = m + 1;
            else if (p > num) h = m - 1;
            else return true;
        }
        return false;
    }
    public static void main(String[]args) {
        Log.info(isPerfectSquare(16));         // true
        Log.info(isPerfectSquare(14));         // false
        Log.info(isPerfectSquare(2147483647)); // false
    }
}
/**
    // there is a beautiful math property,
    // perfect sq can be expressed as sum of consecutive odd numbers
    // [1] = 1, [4] = 1 + 3, [9] = 1 + 3 + 5, [16] = 1 + 3 + 5 + 7....
    private static boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
*/
/**
    // Newton's method
    private static boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) >> 1;
        }
        return r * r == num;
    }
*/
