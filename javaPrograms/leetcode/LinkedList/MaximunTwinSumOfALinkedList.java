/**
   2130. Maximum Twin Sum of a Linked List

   In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is
   known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
   For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
   These are the only nodes with twins for n = 4.
   The twin sum is defined as the sum of a node and its twin.
   Given the head of a linked list with even length, return the maximum twin sum of the linked list.

   Example 1:
   Input: head = [5,4,2,1]
   Output: 6
   Explanation:
   Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
   There are no other nodes with twins in the linked list.
   Thus, the maximum twin sum of the linked list is 6.

   Example 2:
   Input: head = [4,2,2,3]
   Output: 7
   Explanation:
   The nodes with twins present in this linked list are:
   - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
   - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
   Thus, the maximum twin sum of the linked list is max(7, 4) = 7.

   Example 3:
   Input: head = [1,100000]
   Output: 100001
   Explanation:
   There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.

   Constraints:
   The number of nodes in the list is an even integer in the range [2, 105].
   1 <= Node.val <= 105
*/
class MaximunTwinSumOfALinkedList {
    private static int pairSum(Node head) {
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        int res = 0;
        while (slow != null) {
            res = Math.max(res, slow.data + prev.data);
            slow = slow.next;
            prev = prev.next;
        }
        return res;
    }
    public static void main(String[] args) {
        Node q1 = CreateLL.createLL(new int[] {5,4,2,1});
        Log.info(pairSum(q1));
        Node q2 = CreateLL.createLL(new int[] {4,2,2,3});
        Log.info(pairSum(q2));
        Node q3 = CreateLL.createLL(new int[] {1,100000});
        Log.info(pairSum(q3));
    }
}
/**
   Reverse In-place | Two-pointers | Floyd's Tortoise & Hare

   Intuition

   The twin of a node in the first half of the linked list is the corresponding node in the second half
   when viewed from opposite ends.
   To optimally compute the maximum twin sum, we need to access nodes from both halves simultaneously.
   However, we cannot directly access a node and its twin from the opposite end:
   Thus, we first need a way to split the list into two halves and align corresponding twin nodes for
   comparison.

   Finding the Middle of a linked list
   Leetcode 876. Middle of the Linked List
   A standard technique for finding the midpoint of a linked list is Floyd's Tortoise and Hare algorithm:
   Where a slow pointer advances one node at a time while a fast pointer advances two nodes at a time.
   When the fast pointer reaches the end, the slow pointer will be at the middle of the list.

   Reversing the First Half
   Reverse Linked List
   Simultaneously, we reverse the first half of the linked list while locating the middle:
   slow pointer traverses the first half.
   Before advancing slow, we reverse its pointer.
   By the time slow reaches the middle, the first half has been completely reversed.

   At the end:
   prev pointing to the head of the reversed first half.
   slow pointing to the start of the second half.
   Now, corresponding twin nodes can be compared by traversing both halves together.

   Compute Twin Sums
   Since both pointers move in the same direction, every twin pair can be processed simultaenously.
   prev iterates through the reversed first half.
   slow iterates through the second half.
   For each pair, compute prev node + slow node values and update the global max twin sum.
   Finally, return the maximum value.

   Time Complexity: O(n)
   Space Complexity: O(1)

   Recursion
   Instead of reversing the list, we can leverage recursion to traverse the linked list from both ends
   simultaneously.

   The recursive calls move right to the end of the list, and during the unwinding phase, right effectively
   traverses from right to left.

   Meanwhile, a global left pointer advances from left to right.

   This allows us to process each twin pair exactly once and update the maximum twin sum.

   class Solution {
   int res;
   ListNode left;

   public int pairSum(ListNode head) {
   left = head;
   dfs(head);
   return res;
   }

   private void dfs(ListNode right) {
   if (right.next != null)
   dfs(right.next);
   res = Math.max(res, left.val + right.val);
   left = left.next;
   }
   }
   Time Complexity: O(n)
   Space Complexity: O(n)
*/
