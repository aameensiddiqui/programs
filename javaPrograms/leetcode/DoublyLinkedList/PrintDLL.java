class PrintDLL {
    private static final Log log = new Log();
    public void print(Node head) {
        while(head.prev != null)
            head = head.prev;
        
        Node move = head;
        log.info("start******************");
        while(move != null) {
            log.info(move.data);
            move = move.next;
        }
        log.info("end********************");
    }
}
