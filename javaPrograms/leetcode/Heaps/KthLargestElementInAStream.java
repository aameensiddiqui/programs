/**
   703. Kth Largest Element in a Stream

   You are part of a university admissions office and need to keep track of
   the kth highest test score from applicants in real-time. This helps to
   determine cut-off marks for interviews and admissions dynamically as new
   applicants submit their scores.

   You are tasked to implement a class which, for a given integer k, maintains
   a stream of test scores and continuously returns the kth highest test score
   after a new score has been submitted. More specifically, we are looking for
   the kth highest score in the sorted list of all scores.

   Implement the KthLargest class:

   KthLargest(int k, int[] nums) Initializes the object with the integer k and
   the stream of test scores nums.
   int add(int val) Adds a new test score val to the stream and returns the element
   representing the kth largest element in the pool of test scores so far.

   Example 1:
   Input:
   ["KthLargest", "add", "add", "add", "add", "add"]
   [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   Output: [null, 4, 5, 5, 8, 8]

   Explanation:
   KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
   kthLargest.add(3); // return 4
   kthLargest.add(5); // return 5
   kthLargest.add(10); // return 5
   kthLargest.add(9); // return 8
   kthLargest.add(4); // return 8

   Example 2:
   Input:
   ["KthLargest", "add", "add", "add", "add"]
   [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
   Output: [null, 7, 7, 7, 8]

   Explanation:
   KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
   kthLargest.add(2); // return 7
   kthLargest.add(10); // return 7
   kthLargest.add(9); // return 7
   kthLargest.add(9); // return 8

   Constraints:
   0 <= nums.length <= 104
   1 <= k <= nums.length + 1
   -104 <= nums[i] <= 104
   -104 <= val <= 104
   At most 104 calls will be made to add.
*/
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[]nums) {
        pq = new PriorityQueue<>();
        size = k;

        for(int n : nums) {
            pq.offer(n);
            if(pq.size() > k) pq.poll();
        }
    }
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > size) pq.poll();
        return pq.peek();
    }
}
class KthLargestElementInAStream {
    public static void main(String[]args) {
        int[]nums = {4, 5, 8, 2};
        KthLargest k = new KthLargest(3, nums);
        IO.println(k.add(3));
        IO.println(k.add(5));
        IO.println(k.add(10));
        IO.println(k.add(9));
        IO.println(k.add(4));

        int[]nums2 = {7, 7, 7, 7, 8, 3};
        KthLargest k2 = new KthLargest(4, nums2);
        IO.println(k2.add(2));
        IO.println(k2.add(10));
        IO.println(k2.add(9));
        IO.println(k2.add(9));
    }
}
