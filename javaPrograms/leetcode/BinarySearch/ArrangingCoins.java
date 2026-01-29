/**
   441. Arranging Coins

   You have n coins and you want to build a staircase with these coins.
   The staircase consists of k rows where the ith row has exactly i coins.
   The last row of the staircase may be incomplete.

   Given the integer n, return the number of complete rows of the staircase
   you will build.

   Example 1:
   Input: n = 5
   Output: 2
   Explanation:
   $
   $ $
   $
   Because the 3rd row is incomplete, we return 2.

   Example 2:
   Input: n = 8
   Output: 3
   Explanation:
   $
   $ $
   $ $ $
   $ $
   Because the 4th row is incomplete, we return 3.

   Constraints:
   1 <= n <= 231 - 1
*/
class ArrangingCoins {
    // binary search (optimized)
    // we can optimize the binary search by tightening the upper bound
    // since k * (k + 1) / 2 <= n, we know k is roughly sqrt(2n)
    // a safe upper bound is n / 2 + 1 for n > 3, which reduces the search space
    // we also simplify the binary search by finding the first k where the
    // condition fails, then returning k - 1.
    private static int arrangeCoins(int n) {
        if (n <= 3) return n == 1 ? 1 : n - 1;
        int l = 1, h = (n >> 1) + 1;
        while (l < h) {
            int m = (l + h) >> 1;
            long coins = (long) m * (m + 1) >> 1;
            if (coins <= n) l = m + 1;
            else h = m;
        }
        return l - 1;
    }
    public static void main(String[]args) {
        Log.info(arrangeCoins(5));          // 2
        Log.info(arrangeCoins(8));          // 3
        Log.info(arrangeCoins(1));          // 1
        Log.info(arrangeCoins(3));          // 2
        Log.info(arrangeCoins(3));          // 2
        Log.info(arrangeCoins(1804289383)); // 60070
    }
}
/**
    // algebric sol:
    // we need the largest k where
    // k * (k + 1) / 2 <= n
    // k^2 + k - 2n <= 0
    // k = (-1 + sqrt(1 + 8n)) / 2
    // simplifying gives us
    // k = sqrt(2n + 0.25) - 0.5
    private static int arrangeCoins(int n) {
        // return (int) (Math.sqrt(2L * n + 0.25) - 0.5);
        return (int) (Math.sqrt(8L * n + 1) - 1) >> 1;
    }
*/
/**
    // binary search
    // building rows one by one is slow for large n.
    // instead, we can use the formula:
    // the sum of first k integers = k * (k + 1) / 2
    // if this sum is at most n, we can build k complete rows.
    // this creates a monotonic condition perfect for binary search
    // we search for the largest k such that k * (k + 1) / 2 <= n.
    private static int arrangeCoins(int n) {
        if (n <= 3) return n == 1 ? 1 : n - 1;
        int l = 1, h = n, row = 0;
        while (l <= h) {
            int m = (l + h) >> 1;
            long coins = (long) m * (m + 1) >> 1;
            if (coins > n) h = m - 1;
            else {
                l = m + 1;
                row = Math.max(row, m);
            }
        }
        return row;
    }
*/
/**
    // brute force
    private static int arrangeCoins(int n) {
        if (n <= 3) return n == 1 ? 1 : n - 1;
        int row = 0;
        while (n - row > 0) {
            row++;
            n -= row;
        }
        return row;
    }
*/
