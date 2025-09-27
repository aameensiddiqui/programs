/*
Given an integer array arr of size N, sorted in ascending
order (with distinct values).
Now the array is rotated between 1 to N times which is
unknown. Find how many times the array has been rotated.

logic:
find the index of the minimum integer in the array
that will be your ans for how many times the array has been
rotated.
*/
class RotatedTimes {

    public static int solution(int[]arr) {
        int low = 0;
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[low] <= arr[high]) {
                if(arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
            }
            if(arr[low] <= arr[mid]) {
                if(arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid+1;
            }
            else {
                if(arr[mid] <= arr[high]) {
                    if(arr[mid] < min) {
                        min = arr[mid];
                        index = mid;
                    }
                    high = mid-1;
                }
            }
        }
        return index;
    }
    
    public static void main(String[]args) {
        int[]arr = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(solution(arr));
    }
}
