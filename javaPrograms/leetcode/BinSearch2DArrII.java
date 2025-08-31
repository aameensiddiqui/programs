class BinSearch2DArrII {
    private static final Log log = new Log();
    public static boolean searchMatrix(int[][]matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;
        while(row < n && col >= 0) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
    public static void main(String[]args) {
        int[][]matrix = {
            { 1,  4,  7, 11, 15},
            { 2,  5,  8, 12, 19},
            { 3,  6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 30;
        log.info(searchMatrix(matrix, target));
    }
}
/**
    public static boolean binarySearch(int[]arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    public static boolean searchMatrix(int[][]matrix, int target) {
        for(int i = 0; i < matrix.length; ++i) {
            boolean isThere = binarySearch(matrix[i], target);
            if(isThere) return true;
        }
        return false;
    }
 */
