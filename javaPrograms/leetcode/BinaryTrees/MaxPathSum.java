/**
   124. Binary Tree Maximum Path Sum

   A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
   in the sequence has an edge connecting them. A node can only appear in the sequence
   at most once. Note that the path does not need to pass through the root.
   The path sum of a path is the sum of the node's values in the path.
   Given the root of a binary tree, return the maximum path sum of any non-empty path.

   Example 1:
   Input: root = [1,2,3]
   Output: 6
   Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

   Example 2:
   Input: root = [-10,9,20,null,null,15,7]
   Output: 42
   Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

   Constraints:
   The number of nodes in the tree is in the range [1, 3 * 104].
   -1000 <= Node.val <= 1000
 */
class MaxPathSum {
    public static int maxPath(Node root, int[]maxi) {
        if(root == null) return 0;
        int lmax = Math.max(0, maxPath(root.left, maxi));
        int rmax = Math.max(0, maxPath(root.right, maxi));
        maxi[0] = Math.max(maxi[0], (lmax + rmax + root.data));
        return root.data + Math.max(lmax, rmax);
    }
    public static int maxPathSum(Node root) {
        if(root == null) return 0;
        int[]maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPath(root, maxi);
        return maxi[0];
    }
    public static void main(String[]args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        //[-10,9,20,null,null,15,7] ans:42
        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        //[1,2,3] ans:6

        Node root2 = new Node(-3);
        //[-3]    ans:-3
                        
        Node root3 = new Node(2);
        root3.left = new Node(-1);
        //[2,-1]  ans: 2

        IO.println(maxPathSum(root));
        IO.println(maxPathSum(root1));
        IO.println(maxPathSum(root2));
        IO.println(maxPathSum(root3));
    }
}
