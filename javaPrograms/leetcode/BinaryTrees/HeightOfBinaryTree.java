/**
   104. Maximum Depth of Binary Tree

   Given the root of a binary tree, return its maximum depth.

   A binary tree's maximum depth is the number of nodes along
   the longest path from the root node down to the farthest leaf node.

   Example 1:
   Input: root = [3,9,20,null,null,15,7]
   Output: 3

   Example 2:
   Input: root = [1,null,2]
   Output: 2
   
   Constraints:
   The number of nodes in the tree is in the range [0, 104].
   -100 <= Node.val <= 100
 */
import java.util.*;
class HeightOfBinaryTree {
    public int maxDepth(Node root) {
        List<List<Integer>> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> sl = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i < s; ++i) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                sl.add(q.poll().data);
            }
            l.add(sl);
        }
        return l.size();
    }
}

void main() {
    Node root = new Node(3);
    root.left = new Node(9);
    root.right = new Node(20);

    root.right.left = new Node(15);
    root.right.right = new Node(7);

    Log log = new Log();
    HeightOfBinaryTree h = new HeightOfBinaryTree();
    log.info(h.maxDepth(root));
}
