import java.util.Arrays;

class Tabulation {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        log.info((int[]) dp);
        return dp[n];
    }
    public int saveSpace(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev1 = 1;
        int currr = 0;

        for (int i = 2; i <= n; ++i) {
            currr = prev2 + prev1;
            prev2 = prev1;
            prev1 = currr;
        }
        return prev1;
    }
}

class Memoization {
    public int fib(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        // log.info(n);
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = fib(n, dp);
        log.info(dp);
        return ans;
    }
    public int f(int n) {
        if (n <= 1) return n;
        return f(n-1) + f(n-2);
    }
}

class Fibonacci {
    public static void main(String[]args) {
        Memoization m = new Memoization();
        long start = 0, end = 0;

        start = System.nanoTime();
        log.info("1    ", "ans  = " + m.f(40));
        end = System.nanoTime();
        log.info("time = " + (end - start) + " ns");

        start = System.nanoTime();
        log.info("2    ", "ans  = " + m.fib(40));
        end = System.nanoTime();
        log.info("time = " + (end - start) + " ns");

        log.info("---------------------");

        Tabulation t = new Tabulation();
        start = System.nanoTime();
        log.info("1    ", "ans  = " + t.fib(40));
        end = System.nanoTime();
        log.info("time = " + (end - start) + " ns");

        start = System.nanoTime();
        log.info("2    ", "ans  = " + t.saveSpace(40));
        end = System.nanoTime();
        log.info("time = " + (end - start) + " ns");
    }
}
