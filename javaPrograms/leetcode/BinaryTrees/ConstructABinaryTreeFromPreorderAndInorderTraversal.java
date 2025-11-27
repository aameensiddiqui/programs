/**
   105. Construct Binary Tree from Preorder and Inorder Traversal

   Given two integer arrays preorder and inorder where preorder is
   the preorder traversal of a binary tree and inorder is the inorder
   traversal of the same tree, construct and return the binary tree.

   Example 1:
   Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
   Output: [3,9,20,null,null,15,7]

   Example 2:
   Input: preorder = [-1], inorder = [-1]
   Output: [-1]

   Constraints:
   1 <= preorder.length <= 3000
   inorder.length == preorder.length
   -3000 <= preorder[i], inorder[i] <= 3000
   preorder and inorder consist of unique values.
   Each value of inorder also appears in preorder.
   preorder is guaranteed to be the preorder traversal of the tree.
   inorder is guaranteed to be the inorder traversal of the tree.
*/
import java.util.*;
class ConstructABinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[]preorder, int[]inorder) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) mpp.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1, mpp);
    }
    public static TreeNode buildTree(int[]preorder, int pstart, int pend,
                                     int[]inorder, int istart, int iend,
                                     Map<Integer, Integer> mpp) {
        if(pstart > pend || istart > iend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot - istart;

        root.left = buildTree(preorder, pstart + 1, pstart + numsLeft,
                              inorder, istart, inRoot - 1, mpp);
        root.right = buildTree(preorder, pstart + numsLeft + 1, pend,
                               inorder, inRoot + 1, iend, mpp);
        return root;
    }
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public static void preorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    public static void main(String[]args) {
        int[]preorder = {3, 9, 20, 15, 7};
        int[]inorder  = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        IO.println(preorder(root));
        int[]p = {-1};
        int[]i = {-1};
        root = buildTree(p, i);
        IO.println(preorder(root));
    }
}
