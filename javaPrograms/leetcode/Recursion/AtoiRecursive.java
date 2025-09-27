class AtoiRecursive {
    public static int myAtoi(String s) {
        if(s == null) return 0;
        return parse(s, 0, s.length());
    }
    public static int parse(String s, int i, int n) {
        if(i >= n) return 0;
        if(s.charAt(i) == ' ') return parse(s, i+1, n);
        return parseSign(s, i, n, 1);
    }
    public static int parseSign(String s, int i, int n, int sign) {
        if(i >= n) return 0;
        char c = s.charAt(i);
        if(c == '+') return parseDigits(s, i+1, n,  1, 0L);
        if(c == '-') return parseDigits(s, i+1, n, -1, 0L);
        return parseDigits(s, i, n, sign, 0L);
    }
    public static int parseDigits(String s, int i, int n, int sign, long result) {
        if(i >= n || !Character.isDigit(s.charAt(i))) return (int) (result*sign);
        int digit = s.charAt(i) - '0';
        result = result * 10 + digit;
        if(sign ==  1 &&  result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return parseDigits(s, i+1, n, sign, result);
    }
    public static void main(String[]args) {
        //String s = "amin 777";
        String s = "784";
        log.info(myAtoi(s));
        log.info(myAtoi("   -042"));       // -42
        log.info(myAtoi("1337c0d3"));      // 1337
        log.info(myAtoi("0-1"));           // 0
        log.info(myAtoi("words and 987")); // 0
        log.info(myAtoi("2147483647"));    // 2147483647
        log.info(myAtoi("2147483648"));    // 2147483647 (clamped)
        log.info(myAtoi("-2147483648"));   // -2147483648
        log.info(myAtoi("-2147483649"));   // -2147483648 (clamped)
        log.info(myAtoi(" -12345"));
    }
    private static final Log log = new Log();
}
