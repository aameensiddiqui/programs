class ReverseDLL {
    public Node reverseDLL(Node head) {
        if(head == null || head.next == null) return head;
        Node curr = head;
        Node temp = null;
        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }
        // Log log = new Log();
        // log.info("temp.prev.data = "+temp.prev.data);
        head = temp.prev;
        // log.info("head.data = "+head.data);
        // log.info("head.next.data = "+head.next.data);
        return head;
    }
}
