/**
   3753. Total Waviness of Numbers in Range II

   You are given two integers num1 and num2 representing an inclusive range [num1, num2].

   The waviness of a number is defined as the total count of its peaks and valleys:

   A digit is a peak if it is strictly greater than both of its immediate neighbors.
   A digit is a valley if it is strictly less than both of its immediate neighbors.
   The first and last digits of a number cannot be peaks or valleys.
   Any number with fewer than 3 digits has a waviness of 0.
   Return the total sum of waviness for all numbers in the range [num1, num2].

   Example 1:
   Input: num1 = 120, num2 = 130
   Output: 3
   Explanation:
   In the range [120, 130]:
   120: middle digit 2 is a peak, waviness = 1.
   121: middle digit 2 is a peak, waviness = 1.
   130: middle digit 3 is a peak, waviness = 1.
   All other numbers in the range have a waviness of 0.
   Thus, total waviness is 1 + 1 + 1 = 3.

   Example 2:
   Input: num1 = 198, num2 = 202
   Output: 3
   Explanation:
   In the range [198, 202]:
   198: middle digit 9 is a peak, waviness = 1.
   201: middle digit 0 is a valley, waviness = 1.
   202: middle digit 0 is a valley, waviness = 1.
   All other numbers in the range have a waviness of 0.
   Thus, total waviness is 1 + 1 + 1 = 3.

   Example 3:
   Input: num1 = 4848, num2 = 4848
   Output: 2
   Explanation:
   Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.

   Constraints:
   1 <= num1 <= num2 <= 1015​​​​​​​
*/
class TotalWavinessOfNumbersInRangeII {
    private static final int[] dp = new int[570];
    static {
        int j = 0;
        for (int i = 0; i < 1000; ++i) {
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 100;
            if ((m > Math.max(r, l)) | (m < Math.min(r, l)))
                dp[j++] = i;
        }
    }
    private static long cntWays(long num, int pattern) {
        long type = pattern < 100 ? 1 : 0;
        long cnt = 0;
        long mult = 1;
        for (int i = 0; mult * 100 <= num; ++i) {
            long pre = num / (mult * 1000);
            long cur = (num / mult) % 1000;
            long suf = num % mult;
            long ways = 0;
            if (cur > pattern) ways = pre - type + 1;
            else if (cur == pattern) {
                ways = Math.max(0L, pre - type);
                cnt += suf + 1;
            } else ways = Math.max(0L, pre - type);

            cnt += ways * mult;
            mult *= 10;
        }
        return cnt;
    }
    private static long wavesCnt(long num) {
        if (num < 100) return 0;
        long res = 0;
        for (int p : dp) res += cntWays(num, p);
        return res;
    }
    private static long totalWaviness(long num1, long num2) {
        return wavesCnt(num2) - wavesCnt(num1 - 1);
    }
    public static void main(String[] args) {
        log.info(totalWaviness(120, 130));
        log.info(totalWaviness(198, 202));
        log.info(totalWaviness(4848, 4848));
        log.info(totalWaviness(561, 1000));
        log.info(totalWaviness(254929494, 506710444));
    }
}
