/**
   503. Next Greater Element II

   Given a circular integer array nums
   (i.e., the next element of nums[nums.length - 1] is nums[0]),
   return the next greater number for every element in nums.

   The next greater number of a number x is the first greater number
   to its traversing-order next in the array, which means you could
   search circularly to find its next greater number. If it doesn't exist,
   return -1 for this number.

   Example 1:
   Input: nums = [1,2,1]
   Output: [2,-1,2]
   Explanation: The first 1's next greater number is 2; 
   The number 2 can't find next greater number. 
   The second 1's next greater number needs to search circularly, which is also 2.

   Example 2:
   Input: nums = [1,2,3,4,3]
   Output: [2,3,4,-1,4]

   Constraints:
   1 <= nums.length <= 104
   -109 <= nums[i] <= 109
*/
import java.util.Stack;
class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[]ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1; i >= 0; --i) {
            while(!st.empty() && st.peek() <= nums[i%n])
                st.pop();
            if(i < n) ans[i] = st.empty() ? -1 : st.peek();
            st.push(nums[i%n]); 
        }
        return ans;
    }
    public static void main(String[]args) {
        //int[]nums = {1, 2, 1};
        int[]nums = {5, 4, 3, 2, 1};
        log.info(nextGreaterElements(nums));
    }
    private static final Log log = new Log();
}
/**
   // works fine but O(n^2)
   public static int[] nextGreaterElements(int[] nums) {
        int[]ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for(int i = 0; i < nums.length; ++i) {
            int curr = nums[i];
            for(int j = 1; j < nums.length; ++j) {
                int index = (i+j) % nums.length;
                if(nums[index] > curr) {
                    ans[i] = nums[index];
                    break;
                }
            }
        }
        return ans;
    }
 */
/**
   // won't work for [5,4,3,2,1] input
   // expected : [-1,5,5,5,5]
   // getting  : [-1,5,4,3,2]
   public static int[] nextGreaterElements(int[] nums) {
        int[]ans = new int[nums.length];
        for(int i = 0; i < nums.length; ++i) {
            boolean found = false;
            for(int j = i+1; j < nums.length; ++j) {
                if(nums[i] < nums[j]) {ans[i] = nums[j]; found = true;}
            }
            for(int j = i-1; j >= 0; --j) {
                if(nums[i] < nums[j]) {ans[i] = nums[j]; found = true;}
            }
            if(!found) ans[i] = -1;
        }
        return ans;
    }
 */
/**
 public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int top = -1;
        int[]ans   = new int[n];
        int[]stack = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = 0; i < 2*n; i++) {
            int num = nums[i%n];
            while(top >= 0 && nums[stack[top]] < num)
                ans[stack[top--]] = num;
            if(i < n) stack[++top] = i;
        }
        return ans;

    }
 */
