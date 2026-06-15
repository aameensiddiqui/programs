/**
   2095. Delete the Middle Node of a Linked List

   You are given the head of a linked list. Delete the middle node, and return the head of the
   modified linked list.

   The middle node of a linked list of size n is the [n / 2]th node from the start using 0-based
   indexing, where [x] denotes the largest integer less than or equal to x.

   For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

   Example 1:
   Input: head = [1,3,4,7,1,2,6]
   Output: [1,3,4,1,2,6]
   Explanation:
   The above figure represents the given linked list. The indices of the nodes are written below.
   Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
   We return the new list after removing this node.

   Example 2:
   Input: head = [1,2,3,4]
   Output: [1,2,4]
   Explanation:
   The above figure represents the given linked list.
   For n = 4, node 2 with value 3 is the middle node, which is marked in red.

   Example 3:
   Input: head = [2,1]
   Output: [2]
   Explanation:
   The above figure represents the given linked list.
   For n = 2, node 1 with value 1 is the middle node, which is marked in red.
   Node 0 with value 2 is the only node remaining after removing node 1.

   Constraints:
   The number of nodes in the list is in the range [1, 105].
   1 <= Node.val <= 105
 */
class DeleteMiddleNodeLL {
    private static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
    public static void main(String[] args) {
        Node head1 = CreateLL.createLL(new int[] {1,3,4,7,1,2,6});
        PrintLL.printLL(deleteMiddle(head1));                        // [1,3,4,1,2,6]

        Node head2 = CreateLL.createLL(new int[] {1,2,3,4});
        PrintLL.printLL(deleteMiddle(head2));                        // [1,2,4]

        Node head3 = CreateLL.createLL(new int[] {2,1});
        PrintLL.printLL(deleteMiddle(head3));                        // [2]

        Node head4 = CreateLL.createLL(new int[] {1});
        PrintLL.printLL(deleteMiddle(head4));                        // null
    }
}
/**
class DeleteMiddleNodeLL {
    public static Node deleteMiddle(Node head) {
        if(head.next == null || head == null) return null;
        Node slow = head, fast = head, prev = head;
        while(fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        log.info("Node to delete = "+slow.data);
        Node x = prev;
        prev.next = prev.next.next;
        x = null;
        return head;
    }
    public static void main(String[]args) {
        log.info("/ Example 1 /");
        Node head = new Node(1);
        Node firs = new Node(2);
        Node seco = new Node(3);
        Node thir = new Node(4);

        head.next = firs;
        firs.next = seco;
        seco.next = thir;

        log.info("---before---");
        p.printLL(head);
        head = deleteMiddle(head);
        log.info("---after---");
        p.printLL(head);

        log.info("/ Example 2 /");
        Node head2 = new Node(1);
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(7);
        Node d = new Node(1);
        Node e = new Node(2);
        Node f = new Node(6);

        head2.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        log.info("---before---");
        p.printLL(head2);
        head2 = deleteMiddle(head2);
        log.info("---after---");
        p.printLL(head2);

        log.info("/ Example 3 /");
        Node head3 = new Node(2);
        Node first = new Node(1);
        head3.next = first;
        first.next = null;

        log.info("---before---");
        p.printLL(head3);
        head3 = deleteMiddle(head3);
        log.info("---after---");
        p.printLL(head3);

        log.info("/ Example 4 /");
        Node head3 = new Node(2);

        log.info("---before---");
        p.printLL(head3);
        head3 = deleteMiddle(head3);
        log.info("---after---");
        p.printLL(head3);
    }
    private static final PrintLL p = new PrintLL();
    private static final Log log = new Log();
}
*/
