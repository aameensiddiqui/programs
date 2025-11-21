/**
   101. Symmetric Tree

   Given the root of a binary tree, check whether it is a mirror of itself
   (i.e., symmetric around its center).

   Example 1:
   Input: root = [1,2,2,3,4,4,3]
   Output: true

   Example 2:
   Input: root = [1,2,2,null,3,null,3]
   Output: false

   Constraints:
   The number of nodes in the tree is in the range [1, 1000].
   -100 <= Node.val <= 100
 */
class SymmetricTree {
    public boolean is(Node node1, Node node2) {
        if(node1 == null || node2 == null) return node1 == node2;
        return (node1.data == node2.data) &&
            is(node1.right, node2.left) &&
            is(node1.left, node2.right);
    }
    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        return is(root.left, root.right);
    }
}
void main() {
    // 1
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(3);
    root.left.right = new Node(4);
    root.right = new Node(2);
    root.right.left = new Node(4);
    root.right.right = new Node(3);

    // 2
    Node root2 = new Node(1);
    root2.left = new Node(2);
    root2.left.right = new Node(3);
    root2.right = new Node(2);
    root2.right.right = new Node(3);

    SymmetricTree s = new SymmetricTree();
    IO.println(s.isSymmetric(root));
    IO.println(s.isSymmetric(root2));
}
/**
   // iterative approach
   public boolean isSymmetric(Node root) {
        if(root == null) return true;
        Stack<Node> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()) {
            Node n1 = st.pop(), n2 = st.pop();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.data != n2.data) return false;
            st.push(n1.left); st.push(n2.right);
            st.push(n1.right); st.push(n2.left);
        }
        return true;
    }
 */
/**
   // my approach. not correct for trees like 2nd example
   public List<Integer> preorder(Node node) {
        List<Integer> list = new ArrayList<>();
        if(node == null) return list;
        list.add(node.data);
        preorder(node.left);
        preorder(node.right);
        return list;
    }
    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        List<Integer> l = preorder(root.left);
        List<Integer> r = preorder(root.right);
        return l.equals(r);
    }
 */
