/**
   2840. Check if Strings Can be Made Equal With Operations II

   You are given two strings s1 and s2, both of length n, consisting of lowercase
   English letters.

   You can apply the following operation on any of the two strings any number of times:

   Choose any two indices i and j such that i < j and the difference j - i is even,
   then swap the two characters at those indices in the string.
   Return true if you can make the strings s1 and s2 equal, and false otherwise.

   Example 1:
   Input: s1 = "abcdba", s2 = "cabdab"
   Output: true
   Explanation: We can apply the following operations on s1:
   - Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
   - Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
   - Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.

   Example 2:
   Input: s1 = "abe", s2 = "bea"
   Output: false
   Explanation: It is not possible to make the two strings equal.

   Constraints:
   n == s1.length == s2.length
   1 <= n <= 105
   s1 and s2 consist only of lowercase
*/
class CheckIfStringsCanBeMadeEqualWithOperationsII {
    /*
      approach: Hash Table | Frequency Counting

      since characters can only move within the same parity, we only need to check whether
      the two strings contain the same characters in:

      all even, and all odd positions

      so we compare the character frequencies of these two groups separately.
      we can merge the two parity groups into one frequency array.

      indices [0....25] are used for characters at even positions
      indices [26...51] are used for characters at odd  positions

      so the same letter is counted in different slots depending on whether it appears at
      an even or odd index.

      then we scan both strings once:
      add the character from s1.
      subtract the character from s2.
      if both strings contain exactly the same characters at even positions and also at odd
      positions, then every count becomes 0.
     */
    private static boolean checkStrings(String s1, String s2) {
        int[] freq = new int[52]; // 26 + 26
        for (int i = 0; i < s1.length(); ++i) {
            int off = (i & 1) * 26;
            freq[s1.charAt(i) - 'a' + off]++;
            freq[s2.charAt(i) - 'a' + off]--;
        }
        for (int i = 0; i < freq.length; ++i)
            if (freq[i] != 0) return false;
        return true;
    }
    public static void main(String[]args) {
        Log.info(checkStrings("abcdba", "cabdab"));
        Log.info(checkStrings("abe", "bea"));
    }
}
