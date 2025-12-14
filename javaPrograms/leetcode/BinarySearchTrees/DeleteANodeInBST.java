/**
   450. Delete Node in a BST

   Given a root node reference of a BST and a key, delete the node with the given key
   in the BST. Return the root node reference (possibly updated) of the BST.

   Basically, the deletion can be divided into two stages:

   Search for a node to remove.
   If the node is found, delete the node.

   Example 1:
   Input: root = [5,3,6,2,4,null,7], key = 3
   Output: [5,4,6,2,null,null,7]
   Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
   One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
   Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

   Example 2:
   Input: root = [5,3,6,2,4,null,7], key = 0
   Output: [5,3,6,2,4,null,7]
   Explanation: The tree does not contain a node with value = 0.

   Example 3:
   Input: root = [], key = 0
   Output: []

   Constraints:
   The number of nodes in the tree is in the range [0, 104].
   -105 <= Node.val <= 105
   Each node has a unique value.
   root is a valid binary search tree.
   -105 <= key <= 105
*/
class DeleteANodeInBST {
    
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);
        TreeNode dummy = root;
        while(root != null) {
            if(root.val > key) {
                if(root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else root = root.left;
            } else {
                if(root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else root = root.right;
            }
        }
        return dummy;
    }
    
    public static TreeNode helper(TreeNode root) {
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        TreeNode rightChild = root.right;
        TreeNode lastRight  = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }
    
    public static TreeNode findLastRight(TreeNode root) {
        if(root.right == null) return root;
        return findLastRight(root.right);
    }
    
    public static void main(String[]args) {
        // 1
        TreeNode root = new TreeNode(9,
                                     new TreeNode(8,
                                                  new TreeNode(5,
                                                               new TreeNode(3,
                                                                            new TreeNode(2,
                                                                                         new TreeNode(1),
                                                                                         null),
                                                                            new TreeNode(4)),
                                                               new TreeNode(7,
                                                                            new TreeNode(6),
                                                                            new TreeNode(8))),
                                                  null),
                                     new TreeNode(12,
                                                  new TreeNode(10,
                                                               null,
                                                               new TreeNode(11)),
                                                  new TreeNode(13)));
        TreeNode.printTree(root);
        deleteNode(root, 5);
        TreeNode.printTree(root);

        // 2
        TreeNode root2 = new TreeNode(5,
                                      new TreeNode(3,
                                                   new TreeNode(2),
                                                   new TreeNode(4)),
                                      new TreeNode(6,
                                                   null,
                                                   new TreeNode(7)));
        TreeNode.printTree(root2);
        deleteNode(root2, 3);
        TreeNode.printTree(root2);

        // 3
        TreeNode root3 = new TreeNode(5,
                                      new TreeNode(2,
                                                   null,
                                                   new TreeNode(4)),
                                      new TreeNode(6,
                                                   null,
                                                   new TreeNode(7)));
        TreeNode.printTree(root3);
        deleteNode(root3, 0);
        TreeNode.printTree(root3);
    }
}
