/**
   1291. Sequential Digits

   An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

   Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

   Example 1:
   Input: low = 100, high = 300
   Output: [123,234]

   Example 2:
   Input: low = 1000, high = 13000
   Output: [1234,2345,3456,4567,5678,6789,12345]

   Constraints:
   10 <= low <= high <= 10^9
*/
import java.util.*;

class SequentialDigits {
    /*
      Using Breadth-First Search
      Let's start with the base case (all single digit numbers):

      Let d be the last digit of a sequence x in the array q.
      We can append the next digit (d + 1) to generate new valid sequence:
      s = (x * 10) + (d + 1)
      But since 9 cannot be followed by another digit, we stop the generation when the last digit is 9.

      We iterate directly over the array q instead of using an actual queue to avoid the overhead of
      enqueue and dequeue operations.

      By repeatedly applying this rule:

      We can generate every sequential-digit number exactly once, from (1 - 123456789).
      The elements are guaranteed to be sorted in increasing order.
      Finally, since q is already sorted, we can simply search the precomputed array to return the
      sequences within [low, high].

      Time Complexity: O(45)
      Space Complexity: O(45)
    */
    private static final int[] q = new int[45];
    static {
        int n = 0;
        for (int i = 1; i < 10; ++i)
            q[n++] = i;
        for (int i = 0; i < n; ++i) {
            int d = q[i] % 10;
            if (d < 9)
                q[n++] = q[i] * 10 + d + 1;
        }
    }
    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int x : q)
            if (low <= x && x <= high)
                res.add(x);
        return res;
    }
    public static void main(String[] args) {
        Log.info(sequentialDigits(100, 200));       // [123,234]
        Log.info(sequentialDigits(1000, 13000));    // [1234,2345,3456,4567,5678,6789,12345]
        Log.info(sequentialDigits(10, 1000000000)); // [12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,
                                                    // 1234,2345,3456,4567,5678,6789,12345,23456,34567,45678,
                                                    // 56789,123456,234567,345678,456789,1234567,2345678,3456789,
                                                    // 12345678,23456789,123456789]
        Log.info(sequentialDigits(58, 155));        // [67,78,89,123]
    }
}
/**
    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int num = 0;
        int tmp = low;
        int digits = 0;
        while (tmp > 0) {
            digits++;
            tmp /= 10;
        }
        while (digits <= 9) {
            int i = 1;
            while (i <= 10 - digits) {
                int j = i;
                int a = 0;
                int td = 1;
                while (td <= digits) {
                    a *= 10;
                    a += j;
                    td++; j++;
                }
                i++;
                num = a;
                if (num > high) continue;
                if (num >= low) res.add(num);
            }
            digits++;
        }
        return res;
    }
*/
/**
    private static boolean isSequential(int n) {
        if (n < 1) return false;
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); ++i) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            if (curr - prev != 1) return false;
        }
        return true;
    }
    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int num = 0;
        int tmp = low;
        int digits = 0;
        while (tmp > 0) {
            digits++;
            tmp /= 10;
        }
        while (digits <= 9) {
            int i = 1;
            while (i <= 10 - digits) {
                int j = i;
                int a = 0;
                int td = 1;
                while (td <= digits) {
                    a *= 10;
                    a += j;
                    td++; j++;
                }
                i++;
                num = a;
                if (num > high) continue;
                if (num >= low && isSequential(num))
                    res.add(num);
            }
            digits++;
        }
        return res;
    }
*/
