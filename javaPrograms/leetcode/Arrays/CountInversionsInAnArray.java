/*
  Count inversions in an array

  Problem Statement: Given an array of N integers, count the inversion of the array
  (using merge-sort).

  What is an inversion of an array? Definition: for all i & j < size of array,
  if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

  Examples

  Example 1:
  Input Format: N = 5, array[] = {1,2,3,4,5}
  Result: 0
  Explanation: we have a sorted array and the sorted array has 0 inversions as for
  i < j you will never find a pair such that A[j] < A[i]. More clear example: 2 has
  index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

  Example 2:
  Input Format: N = 5, array[] = {5,4,3,2,1}
  Result: 10
  Explanation: we have a reverse sorted array and we will get the maximum inversions
  as for i < j we will always find a pair such that A[j] < A[i]. Example: 5 has index
  0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy
  out conditions and for reverse sorted array we will get maximum inversions and that
  is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

  Example 3:
  Input Format: N = 5, array[] = {5,3,2,1,4}
  Result: 7
  Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and
  we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition.
 */
import java.util.ArrayList;
class CountInversionsInAnArray {
    public static int merge(int[]arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt = 0;
        while(left <= right && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += mid-left+1; /* imp modification */
                right++;
            }
        }
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; ++i) arr[i] = temp.get(i-low);
        // Log log = new Log();
        // log.info(arr);
        return cnt;
    }
    public static int mergeSort(int[]arr, int low, int high) {
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }
    public static int cntInvArr(int[]arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }
    public static void main(String[]args) {
        Log log = new Log();
        int[]arr = {5,4,3,2,1};
        log.info(cntInvArr(arr));
        log.info(arr);
    }
}
