/**
   110. Balanced Binary Tree

   Given a binary tree, determine if it is height-balanced.

   Example 1:
   Input: root = [3,9,20,null,null,15,7]
   Output: true

   Example 2:
   Input: root = [1,2,2,3,3,null,null,4,4]
   Output: false

   Example 3:
   Input: root = []
   Output: true

   Constraints:
   The number of nodes in the tree is in the range [0, 5000].
   -104 <= Node.val <= 104
*/
import java.util.*;
class BalancedBinaryTree {
    public int findH(Node root) {
        if(root == null) return 0;
        int l = findH(root.left);
        int r = findH(root.right);
        if(l == -1 && r == -1) return -1;
        if(Math.abs(l-r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
    public boolean isBalanced(Node root) {
        if(root == null) return true;
        return findH(root) != -1;
    }
}

void main() {
    // 1
    Node root = new Node(3);
    root.left = new Node(9);
    root.right = new Node(20);

    root.right.left = new Node(15);
    root.right.right = new Node(7);

    Log log = new Log();
    BalancedBinaryTree b = new BalancedBinaryTree();
    log.info(b.isBalanced(root));

    // 2
    Node root2 = new Node(1);
    root2.left = new Node(2);
    root2.right = new Node(2);

    root2.left.left = new Node(3);
    root2.left.right = new Node(3);
    
    root2.left.left.left = new Node(4);
    root2.left.left.right = new Node(4);

    log.info(b.isBalanced(root2));
}
/**
   public int findH(Node root) {
        if(root == null) return 0;
        return 1 + Math.max(findH(root.left), findH(root.right));
    }
    public boolean isBalanced(Node root) {
        if(root == null) return true;
        int l = findH(root.left);
        int r = findH(root.right);
        if(Math.abs(l-r) > 1) return false;
        boolean lt = isBalanced(root.left);
        boolean rt = isBalanced(root.right);
        if(!lt || !rt) return false;
        return true;
    }
 */
