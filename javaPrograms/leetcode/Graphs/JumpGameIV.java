/**
1345. Jump Game IV

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last
index of the array.

Example 2:
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.

Example 3:
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

Constraints:
1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108
*/
/**
Intuition

From any index i, you can jump to three types of positions:

i - 1
i + 1
Any index j where arr[j] == arr[i]
Each jump costs exactly 1 move.

So the problem becomes:

Find the minimum number of moves needed to reach index n - 1 from index 0.

This is a classic shortest path in an unweighted graph problem.

Each index is a node.
Each valid jump is an edge.
Every edge has weight 1.

Whenever all edges have equal weight, BFS is the optimal algorithm.

Why BFS?

BFS explores nodes level by level.

Level 0 → indices reachable in 0 jumps
Level 1 → indices reachable in 1 jump
Level 2 → indices reachable in 2 jumps
...

The first time BFS reaches the last index, it is guaranteed to be using the minimum number
of jumps.

Why DFS Fails

DFS goes as deep as possible before exploring alternatives.

It may follow a very long path first:

0 → 1 → 2 → 3 → 4 → 5 → ...

while a much shorter path exists:

0 → 4 → 9

DFS has no natural guarantee that the first solution found is optimal.

Why mp[arr[node]].clear() Is Critical

Suppose value 7 occurs at 10,000 indices.

Without clearing, every time one of those indices is visited, you iterate over all 10,000
positions again.

With clearing, that expensive scan happens only once.
*/
import java.util.*;

class JumpGameIV {
    private static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; ++i)
            mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});

        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];

            if (node == n - 1) return dist;

            if (node - 1 >= 0 && !visited[node - 1]) {
                visited[node + 1] = true;
                q.offer(new int[] {node - 1, dist + 1});
            }
            if (node + 1 <  n && !visited[node + 1]) {
                visited[node + 1] = true;
                q.offer(new int[] {node + 1, dist + 1});
            }
            for (int next : mp.get(arr[node])) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, dist + 1});
                }
            }
            mp.get(arr[node]).clear();
        }
        return -1;
    }
    public static void main(String[] args) {
        log.info(minJumps(new int[] {100,-23,-23,404,100,23,23,23,3,404}));
        log.info(minJumps(new int[] {7}));
        log.info(minJumps(new int[] {7,6,9,6,9,6,9,7}));
    }
}
