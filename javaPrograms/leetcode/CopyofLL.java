import java.util.HashMap;
class RNode {
    int val;
    RNode next;
    RNode random;

    RNode() {
        this.val = 0;
        this.next = null;
        this.random = null;
    }
    RNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    RNode(int val, RNode next, RNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
class CopyofLL {
    public static void insertNodeInBetween(RNode head) {
        RNode temp = head;
        while(temp != null) {
            RNode nextEle = temp.next;
            RNode copyNode = new RNode(temp.val);
            copyNode.next = nextEle;
            temp.next = copyNode;
            temp = nextEle;
        }
    }
    public static void connectRandomPointers(RNode head) {
        RNode temp = head;
        while(temp != null) {
            RNode copy = temp.next;
            if(temp.random != null)  copy.random = temp.random.next;
            else copy.random = null;
            temp = temp.next.next;
        }
    }
    public static RNode getDeepCopy(RNode head) {
        RNode dummy = new RNode(-1);
        RNode result = dummy;
        RNode temp = head;
        while(temp != null) {
            result.next = temp.next;
            result = result.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public static RNode cloneLL(RNode head) {
        insertNodeInBetween(head);
        connectRandomPointers(head);
        return getDeepCopy(head);
    }
    public static void main(String[]args) {
        RNode head = new RNode(7);
        head.next = new RNode(14);
        head.next.next = new RNode(21);
        head.next.next.next = new RNode(28);

        // assign random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        printLLR(head);
        RNode ans = cloneLL(head);
        printLLR(ans);
    }
    public static void printLLR(RNode head) {
        log.info("start****************");
        while (head != null) {
            System.out.print("Val: " + head.val);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.val);
            } else {
                System.out.print(", Random: nullptr");
            }
            System.out.println();
            // Move to the next node in the list
            head = head.next;
        }
        log.info("end****************");
    }
    private static final Log log = new Log();
    private static final PrintLL p = new PrintLL();
}
/**
    public static RNode cloneLL(RNode head) {
        RNode temp = head;
        HashMap<RNode, RNode> mpp = new HashMap<>();
        while(temp != null) {
            RNode newNode = new RNode(temp.val);
            mpp.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            RNode copyNode = mpp.get(temp);
            copyNode.next = mpp.get(temp.next);
            copyNode.random = mpp.get(temp.random);
            temp = temp.next;
        }
        return mpp.get(head);
    }

 */
/**
class Solution {  
   public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        //所有node都拷贝一个加到原本node的后面，形成 A->A’->B->B’
        while(node != null) {
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }
        node = head;
        //为每个copy node拷贝random指针
        while(node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        Node copy = node.next;
        Node resHead = copy;
        while(node != null) {
            node.next = copy.next;
            node = node.next;
            copy.next = node == null ? null : node.next;
            copy = copy.next;
        }
        return resHead;
    }
}
 */
/**
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        // connecting all random pointers
        temp = head;
        while(temp!=null){
            Node copyN = temp.next;
            if(temp.random != null) {
                copyN.random = temp.random.next;
            }else{
                copyN.random = null;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
 */
