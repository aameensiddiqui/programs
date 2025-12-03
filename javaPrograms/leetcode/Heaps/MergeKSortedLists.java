/**
   23. Merge k Sorted Lists

   You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

   Merge all the linked-lists into one sorted linked-list and return it.

   Example 1:
   Input: lists = [[1,4,5],[1,3,4],[2,6]]
   Output: [1,1,2,3,4,4,5,6]
   Explanation: The linked-lists are:
   [
   1->4->5,
   1->3->4,
   2->6
   ]
   merging them into one sorted linked list:
   1->1->2->3->4->4->5->6

   Example 2:
   Input: lists = []
   Output: []

   Example 3:
   Input: lists = [[]]
   Output: []

   Constraints:
   k == lists.length
   0 <= k <= 104
   0 <= lists[i].length <= 500
   -104 <= lists[i][j] <= 104
   lists[i] is sorted in ascending order.
   The sum of lists[i].length will not exceed 104.
*/
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class S {
    public static ListNode mergeKLists(ListNode[] list) {
        if(list.length == 0) return null;
        
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < list.length; ++i) {
            while(list[i] != null) {
                a.add(list[i].val);
                list[i] = list[i].next;
            }
        }
        if(a.size() == 0) return null;
        
        Collections.sort(a);

        // Log.info("-------------");
        // Log.info(a);
        // Log.info("-------------");

        
        ListNode d = new ListNode(a.get(0));
        ListNode move = d;
        for(int i = 1; i < a.size(); ++i) {
            move.next = new ListNode(a.get(i));
            move = move.next;
        }
        return d;
    }
    public static List<Integer> printListNode(ListNode list) {
        List<Integer> a = new ArrayList<>();
        while(list != null) {
            a.add(list.val);
            list = list.next;
        }
        return a;
    }
}

class MergeKSortedLists {
    public static void main(String[]args) {
        // 1
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] lists = new ListNode[] {a,b,c};
        
        ListNode ans = S.mergeKLists(lists);
        Log.info(S.printListNode(ans));


        // 2
        ListNode a2 = null;
        ListNode[] lists2 = new ListNode[] {a2};

        ListNode ans2 = S.mergeKLists(lists2);
        Log.info(S.printListNode(ans2));
        
    }
}
