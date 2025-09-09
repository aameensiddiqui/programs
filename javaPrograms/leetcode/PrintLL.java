class PrintLL {
    public static final Log log = new Log();
    public static void printLL(Node head) {
        Node temp = head;
        log.info("start*****************");
        while(temp != null) {
            log.info(temp.data);
            temp = temp.next;
        }
        log.info("end*******************");
    }
}
