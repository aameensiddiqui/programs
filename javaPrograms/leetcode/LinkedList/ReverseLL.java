class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, Node next) {this.val = val; this.next = next;}
}
class ReverseLL {
    public static Node reverse(Node head) {
        Node move = head;
        Node prev = null;
        while(move != null) {
            Node front = move.next;
            move.next = prev;
            prev = move;
            move = front;
        }
        // return new head
        return prev;
    }
    public static void main(String[]main) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        log.info("*********Before**********");
        Node move = head;
        while(move != null) {
            log.info(move.val);
            move = move.next;
        }
        log.info("*********After**********");
        move = reverse(head);
        while(move != null) {
            log.info(move.val);
            move = move.next;
        }
    }
    private static Log log = new Log();
}
