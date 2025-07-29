/*
The upper bound algorithm finds the first or the smallest
index in a sorted array where the value at that index is
greater than the given key i.e. x.

The upper bound is the smallest index, ind, where arr[ind] > x.

But if any such index is not found, the upper bound algorithm
returns n i.e. size of the given array. The main difference
between the lower and upper bound is in the condition.
For the lower bound the condition was arr[ind] >= x and here,
in the case of the upper bound, it is arr[ind] > x.

Case 1 - If arr[mid] > x: This condition means that the index
mid may be an answer. So, we will update the 'ans' variable
with mid and search in the left half if there is any smaller
index that satisfies the same condition. Here, we are
eliminating the right half.

Case 2 - If arr[mid] <= x: In this case, mid cannot be our
answer and we need to find some bigger element. So, we will
eliminate the left half and search in the right half for the
answer.
*/

class UpperBound {

    public static int solution(int[]arr, int n, int x) {
        int low = 0, high = n-1, ans = n;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }
    
    public static void main(String[]args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int index = solution(arr, n, x);
        System.out.println(index);
    }
}
