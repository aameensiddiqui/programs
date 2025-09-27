class SearchRotated {

    public static int solution(int[]arr, int n, int target) {
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high-low) / 2;
            
            if(arr[mid] == target)
                return mid;

            // if left part is sorted
            if(arr[low] <= arr[mid]) {
                // if target is between arr[low] and arr[mid]
                if(arr[low] <= target && target <= arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            // if right part is sorted
            else {
                // if target is between arr[mid] and arr[high]
                if(arr[mid] <= target && target <= arr[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
    
    public static void main(String[]args) {
        int[]arr = {4,5,6,7,0,1,2};
        int n = 7;
        int target = 0;
        System.out.println(solution(arr, n, target));
    }
}
/*
 
import java.util.*;

public class tUf {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (arr.get(mid) == k)
                return mid;

            // if left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = 9, k = 1;
        int ans = search(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}
 */
