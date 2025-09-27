class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class MiddleOfLinkedList {
    // public static ListNode middleNode(ListNode head) {
    //     if(head == null || head.next == null) return head;
    //     int cnt = 0;
    //     ListNode move = new ListNode();
    //     move = head;
    //     while(move != null) {
    //         cnt++;
    //         move = move.next;
    //     }
    //     int mid = cnt / 2 + 1;
    //     move = head;
    //     while(move != null) {
    //         mid--;
    //         if(mid == 0) break;
    //         move = move.next;
    //     }
    //     return move;
    // }
    /** Tortoise and hare method */
    public static ListNode middleNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare != null && hare.next != null && tortoise != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }
    public static void main(String[]main) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        ListNode midNode = middleNode(head);
        log.info(midNode);
        log.info(midNode.val);
        //log.info(midNode.next);
    }
    private static Log log = new Log();
}
