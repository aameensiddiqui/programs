/**
   1008. Construct Binary Search Tree from Preorder Traversal

   Given an array of integers preorder, which represents the preorder traversal
   of a BST (i.e., binary search tree), construct the tree and return its root.

   It is guaranteed that there is always possible to find a binary search tree
   with the given requirements for the given test cases.

   A binary search tree is a binary tree where for every node, any descendant of
   Node.left has a value strictly less than Node.val, and any descendant of
   Node.right has a value strictly greater than Node.val.

   A preorder traversal of a binary tree displays the value of the node first,
   then traverses Node.left, then traverses Node.right.

   Example 1:
   Input: preorder = [8,5,1,7,10,12]
   Output: [8,5,10,1,7,null,12]

   Example 2:
   Input: preorder = [1,3]
   Output: [1,null,3]

   Constraints:
   1 <= preorder.length <= 100
   1 <= preorder[i] <= 1000
   All the values of preorder are unique.
*/
class PreorderToBST {
    private static TreeNode build(int[]preorder, int upperBound, int[]i) {
        if(i[0] == preorder.length || preorder[i[0]] > upperBound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = build(preorder, root.val, i);
        root.right = build(preorder, upperBound, i);
        return root;
    }

    private static TreeNode bstFromPreorder(int[]preorder) {
        return build(preorder, Integer.MAX_VALUE, new int[1]);
    }

    public static void main(String[]args) {
        TreeNode.printTree(bstFromPreorder(new int[]{8,5,1,7,10,12}));
        TreeNode.printTree(bstFromPreorder(new int[]{1,3}));
        // TreeNode root = new TreeNode(8,
        //                              new TreeNode(5,
        //                                           new TreeNode(1),
        //                                           new TreeNode(7)),
        //                              new TreeNode(10,
        //                                           null,
        //                                           new TreeNode(12)));
        // TreeNode.printTree(root);
    }
}
/**
    private static TreeNode bstFromPreorder(int[]preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        TreeNode dummy = root;

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int i = 1;

        for(; i < preorder.length; ++i) {
            if(preorder[i] > preorder[0]) break;
            leftList.add(preorder[i]);
        }

        for(; i < preorder.length; ++i) {
            rightList.add(preorder[i]);
        }

        if(!leftList.isEmpty()) {
            root.left = bstFromPreorder(toArr(leftList));
        }

        if(!rightList.isEmpty()) {
            root.right = bstFromPreorder(toArr(rightList));
        }

        return dummy;
    }

    private static int[] toArr(List<Integer> list) {
        int[]arr = new int[list.size()];
        for(int i = 0; i < arr.length; ++i) arr[i] = list.get(i);
        return arr;
    }

 */
/**
    private static TreeNode bstFromPreorder(int[]preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        TreeNode dummy = root;

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int i = 1;

        for(; i < preorder.length; ++i) {
            if(preorder[i] > preorder[0]) break;
            leftList.add(preorder[i]);
        }

        for(; i < preorder.length; ++i) {
            rightList.add(preorder[i]);
        }

        if(!leftList.isEmpty()) {
            root.left = bstFromPreorder(leftList.stream().mapToInt(Integer::intValue).toArray());
        }

        if(!rightList.isEmpty()) {
            root.right = bstFromPreorder(rightList.stream().mapToInt(Integer::intValue).toArray());
        }

        return dummy;
    }
 */
