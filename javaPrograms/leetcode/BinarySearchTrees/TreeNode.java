import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {this.val = val;}
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void preorder(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    public static void printTree(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        preorder(node, list);
        Log.info(list);
    }
}
