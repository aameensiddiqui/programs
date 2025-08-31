/**
   {{1, 2}, {3, 4}, {5, 6}}

   to make 2d arrays behave like 1d arrays and access its elements
   like we do in 1d arrays

   {1, 2, 3, 4, 5, 6}

   to access 4 in 1d array we do
   i = 3 and arr[i] = arr[3] = 4;

   to access 4 in 2d array we can do
   i = 3 and arr[i/arr[0].length][i%arr[0].length]
   arr[3/2][3%2] = arr[1][1] = 4

   we can use this trick to do binarysearch on 2d arrays
 */
class BinSearch2DArr {
    private static final Log log = new Log();
    private static boolean searchMatrix(int[][]matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n*m-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(matrix[mid/m][mid%m] == target) return true;
            else if(matrix[mid/m][mid%m] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    
    public static void main(String[]args) {
        int[][]matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 20;
        log.info(searchMatrix(matrix, target));        
    }
}
/* *
   private static boolean binarySearch(int[]arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            log.info("mid = "+mid+" arr[mid] = "+arr[mid]);
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    private static boolean searchMatrix(int[][]matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; ++i) {
            if(matrix[i][0] <= target && target <= matrix[i][m-1]) {
                log.info(matrix[i], target);
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
 */
