import java.util.*;
class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, Node next) {this.val = val; this.next = next;}
}

class OddEvenLL {
    public static Node oddEvenList(Node head) {
        if(head == null || head.next == null) return head;
        Node odd = head, even = head.next, evenHead = head.next;
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
        
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[]args) {
        Node head   = new Node(1);
        Node second = new Node(2);
        Node third  = new Node(3);
        Node fourth = new Node(4);
        Node fifth  = new Node(5);

        head.next   = second;
        second.next = third;
        third.next  = fourth;
        fourth.next = fifth;

        printLL(oddEvenList(head));
    }
    public static void printLL(Node head) {
        Node temp = head;
        log.info("start*****************");
        while(temp != null) {
            log.info(temp.val);
            temp = temp.next;
        }
        log.info("end*******************");
    }

    private static final Log log = new Log();
}
/** // brute force
   public static Node oddEvenList(Node head) {
                              
        List<Integer> list = new ArrayList<>();
        
        // set for odd indexes
        Node temp = head;
        while(temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) list.add(temp.val);

        // set for even indexes
        temp = head.next;
        while(temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) list.add(temp.val);

        temp = head;
        int i = 0;
        while(temp != null) {
            temp.val = list.get(i++);
            temp = temp.next;
        }
        return head;
        
    }
 */
