/**
   12. Integer to Roman

   Seven different symbols represent Roman numerals with the following values:

   Symbol	Value
   I	1
   V	5
   X	10
   L	50
   C	100
   D	500
   M	1000

   Roman numerals are formed by appending the conversions of decimal place values
   from highest to lowest. Converting a decimal place value into a Roman numeral
   has the following rules:

   If the value does not start with 4 or 9, select the symbol of the maximal value
   that can be subtracted from the input, append that symbol to the result, subtract
   its value, and convert the remainder to a Roman numeral.
   If the value starts with 4 or 9 use the subtractive form representing one symbol
   subtracted from the following symbol, for example,

   4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.

   Only the following subtractive forms are used:

   4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).

   Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to
   represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times.
   If you need to append a symbol 4 times use the subtractive form.
   Given an integer, convert it to a Roman numeral.
   
   Example 1:
   Input: num = 3749
   Output: "MMMDCCXLIX"
   Explanation:
   3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
   700 = DCC as 500 (D) + 100 (C) + 100 (C)
   40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
   Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places

   Example 2:
   Input: num = 58
   Output: "LVIII"
   Explanation:
   50 = L
   8 = VIII
   
   Example 3:
   Input: num = 1994
   Output: "MCMXCIV"
   Explanation:
   1000 = M
   900 = CM
   90 = XC
   4 = IV
 
   Constraints:
   1 <= num <= 3999
   
   *************************************************************************

   13. Roman to Integer

   Roman numerals are represented by seven different symbols:
   I, V, X, L, C, D and M.

   Symbol       Value
   I             1
   V             5
   X             10
   L             50
   C             100
   D             500
   M             1000

   For example, 2 is written as II in Roman numeral, just two ones added together.
   12 is written as XII, which is simply X + II. The number 27 is written as XXVII,
   which is XX + V + II.

   Roman numerals are usually written largest to smallest from left to right.
   However, the numeral for four is not IIII. Instead, the number four is written as IV.
   Because the one is before the five we subtract it making four. The same principle
   applies to the number nine, which is written as IX. There are six instances where
   subtraction is used:

   I can be placed before V (5) and X (10) to make 4 and 9. 
   X can be placed before L (50) and C (100) to make 40 and 90. 
   C can be placed before D (500) and M (1000) to make 400 and 900.
   Given a roman numeral, convert it to an integer.

   Example 1:
   Input: s = "III"
   Output: 3
   Explanation: III = 3.

   Example 2:
   Input: s = "LVIII"
   Output: 58
   Explanation: L = 50, V= 5, III = 3.

   Example 3:
   Input: s = "MCMXCIV"
   Output: 1994
   Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
   Constraints:
   1 <= s.length <= 15
   s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
   It is guaranteed that s is a valid roman numeral in the range [1, 3999].   
*/
class RomanNumbers {
    public static String intToRoman2(int num) {
        int[]values = {1000, 900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1};
        String[]ch  = {"M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < values.length && num > 0; ++i) {
            while(num >= values[i])
            str.append(ch[i]); num -= values[i];
        }
        return str.toString();
    }
    public static String intToRoman(int n) {
        String s = "";
        Object[][]arr = {{1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, {100, "C"}, {90, "XC"}, {50, "L"},
                         {40,  "XL"}, {10,   "X"}, {9,  "IX"}, {5,    "V"}, {4,  "IV"}, {1,  "I"}};
        
        for(int i = 0; i < arr.length; ++i) {
            while(n >= (int)arr[i][0]) {
                s += (String)arr[i][1];
                n -= (int)arr[i][0];
            }
        }
        return s;
    }
    public static int romanToInt(String s) {
        int n = 0, ans = 0;
        for(int i = s.length()-1; i >= 0; --i) {
            switch(s.charAt(i)) {
            case 'I' : n = 1;    break;
            case 'V' : n = 5;    break;
            case 'X' : n = 10;   break;
            case 'L' : n = 50;   break;
            case 'C' : n = 100;  break;
            case 'D' : n = 500;  break;
            case 'M' : n = 1000; break;
            }
            if((4*n) < ans) ans = ans - n;
            else ans = ans + n;
        }
        return ans;
    }
    public static void main(String[]args) {
        // String s1 = "III";
        // String s2 = "LVIII";
        // String s3 = "MCMXCIV";
        // log.info(romanToInt(s1));
        // log.info(romanToInt(s2));
        // log.info(romanToInt(s3));

        int n1 = 3749;
        int n2 = 58;
        int n3 = 1994;
        log.info(intToRoman(n1));
        log.info(intToRoman(n2));
        log.info(intToRoman(n3));
        log.info(intToRoman(3));
        
    }
    private static final Log log = new Log();
}
