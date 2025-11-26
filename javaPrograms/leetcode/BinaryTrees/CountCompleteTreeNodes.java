/**
   222. Count Complete Tree Nodes

   Given the root of a complete binary tree, return the number of the nodes
   in the tree.

   According to Wikipedia, every level, except possibly the last, is completely
   filled in a complete binary tree, and all nodes in the last level are as far
   left as possible. It can have between 1 and 2h nodes inclusive at the last
   level h.

   Design an algorithm that runs in less than O(n) time complexity.

   Example 1:
   Input: root = [1,2,3,4,5,6]
   Output: 6

   Example 2:
   Input: root = []
   Output: 0

   Example 3:
   Input: root = [1]
   Output: 1

   Constraints:
   The number of nodes in the tree is in the range [0, 5 * 104].
   0 <= Node.val <= 5 * 104
   The tree is guaranteed to be complete.
 */
class CountCompleteTreeNodes {
    private static int h(TreeNode node, boolean goLeft) {
        if(node == null) return 0;
        int cnt = 0;
        while(node != null) {
            cnt++;
            node = goLeft ? node.left : node.right;
        }
        return cnt;
    }  
    private static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = h(root, true);
        int rh = h(root, false);

        if(lh == rh) return (1 << lh) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[]args) {
        TreeNode root = new TreeNode(1,
                                     new TreeNode(2,
                                                  new TreeNode(4),
                                                  new TreeNode(5)),
                                     new TreeNode(3,
                                                  new TreeNode(6),
                                                  new TreeNode(7)));
        TreeNode root2 = new TreeNode(1,
                                     new TreeNode(2,
                                                  new TreeNode(4),
                                                  new TreeNode(5)),
                                     new TreeNode(3,
                                                  new TreeNode(6),
                                                  null));
        TreeNode root3 = null;

        TreeNode root4 = new TreeNode(1);
        
        IO.println(countNodes(root));
        IO.println(countNodes(root2));
        IO.println(countNodes(root3));
        IO.println(countNodes(root4));
    }
}
/**
   // works
   private static int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
 */
/**
    // works
    private static void preorder(TreeNode node, int[]arr) {
        if(node == null) return;
        arr[0]++;
        preorder(node.left, arr);
        preorder(node.right, arr);
    }
    private static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int[]arr = new int[1];
        preorder(root, arr);
        return arr[0];
    }

 */
