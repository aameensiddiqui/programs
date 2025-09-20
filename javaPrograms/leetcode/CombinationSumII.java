/**
   40. Combination Sum II

   Given a collection of candidate numbers (candidates) and a target number (target),
   find all unique combinations in candidates where the candidate numbers sum to target.

   Each number in candidates may only be used once in the combination.

   Note: The solution set must not contain duplicate combinations.

   Example 1:
   Input: candidates = [10,1,2,7,6,1,5], target = 8
   Output: 
   [
   [1,1,6],
   [1,2,5],
   [1,7],
   [2,6]
   ]
   
   Example 2:
   Input: candidates = [2,5,2,1,2], target = 5
   Output: 
   [
   [1,2,2],
   [5]
   ]
 
   Constraints:
   1 <= candidates.length <= 100
   1 <= candidates[i] <= 50
   1 <= target <= 30
*/
import java.util.*;
class CombinationSumII {
    public static void backtrack(List<List<Integer>> ans, List<Integer> list, int[]arr, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) ans.add(new ArrayList<>(list));
        else {
            for(int i = start; i < arr.length; ++i) {
                if(i > start && arr[i] == arr[i-1]) continue;
                list.add(arr[i]);
                backtrack(ans, list, arr, remain-arr[i], i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum2(int[]arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(ans, new ArrayList<>(), arr, target, 0);
        return ans;
    }
    public static void main(String[]args) {
        //int[]arr = {10, 1, 2, 7, 6, 1, 5}; int target = 8;
        int[]arr = {2, 5, 2, 1, 2}; int target = 5;
        log.info(combinationSum2(arr, target));
    }
    private static final Log log = new Log();
}
/**
import java.util.AbstractList;

class Solution {
    private void combinationSum2(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;
            list.add(candidates[i]);
            combinationSum2(candidates, target-candidates[i], i+1, list, ans);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> getResults(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum2(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ans;
            @Override
            public int size() {
                if(ans == null) ans = getResults(candidates, target);
                return ans.size();
            }
            @Override
            public List<Integer> get(int index) {
                if(ans == null) ans = getResults(candidates, target);
                return ans.get(index);
            }
        };
    }
}
 */
