/**
   653. Two Sum IV - Input is a BST

   Given the root of a binary search tree and an integer k, return true if
   there exist two elements in the BST such that their sum is equal to k,
   or false otherwise.

   Example 1:
   Input: root = [5,3,6,2,4,null,7], k = 9
   Output: true

   Example 2:
   Input: root = [5,3,6,2,4,null,7], k = 28
   Output: false

   Constraints:
   The number of nodes in the tree is in the range [1, 104].
   -104 <= Node.val <= 104
   root is guaranteed to be a valid binary search tree.
   -105 <= k <= 105
*/
import java.util.*;

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (!reverse) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse) node = node.right;
            else node = node.left;
        }
    }
}
class TwoSumInBST {
    private static boolean findTarget(TreeNode root, int k) {
        BSTIterator i = new BSTIterator(root, false);
        BSTIterator j = new BSTIterator(root, true);

        int l = i.next();
        int r = j.next();

        while (l < r) {
            int sum = l + r;
            if (sum < k) l = i.next();
            else if (sum > k) r = j.next();
            else return true;
        }
        return false;
    }

    public static void main(String[]args) {
        TreeNode root = new TreeNode(5,
                                     new TreeNode(3,
                                                  new TreeNode(2),
                                                  new TreeNode(4)),
                                     new TreeNode(6,
                                                  null,
                                                  new TreeNode(7)));
        IO.println(findTarget(root, 9));
        IO.println(findTarget(root, 28));
    }
}
/**
    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Log.info(list);
        int low = 0, high = list.size()-1;
        while (low < high) {
            int sum = list.get(low) + list.get(high);
            if (sum < k) low++;
            else if (sum > k) high--;
            else return true;
        }
        return false;
    }
*/
/**
    private static void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i+1; j < list.size(); ++j) {
                if (list.get(i) + list.get(j) == k) return true;
            }
        }
        return false;
    }
*/
/**
    private static void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();

        preorder(root, list);

        for (int i = 0; i < list.size(); ++i) {
            int sub = k - list.get(i);
            if (mpp.containsKey(sub)) return true;
            mpp.put(list.get(i), i);
        }
        return false;
    }
*/
