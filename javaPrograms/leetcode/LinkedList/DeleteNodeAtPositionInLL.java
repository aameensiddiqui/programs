class DeleteAtPositionInLL {
    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head, fast = head;
        for(int i = 0; i < n; ++i) fast = fast.next;
        if(fast == null) return head.next;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node x = slow.next;
        slow.next = slow.next.next;
        x = null;
        return head;
    }
    public static void main(String[]args) {
        log.info("/** Example 1*/");
        Node head = new Node(1);
        Node firs = new Node(2);
        Node seco = new Node(3);
        Node thir = new Node(4);
        Node four = new Node(5);

        head.next = firs;
        firs.next = seco;
        seco.next = thir;
        thir.next = four;
        four.next = null;

        log.info("---before---");
        p.printLL(head);
        head = removeNthFromEnd(head, 2);
        log.info("---after---");
        p.printLL(head);
        
        log.info("/** Example 2*/");
        Node head2 = new Node(1);
        head2.next = null;
        
        log.info("---before---");
        p.printLL(head2);
        head2 = removeNthFromEnd(head2, 1);
        log.info("---after---");
        p.printLL(head2);

        log.info("/** Example 3*/");
        Node head3 = new Node(1);
        Node first = new Node(2);
        head3.next = first;
        first.next = null;
        
        log.info("---before---");
        p.printLL(head3);
        head3 = removeNthFromEnd(head3, 1);
        log.info("---after---");
        p.printLL(head3);
    }
    private static final PrintLL p = new PrintLL();
    private static final Log log = new Log();
}
/**
    public static Node removeNthFromEnd(Node head, int n) {
        int len = lengthOfLL(head);
        log.info("len="+len);
        int pos = len-n+1;
        log.info("pos="+pos);
        if(pos <= 0 || pos > len || head == null) return head;
        if(pos == 1) return head.next;
        else {
            Node y = head;
            for(int i = 1; i < pos-1; ++i) {
                y = y.next; 
            }
            Node x = y.next;
            y.next = x.next;
            x.next = null;
        }
        return head;
    }
    public static int lengthOfLL(Node head) {
        int cnt = 0;
        for(Node move = head; move != null; move = move.next) cnt++;
        log.info("cnt="+cnt);
        return cnt;
    }
 */
