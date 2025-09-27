import java.util.Map;
import java.util.HashMap;
class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, Node next) {this.val = val; this.next = next;}
}
class LLCycle {
    /** using HashMap */
    // public static boolean detectLoop(Node head) {
    //     Node temp = head;
    //     Map<Node, Integer> nodeMap = new HashMap<>();
    //     while(temp != null) {
    //         if(nodeMap.containsKey(temp)) return true;
    //         nodeMap.put(temp, 1);
    //         temp = temp.next;
    //     }
    //     return false;
    // }
    
    /** Hare and Tortoise Algorithm */
    public static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static void main(String[]main) {
        Node head   = new Node(1);
        Node second = new Node(2);
        Node third  = new Node(3);
        Node fourth = new Node(4);
        Node fifth  = new Node(5);

        head.next   = second;
        second.next = third;
        third.next  = fourth;
        fourth.next = fifth;
        // cycle or loop:
        fifth.next  = third;

        log.info(detectLoop(head));
        
        // printing LL
        // Node move = head;
        // while(move != null) {
        //     log.info(move.val);
        //     move = move.next;
        // }
    }
    private static Log log = new Log();
}
