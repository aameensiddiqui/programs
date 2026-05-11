/**
   2180. Count Integers With Even Digit Sum

   Given a positive integer num, return the number of positive integers less than
   or equal to num whose digit sums are even.

   The digit sum of a positive integer is the sum of all its digits.

   Example 1:
   Input: num = 4
   Output: 2
   Explanation:
   The only integers less than or equal to 4 whose digit sums are even are 2 and 4.

   Example 2:
   Input: num = 30
   Output: 14
   Explanation:
   The 14 integers less than or equal to 30 whose digit sums are even are
   2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.

   Constraints:
   1 <= num <= 1000
*/
class CountIntegersWithEvenDigitSum {
    private static int countEven(int num) {
        int tmp = num, sum = 0;
        while (tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (sum % 2 == 0) return num / 2;
        else return (num - 1) / 2;
    }
    public static void main(String[] args) {
        Log.info(countEven(4));
        Log.info(countEven(30));
    }
}
/**
    private static int countEven(int num) {
        int cnt = 0;
        while (num != 0) {
            int tmp = num;
            int sum = 0;
            while (tmp != 0) {
                int digit = tmp % 10;
                sum += digit;
                tmp /= 10;
            }
            if (sum % 2 == 0) cnt++;
            num--;
        }
        return cnt;
    }
*/
