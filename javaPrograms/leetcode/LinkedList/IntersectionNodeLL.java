class IntersectionNodeLL {
    public static Node getIntersectionNode(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;
        while(t1 != t2) {
            t1 = (t1 == null) ? head2 : t1.next;
            t2 = (t2 == null) ? head1 : t2.next;
        }
        return t1;
    }
    public static void main(String[]args) {
        Node head = new Node(4);
        Node sec = new Node(1);
        Node a = new Node(8);
        Node b = new Node(4);
        Node c = new Node(5);
        head.next = sec;
        sec.next = a;
        a.next = b;
        b.next = c;
        p.printLL(head);

        Node head2 = new Node(5);
        Node second = new Node(6);
        Node third = new Node(1);
        head2.next = second;
        second.next = third;
        third.next = a;
        p.printLL(head2);

        Node ans = getIntersectionNode(head, head2);
        p.printLL(ans);
    }
    public static final Log log = new Log();
    public static final PrintLL p = new PrintLL();
}
/**
    public static Node getIntersectionNode(Node head1, Node head2) {
        while(head2 != null) {
            Node temp = head1;
            while(temp != null) {
                if(temp == head2) return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

 */
