import java.util.Map;
import java.util.HashMap;
class BinarySubarraysWithSum {
    public static int atMost(int[]nums, int goal) {
        if(goal < 0) return 0;
        int left = 0;
        int count = 0;
        int sum = 0;
        for(int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static int numSubarraysWithSum(int[]nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
    public static void main(String[]args) {
        int[]nums1 = {1, 0, 1, 0, 1};
        int[]nums2 = {0, 0, 0, 0, 0};
        int goal1 = 2;
        int goal2 = 0;
        log.info(numSubarraysWithSum(nums1, goal1));
        log.info(numSubarraysWithSum(nums2, goal2));
    }
    private static final Log log = new Log();
}
/**
   public static int numSubarraysWithSum(int[]nums, int goal) {
        Map<Integer, Integer> prefixSumCnt = new HashMap<>();
        int count = 0, sum = 0;
        prefixSumCnt.put(0, 1);
        for(int n : nums) {
            sum += n;
            if(prefixSumCnt.containsKey(sum - goal))
                count += prefixSumCnt.get(sum - goal);
            prefixSumCnt.put(sum, prefixSumCnt.getOrDefault(sum, 0)+1);
        }
        return count;
    }
 */
/**
    public static int numSubarraysWithSum(int[]nums, int goal) {
        int count = 0;
        for(int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for(int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if(sum == goal) count++;
            }
        }
        return count;
    }

 */
