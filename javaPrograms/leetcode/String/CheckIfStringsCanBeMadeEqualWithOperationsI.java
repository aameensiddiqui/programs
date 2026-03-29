/**
   2839. Check if Strings Can be Made Equal With Operations I

   You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.

   You can apply the following operation on any of the two strings any number of times:

   Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices
   in the string.
   Return true if you can make the strings s1 and s2 equal, and false otherwise.

   Example 1:
   Input: s1 = "abcd", s2 = "cdab"
   Output: true
   Explanation: We can do the following operations on s1:
   - Choose the indices i = 0, j = 2. The resulting string is s1 = "cbad".
   - Choose the indices i = 1, j = 3. The resulting string is s1 = "cdab" = s2.

   Example 2:
   Input: s1 = "abcd", s2 = "dacb"
   Output: false
   Explanation: It is not possible to make the two strings equal.

   Constraints:
   s1.length == s2.length == 4
   s1 and s2 consist only of lowercase English letters.
*/
class CheckIfStringsCanBeMadeEqualWithOperationsI {
    private static boolean canBeEqual(String s1, String s2) {
        if(s1.charAt(0) != s2.charAt(0) && (s1.charAt(0) != s2.charAt(2) ||
                                            s1.charAt(2) != s2.charAt(0)))
            return false;
        if(s1.charAt(1) != s2.charAt(1) && (s1.charAt(1) != s2.charAt(3) ||
                                            s1.charAt(3) != s2.charAt(1)))
            return false;
        if(s1.charAt(0) == s2.charAt(0) && s1.charAt(2) != s2.charAt(2))
            return false;
        if(s1.charAt(1) == s2.charAt(1) && s1.charAt(3) != s2.charAt(3))
            return false;
        return true;
    }
    public static void main(String[]args) {
        Log.info(canBeEqual("abcd", "cdab"));
        Log.info(canBeEqual("abcd", "dacb"));
    }
}
/**
    private static String swap(int a, int b, String s) {
        char[] arr = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return String.valueOf(arr);
    }
    private static boolean canBeEqual(String s1, String s2) {
        String ts1 = s1, ts2 = s2;
        int[][] ops = {
            {1, 0}, // s1: (0,2)
            {2, 0}, // s1: (1,3)
            {0, 1}, // s2: (0,2)
            {0, 2}, // s2: (1,3)
            {1, 2}, // s1: both
            {0, 3}, // s2: both
            {1, 1}, // both: (0,2)
            {2, 2}, // both: (1,3)
            {1, 2}, // s1: (0,2), s2: (1,3)
            {2, 1}  // s1: (1,3), s2: (0,2)
        };
        for (int[] op : ops) {
            if (op[0] == 1 || op[0] == 3) s1 = swap(0, 2, s1);
            if (op[0] == 2 || op[0] == 3) s1 = swap(1, 3, s1);

            if (op[1] == 1 || op[1] == 3) s2 = swap(0, 2, s2);
            if (op[1] == 2 || op[1] == 3) s2 = swap(1, 3, s2);

            if (s1.equals(s2)) return true;
        }
        return false;
    }
*/
/**
    private static String swap(int a, int b, String s) {
        char[] arr = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return String.valueOf(arr);
    }
    private static boolean canBeEqual(String s1, String s2) {
        String ts1 = s1, ts2 = s2;
        // 1
        //s1 - 0 2
        //check
        s1 = swap(0, 2, s1);
        if (s1.equals(s2)) return true;
        s1 = ts1;

        // 2
        //s1 - 1 3
        //check
        s1 = swap(1, 3, s1);
        if (s1.equals(s2)) return true;
        s1 = ts1;

        // 3
        //s2 - 0 2
        //check
        s2 = swap(0, 2, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;

        // 4
        //s2 - 1 3
        //check
        s2 = swap(1, 3, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;

        // 5
        //s1 - 0 2
        //s1 - 1 3
        //check
        s1 = swap(0, 2, s1);
        s1 = swap(1, 3, s1);
        if (s1.equals(s2)) return true;
        s1 = ts1;

        // 6
        //s2 - 0 2
        //s2 - 1 3
        //check
        s2 = swap(0, 2, s2);
        s2 = swap(1, 3, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;

        // 7
        //s1 - 0 2
        //s2 - 0 2
        //check
        s1 = swap(0, 2, s1);
        s2 = swap(0, 2, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;
        s1 = ts1;

        // 8
        //s1 - 1 3
        //s2 - 1 3
        //check
        s1 = swap(1, 3, s1);
        s2 = swap(1, 3, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;
        s1 = ts1;

        // 9
        //s1 - 0 2
        //s2 - 1 3
        //check
        s1 = swap(0, 2, s1);
        s2 = swap(1, 3, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;
        s1 = ts1;

        // 10
        //s1 - 1 3
        //s2 - 0 2
        //check
        s1 = swap(1, 3, s1);
        s2 = swap(0, 2, s2);
        if (s1.equals(s2)) return true;
        s2 = ts2;
        s1 = ts1;

        return false;
    }
*/
