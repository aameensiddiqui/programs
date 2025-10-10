import java.util.Deque;
import java.util.ArrayDeque;
class SumOfSubarrayRanges {
    static int[] findNSE(int[]arr) {
        int[]ans = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = arr.length-1; i >= 0; --i) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findPSE(int[]arr) {
        int[]ans = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < arr.length; ++i) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findNGE(int[]arr) {
        int[]ans = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = arr.length-1; i >= 0; --i) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findPGE(int[]arr) {
        int[]ans = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < arr.length; ++i) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public static long subarrayRanges(int[]arr) {
        int[]nge = findNGE(arr);
        int[]pge = findPGE(arr);
        int[]nse = findNSE(arr);
        int[]pse = findPSE(arr);
        long sum = 0;

        for(int i = 0; i < arr.length; ++i) {

            int leftSmaller = i - pse[i];
            int rightSmaller = nse[i] - i;
            long freqSmaller = rightSmaller * leftSmaller * 1L * arr[i];

            int leftGreater = i - pge[i];
            int rightGreater = nge[i] - i;
            long freqGreater = rightGreater * leftGreater * 1L * arr[i];
            
            sum += freqGreater - freqSmaller;
        }
        return sum;
    }
    public static void main(String[]args) {
        int[]arr = {1, 2, 3};
        log.info(subarrayRanges(arr));
    }
    private static final Log log = new Log();
}
/**
   Editorial
   
   Algorithm:

   1. Initialize an empty stack stack, get the size of nums as n.

   2. Iterate over every index from 0 to n (inclusive).
   For each index right, if either of the following two condition is met:
   index = n
   stack is not empty and nums[mid] >= nums[right], where mid is its top value:

   go to step 3.
   Otherwise, repeat step 2.

   3. Calculate the number of subarrays with nums[mid] as its minimum value:
   Pop mid from stack.
   If stack is empty, set left = -1, otherwise, left equals the top element from stack.
   Increment answer by (right - mid) * (mid - left).
   
   Repeat step 2.

   Implementation:

class Solution {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Stack<Integer> stack = new Stack<>();

        // Find the sum of all the minimum.
        for (int right = 0; right <= n; ++right) {
            while (
                   !stack.isEmpty() &&
                   (right == n || nums[stack.peek()] >= nums[right])
                   ) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer -= (long) nums[mid] * (right - mid) * (mid - left);
            }
            stack.add(right);
        }

        // Find the sum of all the maximum.
        stack.clear();
        for (int right = 0; right <= n; ++right) {
            while (
                   !stack.isEmpty() &&
                   (right == n || nums[stack.peek()] <= nums[right])
                   ) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer += (long) nums[mid] * (right - mid) * (mid - left);
            }
            stack.add(right);
        }
        return answer;
    }
}

   Complexity Analysis:
   
   Let n be the size of the input array nums.

   Time complexity: O(n)

   To find the total sum of minVal, we only need one iteration over nums,
   and each number will be added to and popped from stack once,
   these also apply for finding maxVal.

   Therefore the overall time complexity is O(n).
   Space complexity: O(n)

   We use a (monotonic) stack to keep the increasing (decreasing) sequence,
   in the worst-case scenario, there may be O(n) numbers in the stack,
   which takes O(n) space.
   
 */
/**
class SumOfSubarrayRanges {

    static {for(int i = 0; i <= 500; ++i) subArrayRanges(new int[]{});
    
    // -------------------------
    // Next Greater (-> to the right)
    // -------------------------
    public static  int[] findNextGreaterElements(int[] arr) {
        int[] stack = new int[arr.length];
        int[] nextGreaterElements = new int[arr.length];
        int top = -1;

        Arrays.fill(nextGreaterElements, arr.length); // if none, use n as boundary

        for(int i = 0; i < arr.length; ++i) {
            while(top != -1 && arr[i] > arr[stack[top]]) {
                nextGreaterElements[stack[top--]] = i;
            }
            stack[++top] = i;
        }
        return nextGreaterElements;
    }

    // -------------------------
    // Next Smaller (-> to the right)
    // -------------------------
    public static int[] findNextSmallestElements(int[] arr) {
        int[] stack = new int[arr.length];
        int[] nextSmallerElements = new int[arr.length];
        int top = -1;

        Arrays.fill(nextSmallerElements, arr.length); // boundary = n

        for(int i = 0; i < arr.length; ++i) {
            while(top != -1 && arr[i] < arr[stack[top]]) {
                nextSmallerElements[stack[top--]] = i;
            }
            stack[++top] = i;
        }
        return nextSmallerElements;
    }

    // -------------------------
    // Prev Greater (<- to the left)
    // -------------------------
    public static int[] findPrevGreaterElements(int[] arr) {
        int[] stack = new int[arr.length];
        int[] prevGreaterElement = new int[arr.length];
        int top = -1;

        Arrays.fill(prevGreaterElement, -1); // boundary = -1

        for(int i = arr.length - 1; i >= 0; --i) {
            while(top != -1 && arr[i] >= arr[stack[top]]) {
                prevGreaterElement[stack[top--]] = i;
            }
            stack[++top] = i;
        }
        return prevGreaterElement;
    }

    // -------------------------
    // Prev Smaller (<- to the left)
    // -------------------------
    public static int[] findPrevSmallestElements(int[] arr) {
        int[] stack = new int[arr.length];
        int[] prevSmallerElement = new int[arr.length];
        int top = -1;

        Arrays.fill(prevSmallerElement, -1); // boundary = -1

        for(int i = arr.length - 1; i >= 0; --i) {
            while(top != -1 && arr[i] <= arr[stack[top]]) {
                prevSmallerElement[stack[top--]] = i;
            }
            stack[++top] = i;
        }
        return prevSmallerElement;
    }

    // -------------------------
    // Main function: sum of subarray ranges
    // -------------------------
    public static long subArrayRanges(int[] arr) {
        int n = arr.length;

        int[] nextGreater = findNextGreaterElements(arr);
        int[] prevGreater = findPrevGreaterElements(arr);
        int[] nextSmaller = findNextSmallestElements(arr);
        int[] prevSmaller = findPrevSmallestElements(arr);

        long sum = 0;

        for(int i = 0; i < n; ++i) {
            long leftGreater = i - prevGreater[i];
            long rightGreater = nextGreater[i] - i;
            long freqGreater = leftGreater * rightGreater * 1L * arr[i];

            long leftSmaller = i - prevSmaller[i];
            long rightSmaller = nextSmaller[i] - i;
            long freqSmaller = leftSmaller * rightSmaller * 1L * arr[i];

            sum += freqGreater - freqSmaller;
        }

        return sum;
    }
}
  
 */
