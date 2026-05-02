/**
   788. Rotated Digits

   An integer x is a good if after rotating each digit individually by 180 degrees,
   we get a valid number that is different from x.
   Each digit must be rotated - we cannot choose to leave it alone.

   A number is valid if each digit remains a digit after rotation. For example:

   0, 1, and 8 rotate to themselves,
   2 and 5 rotate to each other (in this case they are rotated in a different direction,
   in other words, 2 or 5 gets mirrored),
   6 and 9 rotate to each other, and
   the rest of the numbers do not rotate to any other number and become invalid.
   Given an integer n, return the number of good integers in the range [1, n].

   Example 1:
   Input: n = 10
   Output: 4
   Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
   Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.

   Example 2:
   Input: n = 1
   Output: 0

   Example 3:
   Input: n = 2
   Output: 1

   Constraints:
   1 <= n <= 104
*/
import java.util.*;

class RotatedDigits {
    private static int rotatedDigits(int n) {
        int cnt = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    cnt++;
                } else dp[i] = 0;
            } else {
                int a = dp[i / 10];
                int b = dp[i % 10];
                if (a == 1 && b == 1) dp[i] = 1;
                else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    cnt++;
                } else dp[i] = 0;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        log.info(rotatedDigits(10));   // 4
        log.info(rotatedDigits(1));    // 0
        log.info(rotatedDigits(2));    // 1
        log.info(rotatedDigits(15));   // 6
        log.info(rotatedDigits(1513)); // 455
    }
}
/**
    private static int make(int x) {
        int ans = 0;
        for (int w = 1; x > 0; x /= 10, w *= 10) {
            int temp = -1;
            int c = x % 10;
            switch(c) {
            case 0: case 1: case 8:
                temp = c;
                break;
            case 2:
                temp = 5;
                break;
            case 5:
                temp = 2;
                break;
            case 6:
                temp = 9;
                break;
            case 9:
                temp = 6;
                break;
            }
            if (temp < 0) return -1;
            ans += w * temp;
        }
        return ans;
    }
    private static int rotatedDigits(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            int x = make(i);
            if (x > 0 && x != i) cnt++;
        }
        return cnt;
    }
*/
/**
    private static int rotatedDigits(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            String s = String.valueOf(i);
            if ((s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9"))
                && !(s.contains("3") || s.contains("4") || s.contains("7"))) cnt++;
        }
        return cnt;
    }
*/
/**
    private static int rotatedDigits(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            String s = String.valueOf(i);
            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) {
                if (!s.contains("3") && !s.contains("4") && !s.contains("7")) cnt++;
            }
        }
        return cnt;
    }
*/
/**
    private static Map<Integer, Integer> mpp;
    private static boolean canRotate(int n) {
        if (n < 10 && mpp.containsKey(n)) {
            if (n == 0 || n == 1 || n == 8) return false;
            return true;
        }
        int rotatedNumber = 0, temp = n;
        StringBuilder s = new StringBuilder();
        while (temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            if (!mpp.containsKey(digit)) return false;
            s.append(mpp.get(digit));
        }
        String ss = s.reverse().toString();
        if (ss.equals("")) return false;
        rotatedNumber = Integer.parseInt(ss);
        if (rotatedNumber != n) return true;
        else return false;
    }
    private static int rotatedDigits(int n) {
        mpp = new HashMap<>();
        mpp.put(0, 0);
        mpp.put(1, 1);
        mpp.put(2, 5);
        mpp.put(5, 2);
        mpp.put(6, 9);
        mpp.put(8, 8);
        mpp.put(9, 6);
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (canRotate(i)) cnt++;
        }
        return cnt;
    }
*/
