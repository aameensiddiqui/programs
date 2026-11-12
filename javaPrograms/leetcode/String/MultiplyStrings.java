class MultiplyStrings {
    private static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        StringBuilder rem = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        String[] arr = new String[num1.length()];

        for (int i = num1.length() - 1; i >= 0; --i) {
            char c1 = num1.charAt(i);
            for (int j = num2.length() - 1; j >= 0; --j) {
                char c2 = num2.charAt(j);
                // ans.append((c1 - '0') * (c2 - '0'));
                Log.info("(c1 - '0') = " + (c1 - '0'));
                Log.info("(c2 - '0') = " + (c2 - '0'));
                rem.append((c1 - '0') * (c2 - '0'));
                Log.info("rem = " + rem);
                if (rem.length() > 1) {
                    ans.append(rem.substring(rem.length() - 2));
                    Log.info("==-->" + ans.append(rem.charAt(rem.length() - 1)));
                }
            }
        }
        return "";
        // return String.valueOf((char) num1 * (char) num2);
    }
    public static void main(String[] args) {
        // Log.info("Hello, World!");
        Log.info(multiply("2", "3"));
        Log.info(multiply("123", "456"));
    }
}
