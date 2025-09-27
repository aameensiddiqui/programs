/*
Problem Statement: Given an array of length N. Peak
element is defined as the element greater than both
of its neighbors. Formally, if arr[i] is the peak element if

arr[i-1] < arr[i] && arr[i] > arr[i+1]

Find the index(0-based) of a peak element in the array.
If there are multiple peak numbers, return the index of any peak number.


[1, 2, 3, 4, 5, 6, 7, 8, 5, 1]
------------------->  |  <---- decreasing right half
increasing left half  peak

If arr[i] > arr[i-1]: we are in the left half.
If arr[i] > arr[i+1]: we are in the right half.

For multiple peaks,
If arr[mid] comes either in left or right half, eliminate that half.

*/
class PeakElement {

    public static int solution(int[]arr) {
         int n = arr.length;

         // handle the edge cases
         if(n == 1) return 0;
         if(arr[0] > arr[1]) return 0;
         if(arr[n-2] < arr[n-1]) return n-1;

         int low = 1, high = n-2;
         while(low <= high) {
             int mid = (low + high) / 2;

             // if arr[mid] peak number, return its index
             if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1])
                 return mid;

             // if arr[mid] is in left half, eliminate that half
             if(arr[mid-1] < arr[mid]) low = mid+1;

             // else arr[mid] is in right half, eliminate that half
             else high = mid-1;
         }
         return -1;
    }
    
    public static void main(String[]args) {
        int[]arr = {1,2,1,3,5,6,4}; // o/p should be 5
        System.out.println(solution(arr));
    }
}
