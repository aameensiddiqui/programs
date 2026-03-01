/**
   1323. Maximum 69 Number

   You are given a positive integer num consisting only of digits 6 and 9.

   Return the maximum number you can get by changing at most one digit
   (6 becomes 9, and 9 becomes 6).

   Example 1:
   Input: num = 9669
   Output: 9969
   Explanation:
   Changing the first digit results in 6669.
   Changing the second digit results in 9969.
   Changing the third digit results in 9699.
   Changing the fourth digit results in 9666.
   The maximum number is 9969.

   Example 2:
   Input: num = 9996
   Output: 9999
   Explanation: Changing the last digit 6 to 9 results in the maximum number.

   Example 3:
   Input: num = 9999
   Output: 9999
   Explanation: It is better not to apply any change.

   Constraints:
   1 <= num <= 104
   num consists of only 6 and 9 digits.
*/
class Maximum69Number {
    private static int maximum69Number (int num) {
        char[] s = String.valueOf(num).toCharArray();
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == '6') {
                s[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(s));
    }
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }
}
/**
    private static int maximum69Number (int num) {
        int m = num, tmp = 0;
        String n = String.valueOf(num);
        String t = "";
        for (int i = 0; i < n.length(); ++i) {
            t = n;
            if (n.charAt(i) == '9')
                t = n.substring(0, i) + '6' + n.substring(i + 1);
            else t = n.substring(0, i) + '9' + n.substring(i + 1);
            tmp = Integer.parseInt(t);
            m = Math.max(m, tmp);
        }
        return m;
    }
*/
