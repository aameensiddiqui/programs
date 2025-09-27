/**
   47. Permutations II
   Given a collection of numbers, nums, that might contain duplicates,
   return all possible unique permutations in any order.

   Example 1:
   Input: nums = [1,1,2]
   Output:
   [[1,1,2],
   [1,2,1],
   [2,1,1]]
   
   Example 2:
   Input: nums = [1,2,3]
   Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
   Constraints:
   1 <= nums.length <= 8
   -10 <= nums[i] <= 10
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class PermutationsII {
    public static void backtrack(List<List<Integer>> ans, List<Integer> list, int[]arr, boolean[]used) {
        if(list.size() == arr.length) ans.add(new ArrayList<>(list));
        else {
            for(int i = 0; i < arr.length; ++i) {
                if(used[i] || i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
                list.add(arr[i]);
                used[i] = true;
                backtrack(ans, list, arr, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    public static List<List<Integer>> permuteUnique(int[]arr) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[]used = new boolean[arr.length];
        Arrays.sort(arr);
        backtrack(ans, new ArrayList<>(), arr, used);
        return ans;
    }
    public static void main(String[]args) {
        // int[]arr = {1, 1, 2};
        // int[]arr = {1, 2, 3};
        int[]arr = {3, 3, 0, 3};
        log.info(permuteUnique(arr));
        
        /* getting:
          [[3,3,0,3],[3,3,3,0],[3,0,3,3],[3,0,3,3],[3,3,3,0],[3,3,0,3],
          [0,3,3,3],[0,3,3,3],[0,3,3,3],[3,3,3,0],[3,3,0,3],[3,0,3,3]]

          expected:
          [[0,3,3,3],[3,0,3,3],[3,3,0,3],[3,3,3,0]]

          solution: array needs to be sorted first  */
    }
    private static final Log log = new Log();
}
