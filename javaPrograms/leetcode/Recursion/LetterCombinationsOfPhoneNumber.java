/**
   17. Letter Combinations of a Phone Number

   Given a string containing digits from 2-9 inclusive, return all possible letter
   combinations that the number could represent.
   Return the answer in any order.

   A mapping of digits to letters (just like on the telephone buttons) is given below.
   Note that 1 does not map to any letters.

    1    2    3
        abc  def
       
    4    5    6
   ghi  jkl  mno

    7    8    9
   pqrs tuv wxyz

    *    0    #
   
   Example 1:
   Input: digits = "23"
   Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

   Example 2:
   Input: digits = ""
   Output: []

   Example 3:
   Input: digits = "2"
   Output: ["a","b","c"]

   Constraints:
   0 <= digits.length <= 4
   digits[i] is a digit in the range ['2', '9'].
*/
import java.util.*;
class LetterCombinationsOfPhoneNumber {

    public static void backtrack(List<String> ans,
                                 String digits,
                                 Map<Character, String> mpp,
                                 StringBuilder s,
                                 int index) {
        if(index == digits.length()) {ans.add(s.toString()); return;}
        String letters = mpp.get(digits.charAt(index));
        for(char c : letters.toCharArray()) {
            s.append(c);
            backtrack(ans, digits, mpp, s, index+1);
            s.deleteCharAt(s.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        Map<Character, String> mpp = new HashMap<>();
        mpp.put('2', "abc");
        mpp.put('3', "def");
        mpp.put('4', "ghi");
        mpp.put('5', "jkl");
        mpp.put('6', "mno");
        mpp.put('7', "pqrs");
        mpp.put('8', "tuv");
        mpp.put('9', "wxyz");
        backtrack(ans, digits, mpp, new StringBuilder(), 0);
        return ans;
    }
    public static void main(String[]args) {
        //String digits = "23";
        //String digits = "";
        String digits = "2";
        log.info(letterCombinations(digits));
    }
    private static final Log log = new Log();
}
