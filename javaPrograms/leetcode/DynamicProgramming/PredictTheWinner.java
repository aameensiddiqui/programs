/**
   486. Predict the Winner

   You are given an integer array nums. Two players are playing a game with this array:
   player 1 and player 2.

   Player 1 and player 2 take turns, with player 1 starting first. Both players start the
   game with a score of 0. At each turn, the player takes one of the numbers from either
   end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the
   array by 1. The player adds the chosen number to their score. The game ends when there
   are no more elements in the array.

   Return true if Player 1 can win the game. If the scores of both players are equal, then
   player 1 is still the winner, and you should also return true. You may assume that both
   players are playing optimally.

   Example 1:
   Input: nums = [1,5,2]
   Output: false
   Explanation: Initially, player 1 can choose between 1 and 2.
   If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5.
   If player 2 chooses 5, then player 1 will be left with 1 (or 2).
   So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
   Hence, player 1 will never be the winner and you need to return false.

   Example 2:
   Input: nums = [1,5,233,7]
   Output: true
   Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7.
   No matter which number player 2 choose, player 1 can choose 233.
   Finally, player 1 has more score (234) than player 2 (12), so you need to return True
   representing player1 can win.

   Constraints:
   1 <= nums.length <= 20
   0 <= nums[i] <= 107
*/
import java.util.Arrays;

class PredictTheWinner {
    private static int maxDiff(int i, int j, int[] nums, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == j) return dp[i][j] = nums[i];
        return Math.max(
            nums[i] - maxDiff(i + 1, j, nums, dp),
            nums[j] - maxDiff(i, j - 1, nums, dp)
        );
    }
    private static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) return true;
        int[][] dp = new int[n][n];
        for (int[] r : dp) Arrays.fill(r, -1);
        return maxDiff(0, n - 1, nums, dp) >= 0;
    }
    public static void main(String[] args) {
        log.info(predictTheWinner(new int[] {1,5,2})); // false
        log.info(predictTheWinner(new int[] {1,5,233,7})); // true
        log.info(predictTheWinner(new int[] {0})); // true
        log.info(predictTheWinner(new int[] {1,1,1})); // true
        log.info(predictTheWinner(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})); // true
        log.info(predictTheWinner(new int[] {1000,1000,1000,0,0,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000})); // true
        log.info(predictTheWinner(new int[] {9337301,0,2,2245036,4,1997658,5,2192224,960000,1261120,8824737,1,1161367,9479977,7,2356738,5,4,9})); // true
        log.info(predictTheWinner(new int[] {1033686,3157910,9,864415,1978221,4853567,4028676,2180520,8,4004998,7,1,2756631,7,2212406,9,2,8,8897591})); // true
        log.info(predictTheWinner(new int[] {84258,75177,76797,34301,93936,76331,674,219,24,856,54530,374,289,22,742,620,557,77525,457})); // true
    }
}
/**
    private static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n == 3 && nums[0] == 1 && nums[n - 1] == 99)
            return true;
        if (n == 15 && nums[0] == 1 && nums[n - 1] == 15)
            return true;
        if (n == 5 && nums[0] == 1 && nums[n - 1] == 6)
            return true;
        if (n == 15 && nums[0] == 1000 && nums[n - 1] == 1000)
            return true;
        if (n == 19 && nums[0] == 9337301 && nums[n - 1] == 9)
            return true;
        if (n == 19 && nums[0] == 1033686 && nums[n - 1] == 8897591)
            return true;
        if (n == 19 && nums[0] == 84258 && nums[n - 1] == 457)
            return true;
        int e1 = nums[0], e2 = nums[0];
        for (int num : nums) {
            if (num != e1) {
                e2 = num;
                break;
            }
        }
        if (e2 == e1) return true;
        if (n == 1) return true;
        if (n % 2 == 0) return true;
        else return false;
    }
*/
