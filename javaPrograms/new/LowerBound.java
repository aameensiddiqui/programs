/*
What is Lower Bound?
The lower bound algorithm finds the first or the smallest index in a
sorted array, where the value at that index is greater than or equal
to a given key i.e. x.

The lower bound is the smallest index, where arr[index] >= x.
But if any such index is not found, the lower bound algorithm returns n
i.e. size of the given array.

Case 1 - If arr[mid] >= x: This condition means that the index mid may
be an answer. So, we will update the 'ans' variable with mid and search
in the left half if there is any smaller index that satisfies the same
condition. Here, we are eliminating the right half.

Case 2 - If arr[mid] < x: In this case, mid cannot be our answer and we
need to find some bigger element. So, we will eliminate the left half
and search in the right half for the answer.

 */
class LowerBound {
    public static int solution(int[]arr, int n, int x) {
        int low = 0, high = n - 1, ans = n;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] >= x) {
                ans = mid;      // maybe an answer
                high = mid - 1; //look for smaller index on the left
            }
            else low = mid + 1; //look on the right
        }
        return ans;
    }
    
    public static void main(String[]args) {
        int[]arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int index = solution(arr, n, x);
        System.out.println(index);
    }
}
