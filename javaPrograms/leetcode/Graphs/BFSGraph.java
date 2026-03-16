/**
   BFS of graph
   Given a connected undirected graph containing V vertices, represented by a 2-d adjacency
   list adj[][], where each adj[i] represents the list of vertices connected to vertex i.
   Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices
   from left to right according to the given adjacency list, and return a list containing the
   BFS traversal of the graph.

   Note: Do traverse in the same order as they are in the given adjacency list.

   Examples:

   Example 1:
   Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
   Output: [0, 2, 3, 1, 4]
   Explanation: Starting from 0, the BFS traversal will follow these steps:
   Visit 0 -> Output: 0
   Visit 2 (first neighbor of 0) -> Output: 0, 2
   Visit 3 (next neighbor of 0) -> Output: 0, 2, 3
   Visit 1 (next neighbor of 0) -> Output: 0, 2, 3, 1
   Visit 4 (neighbor of 2) -> Final Output: 0, 2, 3, 1, 4

   Example 2:
   Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
   Output: [0, 1, 2, 3, 4]
   Explanation: Starting from 0, the BFS traversal proceeds as follows:
   Visit 0 -> Output: 0
   Visit 1 (the first neighbor of 0) -> Output: 0, 1
   Visit 2 (the next neighbor of 0) -> Output: 0, 1, 2
   Visit 3 (the first neighbor of 2 that hasn't been visited yet) -> Output: 0, 1, 2, 3
   Visit 4 (the next neighbor of 2) -> Final Output: 0, 1, 2, 3, 4

   Constraints:
   1 <= V = adj.size() <= 104
   0 <= adj[i][j] <= 104
*/
import java.util.*;

class BFSGraph {
    private static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            ans.add(node);
            for (Integer i : adj.get(node)) {
                if (vis[i] == false) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return ans;
    }
    public static void main(String[]args) {
x        // 1
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList(Arrays.asList(0)));
        adj.add(new ArrayList(Arrays.asList(0, 4)));
        adj.add(new ArrayList(Arrays.asList(0)));
        adj.add(new ArrayList(Arrays.asList(2)));
        log.info(bfsOfGraph(adj));

        // 2
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList(Arrays.asList(1, 2)));
        adj2.add(new ArrayList(Arrays.asList(0, 2)));
        adj2.add(new ArrayList(Arrays.asList(0, 1, 3, 4)));
        adj2.add(new ArrayList(Arrays.asList(2)));
        adj2.add(new ArrayList(Arrays.asList(2)));
        log.info(bfsOfGraph(adj2));
    }
}
