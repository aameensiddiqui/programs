/**
   203. Remove Linked List Elements

   Given the head of a linked list and an integer val, remove all the nodes
   of the linked list that has Node.val == val, and return the new head.

   Example 1:
   Input: head = [1,2,6,3,4,5,6], val = 6
   Output: [1,2,3,4,5]

   Example 2:
   Input: head = [], val = 1
   Output: []

   Example 3:
   Input: head = [7,7,7,7], val = 7
   Output: []
   Constraints:
   The number of nodes in the list is in the range [0, 104].
   1 <= Node.val <= 50
   0 <= val <= 50
*/
import java.util.*;

class RemoveLinkedListElements {
    // iterative
    private static Node removeElements(Node head, int val) {
        Node dummy = new Node(0, head);
        Node curr = dummy;
        while (curr.next != null) {
            if (curr.next.data == val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[]args) {
        // 1
        Node head1 = CreateLL.createLL(new int[]{1,2,6,3,4,5,6});
        PrintLL.printLL(head1);
        PrintLL.printLL(removeElements(head1, 6));

        // 2
        Node head2 = CreateLL.createLL(new int[]{});
        PrintLL.printLL(head2);
        PrintLL.printLL(removeElements(head2, 1));

        // 3
        Node head3 = CreateLL.createLL(new int[]{7,7,7,7});
        PrintLL.printLL(head3);
        PrintLL.printLL(removeElements(head3, 7));
    }
}
/**
    // recursive
    private static Node removeElements(Node head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.data != val ? head : head.next;
    }
*/
/**
    // brute force
    private static Node removeElements(Node head, int val) {
        List<Integer> list = new ArrayList<>();
        Node move = head;
        while (move != null) {
            if (move.data == val) {
                move = move.next;
                continue;
            } else list.add(move.data);
            move = move.next;
        }
        Node res = new Node(0);
        move = res;
        for (int i = 0; i < list.size(); ++i) {
            move.next = new Node(list.get(i));
            move = move.next;
        }
        return res.next;
    }
*/
