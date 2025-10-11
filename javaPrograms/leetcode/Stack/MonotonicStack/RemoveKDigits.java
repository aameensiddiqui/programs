/**
   402. Remove K Digits

   Given string num representing a non-negative integer num, and an integer k,
   return the smallest possible integer after removing k digits from num.

   Example 1:
   Input: num = "1432219", k = 3
   Output: "1219"
   Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
   which is the smallest.

   Example 2:
   Input: num = "10200", k = 1
   Output: "200"
   Explanation: Remove the leading 1 and the number is 200. Note that the output
   must not contain leading zeroes.

   Example 3:
   Input: num = "10", k = 2
   Output: "0"
   Explanation: Remove all the digits from the number and it is left with nothing
   which is 0.
 
   Constraints:
   1 <= k <= num.length <= 105
   num consists of only digits.
   num does not have any leading zeros except for the zero itself.
 */
import java.lang.StringBuilder;
import java.util.Stack;
class RemoveKDigits {
    public static String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < nums.length(); ++i) {
            char digit = nums.charAt(i);
            while(!st.empty() && k > 0 && st.peek() > digit) {
                st.pop(); --k;
            }
            st.push(digit);
        }
        while(k > 0) {st.pop(); --k;}

        if(st.empty()) return "0";
        
        StringBuilder ans = new StringBuilder();
        while(!st.empty()) ans.append(st.pop());
        while(ans.length() > 0 && ans.charAt(ans.length()-1) == '0')
            ans.deleteCharAt(ans.length()-1);
        ans.reverse();
        if(ans.length() == 0) return "0";
        return ans.toString();
    }
    public static void main(String[]args) {
        log.info(removeKdigits("1432219", 3));
    }
    private static final Log log = new Log();
}
