/**
   678. Valid Parenthesis String

   Given a string s containing only three types of characters: '(', ')' and '*',
   return true if s is valid.

   The following rules define a valid string:

   Any left parenthesis '(' must have a corresponding right parenthesis ')'.
   Any right parenthesis ')' must have a corresponding left parenthesis '('.
   Left parenthesis '(' must go before the corresponding right parenthesis ')'.
   '*' could be treated as a single right parenthesis ')' or a single left
   parenthesis '(' or an empty string "".

   Example 1:
   Input: s = "()"
   Output: true

   Example 2:
   Input: s = "(*)"
   Output: true

   Example 3:
   Input: s = "(*))"
   Output: true

   Constraints:
   1 <= s.length <= 100
   s[i] is '(', ')' or '*'.
*/
boolean checkValidString(String s) {
    int minOpen = 0, maxOpen = 0;
    for(char ch : s.toCharArray()) {
        if(ch == '(') {
            minOpen++;
            maxOpen++;
        } else if(ch == ')') {
            minOpen--;
            maxOpen--;
        } else {
            minOpen--;
            maxOpen++;
        } if(maxOpen < 0) return false;
        if(minOpen < 0) minOpen = 0;
    }
    return minOpen == 0;
}
void main() {
    IO.println(checkValidString("()"));
    IO.println(checkValidString("())"));
    IO.println(checkValidString("(*)"));
    IO.println(checkValidString("(*))"));
}
