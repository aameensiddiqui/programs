/**
   2833. Furthest Point From Origin

   You are given a string moves of length n consisting only of characters 'L', 'R', and '_'.
   The string represents your movement on a number line starting from the origin 0.

   In the ith move, you can choose one of the following directions:

   move to the left if moves[i] = 'L' or moves[i] = '_'
   move to the right if moves[i] = 'R' or moves[i] = '_'
   Return the distance from the origin of the furthest point you can get to after n moves.

   Example 1:
   Input: moves = "L_RL__R"
   Output: 3
   Explanation: The furthest point we can reach from the origin 0 is point -3 through the
   following sequence of moves "LLRLLLR".

   Example 2:
   Input: moves = "_R__LL_"
   Output: 5
   Explanation: The furthest point we can reach from the origin 0 is point -5 through the
   following sequence of moves "LRLLLLL".

   Example 3:
   Input: moves = "_______"
   Output: 7
   Explanation: The furthest point we can reach from the origin 0 is point 7 through the
   following sequence of moves "RRRRRRR".

   Constraints:
   1 <= moves.length == n <= 50
   moves consists only of characters 'L', 'R' and '_'.
*/
class FurthestPointFromOrigin {
    /*
      Let
      L be the number of ’L’ characters in moves,
      R be the number of ’R’ characters in moves,
      U be the number of '_' characters in moves.

      The distance from the current position to the origin, ignoring '_', is ∣L − R∣.
      To maximize the final distance from the origin, all '_' characters should be assigned in
      the same direction as the current movement, resulting in a maximum distance of ∣L − R∣ + U.
     */
    private static int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, u = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') l++;
            else if (c == 'R') r++;
            else u++;
        }
        return Math.abs(l - r) + u;
    }
    public static void main(String[] args) {
        Log.info(furthestDistanceFromOrigin("L_RL__R"));
        Log.info(furthestDistanceFromOrigin("_R__LL_"));
        Log.info(furthestDistanceFromOrigin("_______"));
    }
}
/**
    // In an optimal answer, all occurrences of '_’ will be replaced with the same character.
    // Replace all characters of '_’ with the character that occurs the most.
    private static int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, ans = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') l++;
            if (c == 'R') r++;
        }
        if (l > r) {
            for (char c : moves.toCharArray()) {
                if (c == 'L') ans--;
                else if (c == 'R') ans++;
                else ans--;
            }
        } else {
            for (char c : moves.toCharArray()) {
                if (c == 'L') ans--;
                else if (c == 'R') ans++;
                else ans++;
            }
        }
        return Math.abs(ans);
    }
*/
