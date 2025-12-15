/**
   230. Kth Smallest Element in a BST

   Given the root of a binary search tree, and an integer k, return the
   kth smallest value (1-indexed) of all the values of the nodes in the tree.

   Example 1:
   Input: root = [3,1,4,null,2], k = 1
   Output: 1

   Example 2:
   Input: root = [5,3,6,2,4,null,null,1], k = 3
   Output: 3

   Constraints:
   The number of nodes in the tree is n.
   1 <= k <= n <= 104
   0 <= Node.val <= 104
 */
class KthSmallestElementInBST {
    private static int kth = 0;
    private static int cur = 0;
    
    public static void inorder(TreeNode node, int k) {
        if(node == null) return;
        inorder(node.left, k);
        cur++;
        if(cur == k) {kth = node.val; return;}
        inorder(node.right, k);
    }
    public static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kth;
    }
    public static void main(String[]args) {
        // 1
        TreeNode root = new TreeNode(3,
                                     new TreeNode(1,
                                                  null,
                                                  new TreeNode(2)),
                                     new TreeNode(4));
        IO.println(kthSmallest(root, 1)); // expected ans: 1

        // 2
        TreeNode root2 = new TreeNode(5,
                                      new TreeNode(3,
                                                   new TreeNode(2,
                                                                new TreeNode(1),
                                                                null),
                                                   new TreeNode(4)),
                                      new TreeNode(6));
        // kth = -1; cur = 1; // resetting
        kth = 0; cur = 0; // resetting
        IO.println(kthSmallest(root2, 3)); // expected ans: 3
    }
}
/**
    private static int kth = -1;
    private static int cur = 1;
    
    public static void inorder(TreeNode node, int k) {
        if(node == null) return;
        inorder(node.left, k);
        if(cur == k) kth = node.val;
        cur++;
        inorder(node.right, k);
    }
    public static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kth;
    }

 */
/**
   public static void inorder(TreeNode node, int[]arr, int k) {
        if(node == null) return;
        inorder(node.left, arr, k);
        arr[1]++;
        if(arr[1] == k) {
            arr[0] = node.val;
            return;
        }
        inorder(node.right, arr, k);
    }
    public static int kthSmallest(TreeNode root, int k) {
        int[]arr = new int[2];
        inorder(root, arr, k);
        return arr[0];
    }
*/
/**
    public static void preorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        Collections.sort(list);
        // Log.info(list);
        return list.get(k-1);
    }
*/
