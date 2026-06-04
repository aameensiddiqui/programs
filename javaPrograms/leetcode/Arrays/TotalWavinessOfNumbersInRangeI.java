/**
   3751. Total Waviness of Numbers in Range I

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
   1 <= num1 <= num2 <= 105
*/
class TotalWavinessOfNumbersInRangeI {
    // precomputation | prefix calculation and dp | lookup O(1)
    /**
       Intuition
       We can precompute the waviness for every number up to the maximum constraints .
       This allows us to compute the totalWaviness in constant time.
       A new wave is only formed if the last three digits create a peak or valley.
--------------------------------------------------------------------------
       i = 14351

       check isWave = 1
             |
           _____
           | | |
       1 4 3 5 1
       |_____|
          |
   check dp[1435] = 2
       therefore, dp[14351] = dp[(14351) / 10] + isWave;
       therefore, dp[14351] = dp[1435]         + 1;
       therefore, dp[14351] = 2                + 1;
       therefore, dp[14351] = 3;
--------------------------------------------------------------------------

       Thus, we can track the total waviness of each number using a dp array:
       The score dp[i] is exactly the score of its prefix dp[i / 10] and
       add +1 if the last three digits form a wave.
       To efficiently process queries for any range [A, B]:
       we accumulate these values into a prefix sum array pref.
       Finally, evaluate the total waviness using pref[B] - pref[A - 1].
       Time Complexity: O(MAX)
       precomputation: O(100000)
       look-up: O(1)
       Space Complexity: O(MAX)
    */
    private static int MAX = 100001;
    private static int[] dp = new int[MAX];
    private static int[] pr = new int[MAX];
    static {
        for (int i = 100; i < MAX; ++i) {
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 10;
            int isWave = m > Math.max(l, r) || m < Math.min(l, r) ? 1 : 0;
            dp[i] = dp[i / 10] + isWave;
            pr[i] = pr[i - 1] + dp[i];
        }
    }
    private static int totalWaviness(int num1, int num2) {
        return pr[num2] - pr[num1 - 1];
    }
    public static void main(String[] args) {
        Log.info(totalWaviness(120, 130));
        Log.info(totalWaviness(198, 202));
        Log.info(totalWaviness(4848, 4848));
    }
}
/**
    private static int calculateWaves(int num) {
        String s = String.valueOf(num);
        int n = s.length(), cnt = 0;
        for (int i = 1; i < n - 1; ++i) {
            int d1 = s.charAt(i - 1) - '0';
            int d2 = s.charAt(i)     - '0';
            int d3 = s.charAt(i + 1) - '0';
            if ((d1 < d2 && d2 > d3) || (d1 > d2 && d2 < d3)) cnt++;
        }
        return cnt;
    }
    private static int totalWaviness(int num1, int num2) {
        int waves = 0;
        num1 = Math.max(100, num1);
        for (int n = num1; n <= num2; ++n) {
            waves += calculateWaves(n);
        }
        return waves;
    }
*/
/**
    private static int calculateWaves(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        if (n < 3) return 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = s[i] - '0';
        }
        int p1 = 0, p2 = 1, p3 = 2, cnt = 0;
        while (p3 < n) {
            if      (arr[p1] < arr[p2] && arr[p2] > arr[p3]) cnt++;
            else if (arr[p1] > arr[p2] && arr[p2] < arr[p3]) cnt++;
            p1++; p2++; p3++;
        }
        return cnt;
    }
    private static int totalWaviness(int num1, int num2) {
        int waves = 0;
        for (int n = num1; n <= num2; ++n) {
            waves += calculateWaves(n);
        }
        return waves;
    }
*/
