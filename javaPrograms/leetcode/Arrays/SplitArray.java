/*

Split Array - Largest Sum

Problem Statement: Given an integer array 'A' of size 'N' and an integer 'K'.
Split the array 'A' into 'K' non-empty subarrays such that the largest sum of
any subarray is minimized. Your task is to return the minimized largest sum of the split.
A subarray is a contiguous part of the array.

Examples

Brute Force Approach
Algorithm / Intuition
Naive Approach: 
The extremely naive approach is to check all possible answers from max(arr[]) to sum(arr[]).
The minimum value for which we can make k subarrays will be our answer.

Algorithm:
First, we will find the maximum element and the summation of the given array.
We will use a loop(say maxSum) to check all possible answers from max(arr[]) to sum(arr[]).
Next, inside the loop, we will send 'maxSum', to the function countPartitions()
function to get the number of partitions.
The first value of 'maxSum', for which the number of partitions will be equal to 'k',
will be our answer. So, we will return that particular value of 'maxSum'.
Finally, if we are out of the loop, we will return max(arr[]) as there cannot exist
any answer smaller than that.
Dry-run: Please refer to the video for the dry-run.

Code

import java.util.*;

public class SplitArray {
    public static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions(a, maxSum) == k)
                return maxSum;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}


Output: The answer is: 60

Complexity Analysis

Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array,
sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible
values of time.
Inside the loop, we are calling the countPartitions() function for each number.
Now, inside the countPartitions() function, we are using a loop that runs for N times.

Space Complexity:  O(1) as we are not using any extra space to solve this problem.

Optimal Approach
Algorithm / Intuition
Optimal Approach(Using Binary Search): 
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the
appropriate half to eliminate, thereby reducing the search space by half.
It does this by determining a specific condition that ensures that the target is not
present in that half.

Upon closer observation, we can recognize that our answer space, represented as [max(arr[]),
sum(arr[])], is actually sorted. Additionally, we can identify a pattern that allows us
to divide this space into two halves: one consisting of potential answers and the other of
non-viable options. So, we will apply binary search on the answer space.

Algorithm:
Place the 2 pointers i.e. low and high: Initially, we will place the pointers.
The pointer low will point to max(arr[]) and the high will point to sum(arr[]).
Calculate the 'mid': Now, inside the loop, we will calculate the value of 'mid'
using the following formula:
mid = (low+high) / 2
Eliminate the halves based on the number of subarrays returned by countPartitions():
We will pass the potential value of 'maxSum', represented by the variable 'mid',
to the 'countPartitions()' function. This function will return the number of partitions
we can make.
If partitions > k: On satisfying this condition, we can conclude that the number
'mid' is smaller than our answer. So, we will eliminate the left half and consider the
right half(i.e. low = mid+1).
Otherwise, the value mid is one of the possible answers. But we want the minimum value.
So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
Finally, outside the loop, we will return the value of low as the pointer will be pointing
to the answer.
The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.

Note: Please make sure to refer to the video and try out some test cases of your own to
understand, how the pointer 'low' will be always pointing to the answer in this case.
This is also the reason we have not used any extra variable here to store the answer.

Dry-run: Please refer to the video for the dry-run.

Code

import java.util.*;

public class SplitArray {
    public static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(a, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}

Output:The answer is: 60.

Complexity Analysis

Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array,
sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop,
we are calling the countPartitions() function for the value of 'mid'.
Now, inside the countPartitions() function, we are using a loop that runs for N times.

Space Complexity:  O(1) as we are not using any extra space to solve this problem.
 */

class SplitArray {

    public static int cntPartitions(int[]arr, int maxSum) {
        int partitions = 1;
        long subArrSum = 0;
        for(int i = 0; i < arr.length; ++i) {
            if((subArrSum + arr[i]) <= maxSum) {
                subArrSum += arr[i];
            } else {
                partitions++;
                subArrSum = arr[i];
            }
        }
        return partitions;
    }
    
    public static int solution(int[]arr, int k) {
        int low = arr[0], high = 0;
        for(int i = 0; i < arr.length; ++i) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        while(low <= high) {
            int mid = low + (high-low) / 2;
            int partition = cntPartitions(arr, mid);
            if(partition > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
    
    public static void main(String[]args) {
        int[]arr = {1, 2, 3, 4, 5};
        int k = 2;
        log(solution(arr, k));
    }

    public static void log(Object ... args) {
        for(Object ob : args) System.out.println("***log*** "+ob);
    }
}
