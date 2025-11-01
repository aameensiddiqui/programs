/**
   506. Relative Ranks

   You are given an integer array score of size n, where score[i] is the score
   of the ith athlete in a competition. All the scores are guaranteed to be unique.

   The athletes are placed based on their scores, where the 1st place athlete has
   the highest score, the 2nd place athlete has the 2nd highest score, and so on.
   The placement of each athlete determines their rank:

   The 1st place athlete's rank is "Gold Medal".
   The 2nd place athlete's rank is "Silver Medal".
   The 3rd place athlete's rank is "Bronze Medal".
   For the 4th place to the nth place athlete, their rank is their placement number
   (i.e., the xth place athlete's rank is "x").
   Return an array answer of size n where answer[i] is the rank of the ith athlete.

   Example 1:
   Input: score = [5,4,3,2,1]
   Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
   Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

   Example 2:
   Input: score = [10,3,8,9,4]
   Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
   Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].



   Constraints:
   n == score.length
   1 <= n <= 104
   0 <= score[i] <= 106
   All the values in score are unique.

   https://leetcode.com/problems/relative-ranks/
 */

import java.util.*;

class RelativeRanks {
    public static String[] findRelativeRanks(int[]nums) {
        String[]s = new String[nums.length];
        /**
         * int[]copy = nums;
         * This does not create a new copy of the
         * array.
         * It just creates another reference to
         * the same array in memory.
         * So when we do:
         * Arrays.sort(copy);
         * we are actually sorting the 
         * original nums array too
         * so we make a real copy
         * */
        int[]copy  = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Map<Integer, String> mpp = new HashMap<>();
        
        for(int i = copy.length-1, cnt = 1; i >= 0; --i) {
            if(cnt == 1) {
                mpp.put(copy[i], "Gold Medal");
                cnt++;
            } else if(cnt == 2) {
                mpp.put(copy[i], "Silver Medal");
                cnt++;;
            } else if(cnt == 3) {
                mpp.put(copy[i], "Bronze Medal");
                cnt++;
            } else {
                mpp.put(copy[i], String.valueOf(cnt++));
            }
        }
        for(int i = 0; i < nums.length; ++i) {
            s[i] = mpp.get(nums[i]);
        }
        return s;
    }
    public static void main(String[]args) {
        int[]arr1 = {5, 4, 3, 2, 1};
        int[]arr2 = {10, 3, 8, 9, 4};
        String[]ans1 = findRelativeRanks(arr1);
        String[]ans2 = findRelativeRanks(arr2);
        for(String s : ans1) System.out.print(s+",");
        System.out.println();
        for(String s : ans2) System.out.print(s+",");
    }
    //private static final Log log = new Log();
}
