/**
   295. Find Median from Data Stream

   The median is the middle value in an ordered integer list. If the size of the
   list is even, there is no middle value, and the median is the mean of the two
   middle values.

   For example, for arr = [2,3,4], the median is 3.
   For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
   Implement the MedianFinder class:

   MedianFinder() initializes the MedianFinder object.
   void addNum(int num) adds the integer num from the data stream to the data structure.
   double findMedian() returns the median of all elements so far. Answers within 10-5
   of the actual answer will be accepted.

   Example 1:
   Input
   ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
   [[], [1], [2], [], [3], []]
   Output
   [null, null, null, 1.5, null, 2.0]
   Explanation
   MedianFinder medianFinder = new MedianFinder();
   medianFinder.addNum(1);    // arr = [1]
   medianFinder.addNum(2);    // arr = [1, 2]
   medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
   medianFinder.addNum(3);    // arr[1, 2, 3]
   medianFinder.findMedian(); // return 2.0

   Constraints:
   -105 <= num <= 105
   There will be at least one element in the data structure before calling findMedian.
   At most 5 * 104 calls will be made to addNum and findMedian.
*/
import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}

class FindMedianFromDataStream {
    public static void main(String[]args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        IO.println(m.findMedian());
        m.addNum(3);
        IO.println(m.findMedian());
    }
}
/**
class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int n = list.size();
        if(list.size() % 2 == 0)
            return (list.get(n/2) + list.get((n/2)-1)) / 2.0;
        return list.get(n/2);
    }
}
*/
