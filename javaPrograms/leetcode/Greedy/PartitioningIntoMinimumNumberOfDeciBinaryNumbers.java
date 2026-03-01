/**
   1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

   A decimal number is called deci-binary if each of its digits is either 0 or 1 without
   any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

   Given a string n that represents a positive decimal integer, return the minimum number
   of positive deci-binary numbers needed so that they sum up to n.

   Example 1:
   Input: n = "32"
   Output: 3
   Explanation: 10 + 11 + 11 = 32

   Example 2:
   Input: n = "82734"
   Output: 8

   Example 3:
   Input: n = "27346209830709182346"
   Output: 9

   Constraints:
   1 <= n.length <= 105
   n consists of only digits.
   n does not contain any leading zeros and represents a positive integer.
 */
class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    /* same logic. checks max digit */
    private static int minPartitions(String n) {
        for (int i = 9; i >= 1; --i)
            if (n.contains(String.valueOf(i))) return i;
        return 1;
    }
    public static void main(String[] args) {
        Log.info(minPartitions("32"));
        Log.info(minPartitions("82734"));
        Log.info(minPartitions("27346209830709182346"));
    }
}
/*
      think of it digit by digit
      if a digit is, say, 7, then you need to add seven 1s
      i.e. at least seven deci-binary numbers
      each deci-binary number only contribute 1 to that position

      so, in short you need the maximum digit in the string

      e.g.
      1700

        1100
       + 100
       + 100
       + 100
       + 100
       + 100
       + 100
       -----
        1700

        if you tried 6 numbers, the hundreds column needs to sum to 7
        but each row can only contribute a maximum of 1
        six rows can sum to at most 6 in any column
        you are one short
        7 is the strict minimum
    */
/**
    private static int minPartitions(String n) {
        int m = 0;
        for (int i = 0; i < n.length(); ++i)
            m = Math.max(m, n.charAt(i) - '0');
        return m;
    }
 */
