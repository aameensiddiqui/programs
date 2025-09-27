import java.util.*;
class RemoveDuplicatesFromSortedLL {
    public static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        while(temp != null && temp.next != null) {
            if(temp.data == temp.next.data) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head;
    }
    public static void main(String[]args) {
        Node head = new Node(1);
        c.addNodeAtEnd(head, 1);
        c.addNodeAtEnd(head, 2);
        p.printLL(head);
        head = deleteDuplicates(head);
        p.printLL(head);
    }
    private static final Log log = new Log();
    private static final PrintLL p = new PrintLL();
    private static final CreateLL c = new CreateLL();
}
/**
 // list = [-3,-1,0,0,0,3,3]
 // expected = [-3,-1,0,3]
 // getting with HashMap = [-1,0,-3,3]
 // so use TreeMap, which maintains insertion order
 
    public static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null) return head;
        TreeMap<Integer, Integer> mpp = new TreeMap<>();
        for(int i = -100; i <= 100; ++i) mpp.put(i, 0);
        Node dummy = new Node(-1);
        Node temp = head;
        while(temp != null) {
            if(mpp.getOrDefault(temp.data, 0) == 0)
                mpp.put(temp.data, mpp.getOrDefault(temp.data, 0)+1);
            temp = temp.next;
        }
        Node ans = dummy;
        for(Map.Entry<Integer, Integer> e: mpp.entrySet()) {
            if(e.getValue() == 1) {
                Node newNode = new Node(e.getKey());
                ans.next = newNode;
                ans = ans.next;
            }
        }
        return dummy.next;
    }
 */
