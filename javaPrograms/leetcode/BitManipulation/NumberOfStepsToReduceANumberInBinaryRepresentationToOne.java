/**
   1404. Number of Steps to Reduce a Number in Binary Representation to One

   Given the binary representation of an integer as a string s, return the number
   of steps to reduce it to 1 under the following rules:

   If the current number is even, you have to divide it by 2.

   If the current number is odd, you have to add 1 to it.

   It is guaranteed that you can always reach one for all test cases.

   Example 1:
   Input: s = "1101"
   Output: 6
   Explanation: "1101" corressponds to number 13 in their decimal representation.
   Step 1) 13 is odd, add 1 and obtain 14.
   Step 2) 14 is even, divide by 2 and obtain 7.
   Step 3) 7 is odd, add 1 and obtain 8.
   Step 4) 8 is even, divide by 2 and obtain 4.
   Step 5) 4 is even, divide by 2 and obtain 2.
   Step 6) 2 is even, divide by 2 and obtain 1.

   Example 2:
   Input: s = "10"
   Output: 1
   Explanation: "10" corresponds to number 2 in their decimal representation.
   Step 1) 2 is even, divide by 2 and obtain 1.

   Example 3:
   Input: s = "1"
   Output: 0

   Constraints:
   1 <= s.length <= 500
   s consists of characters '0' or '1'
   s[0] == '1'
*/
class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    private static int numSteps(String s) {
        int steps = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; --i) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if (digit % 2 == 1) {carry = 1; steps += 2;}
            else steps++;
        }
        return steps + carry;
    }
    public static void main(String[] args) {
        Log.info(numSteps("1101")); // 13
        Log.info(numSteps("10"));   // 1
        Log.info(numSteps("1"));    // 0
        Log.info(numSteps("1111011110000011100000110001011011110010111001010111110001"));        // 85
        Log.info(numSteps("1111110011101010110011100100101110010100101110111010111110110010"));  // 89
    }
}
/**
    private static long binToDec(String s) {
        long ans = 0, r = 0, p = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                ans += Math.pow(2, p);
            }
            p++;
        }
        return ans;
    }
    private static int numSteps(String s) {
        int steps = 0;
        long curr = binToDec(s);
        Log.info(curr);
        while (curr != 1) {
            if (curr % 2 == 0) {curr >>= 1; steps++;}
            else {curr++; steps++;}
        }
        return steps;
    }
*/
