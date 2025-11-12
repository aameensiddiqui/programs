/**
   102. Binary Tree Level Order Traversal

   Given the root of a binary tree, return the level order traversal of its
   nodes' values. (i.e., from left to right, level by level).

   Example 1:
   Input: root = [3,9,20,null,null,15,7]
   Output: [[3],[9,20],[15,7]]

   Example 2:
   Input: root = [1]
   Output: [[1]]

   Example 3:
   Input: root = []
   Output: []

   Constraints:
   The number of nodes in the tree is in the range [0, 2000].
   -1000 <= Node.val <= 1000
 */
import java.util.*;

List<List<Integer>> leverOrder(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if(root == null) return ans;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
        int size = q.size();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; ++i) {
            if(q.peek().left  != null) q.offer(q.peek().left);
            if(q.peek().right != null) q.offer(q.peek().right);
            list.add(q.poll().data);
        }
        ans.add(list);
    }
    return ans;
}
void main() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    
    root.left.left = new Node(4); 
    root.left.right = new Node(5);
    
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    
    root.right.right.left = new Node(10);
    root.right.right.right = new Node(11);

    Log log = new Log();
    log.info(leverOrder(root));
}
