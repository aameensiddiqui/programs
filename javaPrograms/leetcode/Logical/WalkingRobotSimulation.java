/**
   874. Walking Robot Simulation

   A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an
   array of integers commands, which represents a sequence of moves that it needs to execute.
   There are only three possible types of instructions the robot can receive:

   -2: Turn left 90 degrees.
   -1: Turn right 90 degrees.
   1 <= k <= 9: Move forward k units, one unit at a time.
   Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi).
   If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to
   the obstacle) and move onto the next command.

   Return the maximum squared Euclidean distance that the robot reaches at any point in its path
   (i.e. if the distance is 5, return 25).

   Note:

   There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it
   has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
   North means +Y direction.
   East means +X direction.
   South means -Y direction.
   West means -X direction.

   Example 1:
   Input: commands = [4,-1,3], obstacles = []
   Output: 25
   Explanation:
   The robot starts at (0, 0):
   Move north 4 units to (0, 4).
   Turn right.
   Move east 3 units to (3, 4).
   The furthest point the robot ever gets from the origin is (3, 4),
   which squared is 32 + 42 = 25 units away.

   Example 2:
   Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
   Output: 65
   Explanation:
   The robot starts at (0, 0):
   Move north 4 units to (0, 4).
   Turn right.
   Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
   Turn left.
   Move north 4 units to (1, 8).
   The furthest point the robot ever gets from the origin is (1, 8),
   which squared is 12 + 82 = 65 units away.

   Example 3:
   Input: commands = [6,-1,-1,6], obstacles = [[0,0]]
   Output: 36
   Explanation:
   The robot starts at (0, 0):
   Move north 6 units to (0, 6).
   Turn right.
   Turn right.
   Move south 5 units and get blocked by the obstacle at (0,0), robot is at (0, 1).
   The furthest point the robot ever gets from the origin is (0, 6),
   which squared is 62 = 36 units away.

   Constraints:
   1 <= commands.length <= 104
   commands[i] is either -2, -1, or an integer in the range [1, 9].
   0 <= obstacles.length <= 104
   -3 * 104 <= xi, yi <= 3 * 104
   The answer is guaranteed to be less than 231.
*/
import java.util.*;

class WalkingRobotSimulation {
    private static final class Coord {
        private int x, y;
        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private int getDistance() {
            return x * x + y * y;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Coord coord)) return false;
            return x == coord.x && y == coord.y;
        }
        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }
    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {1,0,-1,0};
    private static int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0, ans = 0;
        Set<Coord> set = new HashSet<>(obstacles.length, 1.0f);

        for (int[] arr : obstacles) set.add(new Coord(arr[0], arr[1]));

        Coord cur = new Coord(0, 0);

        for (int command : commands) {
            if      (command == -1) dir = dir == 3 ? 0 : dir + 1;
            else if (command == -2) dir = dir == 0 ? 3 : dir - 1;
            else {
                for (int i = 0; i < command; ++i) {
                    cur.x += dx[dir];
                    cur.y += dy[dir];
                    if (set.contains(cur)) {
                        cur.x -= dx[dir];
                        cur.y -= dy[dir];
                        break;
                    }
                }
            }
            ans = Math.max(ans, cur.getDistance());
        }
        return ans;
    }
    public static void main(String[] args) {
        Log.info(robotSim(new int[] {4,-1,3},      new int[][] {}));
        Log.info(robotSim(new int[] {4,-1,4,-2,4}, new int[][] {{2,4}}));
        Log.info(robotSim(new int[] {6,-1,-1,6},   new int[][] {{0,0}}));
    }
}
/**
    private static int robotSim(int[] commands, int[][] obstacles) {
        int a = 0, b = 0, ans = 0;
        String curDir = "+y";

        Map<String, String> right = new HashMap<>();
        right.put("+x", "-y");
        right.put("-y", "-x");
        right.put("-x", "+y");
        right.put("+y", "+x");

        Map<String, String> left = new HashMap<>();
        left.put("+x", "+y");
        left.put("+y", "-x");
        left.put("-x", "-y");
        left.put("-y", "+x");

        HashSet<String> obs = new HashSet<>();
        for (int[] arr : obstacles) obs.add(arr[0] + "," + arr[1]);

        for (int command : commands) {
            int cur = command;
            if (cur == -1) {
                curDir = right.get(curDir);
            } else if (cur == -2) {
                curDir = left.get(curDir);
            } else {
                if (curDir.equals("+x")) {
                    for (int i = 0; i < cur; ++i) {
                        if (obs.contains((a + 1) + "," + b)) break;
                        ++a;
                    }
                }
                if (curDir.equals("-x")) {
                    for (int i = 0; i < cur; ++i) {
                        if (obs.contains((a - 1) + "," + b)) break;
                        --a;
                    }
                }
                if (curDir.equals("+y")) {
                    for (int i = 0; i < cur; ++i) {
                        if (obs.contains(a + "," + (b + 1))) break;
                        ++b;
                    }
                }
                if (curDir.equals("-y")) {
                    for (int i = 0; i < cur; ++i) {
                        if (obs.contains(a + "," + (b - 1))) break;
                        --b;
                    }
                }
            }
            ans = Math.max(ans, ((a * a) + (b * b)));
        }
        return ans;
    }
*/
/***
          +y
           |
   -x------|-----+x
           |
           -y

two int a, b for recording max coordinates
iterate obstacles within commands
for commands:
    turning:
        should keep a record of which direction we are currently in
            for that we can store one string and change it w.t.h.o. hashmaps
        we know we go north first.
                so if we go +x,
                (+, 0)
                so if we go -x,
                (-, 0)
                so for x we can increase/decrease 'a'
                ------------------------------
                so if we go +y,
                (0, +)
                so if we go -y,
                (0, -)
                so for y we can increase/decrease 'b'
                -----------------------------
        -1: turn right
            record rakho: kiske right me kya hai
        -2: turn left
            record rakho: kiske left me kya hai
        1-9: increase a/b

*/
/**
right:
    +x -> -y
    -y -> -x
    -x -> +y
    +y -> +x

left:
    +x -> +y
    +y -> -x
    -x -> -y
    -y -> +x
*/
