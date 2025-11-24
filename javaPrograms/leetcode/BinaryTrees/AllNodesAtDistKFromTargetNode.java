/**
   863. All Nodes Distance K in Binary Tree

   Given the root of a binary tree, the value of a target node target, and an
   integer k, return an array of the values of all nodes that have a distance k
   from the target node.

   You can return the answer in any order.

   Example 1:
   Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
   Output: [7,4,1]
   Explanation: The nodes that are a distance 2 from the target node (with value 5)
   have values 7, 4, and 1.

   Example 2:
   Input: root = [1], target = 1, k = 3
   Output: []

   Constraints:
   The number of nodes in the tree is in the range [1, 500].
   0 <= Node.val <= 500
   All the values Node.val are unique.
   target is the value of one of the nodes in the tree.
   0 <= k <= 1000
 */
import java.util.*;

class Solution {
    private static void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentsMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.offer(node.left);
                parentsMap.put(node.left, node);
            }
            if(node.right != null) {
                q.offer(node.right);
                parentsMap.put(node.right, node);
            }
        }
    }
    private static List<Integer> bfsFromTarget(TreeNode target, int k, Map<TreeNode, TreeNode> parentsMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currentLevel = 0;
        
        while(!q.isEmpty()) {
            if(currentLevel++ == k) break;
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                TreeNode node = q.poll();

                //left
                if(node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }
                //right
                if(node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }
                //parent
                if(parentsMap.containsKey(node) && !visited.contains(parentsMap.get(node))) {
                    visited.add(parentsMap.get(node));
                    q.offer(parentsMap.get(node));
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {list.add(q.poll().val);}
        return list;
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        mapParents(root, parentsMap);
        return bfsFromTarget(target, k, parentsMap);
    }
}

class AllNodesAtDistKFromTargetNode {
    public static void main(String[]args) {
        TreeNode root = new TreeNode(3,
                                     new TreeNode(5,
                                                  new TreeNode(6),
                                                  new TreeNode(2,
                                                               new TreeNode(7),
                                                               new TreeNode(4))),
                                     new TreeNode(1,
                                                  new TreeNode(0),
                                                  new TreeNode(8)));

        TreeNode root2 = new TreeNode(1);

        Log log = new Log();
        Solution s = new Solution();
        
        log.info(s.distanceK(root, root.left, 2)); // [7, 4, 1]
        log.info(s.distanceK(root2, root2, 3));    // []
    }
}
