/**
   3558. Number of Ways to Assign Edge Weights I

   There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1.
   The tree is represented by a 2D integer array edges of length n - 1,
   where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.
   Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.
   The cost of a path between any two nodes u and v is the total weight of all edges in the path
   connecting them.
   Select any one node x at the maximum depth. Return the number of ways to assign edge weights in
   the path from node 1 to x such that its total cost is odd.
   Since the answer may be large, return it modulo 109 + 7.
   Note: Ignore all edges not in the path from node 1 to x.

   Example 1:
   Input: edges = [[1,2]]
   Output: 1
   Explanation:
   The path from Node 1 to Node 2 consists of one edge (1 -> 2).
   Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments
   is 1.

   Example 2:
   Input: edges = [[1,2],[1,3],[3,4],[3,5]]
   Output: 2

   Explanation:
   The maximum depth is 2, with nodes 4 and 5 at the same depth. Either node can be selected for
   processing.
   For example, the path from Node 1 to Node 4 consists of two edges (1 -> 3 and 3 -> 4).
   Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.

   Constraints:
   2 <= n <= 105
   edges.length == n - 1
   edges[i] == [ui, vi]
   1 <= ui, vi <= n
   edges represents a valid tree.
*/
import java.util.*;

class NumberOfWaysToAssignEdgeWeightsI {
    // we only need to find maxDepth(d edges).
    // so that we can find the possible assignents from 2^d.
    private static final int MOD = 1_000_000_007;
    private static long power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) // if b is odd
                ans = (ans * a) % MOD;
            // do -> a^1, a^2, a^4, a^8, .....until a^b
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }
    private static int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1, maxDepth = 0;
        List<List<Integer>> adj = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; ++i) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        q.offer(new int[] {1, 0}); // [node, depth]
        visited[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];
            maxDepth = Math.max(maxDepth, depth);
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(new int[] {neighbour, depth + 1});
                }
            }
        }
        return (int) power(2, maxDepth - 1);
    }
    public static void main(String[] args) {
        Log.info(assignEdgeWeights(new int[][] {{1,2}}));
        Log.info(assignEdgeWeights(new int[][] {{1,2},{1,3},{3,4},{3,5}}));
    }
}
