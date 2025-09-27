class InsertAtEnd {
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) head = newNode;
        else {
            Node move;
            for(move = head; move.next != null; move = move.next);
            move.next = newNode;
            newNode.prev = move;
        }
        return head;
    }
}
