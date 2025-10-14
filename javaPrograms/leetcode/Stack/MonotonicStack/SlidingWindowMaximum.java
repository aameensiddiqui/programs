import java.util.*;
class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int[]ans = new int[n-k+1];
        for(int i = 0; i < n; ++i) {
            if(!dq.isEmpty() && dq.peek() == i-k)
                dq.poll();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offer(i);
            if(i >= k-1) ans[index++] = nums[dq.peek()];
        }
        return ans;
    }
    public static void main(String[]args) {
        int[]arr1 = {1,3,-1,-3,5,3,6,7};
        int[]arr2 = {1};
        log.info(maxSlidingWindow(arr1, 3));
        log.info(maxSlidingWindow(arr2, 1));
    }
    private static final Log log = new Log();
}
/**
    public static int getMax(int[]nums, int l, int r) {
        int maxx = 0;
        for(int i = l; i <= r; ++i) {
            maxx = Math.max(maxx, nums[i]);
        }
        return maxx;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[]ans = new int[n-k+1];
        int left = 0, right = k-1;
        int i = 0;
        while(right < n) {
            ans[i++] = getMax(nums, left, right);
            left++; right++;
        }
        return ans;
    }
 */
/**
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[]ans = new int[n-k+1];
        for(int i = 0; i < n; ++i) {    
            int max = Integer.MIN_VALUE;
            if(i+k <= n) {
                int temp = k;
                int j = i;
                while(temp > 0) {
                    max = Math.max(max, nums[j]);
                    temp--;  j++;
                }
                ans[i] = max;
            }
        }
        return ans;
    }
 */
