import java.util.*;
class SubsetsRecursionII {
    public static void backtrack(List<List<Integer>> ans,
                                 List<Integer> list,
                                 int[]arr, int start) {
        ans.add(new ArrayList<>(list));
        for(int i = start; i < arr.length; ++i) {
            if(i > start && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            log.info("before backtracking: "+list);
            backtrack(ans, list, arr, i+1);
            log.info("after  backtracking: "+list);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[]arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(ans, list, arr, 0);
        return ans;
    }
    public static void main(String[]args) {
        //int[]arr = {1, 2, 2};
        int[]arr = {4, 4, 4, 1, 4};
        log.info(subsetsWithDup(arr));
    }
    private static final Log log = new Log();
}
/**
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], ans, 0);
        return ans;
    }

    public void f(int[] nums, int i, int[] path, List<List<Integer>> ans, int size) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int index = 0; index < size; index++) cur.add(path[index]);
            ans.add(cur);
        } else {
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) j++;

            f(nums, j, path, ans, size);

            for (; i < j; ) {
                path[size++] = nums[i++];
                f(nums, j, path, ans, size);
            }
        }
    }
}
 */
