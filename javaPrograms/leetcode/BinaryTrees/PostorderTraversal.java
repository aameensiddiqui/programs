class PostorderTraversal {
    public List<Integer> postorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    public void postorder(Node root, List<Integer> list) {
        if(root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.data);
    }
    /****************************/
    public List<Integer> iterativePostorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while(!st2.isEmpty()) {
            ans.add(st2.pop().data);
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
    PostorderTraversal pt = new PostorderTraversal();
    log.info(pt.postorderTraversal(root));
    log.info(pt.iterativePostorderTraversal(root));
}
