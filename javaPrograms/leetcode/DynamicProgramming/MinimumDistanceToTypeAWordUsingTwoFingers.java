/**
   1320. Minimum Distance to Type a Word Using Two Fingers

   You have a keyboard layout as shown above in the X-Y plane, where each English uppercase letter
   is located at some coordinate.

   For example, the letter 'A' is located at coordinate (0, 0), the letter 'B' is located at coordinate
   (0, 1), the letter 'P' is located at coordinate (2, 3) and the letter 'Z' is located at coordinate (4, 1).
   Given the string word, return the minimum total distance to type such string using only two fingers.

   The distance between coordinates (x1, y1) and (x2, y2) is |x1 - x2| + |y1 - y2|.

   Note that the initial positions of your two fingers are considered free so do not count towards your
   total distance, also your two fingers do not have to start at the first letter or the first two letters.

   Example 1:
   Input: word = "CAKE"
   Output: 3
   Explanation: Using two fingers, one optimal way to type "CAKE" is:
   Finger 1 on letter 'C' -> cost = 0
   Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
   Finger 2 on letter 'K' -> cost = 0
   Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
   Total distance = 3

   Example 2:
   Input: word = "HAPPY"
   Output: 6
   Explanation: Using two fingers, one optimal way to type "HAPPY" is:
   Finger 1 on letter 'H' -> cost = 0
   Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
   Finger 2 on letter 'P' -> cost = 0
   Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
   Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
   Total distance = 6

   Constraints:
   2 <= word.length <= 300
   word consists of uppercase English letters.
*/
/*
  2D Dynamic Programming Approach

  Intuition
  From Approach 1, recall the key property: for any state dp[i][l][r],
  either word[i] == l or word[i] == r.
  This means that for each i, we only need to store 2 * 26 states instead of 26^2.

  We can redefine the state as dp[i][op][rest], where:

  op = 0 means the left  hand is at word[i]
  op = 1 means the right hand is at word[i]
  rest represents the position of the other hand
  We can simplify this further by observing symmetry.
  Swapping the roles of the left and right hands does not change the total movement cost.
  Therefore, dp[i][op = 0][rest] and
             dp[i][op = 1][rest] are always equal.

  This allows us to reduce the state to dp[i][rest],
  which represents the minimum movement cost when one hand is at word[i] and the other is at
  position rest.
  We no longer need to distinguish between left and right hands.

  Complexity Analysis
  Time complexity:  O(26 * N).
  Space complexity: O(26 * N).
*/
/*
  WHY CAN WE REDUCE FROM 3D TO 2D?
  In the 3D approach, the state was dp[i][l][r]:
  after typing character i, left finger at l, right finger at r.
  But we know one finger MUST be on word[i] at all times.
  So for each i, only 26 states are actually meaningful, not 26x26.

  We redefine: dp[i][rest] = minimum total distance after typing character i,
  where one finger is ON word[i] and the other finger is at position rest.
  We don't care which hand is which - swapping hands never changes the cost.

  BASE CASE (i = 0):
  First character costs zero no matter where the other finger is:
  dp[0][any] = 0   (one finger sits on word[0], other finger anywhere for free)

  TRANSITION (i >= 1):
  curr = word[i],  prev = word[i - 1],  dist = getDist(prev, curr)

  Case 1 - same finger moves from prev to curr (other finger j stays put):
  dp[i][j] = dp[i - 1][j] + dist
  The idle finger j did not move, active finger paid dist to reach curr.

  Case 2 - idle finger takes over and types curr (only when j == prev):
  The finger that was at k now moves to curr, idle finger stays at prev(=j):
  dp[i][j] = dp[i - 1][k] + getDist(k, curr)   for all k
  Previous active finger k moves to curr, previous idle finger j = prev stays.

  ANSWER:
  min(dp[n - 1][i]) over all i
  One finger is on the last character, the other is at some position i.
  The minimum across all those positions is the answer.

  COMPLEXITY:
  Time  -> O(26 * N) : for each character, we loop over 26 idle positions
  Space -> O(26 * N) : 2D dp table instead of 3D, 26x smaller than Approach 1
*/
import java.util.*;

