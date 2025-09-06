class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, Node next) {this.val = val; this.next = next;}
}
class PalindromeLL {
    public static Node reverseLL(Node head) {
        if(head == null || head.next == null) return head;
        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverseLL(slow.next);
        Node first   = head;
        Node second  = newHead;
        while(second != null) {
            if(second.val != first.val) {
                reverseLL(newHead);
                return false;
            }
            second = second.next;
            first  = first.next;
        }
        reverseLL(newHead);
        return true;
    }
    public static void main(String[]main) {
        /** Example 1 */
        // Node head   = new Node(1);
        // Node second = new Node(2);
        // Node third  = new Node(3);
        // Node fourth = new Node(3);
        // Node fifth  = new Node(2);
        // Node sixth  = new Node(1);
        // head.next   = second;
        // second.next = third;
        // third.next  = fourth;
        // fourth.next = fifth;
        // fifth.next  = sixth;

        /** Example 2 */
        Node head   = new Node(1);
        Node second = new Node(1);
        Node third  = new Node(2);
        Node fourth = new Node(1);
        head.next   = second;
        second.next = third;
        third.next  = fourth;

        printLL(head);
        log.info(isPalindrome(head));
    }
    private static Log log = new Log();
    public static void printLL(Node head) {
        Node temp = head;
        log.info("start*****************");
        while(temp != null) {
            log.info(temp.val);
            temp = temp.next;
        }
        log.info("end*******************");
    }
}
/**
   // faster
   public static boolean isPalindrome(ListNode head) {
        if(head.next == null ) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode nextNode = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        if(fast != null) slow = slow.next;
        while(prev != null && slow != null) {
            if(prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
 */
