/**
   2463. Minimum Total Distance Traveled

   There are some robots and factories on the X-axis. You are given an integer array robot where
   robot[i] is the position of the ith robot. You are also given a 2D integer array factory where
   factory[j] = [positionj, limitj] indicates that positionj is the position of the jth factory and
   that the jth factory can repair at most limitj robots.

   The positions of each robot are unique. The positions of each factory are also unique.
   Note that a robot can be in the same position as a factory initially.

   All the robots are initially broken; they keep moving in one direction.
   The direction could be the negative or the positive direction of the X-axis.
   When a robot reaches a factory that did not reach its limit, the factory repairs the robot,
   and it stops moving.

   At any moment, you can set the initial direction of moving for some robot.
   Your target is to minimize the total distance traveled by all the robots.

   Return the minimum total distance traveled by all the robots.
   The test cases are generated such that all the robots can be repaired.

   Note that

   All robots move at the same speed.
   If two robots move in the same direction, they will never collide.
   If two robots move in opposite directions and they meet at some point, they do not collide.
   They cross each other.
   If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.
   If the robot moved from a position x to a position y, the distance it moved is |y - x|.

   Example 1:
   Input: robot = [0,4,6], factory = [[2,2],[6,2]]
   Output: 4
   Explanation: As shown in the figure:
   - The first robot at position 0 moves in the positive direction.
     It will be repaired at the first factory.
   - The second robot at position 4 moves in the negative direction.
     It will be repaired at the first factory.
   - The third robot at position 6 will be repaired at the second factory. It does not need to move.
   The limit of the first factory is 2, and it fixed 2 robots.
   The limit of the second factory is 2, and it fixed 1 robot.
   The total distance is |2 - 0| + |2 - 4| + |6 - 6| = 4.
   It can be shown that we cannot achieve a better total distance than 4.

   Example 2:
   Input: robot = [1,-1], factory = [[-2,1],[2,1]]
   Output: 2
   Explanation: As shown in the figure:
   - The first robot at position 1 moves in the positive direction.
     It will be repaired at the second factory.
   - The second robot at position -1 moves in the negative direction.
     It will be repaired at the first factory.
   The limit of the first factory is 1, and it fixed 1 robot.
   The limit of the second factory is 1, and it fixed 1 robot.
   The total distance is |2 - 1| + |(-2) - (-1)| = 2.
   It can be shown that we cannot achieve a better total distance than 2.

   Constraints:
   1 <= robot.length, factory.length <= 100
   factory[j].length == 2
   -109 <= robot[i], positionj <= 109
   0 <= limitj <= robot.length
   The input will be generated such that it is always possible to repair every robot.
*/
import java.util.*;

class MinimumTotalDistanceTraveled {
    // tabulation
    private static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        List<Integer> fPos = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; ++i) fPos.add(f[0]);
        }
        int rCnt = robot.size(), fCnt = fPos.size();
        long[] next = new long[fCnt + 1];
        long[] curr = new long[fCnt + 1];
        curr[fCnt] = (long) 1e12;

        for (int r = rCnt - 1; r >= 0; --r) {
            for (int f = fCnt - 1; f >= 0; --f) {
                long assign = Math.abs(robot.get(r) - fPos.get(f)) + next[f + 1];
                long skip   = curr[f + 1];
                curr[f] = Math.min(assign, skip);
            }
            System.arraycopy(curr, 0, next, 0, fCnt + 1);
        }
        return curr[0];
    }
    public static void main(String[] args) {
        log.info(minimumTotalDistance(new ArrayList<>(Arrays.asList(0,4,6)), new int[][] {{2,2},{6,2}})); // 4
        log.info(minimumTotalDistance(new ArrayList<>(Arrays.asList(-1,1)), new int[][] {{-2,1},{2,1}})); // 2
        log.info(minimumTotalDistance(new ArrayList<>(Arrays.asList(789300819,-600989788,529140594,-592135328,
                                                                    -840831288,209726656,-671200998)
                                                      ),
                                      new int[][] {
                                          {-865262624,6},{-717666169,0},{725929046,2},{449443632,3},{-912630111,0},
                                          {270903707,3},{-769206598,2},{-299780916,4},{-159433745,5},{-467185764,3},
                                          {849991650,7},{-292158515,6},{940410553,6},{258278787,0},{83034539,2},
                                          {54441577,3},{-235385712,2},{75791769,3}
                                      })); // 582755368
    }
}
/**
    // tabulation
    private static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        List<Integer> fPos = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; ++i) fPos.add(f[0]);
        }
        int rCnt = robot.size(), fCnt = fPos.size();
        long[][] dp = new long[rCnt + 1][fCnt + 1];
        for (int i = 0; i < rCnt; ++i) dp[i][fCnt] = (long) 1e12;

        for (int r = rCnt - 1; r >= 0; --r) {
            for (int f = fCnt - 1; f >= 0; --f) {
                long assign = Math.abs(robot.get(r) - fPos.get(f)) + dp[r + 1][f + 1];
                long skip   = dp[r][f + 1];
                dp[r][f] = Math.min(assign, skip);
            }
        }
        return dp[0][0];
    }
*/
/**
    // memoisation
    private static long[][] dp;
    private static long dfs(int r, int f, List<Integer> robot, List<Integer> fPos) {
        if (r == robot.size()) return 0; // all robots assigned
        if (f == fPos.size()) return (long) 1e12; // no factories left to assign
        if (dp[r][f] != -1) return dp[r][f];
        // option 1: assign the current robot to the current factory
        long assign = Math.abs(robot.get(r) - fPos.get(f)) + dfs(r + 1, f + 1, robot, fPos);
        // option 2: skip the current factory for the current robot
        long skip = dfs(r, f + 1, robot, fPos);
        return dp[r][f] = Math.min(assign, skip);
    }
    private static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        List<Integer> fPos = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; ++i) fPos.add(f[0]);
        }
        dp = new long[robot.size()][fPos.size()];
        for (long[] arr : dp) Arrays.fill(arr, -1);
        return dfs(0, 0, robot, fPos);
    }
*/
/**
    // recursive approach
    private static long dfs(int r, int f, List<Integer> robot, List<Integer> fPos) {
        if (r == robot.size()) return 0;
        if (f == fPos.size()) return (long) 1e12;
        // option 1: assign the current robot to the current factory
        long assign = Math.abs(robot.get(r) - fPos.get(f)) + dfs(r + 1, f + 1, robot, fPos);
        // option 2: skip the current robot for the current factory
        long skip = dfs(r, f + 1, robot, fPos);
        return Math.min(assign, skip);
    }
    private static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        List<Integer> fPos = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; ++i) fPos.add(f[0]);
        }
        return dfs(0, 0, robot, fPos);
    }
*/
