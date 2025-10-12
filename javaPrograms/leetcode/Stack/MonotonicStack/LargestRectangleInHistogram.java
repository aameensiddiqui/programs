/**
   84. Largest Rectangle in Histogram

   Given an array of integers heights representing the histogram's bar height
   where the width of each bar is 1, return the area of the largest rectangle
   in the histogram.

   Example 1:
   Input: heights = [2,1,5,6,2,3]
   Output: 10
   Explanation: The above is a histogram where width of each bar is 1.
   The largest rectangle is shown in the red area, which has an area = 10 units.

   Example 2:
   Input: heights = [2,4]
   Output: 4

   Constraints:

   1 <= heights.length <= 105
   0 <= heights[i] <= 104
 */
import java.util.*;
class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[]arr) {
        int n = arr.length, maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i <= n; ++i) {
            while(!st.isEmpty() && (i == n || arr[st.peek()] > arr[i])) {
                int h = arr[st.pop()];
                int w = st.isEmpty() ? (i) : (i-st.peek()-1);
                maxArea = Math.max(maxArea, (h * w));
            }
            st.push(i);    
        }
        return maxArea;
    }
    public static void main(String[]args) {
        int[]arr1 = {2, 1, 5, 6, 2, 3};
        int[]arr2 = {1};
        int[]arr3 = {1, 1};
        int[]arr4 = {3, 2, 10, 11, 5, 10, 6, 3};
        log.info(largestRectangleArea(arr1));
        log.info(largestRectangleArea(arr2));
        log.info(largestRectangleArea(arr3));
        log.info(largestRectangleArea(arr4));
    }
    private static final Log log = new Log();
}
/**
    // sc = O(N)
    // tc = O(2N)
    public static int largestRectangleArea(int[]arr) {
        int n = arr.length, maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < n; ++i) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int element = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (element * (nse - pse - 1)));
            }
            st.push(i);    
        }
        while(!st.isEmpty()) {
            int element = arr[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (element * (nse - pse - 1)));
        }
        return maxArea;
    }
 */
/**
    // sc = O(3N)
    // tc = O(3N)
    public static int largestRectangleArea(int[]arr) {
        int n = n;
        Deque<Integer> st = new ArrayDeque<>();
        int[]nse = new int[n];
        int[]pse = new int[n];

        for(int i = n-1; i >= 0; --i) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n-1 : st.peek()-1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();

        for(int i = 0; i < n; ++i) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            pse[i] = st.isEmpty() ? 0 : st.peek()+1;
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n; ++i) {
            maxArea = Math.max(maxArea, arr[i] * (nse[i] - pse[i] + 1));
        }
        return maxArea;
    }
 */
