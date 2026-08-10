/**
   1510. Stone Game IV

   Alice and Bob take turns playing a game, with Alice starting first.

   Initially, there are n stones in a pile. On each player's turn, that player makes a move
   consisting of removing any non-zero square number of stones in the pile.

   Also, if a player cannot make a move, he/she loses the game.

   Given a positive integer n, return true if and only if Alice wins the game otherwise return
   false, assuming both players play optimally.

   Example 1:
   Input: n = 1
   Output: true
   Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.

   Example 2:
   Input: n = 2
   Output: false
   Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the
   game (2 -> 1 -> 0).

   Example 3:
   Input: n = 4
   Output: true
   Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones
   (4 -> 0).

   Constraints:
   1 <= n <= 105
 */
class StoneGameIV {
    private static final int MAX = 100_000;
    private static final boolean[] dp = new boolean[MAX + 1];
    static {
        for (int i = 0; i <= MAX; ++i) {
            if (dp[i]) continue;
            for (int j = 1; j * j <= MAX - i; ++j)
                dp[i + j * j] = true;
        }
    }
    public static boolean winnerSquareGame(int n) {
        return dp[n];
    }
    public static void main(String[] args) {
        log.info("1 : " + winnerSquareGame(1));       // true
        log.info("2 : " + winnerSquareGame(2));       // false
        log.info("4 : " + winnerSquareGame(4));       // true
        log.info("7 : " + winnerSquareGame(7));       // false
        log.info("76 : " + winnerSquareGame(76));     // true
        log.info("2712 : " + winnerSquareGame(2712)); // true
        log.info("8 : " + winnerSquareGame(8));       // true
        log.info("3 : " + winnerSquareGame(3));       // true
    }
}
/**
    // greedy approach won't work because player can choose ANY sq number for his advantage
    private static boolean isSq(int n) {
        int x = (int) Math.sqrt(n);
        return Math.pow(x, 2) == n;
    }
    private static int closestSq(int n) {
        for (int i = 2; i < n; ++i) {
            // log.info("i = " + i);
            if (i * i > n) return (i - 1) * (i - 1);
        }
        return 1;
    }
    public static boolean winnerSquareGame(int n) {
        if (isSq(n)) return true;
        boolean aliceTurn = true;
        while (n != 0) {
            n = n - closestSq(n);
            // log.info("n = " + n + "  aliceturn = " + aliceTurn);
            if (n == 0) break;
            else aliceTurn = aliceTurn == true ? false : true;
        }
        return aliceTurn;
    }
*/
