/**
   236. Lowest Common Ancestor of a Binary Tree

   Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

   According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
   between two nodes p and q as the lowest node in T that has both p and q as descendants
   (where we allow a node to be a descendant of itself).”

   Example 1:
   Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   Output: 3
   Explanation: The LCA of nodes 5 and 1 is 3.

   Example 2:
   Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   Output: 5
   Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
   according to the LCA definition.

   Example 3:
   Input: root = [1,2], p = 1, q = 2
   Output: 1

   Constraints:
   The number of nodes in the tree is in the range [2, 105].
   -109 <= Node.val <= 109
   All Node.val are unique.
   p != q
   p and q will exist in the tree.
 */
class LowestCommonAncestorOfBT {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q) return root;
        Node l = lowestCommonAncestor(root.left, p, q);
        Node r = lowestCommonAncestor(root.right, p, q);
        if(l == null) return r;
        else if(r == null) return l;
        else return root;
    }
    public static void main(String[]args) {
        //1
        Node root = new Node(3);
        root.left = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        IO.println(lowestCommonAncestor(root, root.left, root.right).data);

        //2
        IO.println(lowestCommonAncestor(root, root.left, root.left.right.right).data);
        
        //3
        Node root2 = new Node(1);
        root2.left = new Node(2);
        
        IO.println(lowestCommonAncestor(root2, root2, root.left).data);
        
        //4
        Node root3 = new Node(1);
        root3.left = new Node(2);
        root3.left.left = new Node(4);
        root3.left.right = new Node(5);
        root3.right = new Node(3);
        root3.right.left = new Node(6);
        root3.right.right = new Node(7);
        
        IO.println(lowestCommonAncestor(root3, root3.left.left, root3.left.right).data);
    }
}
