/*
  39. Combination Sum

  Given an array of distinct integers candidates and a target integer target,
  return a list of all unique combinations of candidates where the chosen numbers
  sum to target. You may return the combinations in any order.

  The same number may be chosen from candidates an unlimited number of times.
  Two combinations are unique if the frequency of at least one of the chosen numbers
  is different.

  The test cases are generated such that the number of unique combinations that sum
  up to target is less than 150 combinations for the given input.

  Example 1:
  Input: candidates = [2,3,6,7], target = 7
  Output: [[2,2,3],[7]]
  Explanation:
  2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
  7 is a candidate, and 7 = 7.
  These are the only two combinations.

  Example 2:
  Input: candidates = [2,3,5], target = 8
  Output: [[2,2,2,2],[2,3,3],[3,5]]

  Example 3:
  Input: candidates = [2], target = 1
  Output: []
 
  Constraints:
  1 <= candidates.length <= 30
  2 <= candidates[i] <= 40
  All elements of candidates are distinct.
  1 <= target <= 40
*/
import java.util.ArrayList;
import java.util.List;
class CombinationSum {
    public static void findCombinations(
                  int index, int[]arr, int target,
                  List<List<Integer>> ans, List<Integer> ds) {
        if(index == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(index, arr, target-arr[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1, arr, target, ans, ds);
    }
    public static List<List<Integer>> combinationSum(int[]arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[]args) {
        int[]arr = {2,3,6,7};
        int target = 7;
        log.info(combinationSum(arr, target));
    }
    private static final Log log = new Log();
}
/**
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new java.util.AbstractList(){
            List<List<Integer>> result;
            private void init(){
                result = new ArrayList();
                backtrack(0, target, candidates, new ArrayList(), result);
            }
            @Override
            public int size(){
                if(result == null){
                    init();
                }
                return result.size();
            }
            @Override
            public List<Integer> get(int position){
                return result.get(position);
            }
        };
    }
    private void backtrack(int index, int target, 
    int[] candidates, List<Integer>list, List<List<Integer>>result){
        if(target == 0){
            result.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            int remain = target - candidates[i];
            if(remain >= 0){
                list.add(candidates[i]);
                backtrack(i, remain, candidates, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
 */
