/**
   114. Flatten Binary Tree to Linked List

   Given the root of a binary tree, flatten the tree into a "linked list":

   The "linked list" should use the same TreeNode class where the right
   child pointer points to the next node in the list and the left child
   pointer is always null. The "linked list" should be in the same order
   as a pre-order traversal of the binary tree.

   Example 1:
   Input: root = [1,2,5,3,4,null,6]
   Output: [1,null,2,null,3,null,4,null,5,null,6]

   Example 2:
   Input: root = []
   Output: []

   Example 3:
   Input: root = [0]
   Output: [0]

   Constraints:
   The number of nodes in the tree is in the range [0, 2000].
   -100 <= Node.val <= 100
*/
import java.util.*;

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

class FlattenBinaryTreeToLinkedList {
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                TreeNode currNode = q.poll();
                if(currNode == null) {
                    ans.append("null,");
                    continue;
                }
                ans.append(currNode.val + ",");
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }
        ans.deleteCharAt(ans.length()-1);
        ans.append("]");
        return ans.toString();
    }
    public static void main(String[]args) {
        TreeNode root = new TreeNode(1,
                                     new TreeNode(2,
                                                  new TreeNode(3),
                                                  new TreeNode(4)),
                                     new TreeNode(5,
                                                  null,
                                                  new TreeNode(6)
                                                  )
                                     );
        Solution s = new Solution();
        IO.println("before: "+serialize(root));
        s.flatten(root);
        IO.println("after:  "+serialize(root));
    }
}
/**
 // Create an ArrayList of preorder traversal.
 // Make root.left = null because the flattened tree must use only right pointers.
 // Rewrite the tree by adding new TreeNodes to the right with the help of preorder array list.
 // Ensure all nodes' left pointers are null.
 // So the tree becomes right-skewed linked list following preorder.

 // TC: O(2n)
 // SC: O(n)
 //
    public void preorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        // Log.info(list);

        // NOTE: this rebuilds the tree using new nodes
        // (not the optimal in--place solution)

        TreeNode node = root;
        root.val = list.get(0);
        root.right = node;
        root.left = null;

        for(int i = 1; i < list.size(); ++i) {
            TreeNode newNode = new TreeNode(list.get(i));
            node.right = newNode;
            node.left = null;
            node = newNode;
        }
    }
*/
