/**
   Problem Statement: Given an array arr of size n containing elements,
   find the next greater element for each element in the array in the order
   of their appearance.

   The next greater element of an element in the array is the nearest element
   on the right that is greater than the current element.

   If there does not exist a next greater element for the current element,
   then the next greater element for that element is -1.

   Example 1:
   Input: arr = [1, 3, 2, 4]  
   Output: [3, 4, 4, -1]  
   Explanation:  
   The next greater element for 1 is 3, for 3 is 4, for 2 is 4, and for 4 is -1
   (no greater element on the right).

   Example 2:
   Input: arr = [6, 8, 0, 1, 3]  
   Output: [8, -1, 1, 3, -1]  
   Explanation:  
   The next greater element for 6 is 8, for 8 is -1, for 0 is 1, for 1 is 3, and for 3 is -1.
 */
import java.util.*;
class NextGreaterElementToRight {
    public static int[] nger(int[]arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[]res = new int[n];
        Arrays.fill(res, -1);
        for(int i = n-1; i >= 0; --i) {
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if(!st.isEmpty()) res[i] = st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[]args) {
        int[]arr = {1, 3, 2, 4};
        int[]arr2 = {6, 8, 0, 1, 3};
        log.info(nger(arr));
        log.info(nger(arr2));
    }
    private static final Log log = new Log();
}
