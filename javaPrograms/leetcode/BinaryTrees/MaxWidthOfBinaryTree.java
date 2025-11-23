/**
   662. Maximum Width of Binary Tree

   Given the root of a binary tree, return the maximum width of the given tree.

   The maximum width of a tree is the maximum width among all levels.

   The width of one level is defined as the length between the end-nodes
   (the leftmost and rightmost non-null nodes), where the null nodes between the
   end-nodes that would be present in a complete binary tree extending down to that
   level are also counted into the length calculation.

   It is guaranteed that the answer will in the range of a 32-bit signed integer.

   Example 1:
   Input: root = [1,3,2,5,3,null,9]
   Output: 4
   Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

   Example 2:
   Input: root = [1,3,2,5,null,null,9,6,null,7]
   Output: 7
   Explanation: The maximum width exists in the fourth level with length 7
   (6,null,null,null,null,null,7).

   Example 3:
   Input: root = [1,3,2,5]
   Output: 2
   Explanation: The maximum width exists in the second level with length 2 (3,2).

   Constraints:
   The number of nodes in the tree is in the range [1, 3000].
   -100 <= Node.val <= 100
*/
import java.util.*;
class Pair {
    int index;
    Node node;
    public Pair(int index, Node node) {
        this.index = index;
        this.node = node;
    }
}
class Pair2 {
    int index;
    TreeNode node;
    public Pair2(int index, TreeNode node) {
        this.index = index;
        this.node = node;
    }
}
class MaxWidthOfBinaryTree {
    public static int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));                 
        while(!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().index;
            int first = 0, last = 0;
            for(int i = 0; i < size; ++i) {
                int curIndex = q.peek().index - mmin;
                Node node = q.peek().node;
                q.poll();
                if(i == 0)      first = curIndex;
                if(i == size-1) last  = curIndex;
                if(node.left  != null) q.offer(new Pair((2 * curIndex + 1), node.left));
                if(node.right != null) q.offer(new Pair((2 * curIndex + 2), node.right));
            }
            width = Math.max(width, (last - first + 1));
        }
        return width;
    }
    public static int widthOfBinaryTreeForTreeNode(TreeNode root) {
        if(root == null) return 0;
        int width = 0;
        Queue<Pair2> q = new LinkedList<>();
        q.offer(new Pair2(0, root));                 
        while(!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().index;
            int first = 0, last = 0;
            for(int i = 0; i < size; ++i) {
                int curIndex = q.peek().index - mmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i == 0)      first = curIndex;
                if(i == size-1) last  = curIndex;
                if(node.left  != null) q.offer(new Pair2((2 * curIndex + 1), node.left));
                if(node.right != null) q.offer(new Pair2((2 * curIndex + 2), node.right));
            }
            width = Math.max(width, (last - first + 1));
        }
        return width;
    }
    public static void main(String[]args) {
        Node r = new Node(1);
        r.left = new Node(3);
        r.left.left = new Node(5);
        r.left.right = new Node(3);
        r.right = new Node(2);
        r.right.right = new Node(9);
        
        IO.println(widthOfBinaryTree(r));
                                       
        TreeNode r2 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                                   new TreeNode(2, null, new TreeNode(9))
                                   );
        IO.println(widthOfBinaryTreeForTreeNode(r2));
    }
}
