/*
  4Sum Problem :
  
  Given an array arr of n integers,
  return an array of all the unique quadruplets
  [arr[a], arr[b], arr[c], arr[d]] such that:

  0 <= a, b, c, d < n
  a, b, c, and d are distinct.
  arr[a] + arr[b] + arr[c] + arr[d] == target
  You may return the answer in any order.

  Example 1:
  Input: arr = [1,0,-1,0,-2,2], target = 0
  Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
          [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

  Example 2:
  Input: arr = [2,2,2,2,2], target = 8
  Output: [[2,2,2,2]]

  Example 3:
  Input: arr = [-3,-1,0,2,4,5], target = 0
  Output: [[-3,-1,0,4]]

  Example 4: 
  Input: arr = [1000000000,1000000000,1000000000,1000000000], target = -294967296
  Output: []
*/
import java.util.*;
class FourSome {
    public static List<List<Integer>> fourSum(int[]arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i < n; ++i) {
            if(i > 0 && arr[i] == arr[i-1]) continue;

            for(int j = n-1; j >= 0; --j) {
                if(j < n-1 && arr[j] == arr[j+1]) continue;

                int x = i+1, y = j-1;

                while(x < y) {
                    long sum = (long) arr[i]+arr[x]+arr[y]+arr[j];
                    if(sum < target) x++;
                    else if(sum > target) y--;
                    else {
                        List<Integer> temp = Arrays.asList(arr[i], arr[x], arr[y], arr[j]);
                        ans.add(temp);
                        x++; --y;

                        /* skipping the duplicates */
                        while(x < y && arr[x] == arr[x-1]) x++;
                        while(x < y && arr[y] == arr[y+1]) y--;
                    }
                }
            }
        }
        return ans;
        
    }
    
    public static void main(String[]args) {
        //int[]arr = {1,0,-1,0,-2,2}; int target = 8;
        //int[]arr = {2,2,2,2,2}; int target = 8;
        //int[]arr = {-3,-1,0,2,4,5}; int target = 0;
        int[]arr = {1000000000,1000000000,1000000000,1000000000}; int target = -294967296;
       
        log(fourSum(arr, target));
        //log(1000000000+1000000000+1000000000+1000000000);
        //int n = 1000000000;
        //1000000000
        //log(n+n);
    }
    public static void log(Object...args) {
        for(Object ob : args) System.out.println(ob);
    }
}

/* ***********************************************************************
 * this approach has a little fault that it changes i and j together
 * so we are not able to compare all the possibilities
 * that's why it will give wrong ans for int[]arr = {-3,-1,0,2,4,5};
 * expected: [[-3,-1,0,4]] geting:[]
 * but it passed 156/294 test cases
 *
 */
// public static List<List<Integer>> fourSum(int[]arr, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(arr);
//        int n = arr.length;
//        for(int i = 0, j = n-1; i < n && j >= 0; ++i, --j) {
//            if(i != 0 && arr[i] == arr[i-1]) continue;
//            if(j != n-1 && arr[j] == arr[j+1]) continue;
//            int x = i+1, y = j-1;
//            while(x < y) {
//                int sum = arr[i]+arr[j]+arr[x]+arr[y];
//                if(sum < target) x++;
//                else if(sum > target) y--;
//                else {
//                    List<Integer> temp =
//                    Arrays.asList(arr[i], arr[x], arr[y], arr[j]);
//                    ans.add(temp);
//                    x++; --y;
//                    /* skipping the duplicates */
//                    while(x < y && arr[x] == arr[x-1]) x++;
//                    while(x < y && arr[y] == arr[y+1]) y--;
//                }
//            }
//        }
//        return ans;
//    }
/* ***********************************************************************/
