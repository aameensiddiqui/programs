/**
   1871. Jump Game VII

   You are given a 0-indexed binary string s and two integers minJump and maxJump.
   In the beginning, you are standing at index 0, which is equal to '0'. You can move
   from index i to index j if the following conditions are fulfilled:

   i + minJump <= j <= min(i + maxJump, s.length - 1), and
   s[j] == '0'.
   Return true if you can reach index s.length - 1 in s, or false otherwise.

   Example 1:
   Input: s = "011010", minJump = 2, maxJump = 3
   Output: true
   Explanation:
   In the first step, move from index 0 to index 3. 
   In the second step, move from index 3 to index 5.

   Example 2:
   Input: s = "01101110", minJump = 2, maxJump = 3
   Output: false

   Constraints:
   2 <= s.length <= 105
   s[i] is either '0' or '1'.
   s[0] == '0'
   1 <= minJump <= maxJump < s.length
*/
class JumpGameVII {
    private static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        boolean[] dp = new boolean[n];
        int[] prefix = new int[n + 1];

        dp[0] = true;
        prefix[1] = 1;

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '0') {
                int low = Math.max(0, i - maxJump);
                int high = i - minJump;
                if (high >= 0) {
                    int reachableCnt = prefix[high + 1] - prefix[low];
                    dp[i] = reachableCnt > 0;
                }
            }
            prefix[i + 1] = prefix[i] + (dp[i] ? 1 : 0);
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        log.info(canReach("011010", 2, 3));
        log.info(canReach("01101110", 2, 3));
        log.info(canReach("0000000000", 2, 3));
    }
}
/**
    // TLE
    private static Boolean[] dp;
    private static boolean dfs(int i, int minJump, int maxJump, int n, String s) {
        if (i >= n - 1) {
            if (i == n - 1) return true;
            return false;
        }
        if (dp[i] != null) return dp[i];
        for (int j = i + minJump;
             j <= Math.min(i + maxJump, n - 1);
             ++j) {
            boolean res = false;
            if (s.charAt(j) == '0') {
                res = dfs(j, minJump, maxJump, n, s);
                if (res) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
    private static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        dp = new Boolean[n];
        if (s.charAt(n - 1) == '1') return false;
        return dfs(0, minJump, maxJump, n, s);
    }
*/
