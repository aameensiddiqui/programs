class MergeSortLL {
    public static Node mergeLL(Node low, Node high) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while(low != null && high != null) {
            if(low.data <= high.data) {
                temp.next = low;
                low = low.next;
            } else {
                temp.next = high;
                high = high.next;
            }
            temp = temp.next;
        }
        if(low != null) temp.next = low;
        else temp.next = high;
        return dummyNode.next;
    }
    public static Node findMidLL(Node head) {
        if(head == null || head.next == null) return head;
        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node sortLL(Node head) {
        if(head == null || head.next == null) return head;

        Node middle = findMidLL(head);
        Node right  = middle.next;
        middle.next = null;
        Node left   = head;

        left  = sortLL(left);
        right = sortLL(right);

        return mergeLL(left, right);
    }
    public static void main(String[]args) {
        log.info("/** Example 1*/");
        Node head = new Node(1);
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(7);
        Node d = new Node(2);
        Node e = new Node(6);
        Node f = new Node(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        
        log.info("---before---");
        p.printLL(head);
        head = sortLL(head);
        log.info("---after---");
        p.printLL(head);
        
        log.info("/** Example 2*/");
        Node head2 = new Node(-1);
        Node a2 = new Node(5);
        Node b2 = new Node(3);
        Node c2 = new Node(4);
        Node d2 = new Node(0);

        head2.next = a2;
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        
        log.info("---before---");
        p.printLL(head2);
        head2 = sortLL(head2);
        log.info("---after---");
        p.printLL(head2);

        log.info("/** Example 3*/");
        Node head3 = new Node();
        head3 = null;
        
        log.info("---before---");
        p.printLL(head3);
        head3 = sortLL(head3);
        log.info("---after---");
        p.printLL(head3);
    }
    private static final PrintLL p = new PrintLL();
    private static final Log log = new Log();
}
/**
    public static Node sortLL(Node head) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(temp != null) {
            min = Math.min(min, temp.data);
            max = Math.max(max, temp.data);
            temp = temp.next;
        }
        int offset = Math.abs(min);
        int freq[] = new int[Math.abs(max) + offset + 1];
        temp = head;
        while(temp != null) {
            freq[temp.data + offset]++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i < freq.length; ++i) {
            while(freq[i] != 0) {
                temp.data = i-offset;
                freq[i]--;
                temp = temp.next;
            }
        }
        return head;
    }

 */
