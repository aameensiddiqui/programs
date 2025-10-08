/**
   907. Sum of Subarray Minimums

   Given an array of integers arr, find the sum of min(b), where b ranges over
   every (contiguous) subarray of arr. Since the answer may be large, return
   the answer modulo 10^9 + 7.

   Example 1:
   Input: arr = [3,1,2,4]
   Output: 17
   Explanation: 
   Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
   Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
   Sum is 17.

   Example 2:
   Input: arr = [11,81,94,43,3]
   Output: 444

   Constraints:
   1 <= arr.length <= 3 * 104
   1 <= arr[i] <= 3 * 104
 */
import java.util.*;
class SumOfSubarrayMinimum {
    public static int[] findNSE(int[]arr) {
        int[]nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1; i >= 0; --i) {
            while(!st.empty() && arr[i] <= arr[st.peek()]) st.pop();
            nse[i] = !st.empty() ? st.peek() : arr.length;
            st.push(i);
        }
        return nse;
    }
    public static int[] findPSEE(int[]arr) {
        int[]psee = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; ++i) {
            while(!st.empty() && arr[i] < arr[st.peek()]) st.pop();
            psee[i] = !st.empty() ? st.peek() : -1;
            st.push(i);
        }
        return psee;
    }
    public static int sumSubarrayMins(int[]arr) {
        int sum = 0;
        int mod = (int)(1e9+7);
        int[]nse  = findNSE(arr);
        int[]psee = findPSEE(arr);
        
        for(int i = 0; i < arr.length; ++i) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }
    public static void main(String[]args) {
        int[]arr = {3, 1, 2, 4};
        //int[]arr = {11,81,94,43,3};
        log.info(sumSubarrayMins(arr));
    }
    private static final Log log = new Log();
}
/**
[3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]
 3 +  1  + 2  + 4  +  1   +  1   +  2   +   1   +    1    +   1 = 17
 */
/**
class SumOfSubarrayMinimum {

    static {for(int i = 0; i < 500; ++i) sumSubarrayMins(new int[]{});}
    
    private static int[] findPSEs(int[]arr) {
        int[]res = new int[arr.length];
        int[]stack = new int[arr.length];
        int top = -1;
        
        for(int i = arr.length-1; i >= 0; --i) {
            while(top > -1 && arr[i] < arr[stack[top]])
                res[stack[top--]] = i;
            
            res[i] = -1;
            stack[++top] = i;
        }
        return res;
    }
    private static int[] findNSEs(int[]arr) {
        int[]res = new int[arr.length];
        int[]stack = new int[arr.length];
        int top = -1;
        
        for(int i = 0; i < arr.length; ++i) {
            while(top > -1 && arr[i] <= arr[stack[top]])
                res[stack[top--]] = i;
            
            res[i] = arr.length;
            stack[++top] = i;
        }
        return res;
    }
    public static int sumSubarrayMins(int[]arr) {
        int mod = (int)(1e9 + 7);
        long sum = 0;
        int[]stack = new int[arr.length];
        int top = -1;
        
        for(int i = 0; i < arr.length; ++i) {
            while(top > -1 && arr[i] < arr[stack[top]]) {
                int NSE = i;
                int element = stack[top--];
                int PSE = top > -1 ? stack[top] : -1;
                sum = (sum + (1L * (element - PSE) * (NSE - element) * arr[element]) % mod) % mod;
            }
            stack[++top] = i;
        }
        int NSE = arr.length;
        while(top > -1) {
            int element = stack[top--];
            int PSE = top > -1 ? stack[top] : -1;
            sum = (sum + (1L * (element - PSE) * (NSE - element) * arr[element]) % mod) % mod;
        }
        return (int)sum;
    }
}
 */
