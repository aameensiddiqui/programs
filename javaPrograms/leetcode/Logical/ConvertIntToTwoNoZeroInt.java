/**
   1317. Convert Integer to the Sum of Two No-Zero Integers

   No-Zero integer is a positive integer that does not contain any 0 in its
   decimal representation.

   Given an integer n, return a list of two integers [a, b] where:

   a and b are No-Zero integers.
   a + b = n
   The test cases are generated so that there is at least one valid solution.
   If there are many valid solutions, you can return any of them.

   Example 1:

   Input: n = 2
   Output: [1,1]
   Explanation: Let a = 1 and b = 1.
   Both a and b are no-zero integers, and a + b = 2 = n.
   Example 2:

   Input: n = 11
   Output: [2,9]
   Explanation: Let a = 2 and b = 9.
   Both a and b are no-zero integers, and a + b = 11 = n.
   Note that there are other valid answers as [8, 3] that can be accepted.
 
   Constraints:
   2 <= n <= 10000
*/
class ConvertIntToTwoNoZeroInt {
    public static int[] getNoZeroIntegers(int n) {
        for(int i = 1; i <= n; ++i) {
            int j = n-i;
            if(!hasZero(i) && !hasZero(j))
                return new int[] {i, j};
        }
        return new int[0];
    }
    public static boolean hasZero(int n) {
        while(n > 0) {
            int digit = n % 10;
            if(digit == 0) return true;
            n /= 10;
        }
        return false;
    }
    public static void main(String[]args) {
        int n = 1010;
        log.info(getNoZeroIntegers(n));
    }
    private static final Log log = new Log();
}
