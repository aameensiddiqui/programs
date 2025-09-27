class DeleteNodeAtEndDLL {
    public Node deleteAtEnd(Node head) {
        if(head == null || head.next == null) return null;
        Node move;
        for(move = head; move.next != null; move = move.next);
        Node temp = move.prev;
        temp.next = null;
        move.prev = null;
        return head;
    }
}
