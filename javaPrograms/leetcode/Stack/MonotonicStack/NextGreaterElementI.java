import java.util.Stack;
import java.util.HashMap;
class NextGreaterElementI {
    public static int[] nextGreaterElement(int[]nums1, int[]nums2) {
        int[]ans = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = nums2.length-1; i >= 0; --i) {
            while(!st.empty() && st.peek() <= nums2[i]) st.pop();
            if(st.empty()) freq.put(nums2[i], -1);
            else freq.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; ++i)
            ans[i] = freq.get(nums1[i]);
        return ans;
    } 
    public static void main(String[]args) {
        int[]nums1 = {4, 2, 1};
        int[]nums2 = {1, 3, 4, 2};
        log.info(nextGreaterElement(nums1, nums2));
    }
    private static final Log log = new Log();
}
/**
   public static int[] nextGreaterElement(int[]nums1, int[]nums2) {
        int[]ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; ++i) {
            boolean found = false;
            for(int j = 0; j < nums2.length; ++j) {
                if(nums1[i] == nums2[j]) {
                    for(int k = j+1; k < nums2.length; k++) {
                        if(nums2[k] > nums2[j]) {
                            ans[i] = nums2[k];
                            found = true;
                            break;
                        }
                    }
                    if(!found) ans[i] = -1;
                }
            }
        }
        return ans;
    }
 */
