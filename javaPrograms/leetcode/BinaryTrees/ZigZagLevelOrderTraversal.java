/**
   103. Binary Tree Zigzag Level Order Traversal

   Given the root of a binary tree, return the zigzag level order traversal of its
   nodes' values. (i.e., from left to right, then right to left for the next level
   and alternate between).

   Example 1:
   Input: root = [3,9,20,null,null,15,7]
   Output: [[3],[20,9],[15,7]]

   Example 2:
   Input: root = [1]
   Output: [[1]]

   Example 3:
   Input: root = []
   Output: []

   Constraints:
   The number of nodes in the tree is in the range [0, 2000].
   -100 <= Node.val <= 100
 */
import java.util.*;
class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int n = 0;
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i < s; ++i) {
                if(q.peek().left  != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                if(n % 2 == 0) list.add(q.poll().data);
                else list.add(0, q.poll().data);
            }
            ans.add(list);
            n++;   
        }
        return ans;
    }
}
void main() {
    Node root = new Node(3);
    root.left = new Node(9);
    root.right = new Node(20);
    root.right.left = new Node(15);
    root.right.right = new Node(7);

    
    ZigZagLevelOrderTraversal z = new ZigZagLevelOrderTraversal();
    IO.println(z.zigzagLevelOrder(root));
}
/**
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root == nullptr) return ans;
        queue<TreeNode*> q;
        q.push(root);
        bool ltor = true;
        while(!q.empty()) {
            int s = q.size();
            vector<int> list(s);
            for(int i = 0; i < s; ++i) {
                TreeNode* node = q.front();
                q.pop();
                int index = ltor ? i : (s-1-i);
                list[index] = node->val;
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            ans.push_back(list);
            ltor = !ltor;
        }
        return ans;
    }
};
 */
/**
public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean ltor = true;
        while(!q.isEmpty()) {
            Deque<Integer> dq = new LinkedList<>();
            int s = q.size();
            for(int i = 0; i < s; ++i) {
                Node node = q.poll();
                if(ltor) dq.addLast(node.data);
                else dq.addFirst(node.data);
                if(node.left  != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }            
            ltor = !ltor;
            ans.add(new ArrayList<>(dq));
        }
        return ans;
    }
 */
/**
   //XXXXXXX
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int n = 0;
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int s = q.size();
            if(n % 2 != 0) {
                for(int i = 0; i < s; ++i) {
                    if(q.peek().left  != null) q.offer(q.peek().left);
                    if(q.peek().right != null) q.offer(q.peek().right);
                    list.add(q.poll().data);
                }
                ans.add(list);
            } else {
                for(int i = 0; i < s; ++i) {
                    if(q.peek().right != null) q.offer(q.peek().right);
                    if(q.peek().left  != null) q.offer(q.peek().left);
                    list.add(q.poll().data);
                }
                ans.add(list);
            }
            n++;
        }
        return ans;
    }
 */
