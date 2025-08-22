import java.lang.StringBuilder;
class Atoi {
    public static int solution(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == ' ') i++;

        if(i < s.length() && s.charAt(i) == '+' || s.charAt(i) == '-') {
            ans.append(s.charAt(i));
            i++;
        }

        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            ans.append(s.charAt(i));
            i++;
        }
        String str = ans.toString();
        log(str);
        if(str.isEmpty() || str.equals("+") || str.equals("-")) return 0;
        int n = Integer.parseInt(str);
        return n;
        
        // if (s == null || s.length() == 0) return 0;
        // int i = 0;
        // int n = s.length();
        
        // // Step 1: Skip leading whitespace
        // while (i < n && s.charAt(i) == ' ') i++;
        
        // // Check if we've reached the end
        // if (i == n) return 0;
        
        // // Step 2: Check for sign
        // int sign = 1;
        // if (s.charAt(i) == '+') i++;
        // else if (s.charAt(i) == '-') {
        //     sign = -1;
        //     i++;
        // }
        
        // long res = 0;
        // while (i < n && Character.isDigit(s.charAt(i))) {
        //     int digit = s.charAt(i) - '0';
        //     res = res * 10 + digit;
        //     if (sign * res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        //     if (sign * res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;;
        //     i++;
        // }
        
        // return (int)(res * sign);  

    }
    
    public static void main(String[]args) {
        //String s = "   -042";
        //String s = "1337c0d3";
        //String s = "0-1";
        String s = "words and 987";
        log("["+solution(s)+"]");
    }
    
    public static void log(Object ... args) {
        for(Object ob : args) System.out.println(ob);
    }
}
