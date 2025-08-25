/*
  Given an integer array nums, return all the triplets

  [nums[i], nums[j], nums[k]]

  such that
  i != j, i != k, and j != k,

  and

  nums[i] + nums[j] + nums[k] == 0.

  Notice that the solution set must not contain duplicate triplets.
  ----------
  Example 1:

  Input: nums = [-1,0,1,2,-1,-4]
  Output: [[-1,-1,2],[-1,0,1]]
  Explanation: 
  nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
  The distinct triplets are [-1,0,1] and [-1,-1,2].
  Notice that the order of the output and the order of the triplets does not matter.

  Example 2:

  Input: nums = [0,1,1]
  Output: []
  Explanation: The only possible triplet does not sum up to 0.
  Example 3:

  Input: nums = [0,0,0]
  Output: [[0,0,0]]
  Explanation: The only possible triplet sums up to 0.
*/
import java.util.*;
import java.io.*;
class ThreeSome {
    public static List<List<Integer>> threeSum(int[]arr) {
        Set<List<Integer>> st = new HashSet<>();
        for(int i = 0; i < arr.length; ++i) {
            for(int j = i+1; j < arr.length; ++j) {
                for(int k = j+1; k < arr.length; ++k) {
                    if((arr[i]+arr[j]+arr[k]) == 0) {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                        list.sort(null);
                        st.add(list);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    public static void main(String[]args) {
        // int[]arr = {-1, 0, 1, 2, -1, -4};
        // int[]arr = {0, 0, 0};
        // int[]arr = {0, 1, 1};
        log(threeSum(arr));
        
        
        // String fileName = "3SumOutput.txt";
        // try(PrintWriter pr = new PrintWriter(new FileWriter(fileName))) {
        //     pr.println(threeSum(arr));
        //     log("[OK] writtern o/p in the file.");
        // } catch(Exception e) {
        //     log("[NOT OK] koi error aya: ", e.getMessage());
        //     e.printStackTrace();
        // }
    }   
    public static void log(Object...args) {
        for(Object ob : args) System.out.println(ob);
    }
}
