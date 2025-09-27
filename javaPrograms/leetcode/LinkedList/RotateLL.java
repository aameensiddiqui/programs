class RotateLL {
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        Node temp = head;
        int len = 1;
        while(temp.next != null) {len++; temp = temp.next;}
        temp.next = head;
        k = k % len;
        int end = len - k;
        while(end != 0) {temp = temp.next; end--;}
        head = temp.next;
        temp.next = null;
        return head;
    }
    public static void main(String[]args) {
        Node head = new Node(1);
        c.addNodeAtEnd(head, 2);
        c.addNodeAtEnd(head, 3);
        c.addNodeAtEnd(head, 4);
        c.addNodeAtEnd(head, 5);
        c.addNodeAtEnd(head, 6);
        c.addNodeAtEnd(head, 7);
        c.addNodeAtEnd(head, 8);
        p.printLL(head);

        //head = rotateRight(head, 2);
        //head = rotateRight(head, 2000000000);
        head = rotateRight(head, 363243333);
        p.printLL(head);
    }
    private static final Log log = new Log();
    private static final CreateLL c = new CreateLL();
    private static final PrintLL p = new PrintLL();
}
/**
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null) return head;
        for(int i = 0; i < k; ++i) {
            Node temp = head;
            while(temp.next.next != null) temp = temp.next;
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }
*/
