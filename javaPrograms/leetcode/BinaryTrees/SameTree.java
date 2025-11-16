import java.util.*;
class SameTree {
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return ((p.data == q.data)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }
}
void main() {
    // 1
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);

    Node root2 = new Node(1);
    root2.left = new Node(2);
    root2.right = new Node(3);

    // 2
    Node root3 = new Node(1);
    root3.left = new Node(2);

    Node root4 = new Node(1);
    root4.right = new Node(2);

    SameTree st = new SameTree();
    IO.println(st.isSameTree(root1, root2));
    IO.println(st.isSameTree(root3, root4));
}
/**
   public void preorder(Node root, List<Integer> list) {
        if(root == null) {
            list.add(null);
            return;
        }
        list.add(root.data);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    public boolean isSameTree(Node p, Node q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preorder(p, list1);
        preorder(q, list2);
        return list1.equals(list2);
    }
 */
