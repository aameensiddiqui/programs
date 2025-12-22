/**
   99. Recover Binary Search Tree

   You are given the root of a binary search tree (BST), where the values of
   exactly two nodes of the tree were swapped by mistake. Recover the tree
   without changing its structure.

   Example 1:
   Input: root = [1,3,null,null,2]
   Output: [3,1,null,null,2]
   Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3
   makes the BST valid.

   Example 2:
   Input: root = [3,1,4,null,null,2]
   Output: [2,1,4,null,null,3]
   Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping
   2 and 3 makes the BST valid.

   Constraints:
   The number of nodes in the tree is in the range [2, 1000].
   -231 <= Node.val <= 231 - 1
*/
class RecoverBST {
    private static TreeNode prev;
    private static TreeNode first;
    private static TreeNode middle;
    private static TreeNode last;

    private static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        
        if (prev != null && (node.val < prev.val)) {
            if (first == null) {
                first = prev;
                middle = node;
            } else last = node;
        }
        prev = node;

        inorder(node.right);
    }
    private static void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    public static void main(String[]args) {
        TreeNode root = new TreeNode(1,
                                     new TreeNode(3,
                                                  null,
                                                  new TreeNode(2)),
                                     null);

        TreeNode root2 = new TreeNode(3,
                                      new TreeNode(1),
                                      new TreeNode(4,
                                                   new TreeNode(2),
                                                   null));
        Log.info("------------------------------before");
        TreeNode.printTree(root);
        recoverTree(root);
        Log.info("-------------------------------after");
        TreeNode.printTree(root);

        Log.info("====================================");

        Log.info("------------------------------before");
        TreeNode.printTree(root2);
        recoverTree(root2);
        Log.info("-------------------------------after");
        TreeNode.printTree(root2);
    }
}
/**
    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    private static void traversal(TreeNode node, List<Integer> list, int[]arr) {
        if (node == null) return;
        traversal(node.left, list, arr);
        if (node.val != list.get(arr[0])) node.val = list.get(arr[0]);
        arr[0]++;
        traversal(node.right, list, arr);
    }
    private static void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        int[]arr = new int[1];
        traversal(root, list, arr);
    }
*/
