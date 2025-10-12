/**
   Both are correct, but they do different things - the difference is what they return.
   nse is value based
   returns the values of next smaller elements

   nsei is index based
   returns the values of indexes of next smaller elements
   required in other algorithms (see SumOfSubarrayRanges.java)
 */
import java.util.*;
class NextSmallerElement {
    public static int[] nse(int[]arr) {
        Stack<Integer> st = new Stack<>();
        int[]ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for(int i = arr.length-1; i >= 0; --i) {
            while(!st.empty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if(!st.empty()) ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public static int[] nsei(int[]arr) {
        Stack<Integer> st = new Stack<>();
        int[]ans = new int[arr.length];
        for(int i = arr.length-1; i >= 0; --i) {
            while(!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.empty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }
    public static void main(String[]args) {
        int[]arr = {4, 8, 5, 2, 25};
        log.info(nse(arr));
        log.info(nsei(arr));
    }
    private static final Log log = new Log();
}
