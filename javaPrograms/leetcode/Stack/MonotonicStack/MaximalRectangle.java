import java.util.*;
class MaximalRectangle {
    private static int largestRectangleArea(int[]arr) {
        int n = arr.length, maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i <= n; ++i) {
            while(!st.isEmpty() && (i == n || arr[st.peek()] > arr[i])) {
                int h = arr[st.pop()];
                int w = st.isEmpty() ? (i) : (i-1-st.peek());
                maxArea = Math.max(maxArea, (h * w));
            }
            st.push(i);
        }
        return maxArea;
    }

    public static int maximalAreaOfSubMatrixOfAll1(int[][]matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]prefixSum = new int[n][m];
        for(int j = 0; j < m; ++j) {
            int sum = 0;
            for(int i = 0; i < n; ++i) {
                sum += matrix[i][j];
                if(matrix[i][j] == 0) {
                    prefixSum[i][j] = 0;
                    sum = 0;
                } else prefixSum[i][j] = sum;
            }
        }
        int maxArea = 0;
        for(int i = 0; i < n; ++i)
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[i]));
        return maxArea;
    }
    
    public static void main(String[]args) {
        int[][]matrix = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };
        int[][]matrix2 = {{0}};
        int[][]matrix3 = {{1}};
        log.info(maximalAreaOfSubMatrixOfAll1(matrix));
        log.info(maximalAreaOfSubMatrixOfAll1(matrix2));
        log.info(maximalAreaOfSubMatrixOfAll1(matrix3));
    }
    private static final Log log = new Log();
}
