class RmOuterParentheses {

    public static String solution(String s) {
        String ans = "";
        int balance = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                // If balance is greater than 0, it means this '(' is not an
                // outermost parenthesis that's how we add all the inner parentheses to our ans
                if(balance > 0) ans = ans + String.valueOf(c);
                balance++;
            } else if(c == ')') {
                balance--;
                // If balance is greater than 0, it means this ')' is not an
                // outermost parenthesis
                if(balance > 0) ans = ans + String.valueOf(c);
            }
        }
        return ans;
    }
    
    public static void main(String[]args) {
        String s = "(()())(())";
        // should return ()()()
        System.out.println(solution(s));
    }
}
