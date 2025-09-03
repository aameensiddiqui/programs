/**
   Approach: Fast Exponentiation
   Intuition

   For the numbers at even indices, they can be 0,2,4,6,8, a total of 5 types.
   A digit string of length n has [(n+1)/2] even indices,
   where [x] denotes the floor function of x.

   For the numbers at odd indices, they can be 2,3,5,7, a total of 4 types.
   A digit string of length n has [n/2] odd indices.

   Therefore, the total number of good numbers in a digit string of length n is:
   [5^((n+1)/2)] * [4^(n/2)]

   In this question, since the maximum value of n can reach 10^15,
   directly calculating the power in the formula using ordinary multiplication
   would exceed the time limit.
   Therefore, we need to use the fast exponentiation algorithm to optimize the
   calculation of the power.
*/
class CountGoodNumbers1922 {
    private static final int MOD = 1000000007;
    public static long pow(long x, long n) {
        if(n == 0) return 1;
        long half = pow(x, n/2);
        long halfsq = (half * half) % MOD;
        if(n % 2 != 0) halfsq = (x * halfsq) % MOD;
        return halfsq;
    }
    public static int countGoodNumbers(long n) {
        return (int)(pow(5, (n+1)/2) * (pow(4, n/2)) % MOD);
    }
    public static void main(String[]args) {
        long n = 50;
        log.info(countGoodNumbers(n));
    }
    private static final Log log = new Log();
}
