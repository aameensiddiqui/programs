class NumberOfPeopleAwareOfASecret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        int[]dp = new int[n+1];
        dp[1] = 1;
        long sum = 0;
        for (int day = 2; day <= n; ++day) {
            if (day - delay >= 1)
                sum = (sum + dp[day - delay]) % MOD;
            if (day - forget >= 1)
                sum = (sum - dp[day - forget] + MOD) % MOD;
            dp[day] = (int) sum;
        }
        long ans = 0;
        for (int i = n-forget+1; i <= n; ++i)
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        return (int)ans;
    }
    public static void main(String[]args) {
        int n = 6;
        int delay = 2;
        int forget = 4;
        log.info(peopleAwareOfSecret(n, delay, forget));
    }
    public static final Log log = new Log();
}
/**
   import java.util.Deque;
   import java.util.LinkedList;

   private static final int MOD = 1000000007;
   public static int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<int[]> know = new LinkedList<>();
        Deque<int[]> share = new LinkedList<>();
        know.add(new int[] { 1, 1 });
        int knowCnt = 1;
        int shareCnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!know.isEmpty() && know.peekFirst()[0] == i - delay) {
                int[] first = know.pollFirst();
                knowCnt = (knowCnt - first[1] + MOD) % MOD;
                shareCnt = (shareCnt + first[1]) % MOD;
                share.add(first);
            }
            if (!share.isEmpty() && share.peekFirst()[0] == i - forget) {
                int[] first = share.pollFirst();
                shareCnt = (shareCnt - first[1] + MOD) % MOD;
            }
            if (!share.isEmpty()) {
                knowCnt = (knowCnt + shareCnt) % MOD;
                know.add(new int[] { i, shareCnt });
            }
        }
        return (knowCnt + shareCnt) % MOD;
    }
 */
