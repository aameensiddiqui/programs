/**
   98. Validate Binary Search Tree

   Given the root of a binary tree, determine if it is a valid binary search tree (BST).

   A valid BST is defined as follows:

   The left subtree of a node contains only nodes with keys strictly less than the node's key.
   The right subtree of a node contains only nodes with keys strictly greater than the node's key.
   Both the left and right subtrees must also be binary search trees.

   Example 1:
   Input: root = [2,1,3]
   Output: true

   Example 2:
   Input: root = [5,1,4,null,null,3,6]
   Output: false
   Explanation: The root node's value is 5 but its right child's value is 4.

   Constraints:
   The number of nodes in the tree is in the range [1, 104].
   -231 <= Node.val <= 231 - 1
*/
class IsBST {
    private static boolean recur(TreeNode node, long min, long max) {
        if(node == null) return true;
        if(min >= node.val || node.val >= max) return false;
        return recur(node.left, min, node.val)
            && recur(node.right, node.val, max);
    }
    public static boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static void main(String[]args) {
        // 1
        TreeNode root = new TreeNode(2,
                                     new TreeNode(1),
                                     new TreeNode(3));
        IO.println("expected: true  -> "+isValidBST(root));

        // 2
        TreeNode root2 = new TreeNode(5,
                                      new TreeNode(1),
                                      new TreeNode(4,
                                                   new TreeNode(3),
                                                   new TreeNode(6)));
        IO.println("expected: false -> "+isValidBST(root2));

        // 3
        TreeNode root3 = new TreeNode(0);
        IO.println("expected: true  -> "+isValidBST(root3));

        // 4
        TreeNode root4 = new TreeNode(2,
                                      new TreeNode(2),
                                      new TreeNode(2));
        IO.println("expected: false -> "+isValidBST(root4));

        // 5
        TreeNode root5 = new TreeNode(0,
                                      new TreeNode(-1),
                                      null);
        IO.println("expected: true  -> "+isValidBST(root5));

        // 6
        TreeNode root6 = new TreeNode(1,
                                      new TreeNode(1),
                                      null);
        IO.println("expected: false -> "+isValidBST(root6));

        // 7
        /*
          5
         / \
        4   6
           / \
   wrong((3)) 7

   3 is less than 5. X
         */
        TreeNode root7 = new TreeNode(5,
                                      new TreeNode(4),
                                      new TreeNode(6,
                                                   new TreeNode(3),
                                                   new TreeNode(7)));
        IO.println("expected: false -> "+isValidBST(root7));
    }
}
/**
   // 77 / 86 test cases passed but
   // here, i am not checking
   // if the current node.val is less than or greater than its ansestors
   // (in the left subtree,  node.val should not be greater than its ansestors)
   // (in the right subtree, node.val should not be less    than its ansestors)

    private static void recur(TreeNode node, int[]arr) {
        //Log.info("1--"+arr[0]+"--"+node.val);
        if(node == null || (node.right == null && node.left == null))
            return;
        else if(node.right == null && node.left != null) {
            //Log.info("2--"+arr[0]+"--"+node.val);
            if(node.left.val >= node.val) {
                arr[0] = 0; return;
            } else recur(node.left, arr);
        } else if(node.left == null && node.right != null) {
            //Log.info("3--"+arr[0]+"--"+node.val);
            if(node.right.val <= node.val) {
                arr[0] = 0; return;
            } else recur(node.right, arr);
        } else if(node.right.val <= node.val || node.left.val >= node.val) {
            arr[0] = 0;
            //Log.info("4--"+arr[0]+"--"+node.val);
            return;
        } else {
            arr[0] = 1;
            //Log.info("5--"+arr[0]+"--"+node.val);
            recur(node.left, arr);
            recur(node.right, arr);
        }
    }
    public static boolean isValidBST(TreeNode root) {
        int[]arr = new int[1];
        arr[0] = 1;
        recur(root, arr);
        return arr[0] == 1 ? true : false;
    }
*/
