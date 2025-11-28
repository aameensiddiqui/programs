/**
   106. Construct Binary Tree from Inorder and Postorder Traversal

   Given two integer arrays inorder and postorder where inorder is the
   inorder traversal of a binary tree and postorder is the postorder
   traversal of the same tree, construct and return the binary tree.

   Example 1:
   Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
   Output: [3,9,20,null,null,15,7]

   Example 2:
   Input: inorder = [-1], postorder = [-1]
   Output: [-1]

   Constraints:
   1 <= inorder.length <= 3000
   postorder.length == inorder.length
   -3000 <= inorder[i], postorder[i] <= 3000
   inorder and postorder consist of unique values.
   Each value of postorder also appears in inorder.
   inorder is guaranteed to be the inorder traversal of the tree.
   postorder is guaranteed to be the postorder traversal of the tree.
 */
import java.util.*;
class ConstructABinaryTreeFromPostorderAndInorderTraversal {
    public static TreeNode buildTree(int[]postorder, int[]inorder) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) mpp.put(inorder[i], i);
        return buildTree(postorder, 0, postorder.length - 1,
                         inorder, 0, inorder.length - 1, mpp);
    }
    public static TreeNode buildTree(int[]postorder, int pstart, int pend,
                                     int[]inorder, int istart, int iend,
                                     Map<Integer, Integer> mpp) {
        if(pstart > pend || istart > iend) return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot - istart;

        root.left = buildTree(postorder, pstart, pstart + numsLeft - 1,
                              inorder, istart, inRoot - 1, mpp);
        root.right = buildTree(postorder, pstart + numsLeft, pend - 1,
                               inorder, inRoot + 1, iend, mpp);
        return root;
    }
    public static List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    public static void postorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        postorder(node.left, list);
        postorder(node.right, list);
    }
    public static void main(String[]args) {
        int[]postorder = {9, 15, 7, 20, 3};
        int[]inorder   = {9, 3, 15, 20, 7};
        TreeNode root  = buildTree(postorder, inorder);
        IO.println(postorder(root));
        int[]p = {-1};
        int[]i = {-1};
        root = buildTree(p, i);
        IO.println(postorder(root));
    }
}
