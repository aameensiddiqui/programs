import java.util.*;
class Pair {
    Node key;
    int value;
    public Pair(Node key, int value) {
        this.key = key;
        this.value = value;
    }
    private Node getKey() {return key;}
    private int getValue() {return value;}
    private void setKey(Node key) {this.key = key;}
    private void setValue(int value) {this.value = value;}
}
class TopViewOfBT {
    public List<Integer> topView(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.getKey();
            int  line = p.getValue();

            if(!mpp.containsKey(line)) mpp.put(line, node.data);
            if(node.left  != null) q.offer(new Pair(node.left,  line-1));
            if(node.right != null) q.offer(new Pair(node.right, line+1));
        }
        for(int n : mpp.values()) list.add(n);
        return list;
    }
}
void main() {
    Node root = new Node(1);
    
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(10);

    root.right.left = new Node(9);
    root.right.right = new Node(11);

    root.left.left.right = new Node(5);

    root.left.left.right.right = new Node(6);

    Log log = new Log();
    TopViewOfBT t = new TopViewOfBT();
    log.info(t.topView(root));
}
/**
   // Naive solution. It does not consider the trees where nodes "stick out"
   // beyond left and right chains
    public List<Integer> topView(Node root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.data);
        Node temp = root;
        while(temp.left != null) {
            temp = temp.left;
            list.add(temp.data);
        }
        Collections.reverse(list);
        temp = root;
        while(temp.right != null) {
            temp = temp.right;
            list.add(temp.data);
        }
        return list;
    }

 */
