class DeleteHeadDLL {
    public Node deleteHead(Node head) {
        if(head == null || head.next == null) return null;
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }
}
