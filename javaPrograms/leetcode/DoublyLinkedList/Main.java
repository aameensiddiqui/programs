class Main {
    private static final PrintDLL p = new PrintDLL();
    private static final InsertAtEnd i = new InsertAtEnd();
    private static final DeleteNodeAtEndDLL d = new DeleteNodeAtEndDLL();
    private static final DeleteHeadDLL dh = new DeleteHeadDLL();
    private static final ConvertArrayToDLL atd = new ConvertArrayToDLL();
    private static final ReverseDLL r = new ReverseDLL();

    public static void main(String[]args) {
        Node head = new Node(1);
        Node firs = new Node(2);
        Node seco = new Node(3);
        
        head.prev = null;
        head.next = firs;
        
        firs.prev = head;
        firs.next = seco;
        
        seco.prev = firs;
        seco.next = null;

        Node thir = i.insertAtEnd(head, 4);
        Node four = i.insertAtEnd(head, 5);
        Node fift = i.insertAtEnd(head, 6);
        Node sixt = i.insertAtEnd(head, 7);
        Node seve = i.insertAtEnd(head, 7);
        Node eigh = i.insertAtEnd(head, 8);
        Node nine = i.insertAtEnd(head, 9);

        p.print(nine);
        d.deleteAtEnd(head);
        p.print(nine);
        head = dh.deleteHead(head);
        p.print(head);

        int[]arr = {11, 22, 33, 44, 55, 66, 77, 88};
        Node h = atd.arrToDll(arr);
        p.print(h);
        r.reverseDLL(h);
        p.print(h);        
    }
}
