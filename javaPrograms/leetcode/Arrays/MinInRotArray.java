class MinInRotArray {

    public static int solution(int[]arr) {
        int low = 0;
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;
        
        while(low <= high) {
            int mid = low + (high-low) / 2;

            // for cases where the array is sorted all the way
            if(arr[low] <= arr[high]) min = Math.min(min, arr[low]);
            
            // if left part is sorted
            if(arr[low] <= arr[mid]) {
                min = Math.min(arr[low], min);
                low = mid+1;
            }
            // if right part is sorted
            else {
                min = Math.min(arr[mid], min);
                high = mid-1;
            }
        }
        return min;
    }
    
    public static void main(String[]args) {
        int[]arr = {4,5,6,7,0,1,2};
        System.out.println(solution(arr));
    }
}
