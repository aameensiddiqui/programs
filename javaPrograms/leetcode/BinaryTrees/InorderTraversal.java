class InorderTraversal {
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    public void inorder(Node root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    /*************************************/
    public List<Integer> iterativeInorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st = new Stack<>();
        while(true) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                if(st.isEmpty()) break;
                root = st.pop();
                ans.add(root.data);
                root = root.right;
            }
        }
        return ans;
    }
}

void main() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    
    root.left.left = new Node(4); 
    root.left.right = new Node(5);
    
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    Log log = new Log();
    InorderTraversal pt = new InorderTraversal();
    log.info(pt.inorderTraversal(root));
    log.info(pt.iterativeInorderTraversal(root));
}
