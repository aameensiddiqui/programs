// contains duplicate values
// there for an edge case can arise arr[low] = arr[mid] = arr[high]
// in this case, the SearchRotated will not work
// to make it work, simply increment low by 1 and decrement high by 1
// until the edge case is no longer satisfied
class SearchRotatedII {

    public static boolean solution(int[]arr, int target) {
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high) {
            int mid = low + (high-low) / 2;
            
            if(arr[mid] == target)
                return true;

            // edge case
            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low+1;
                high = high-1;
                continue;
            }
            
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
        return false;
    }
    
    public static void main(String[]args) {
        int[]arr = {1,0,1,1,1};
        int target = 0;
        System.out.println(solution(arr, target));
    }
}
