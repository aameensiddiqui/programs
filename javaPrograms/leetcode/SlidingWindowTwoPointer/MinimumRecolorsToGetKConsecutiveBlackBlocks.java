/**
   2379. Minimum Recolors to Get K Consecutive Black Blocks

   You are given a 0-indexed string blocks of length n, where blocks[i] is either
   'W' or 'B', representing the color of the ith block. The characters 'W' and 'B'
   denote the colors white and black, respectively.

   You are also given an integer k, which is the desired number of consecutive black
   blocks.

   In one operation, you can recolor a white block such that it becomes a black block.

   Return the minimum number of operations needed such that there is at least one
   occurrence of k consecutive black blocks.

   Example 1:
   Input: blocks = "WBBWWBBWBW", k = 7
   Output: 3
   Explanation:
   One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th
   blocks
   so that blocks = "BBBBBBBWBW".
   It can be shown that there is no way to achieve 7 consecutive black blocks in less
   than 3 operations.
   Therefore, we return 3.

   Example 2:
   Input: blocks = "WBWBBBW", k = 2
   Output: 0
   Explanation:
   No changes need to be made, since 2 consecutive black blocks already exist.
   Therefore, we return 0.
*/
class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    /*
      When sliding the window one position to the right, most of the count stays the same.
      We only need to subtract the contribution of the element leaving the window and add
      the contribution of the new element entering. This avoids recounting the entire
      window each time, reducing time from O(n*k) to O(n).
      Count 'W' characters in the first window (positions 0 to k-1).
      Set this as the initial result.

      Algorithm:
      Slide the window from position k to n-1:
      If the element leaving (at position i - k) is 'W', decrement the count.
      If the element entering (at position i) is 'W', increment the count.
      Update res with the minimum count seen.
     */
    private static int minimumRecolors(String blocks, int k) {
        int cntW = 0;
        for (int i = 0; i < k; ++i) if (blocks.charAt(i) == 'W') cntW++;
        int res = cntW;
        for (int i = k; i < blocks.length(); ++i) {
            if (blocks.charAt(i - k) == 'W') cntW--;
            if (blocks.charAt(i) == 'W') cntW++;
            res = Math.min(res, cntW);
        }
        return res;
    }
    public static void main(String[]args) {
        Log.info(minimumRecolors("WBBWWBBWBW", 7));
        Log.info(minimumRecolors("WBWBBBW", 2));
    }
}
/*
  We need to find a window of k consecutive blocks that requires the fewest recolors
  to become all black. A recolor is needed for each white block ('W') in the window.
  We can check every possible window of size k and count the white blocks in each,
  keeping track of the minimum count.

  Algorithm:
  Initialize res to the length of the string (worst case).
  For each starting position i from 0 to n - k:
  Count the number of 'W' characters in the window from i to i + k - 1.
  Update res with the minimum count seen.
*/
/**
    private static int minimumRecolors(String blocks, int k) {
        int res = blocks.length();
        for (int i = 0; i <= blocks.length() - k; ++i) {
            int cntW = 0;
            for (int j = i; j < i + k; ++j) {
                if (blocks.charAt(j) == 'W') cntW++;
            }
            res = Math.min(res, cntW);
        }
        return res;
    }
*/
