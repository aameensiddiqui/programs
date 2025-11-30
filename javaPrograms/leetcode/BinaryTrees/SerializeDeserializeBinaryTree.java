/**
   297. Serialize and Deserialize Binary Tree

   Serialization is the process of converting a data structure or object into
   a sequence of bits so that it can be stored in a file or memory buffer, or
   transmitted across a network connection link to be reconstructed later in
   the same or another computer environment.

   Design an algorithm to serialize and deserialize a binary tree. There is no
   restriction on how your serialization/deserialization algorithm should work.
   You just need to ensure that a binary tree can be serialized to a string and
   this string can be deserialized to the original tree structure.

   Clarification: The input/output format is the same as how LeetCode serializes
   a binary tree. You do not necessarily need to follow this format, so please
   be creative and come up with different approaches yourself.

   Example 1:
   Input: root = [1,2,3,null,null,4,5]
   Output: [1,2,3,null,null,4,5]

   Example 2:
   Input: root = []
   Output: []

   Constraints:
   The number of nodes in the tree is in the range [0, 104].
   -1000 <= Node.val <= 1000
*/
import java.lang.StringBuilder;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                TreeNode currNode = q.poll();
                if(currNode == null) {
                    ans.append("null,");
                    continue;
                }
                ans.append(currNode.val + ",");
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }
        ans.deleteCharAt(ans.length()-1);
        ans.append("]");
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("[]") || data.length() <= 2) return null;
        data = data.substring(1, data.length()-1);
        String[]s = data.split(",");
        // Log.info((Object)s);

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1; i < s.length; ++i) {
            TreeNode parent = q.poll();
            if(!s[i].equals("null")) {
                TreeNode l = new TreeNode(Integer.parseInt(s[i]));
                parent.left = l;
                q.offer(l);
            }
            if(!s[++i].equals("null")) {
                TreeNode r = new TreeNode(Integer.parseInt(s[i]));
                parent.right = r;
                q.offer(r);
            }
        }
        return root;
    }
}

class SerializeDeserializeBinaryTree {
    public static void main(String[]args) {
        // 1
        TreeNode root = new TreeNode(1,
                                     new TreeNode(2),
                                     new TreeNode(3,
                                                  new TreeNode(4),
                                                  new TreeNode(5)
                                                  )
                                     );
        Codec c = new Codec();
        IO.println(c.serialize(root));
        TreeNode r = c.deserialize("[1,2,3,null,null,4,5]");
        IO.println(c.serialize(r));

        // 2
        TreeNode root2 = null;
        IO.println(c.serialize(root2));
        TreeNode r2 = c.deserialize("[]");
        IO.println(c.serialize(r2));

        // 3
        TreeNode root3 = new TreeNode(1,
                                      new TreeNode(2,
                                                   new TreeNode(4),
                                                   new TreeNode(5)
                                                   ),
                                      new TreeNode(3,
                                                   new TreeNode(6),
                                                   new TreeNode(7)
                                                   )
                                      );
        IO.println(c.serialize(root3));
        TreeNode r3 = c.deserialize("[1,2,3,4,5,6,7]");
        IO.println(c.serialize(r3));
    }
}
