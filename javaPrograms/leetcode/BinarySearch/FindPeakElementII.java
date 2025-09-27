class FindPeakElementII {
    private static final Log log = new Log();
    public static int findMaxEleInd(int[][]mat, int n, int m, int col) {
        int max = -1, index = -1;
        for(int i = 0; i < n; ++i) {
            if(mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
    public static int[] findPeakGrid(int[][]mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m-1;
        int[]arr = {-1, -1};
        while(low <= high) {
            int mid = (low+high)/2;
            int maxEleInd = findMaxEleInd(mat, n, m, mid);
            int left  = mid-1 >= 0 ? mat[maxEleInd][mid-1] : -1;
            int right = mid+1 < m  ? mat[maxEleInd][mid+1] : -1;
            if(left < mat[maxEleInd][mid] && mat[maxEleInd][mid] > right) {
                arr[0] = maxEleInd; arr[1] = mid;
                return arr;
            }
            else if(mat[maxEleInd][mid] > right) high = mid-1;
            else low = mid+1;
        }
        return arr;
    }
    public static void main(String[]args) {
        //int[][]matrix = {{1, 4}, {3, 2}};
        //int[][]matrix = {{10,20,15},{21,30,14},{7,16,32}};
        //int[][]matrix = {{70,50,40,30,20},{100,1,2,3,4}};
        int[][]matrix = {{1,10},{50,500},{40,2},{30,3},{20,4}};
        log.info(findPeakGrid(matrix));
    }
}
