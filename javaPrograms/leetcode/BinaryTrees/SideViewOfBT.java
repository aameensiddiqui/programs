/**
   199. Binary Tree Right Side View

   Given the root of a binary tree, imagine yourself standing on the right side of it,
   return the values of the nodes you can see ordered from top to bottom.

   Example 1:
   Input: root = [1,2,3,null,5,null,4]
   Output: [1,3,4]

   Example 2:
   Input: root = [1,2,3,4,null,null,null,5]
   Output: [1,3,4,5]

   Example 3:
   Input: root = [1,null,3]
   Output: [1,3]

   Example 4:
   Input: root = []
   Output: []

   Constraints:
   The number of nodes in the tree is in the range [0, 100].
   -100 <= Node.val <= 100
 */
class SideViewOfBT {
    // right side view
    public void recursiveRight(Node node, int line, List<Integer> list) {
        if(node == null) return;
        if(list.size() == line) list.add(node.data);
        recursiveRight(node.right, line+1, list);
        recursiveRight(node.left,  line+1, list);
    }
    public List<Integer> rightView(Node root) {
        List<Integer> list = new ArrayList<>();
        recursiveRight(root, 0, list);
        return list;
    }

    // left side view
    public void recursiveLeft(Node node, int line, List<Integer> list) {
        if(node == null) return;
        if(list.size() == line) list.add(node.data);
        recursiveRight(node.left,  line+1, list);
        recursiveRight(node.right, line+1, list);
    }
    public List<Integer> leftView(Node root) {
        List<Integer> list = new ArrayList<>();
        recursiveLeft(root, 0, list);
        return list;
    }
}
void main() {
    Node root = new Node(1);
    root.right = new Node(3);
    root.right.left = new Node(9);
    root.right.right = new Node(11);
    root.right.right.left = new Node(10);
    
    root.left = new Node(2); 
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.right.right = new Node(6);

    SideViewOfBT r = new SideViewOfBT();
    IO.println(r.rightView(root));
    IO.println(r.leftView(root));
}
