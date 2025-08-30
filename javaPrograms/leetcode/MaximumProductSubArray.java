class MaximumProductSubArray {
    public static int maxProd(int[]arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        long res = Long.MIN_VALUE;
        long pre = 1, stuff = 1;
        for(int i = 0; i < n-1; ++i) {
            if(pre == 0) pre = 1;
            if(stuff == 0) stuff = 1;
            pre *= arr[i];
            stuff *= arr[n-i-1];
            res = Math.max(res, Math.max(pre, stuff));
        }
        return (int)res;
    }
    public static void main(String[]args) {
        Log log = new Log();
        int[]arr = {1, 2, 3, 4, 5, 0};
        //int[]arr = {2, 3, -2, 4};
        //int[]arr = {-2, 0, -1};
        //int[]arr = {-2};
        log.info(maxProd(arr));
    }
}
/*
    public static int maxProd(int[]arr) {
        if(arr.length == 1) return arr[0];
        long res = Long.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                long pro = 1;
                for(int k = i; k <= j; ++k) {
                    pro *= arr[k];
                    res = Math.max(pro, res);
                }
            }
        }
        return (int)res;
    }

 */
