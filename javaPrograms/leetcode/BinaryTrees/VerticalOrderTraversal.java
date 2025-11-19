/**
   987. Vertical Order Traversal of a Binary Tree

   Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

   For each node at position (row, col), its left and right children will be at
   positions (row + 1, col - 1) and (row + 1, col + 1) respectively.
   The root of the tree is at (0, 0).

   The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each
   column index starting from the leftmost column and ending on the rightmost column.
   There may be multiple nodes in the same row and same column. In such a case, sort these nodes
   by their values.

   Return the vertical order traversal of the binary tree.

   Example 1:
   Input: root = [3,9,20,null,null,15,7]
   Output: [[9],[3,15],[20],[7]]
   Explanation:
   Column -1: Only node 9 is in this column.
   Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
   Column 1: Only node 20 is in this column.
   Column 2: Only node 7 is in this column.

   Example 2:
   Input: root = [1,2,3,4,5,6,7]
   Output: [[4],[2],[1,5,6],[3],[7]]
   Explanation:
   Column -2: Only node 4 is in this column.
   Column -1: Only node 2 is in this column.
   Column 0: Nodes 1, 5, and 6 are in this column.
   1 is at the top, so it comes first.
   5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
   Column 1: Only node 3 is in this column.
   Column 2: Only node 7 is in this column.

   Example 3:
   Input: root = [1,2,3,4,6,5,7]
   Output: [[4],[2],[1,5,6],[3],[7]]
   Explanation:
   This case is the exact same as example 2, but with nodes 5 and 6 swapped.
   Note that the solution remains the same since 5 and 6 are in the same location and should be
   ordered by their values.

   Constraints:
   The number of nodes in the tree is in the range [1, 1000].
   0 <= Node.val <= 1000
 */
import java.util.*;
class Tuple {
    Node node;
    int row;
    int col;
    public Tuple(Node node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class VerticalOrderTreversal {
    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tmap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            Node node = t.node;
            int x = t.row;
            int y = t.col;

            if(!tmap.containsKey(x)) tmap.put(x, new TreeMap<>());
            if(!tmap.get(x).containsKey(y)) tmap.get(x).put(y, new PriorityQueue<>());
            tmap.get(x).get(y).offer(node.data);
            if(node.left != null) q.offer(new Tuple(node.left, x-1, y+1));
            if(node.right != null) q.offer(new Tuple(node.right, x+1, y+1));
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> m : tmap.values()) {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> p : m.values()) {
                while(!p.isEmpty()) {
                    ans.get(ans.size()-1).add(p.poll());
                }
            }
        }
        return ans;
    }
}
void main() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    
    VerticalOrderTreversal v = new VerticalOrderTreversal();
    IO.println(v.verticalTraversal(root));
}
