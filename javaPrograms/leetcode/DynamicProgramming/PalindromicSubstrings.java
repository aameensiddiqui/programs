import java.lang.StringBuilder;

class PalindromicSubstrings {
    private static int countSubstrings(String s) {
        int cnt = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[]args) {
        log.info(countSubstrings("abc"));
        log.info(countSubstrings("aaa"));
    }
}
/**
   private static boolean isPal(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length()-1; i >= 0; --i) str.append(s.charAt(i));
        String ans = str.toString();
        //log.info("ans="+ans+"  str="+str+"   s="+s);
        return s.equals(ans);
    }
    private static int countSubstrings(String s) {
        int cnt = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n+1; ++j) {
                if (isPal(s.substring(i, j))) {
                    cnt++;
                    //log.info(cnt);
                }
            }
        }
        return cnt;
    }
*/
