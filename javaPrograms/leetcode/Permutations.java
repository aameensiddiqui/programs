/**
   46. Permutations
   Given an array nums of distinct integers, return all the possible permutations.
   You can return the answer in any order.

   Example 1:
   Input: nums = [1,2,3]
   Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

   Example 2:
   Input: nums = [0,1]
   Output: [[0,1],[1,0]]

   Example 3:
   Input: nums = [1]
   Output: [[1]]
*/
import java.util.*;
class Permutations {
    public static void backtrack(List<List<Integer>> ans, List<Integer> list, int[]arr) {
        if(list.size() == arr.length) ans.add(new ArrayList<>(list));
        else {
            for(int i = 0; i < arr.length; ++i) {
                if(list.contains(arr[i])) continue;
                list.add(arr[i]);
                backtrack(ans, list, arr);
                list.remove(list.size()-1);
            }
        }
    }
    public static List<List<Integer>> permute(int[]arr) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), arr);
        return ans;
    }
    public static void main(String[]args) {
        int[]arr = {1, 2, 3};
        log.info(permute(arr));
    }
    private static final Log log = new Log();
}
