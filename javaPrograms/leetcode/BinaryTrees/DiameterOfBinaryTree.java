/**
   543. Diameter of Binary Tree

   Given the root of a binary tree, return the length of the diameter of the tree.
   The diameter of a binary tree is the length of the longest path between any two
   nodes in a tree. This path may or may not pass through the root.
   The length of a path between two nodes is represented by the number of
   edges between them.

   Example 1:
   Input: root = [1,2,3,4,5]
   Output: 3
   Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

   Example 2:
   Input: root = [1,2]
   Output: 1

   Constraints:
   The number of nodes in the tree is in the range [1, 104].
   -100 <= Node.val <= 100
 */
import java.util.*;
class DiameterOfBinaryTree {
    public int findMaxH(Node root, int[]maxi) {
        if(root == null) return 0;
        int lh = findMaxH(root.left, maxi);
        int rh = findMaxH(root.right, maxi);
        maxi[0] = Math.max(maxi[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(Node root) {
        if(root == null) return 0;
        int[]maxi = new int[1];
        findMaxH(root, maxi);
        return maxi[0];
    }
}

void main() {
    // 1
    Node root = new Node(3);
    root.left = new Node(9);
    root.right = new Node(20);

    root.right.left = new Node(15);
    root.right.right = new Node(7);
    
    // 2
    Node root2 = new Node(1);
    root2.left = new Node(2);
    root2.right = new Node(3);

    root2.right.left = new Node(4);
    root2.right.left.left = new Node(5);
    root2.right.left.left.left = new Node(9);
    
    root2.right.right = new Node(6);
    root2.right.right.right = new Node(7);
    root2.right.right.right.right = new Node(8);

    Log log = new Log();
    DiameterOfBinaryTree d = new DiameterOfBinaryTree();
    log.info(d.diameterOfBinaryTree(root));
    log.info(d.diameterOfBinaryTree(root2));
}
/**
class DiameterOfBinaryTree {
    int max = Integer.MIN_VALUE;
    public int ht(Node root) {
        if(root == null) return 0;
        return Math.max(ht(root.left), ht(root.right))+1;
    }
    public int diameterOfBinaryTree(Node root) {
        if(root == null) return 0;
        int lh = ht(root.left);
        int rh = ht(root.right);
        max = Math.max(max, lh+rh);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
}
 */
