class DeleteMiddleNodeLL {
    public static Node deleteMiddle(Node head) {
        if(head.next == null || head == null) return null;
        Node slow = head, fast = head, prev = head;
        while(fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        log.info("Node to delete = "+slow.data);
        Node x = prev;
        prev.next = prev.next.next;
        x = null;
        return head;
    }
    public static void main(String[]args) {
        log.info("/** Example 1*/");
        Node head = new Node(1);
        Node firs = new Node(2);
        Node seco = new Node(3);
        Node thir = new Node(4);

        head.next = firs;
        firs.next = seco;
        seco.next = thir;

        log.info("---before---");
        p.printLL(head);
        head = deleteMiddle(head);
        log.info("---after---");
        p.printLL(head);

        log.info("/** Example 2*/");
        Node head2 = new Node(1);
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(7);
        Node d = new Node(1);
        Node e = new Node(2);
        Node f = new Node(6);

        head2.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        
        log.info("---before---");
        p.printLL(head2);
        head2 = deleteMiddle(head2);
        log.info("---after---");
        p.printLL(head2);

        log.info("/** Example 3*/");
        Node head3 = new Node(2);
        Node first = new Node(1);
        head3.next = first;
        first.next = null;
        
        log.info("---before---");
        p.printLL(head3);
        head3 = deleteMiddle(head3);
        log.info("---after---");
        p.printLL(head3);

        log.info("/** Example 4*/");
        Node head3 = new Node(2);
        
        log.info("---before---");
        p.printLL(head3);
        head3 = deleteMiddle(head3);
        log.info("---after---");
        p.printLL(head3);
    }
    private static final PrintLL p = new PrintLL();
    private static final Log log = new Log();
}
