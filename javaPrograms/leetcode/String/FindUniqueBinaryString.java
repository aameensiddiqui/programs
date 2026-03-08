/**
   1980. Find Unique Binary String

   Given an array of strings nums containing n unique binary strings each of length n,
   return a binary string of length n that does not appear in nums. If there are multiple
   answers, you may return any of them.

   Example 1:
   Input: nums = ["01","10"]
   Output: "11"
   Explanation: "11" does not appear in nums. "00" would also be correct.

   Example 2:
   Input: nums = ["00","01"]
   Output: "11"
   Explanation: "11" does not appear in nums. "10" would also be correct.

   Example 3:
   Input: nums = ["111","011","001"]
   Output: "101"
   Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also
   be correct.

   Constraints:
   n == nums.length
   1 <= n <= 16
   nums[i].length == n
   nums[i] is either '0' or '1'.
   All the strings of nums are unique.
*/
import java.util.*;

class FindUniqueBinaryString {
    private static int n;
    private static Set<String> numSet = new HashSet<>();
    private static String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        for (String s : nums) numSet.add(s);
        return generate("");
    }
    private static String generate(String cur) {
        if (cur.length() == n) {
            if (!numSet.contains(cur)) return cur;
            return "";
        }
        String add_0 = generate(cur + "0");
        if (add_0.length() > 0) return add_0;
        return generate(cur + "1");
    }
    public static void main(String[] args) {
        Log.info(findDifferentBinaryString(new String[] {"01","10"}));
        Log.info(findDifferentBinaryString(new String[] {"00","01"}));
        Log.info(findDifferentBinaryString(new String[] {"111","011","001"}));
    }
}
