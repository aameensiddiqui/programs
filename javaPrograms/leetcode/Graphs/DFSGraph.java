/**
   DFS of Graph

   Given a connected undirected graph containing V vertices represented by a 2-d adjacency
   list adj[][], where each adj[i] represents the list of vertices connected to vertex i.
   Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices
   from left to right as per the given adjacency list, and return a list containing the DFS
   traversal of the graph.

   Note: Do traverse in the same order as they are in the given adjacency list.

   Examples:

   Example 1:
   Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
   Output: [0, 2, 4, 3, 1]
   Explanation: Starting from 0, the DFS traversal proceeds as follows:
   Visit 0 -> Output: 0
   Visit 2 (the first neighbor of 0) -> Output: 0, 2
   Visit 4 (the first neighbor of 2) -> Output: 0, 2, 4
   Backtrack to 2, then backtrack to 0, and visit 3 -> Output: 0, 2, 4, 3
   Finally, backtrack to 0 and visit 1 -> Final Output: 0, 2, 4, 3, 1

   Example 2:
   Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
   Output: [0, 1, 2, 3, 4]
   Explanation: Starting from 0, the DFS traversal proceeds as follows:
   Visit 0 -> Output: 0
   Visit 1 (the first neighbor of 0) -> Output: 0, 1
   Visit 2 (the first neighbor of 1) -> Output: 0, 1, 2
   Visit 3 (the first neighbor of 2) -> Output: 0, 1, 2, 3
   Backtrack to 2 and visit 4 -> Final Output: 0, 1, 2, 3, 4

   Constraints:
   1 <= V = adj.size() <= 104
   0 <= adj[i][j] <= 104
*/
import java.util.*;

class DFSGraph {
    private static void dfs(int node, boolean[] vis,
                            ArrayList<ArrayList<Integer>> adj,
                            ArrayList<Integer> list) {
        vis[node] = true;
        list.add(node);
        for (int i : adj.get(node)) {
            if (vis[i] == false) dfs(i, vis, adj, list);
        }
    }
    private static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        dfs(0, vis, adj, list);
        return list;
    }
    public static void main(String[]args) {
        // 1
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList(Arrays.asList(0)));
        adj.add(new ArrayList(Arrays.asList(0, 4)));
        adj.add(new ArrayList(Arrays.asList(0)));
        adj.add(new ArrayList(Arrays.asList(2)));
        log.info(dfsOfGraph(adj));

        // 2
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList(Arrays.asList(1, 2)));
        adj2.add(new ArrayList(Arrays.asList(0, 2)));
        adj2.add(new ArrayList(Arrays.asList(0, 1, 3, 4)));
        adj2.add(new ArrayList(Arrays.asList(2)));
        adj2.add(new ArrayList(Arrays.asList(2)));
        log.info(dfsOfGraph(adj2));
    }
}
