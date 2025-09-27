import java.util.Stack;

class Parentheses {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(' && c == ')' || stack.peek() == '{' && c == '}' || stack.peek() == '[' && c == ']')
                    stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[]args) {
        String s = "{}[]()";
        System.out.println(isValid(s));
    } 
}
