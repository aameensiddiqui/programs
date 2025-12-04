/**
   621. Task Scheduler

   You are given an array of CPU tasks, each labeled with a letter from A to Z,
   and a number n. Each CPU interval can be idle or allow the completion of one
   task. Tasks can be completed in any order, but there's a constraint: there has
   to be a gap of at least n intervals between two tasks with the same label.

   Return the minimum number of CPU intervals required to complete all tasks.

   Example 1:
   Input: tasks = ["A","A","A","B","B","B"], n = 2
   Output: 8
   Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
   After completing task A, you must wait two intervals before doing A again.
   The same applies to task B. In the 3rd interval, neither A nor B can be done,
   so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

   Example 2:
   Input: tasks = ["A","C","A","B","D","B"], n = 1
   Output: 6
   Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
   With a cooling interval of 1, you can repeat a task after just one other task.

   Example 3:
   Input: tasks = ["A","A","A", "B","B","B"], n = 3
   Output: 10

   Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
   There are only two types of tasks, A and B, which need to be separated by 3
   intervals. This leads to idling twice between repetitions of these tasks.

   Constraints:
   1 <= tasks.length <= 104
   tasks[i] is an uppercase English letter.
   0 <= n <= 100
*/
import java.util.*;
class S {
    public static int leastInterval(char[]tasks, int n) {

        // count frequency of each task
        Map<Character, Integer> mpp = new HashMap<>();
        for(char c : tasks) mpp.put(c, mpp.getOrDefault(c, 0)+1);
        // Log.info("mpp---> "+ mpp);

        // create a max heap (pq in reverseorder) to store the frequency of tasks
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : mpp.values()) pq.add(cnt);
        // Log.info("pq---> "+ pq);

        // answer
        int totalTime = 0;

        // process tasks in cycle of size (n + 1)
        while(!pq.isEmpty()) {

            // temp list to store tasks of current cycle
            List<Integer> list = new ArrayList<>();

            // for tracking number of tasks processed in current cycle
            int i = 0;

            // run up to n+1 tasks or until heap is empty
            while(i < (n + 1) && !pq.isEmpty()) {
                // get the most frequent task
                int cnt = pq.poll();
                cnt--; // decrease freq (used once)
                if(cnt > 0) list.add(cnt); // if task is still remaining, store it for next cycle
                totalTime++;
                i++;
                // Log.info("i="+i+"  totaltime="+totalTime);
            }
            // Log.info("list---> "+ list);

            // add remainingtasks in pq(heap)
            for(int remainingTasks : list) pq.add(remainingTasks);

            // idle time
            if(!pq.isEmpty()) totalTime += ((n + 1) - i);
        }
        return totalTime;
    }
}
class TaskSchedular {
    public static void main(String[]args) {
        IO.println(S.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        IO.println(S.leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        IO.println(S.leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
    }
}
