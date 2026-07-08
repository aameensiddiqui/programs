/**
   3756. Concatenate Non-Zero Digits and Multiply by Sum II

   You are given a string s of length m consisting of digits.
   You are also given a 2D integer array queries, where queries[i] = [li, ri].

   For each queries[i], extract the substring s[li..ri]. Then, perform the following:

   Form a new integer x by concatenating all the non-zero digits from the substring in
   their original order. If there are no non-zero digits, x = 0.
   Let sum be the sum of digits in x. The answer is x * sum.
   Return an array of integers answer where answer[i] is the answer to the ith query.

   Since the answers may be very large, return them modulo 109 + 7.

   Example 1:
   Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]
   Output: [12340, 4, 9]
   Explanation:
   s[0..7] = "10203004"
   x = 1234
   sum = 1 + 2 + 3 + 4 = 10
   Therefore, answer is 1234 * 10 = 12340.
   s[1..3] = "020"
   x = 2
   sum = 2
   Therefore, the answer is 2 * 2 = 4.
   s[4..6] = "300"
   x = 3
   sum = 3
   Therefore, the answer is 3 * 3 = 9.

   Example 2:
   Input: s = "1000", queries = [[0,3],[1,1]]
   Output: [1, 0]
   Explanation:
   s[0..3] = "1000"
   x = 1
   sum = 1
   Therefore, the answer is 1 * 1 = 1.
   s[1..1] = "0"
   x = 0
   sum = 0
   Therefore, the answer is 0 * 0 = 0.

   Example 3:
   Input: s = "9876543210", queries = [[0,9]]
   Output: [444444137]
   Explanation:
   s[0..9] = "9876543210"
   x = 987654321
   sum = 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45
   Therefore, the answer is 987654321 * 45 = 44444444445.
   We return 44444444445 modulo (109 + 7) = 444444137.

   Constraints:
   1 <= m == s.length <= 105
   s consists of digits only.
   1 <= queries.length <= 105
   queries[i] = [li, ri]
   0 <= li <= ri < m
*/
class ConcatenateNonZeroDigitsAndMultiplyBySumII {
    private static final int MOD = 1000000007;
    private static final int MAX = 100001;
    private static final int[] pow = new int[MAX];
    static {
        pow[0] = 1;
        for (int i = 1; i < MAX; ++i)
            pow[i] = (int) ((pow[i - 1] * 10L) % MOD);
    }
    private static int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        int[] len = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int d = s.charAt(i) - '0';
            A[i + 1] = A[i] + d;
            if (d > 0) {
                B[i + 1] = (int) ((B[i] * 10L + d) % MOD);
                len[i + 1] = len[i] + 1;
            } else {
                B[i + 1] = B[i];
                len[i + 1] = len[i];
            }
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1] + 1;
            long sub = ((long) B[l] * pow[len[r] - len[l]]) % MOD;
            long x = (B[r] - sub + MOD) % MOD;
            res[i++] = (int) ((x * (A[r] - A[l])) % MOD);
        }
        return res;
    }
    public static void main(String[] args) {
        Log.info(sumAndMultiply("10203004", new int[][] {{0,7},{1,3},{4,6}})); // [12340,4,9]
        Log.info(sumAndMultiply("1000", new int[][] {{0,3},{1,1}})); // [1,0]
        Log.info(sumAndMultiply("9876543210", new int[][] {{0,9}})); // [444444137]
    }
}
// Log.info("str[i] = " + str.charAt(i) + " res = " + res + " sum = " + sum);
/**
    private static final int MOD = 1_000_000_007;
    private static int[] ans;
    private static int func(String str, int left, int right) {
        long sum = 0;
        long res = 0;
        for (int i = left; i <= right; ++i) {
            if (str.charAt(i) != '0') {
                res = (res * 10 + (str.charAt(i) - '0')) % MOD;
                sum += (str.charAt(i) - '0');
            }
        }
        return (int) ((sum * (res % MOD) % MOD));
    }
    private static int[] sumAndMultiply(String s, int[][] queries) {
        ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = func(s, queries[i][0], queries[i][1]);
        }
        return ans;
    }
*/
