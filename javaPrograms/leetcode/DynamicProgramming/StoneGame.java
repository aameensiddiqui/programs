/**
   877. Stone Game

   Alice and Bob play a game with piles of stones. There are an even number of piles arranged
   in a row, and each pile has a positive integer number of stones piles[i].

   The objective of the game is to end with the most stones. The total number of stones across
   all the piles is odd, so there are no ties.

   Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile
   of stones either from the beginning or from the end of the row. This continues until there are
   no more piles left, at which point the person with the most stones wins.

   Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.

   Example 1:
   Input: piles = [5,3,4,5]
   Output: true
   Explanation:
   Alice starts first, and can only take the first 5 or the last 5.
   Say she takes the first 5, so that the row becomes [3, 4, 5].
   If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
   If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
   This demonstrated that taking the first 5 was a winning move for Alice, so we return true.

   Example 2:
   Input: piles = [3,7,2,3]
   Output: true

   Constraints:
   2 <= piles.length <= 500
   piles.length is even.
   1 <= piles[i] <= 500
   sum(piles[i]) is odd.
*/
import java.util.Arrays;

class StoneGame {
    // bottom up (space optimized)
    private static boolean stoneGame(int[] piles) {
        int total = 0, n = piles.length;
        for (int p : piles) total += p;
        int[] dp = new int[n];

        for (int l = n - 1; l >= 0; --l) {
            for (int r = l; r < n; ++r) {
                boolean isEven = (r - l) % 2 == 0;
                int left  = isEven ? piles[l] : 0;
                int right = isEven ? piles[r] : 0;
                if (l == r) dp[r] = left;
                else {
                    dp[r] = Math.max(
                                        dp[r] + left,
                                        dp[r - 1] + right
                                        );
                }
            }
        }
        int aliceScore = dp[n - 1];
        return aliceScore > total - aliceScore;
    }
    public static void main(String[] args) {
        log.info(stoneGame(new int[] {5,3,5,4}));
        log.info(stoneGame(new int[] {3,7,2,3}));
        log.info(stoneGame(new int[] {7,7,12,16,41,48,41,48,11,9,34,2,44,30,27,12,11,
                                      39,31,8,23,11,47,25,15,23,4,17,11,50,16,50,38,
                                      34,48,27,16,24,22,48,50,10,26,27,9,43,13,42,46,24}
                )
            );
    }
}
/**
    // bottom up
    private static boolean stoneGame(int[] piles) {
        int total = 0, n = piles.length;
        for (int p : piles) total += p;
        int[][] dp = new int[n][n];

        for (int l = n - 1; l >= 0; --l) {
            for (int r = l; r < n; ++r) {
                boolean isEven = (r - l) % 2 == 0;
                int left  = isEven ? piles[l] : 0;
                int right = isEven ? piles[r] : 0;
                if (l == r) dp[l][r] = left;
                else {
                    dp[l][r] = Math.max(
                                        dp[l + 1][r] + left,
                                        dp[l][r - 1] + right
                                        );
                }
            }
        }
        int aliceScore = dp[0][n - 1];
        return aliceScore > total - aliceScore;
    }
*/
/**
    // top down
    private static int[][] dp;
    private static int dfs(int l, int r, int[] piles) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];
        boolean isEven = (r - l) % 2 == 0;
        int left  = isEven ? piles[l] : 0;
        int right = isEven ? piles[r] : 0;
        return dp[l][r] = Math.max(
                        dfs(l + 1, r, piles) + left,
                        dfs(l, r - 1, piles) + right
                        );
    }
    private static boolean stoneGame(int[] piles) {
        int total = 0;
        for (int p : piles) total += p;
        dp = new int[piles.length][piles.length];
        for (int[] a : dp) Arrays.fill(a, -1);
        int aliceScore = dfs(0, piles.length - 1, piles);
        return aliceScore > total - aliceScore;
    }
*/
/**
    // recursion
    private static int dfs(int l, int r, int[] piles) {
        if (l > r) return 0;
        boolean isEven = (r - l) % 2 == 0;
        int left  = isEven ? piles[l] : 0;
        int right = isEven ? piles[r] : 0;
        return Math.max(
                        dfs(l + 1, r, piles) + left,
                        dfs(l, r - 1, piles) + right
                        );
    }
    private static boolean stoneGame(int[] piles) {
        int total = 0;
        for (int p : piles) total += p;
        int aliceScore = dfs(0, piles.length - 1, piles);
        return aliceScore > total - aliceScore;
    }
*/
/**
    // key insight: with an even number of piles and an odd total sum,
    // Alice can always win. She can always choose to take all even-indexed piles
    // or all odd-indexed piles. Since the total is odd, one of these sets must have
    // a larger sum. Alice, moving first, can force the game to give her whichever
    // set she prefers, guaranteeing a win.
    private static boolean stoneGame(int[] piles) {
        return true;
    }
*/
