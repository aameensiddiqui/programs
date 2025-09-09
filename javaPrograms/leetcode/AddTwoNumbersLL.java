/**
   2. Add Two Numbers

   You are given two non-empty linked lists representing two non-negative integers.
   The digits are stored in reverse order, and each of their nodes contains a single digit.
   Add the two numbers and return the sum as a linked list.

   You may assume the two numbers do not contain any leading zero, except the number 0 itself.

   Example 1:
   Input: l1 = [2,4,3], l2 = [5,6,4]
   Output: [7,0,8]
   Explanation: 342 + 465 = 807.

   Example 2:
   Input: l1 = [0], l2 = [0]
   Output: [0]
   Example 3:

   Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
   Output: [8,9,9,9,0,0,0,1]
   
   Constraints:
   The number of nodes in each linked list is in the range [1, 100].
   0 <= Node.val <= 9
   It is guaranteed that the list represents a number that does not have leading zeros.
*/
class AddTwoNumbersLL {
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node ans = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ans.next = new Node(sum % 10);
            ans = ans.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
    
    public static void addAtEnd(Node head, int data) {
        Node record = new Node(data);
        if(head == null) head = record;
        else {
            Node move;
            for(move = head; move.next != null; move = move.next);
            move.next = record;
        }
    }
    public static void main(String[]args) {
        PrintLL p = new PrintLL();

        /** Example 1 */
        Node head = new Node(2);
        addAtEnd(head, 4);
        addAtEnd(head, 3);

        Node head2 = new Node(5);
        addAtEnd(head2, 6);
        addAtEnd(head2, 4);

        log.info("***** Example  1 *****");
        Node ans1 = addTwoNumbers(head, head2);
        p.printLL(ans1);

        /** Example 2 */
        Node head3 = new Node(9);
        addAtEnd(head3, 9);
        addAtEnd(head3, 9);
        addAtEnd(head3, 9);
        addAtEnd(head3, 9);
        addAtEnd(head3, 9);
        addAtEnd(head3, 9);

        Node head4 = new Node(9);
        addAtEnd(head4, 9);
        addAtEnd(head4, 9);
        addAtEnd(head4, 9);
        log.info("***** Example  2 *****");
        Node ans2 = addTwoNumbers(head3, head4);
        p.printLL(ans2);
        
        /** Example 3 */
        Node head5 = new Node(2);
        addAtEnd(head5, 4);
        addAtEnd(head5, 9);

        Node head6 = new Node(5);
        addAtEnd(head6, 6);
        addAtEnd(head6, 4);
        addAtEnd(head6, 9);
        
        log.info("***** Example  3 *****");
        Node ans3 = addTwoNumbers(head5, head6);
        p.printLL(ans3);
    }
    private static final Log log = new Log();
}
/**
    // gives wrong o/p for example 3: [8,9,8,5]
    // o/p should be [7,0,4,0,1]
    public static Node addTwoNumbers(Node head, Node head2) {
        Node a = head;
        Node b = head2;
        int n = 0, n2 = 0;
        while(a != null) {
            n *= 10; //log.info("n="+n);
            n += a.data; //log.info("a.data="+a.data); log.info("n="+n);
            
            a = a.next;
        }
        while(b != null) {
            n2 *= 10; //log.info("n2="+n2);
            n2 += b.data; //log.info("b.data="+b.data); log.info("n2="+n2);
            
            b = b.next;
        }
        n += n2;
        int digit = n % 10;
        n /= 10;
        Node ans = new Node(digit);
        while(n > 0) {
            digit = n % 10;
            n /= 10;
            addAtEnd(ans, digit);
        }
        return ans;
    }
 */
