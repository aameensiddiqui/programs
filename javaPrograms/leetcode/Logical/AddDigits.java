/**
   258. Add Digits

   Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

   Example 1:
   Input: num = 38
   Output: 2
   Explanation: The process is
   38 --> 3 + 8 --> 11
   11 --> 1 + 1 --> 2
   Since 2 has only one digit, return it.

   Example 2:
   Input: num = 0
   Output: 0

   Constraints:
   0 <= num <= 231 - 1
   Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
class AddDigits {
    private static int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
    public static void main(String[] args) {
        Log.info(addDigits(38));
        Log.info(addDigits(0));
    }
}
/**
    private static int addD(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }
    public static int addDigits(int num) {
        while (String.valueOf(num).length() != 1) {
            num = addD(num);
        }
        return num;
    }
*/
