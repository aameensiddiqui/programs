/**
   144. Binary Tree Preorder Traversal

   Given the root of a binary tree, return the preorder traversal
   of its nodes' values.

   Example 1:
   Input: root = [1,null,2,3]
   Output: [1,2,3]
   Explanation:

   Example 2:
   Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
   Output: [1,2,4,5,6,7,3,8,9]
   Explanation:

   Example 3:
   Input: root = []
   Output: []

   Example 4:
   Input: root = [1]
   Output: [1]

   Constraints:
   The number of nodes in the tree is in the range [0, 100].
   -100 <= Node.val <= 100 
 */
void main() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4); 
    root.left.right = new Node(5);
    root.left.right.left = new Node(6);

    root.right = new Node(3);
    root.right.left = new Node(7);
    root.right.right = new Node(8);
    root.right.right.left = new Node(9);
    root.right.right.right = new Node(10);

    printPreOrder(root);
    System.out.println();
}

void printPreOrder(Node move) {
    if(move != null) {
        System.out.print(move.data+" ");
        printPreOrder(move.left);
        printPreOrder(move.right);
    }
}
/**
   public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public void preorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
 */
