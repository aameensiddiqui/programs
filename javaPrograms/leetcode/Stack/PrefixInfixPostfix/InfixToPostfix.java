import java.util.Stack;
class InfixToPostfix {
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";

        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) ans += ch;
            else if(ch == '(') st.push(ch);
            else if(ch == ')') {
                while(!st.isEmpty() && st.peek() != '(')
                    ans += st.pop();
                if(!st.isEmpty()) st.pop();
            } else {
                while(!st.isEmpty() && priority(ch) <= priority(st.peek()))
                    ans += st.pop();
                st.push(ch);
            }
        }
        while(!st.isEmpty())
            if(st.peek() != '(')
                ans += st.pop();
        return ans;
    }
    public static int priority(char c) {
        if(c == '^') return 3;
        if(c == '/' || c == '*') return 2;
        if(c == '+' || c == '-') return 1;
        else return -1;
    }
    public static void main(String[]args) {
        String s = "a+b*(c^d-e)";
        String s2 = "(p+q)*(m-n)";
        log.info(infixToPostfix(s2));
    }
    private static final Log log = new Log();
}
