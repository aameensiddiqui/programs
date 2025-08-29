/* *
 * 493. Reverse Pairs
 *
 * Given an integer array nums, return the number of reverse pairs in the array.
 *
 * A reverse pair is a pair (i, j) where:
 *
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,3,1]
 * Output: 2
 * Explanation: The reverse pairs are:
 * (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
 * (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
 * Example 2:
 *
 * Input: nums = [2,4,3,5,1]
 * Output: 3
 * Explanation: The reverse pairs are:
 * (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
 * (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
 * (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 */
import java.util.*;

class ReversePairs {

    public static void merge(int[]arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> list = new ArrayList<>();
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while(left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while(right <= high) {
            list.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; ++i) {
            arr[i] = list.get(i-low);
        }
    }
    public static int mergeSort(int[]arr, int low, int high) {
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }
    public static int countPairs(int[]arr, int low, int mid, int high) {
        int cnt = 0;
        int right = mid+1;
        for(int i = low; i <= mid; ++i) {
            while(right <= high && ((long)arr[i] > 2L*arr[right]))
                right++;
            cnt += (right-(mid+1));
        }
        return cnt;
    }
    public static int reversePairs(int[]arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }
    
    public static void main(String[]args) {
        Log log = new Log();
        //int[]arr = {1,3,2,3,1};
        //int[]arr = {2,4,3,5,1};
        int[]arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}; // 0
        log.info(reversePairs(arr));
    } 
}
/* *
 *   public static int reversePairs(int[]arr) {
 *      int n = arr.length;
 *      int cnt = 0;
 *      for(int i = 0; i < n; ++i) {
 *          for(int j = i+1; j < n; ++j) {
 *              long m = 2L * arr[j];
 *              if((long)arr[i] > m) cnt++;
 *              
 *          }            
 *      }
 *      return cnt;
 *  }
 */