class MinimumDistanceToTypeAWordUsingTwoFingers {
    private static int getDist(int x, int y) {
        int x1 = x / 6;
        int y1 = x % 6;
        int x2 = y / 6;
        int y2 = y % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    private static int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        Arrays.fill(dp[0], 0);

        for (int i = 1; i < n; ++i) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            int dist = getDist(prev, curr);

            for (int j = 0; j < 26; ++j) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dist);

                if (prev == j) {
                    for (int k = 0; k < 26; ++k) {
                        int d0 = getDist(k, curr);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + d0);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < 26; ++i) {
                ans = Math.min(ans, dp[n - 1][i]);
        }
        // for (int val : dp[n - 1]) ans = Math.min(ans, val);
        return ans;
    }
    public static void main(String[] args) {
        log.info(minimumDistance("CAKE"));
        log.info(minimumDistance("HAPPY"));
    }
}
/*
  3D Dynamic Programming Approach

  KEYBOARD LAYOUT (6 columns):
  A B C D E F   ->  0 - 5
  G H I J K L   ->  6 - 11
  M N O P Q R   -> 12 - 17
  S T U V W X   -> 18 - 23
  Y Z           -> 24 - 25

  Each letter maps to a number: A = 0, B = 1,... Z = 25
  Row = position / 6,
  Col = position % 6
  Movement cost between two letters = |row1-row2| + |col1-col2|  (Manhattan distance)

  GOAL:
  Type the entire word with two fingers, minimizing total finger movement.

  KEY OBSERVATION:
  After typing character i, one finger MUST be sitting on word[i].
  The other finger can be anywhere.
  So the state is: dp[i][l][r] = minimum total distance after typing
  the ith character, with left finger at l and right finger at r.

  AT EVERY STEP, only two things can happen:
  1. The same finger that typed word[i - 1] also types word[i]  -> cost = dist(prev, curr)
  2. The idle finger jumps in and types word[i]                 -> cost = dist(idle_pos, curr)

  BASE CASE (i = 0):
  First character costs zero. One finger sits on it, other finger
  can be anywhere:
  dp[0][any][word[0]] = 0
  dp[0][word[0]][any] = 0

  TRANSITION (i >= 1):
  curr = word[i],  prev = word[i - 1],  dist = getDistance(prev, curr)

  Case 1 - same finger moves (idle finger j stays put):
  dp[i][curr][j] = dp[i - 1][prev][j] + dist   // left finger moved
  dp[i][j][curr] = dp[i - 1][j][prev] + dist   // right finger moved

  Case 2 - idle finger takes over (only when j == prev):
  The finger that was at k now moves to curr:
  dp[i][curr][j] = dp[i - 1][k][j] + dist(k, curr)   // left finger came from k
  dp[i][j][curr] = dp[i - 1][j][k] + dist(k, curr)   // right finger came from k

  ANSWER:
  min(dp[n - 1][i][j]) over all i, j

  COMPLEXITY:
  Time  -> O(26   * N) : for each character, we loop over 26 idle positions
  Space -> O(26^2 * N) : the full dp table
*/
/*
  class MinimumDistanceToTypeAWordUsingTwoFingers {
    private static int getDist(int x, int y) {
        int x1 = x / 6;
        int y1 = x % 6;
        int x2 = y / 6;
        int y2 = y % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    private static int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n][26][26];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k)
                    dp[i][j][k] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < 26; ++i) {
            dp[0][word.charAt(0) - 'A'][i] = 0;
            dp[0][i][word.charAt(0) - 'A'] = 0;
        }
        for (int i = 1; i < n; ++i) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            int dist = getDist(prev, curr);

            for (int j = 0; j < 26; ++j) {
                dp[i][curr][j] = Math.min(dp[i][curr][j], dp[i - 1][prev][j] + dist);
                dp[i][j][curr] = Math.min(dp[i][j][curr], dp[i - 1][j][prev] + dist);

                if (prev == j) {
                    for (int k = 0; k < 26; ++k) {
                        int d0 = getDist(k, curr);
                        dp[i][curr][j] = Math.min(dp[i][curr][j], dp[i - 1][k][j] + d0);
                        dp[i][j][curr] = Math.min(dp[i][j][curr], dp[i - 1][j][k] + d0);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j)
                ans = Math.min(ans, dp[n - 1][i][j]);
        }
        return ans;
    }
*/
