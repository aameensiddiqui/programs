class TrappingRainwater {
    // s.c : O(1)
    // t.c : O(N)
    public static int trap(int[]arr) {
        int n = arr.length;
        int lmax = 0, rmax = 0;
        int lp = 0, rp = n-1;
        int total = 0;
        while(lp < rp) {
            if(arr[lp] < arr[rp]) {
                if(lmax < arr[lp])
                    lmax = arr[lp];
                else     
                    total += lmax - arr[lp];
                lp++;
            } else {
                if(rmax < arr[rp])
                    rmax = arr[rp];
                else     
                    total += rmax - arr[rp];
                rp--;
            }
        }
        return total;
    }
    public static void main(String[]args) {
        //int[]arr = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
        int[]arr = {4,2,0,3,2,5}; // 9
        log.info(trap(arr));
    }
    private static final Log log = new Log();
}
/**
    // s.c : O(N)
    // t.c : O(2N)
    public static int trap(int[]arr) {
        int n = arr.length;
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int[]suffixMax = new int[n];
        
        suffixMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; --i)
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);

        // we can reduce complexity by remembering leftMax below 
        for(int i = 0; i < n; ++i) {
            maxLeft  = Math.max(arr[i], maxLeft);
            maxRight = suffixMax[i];
            if(maxLeft > arr[i] && arr[i] < maxRight)
                total += Math.min(maxLeft, maxRight) - arr[i];
        }
        return total;
    }

 */
/**
    // space complexity : O(2N)
    // time  complexity : O(3N)
    public static int trap(int[]arr) {
        int n = arr.length;
        int total = 0;
        int[]prefixMax = new int[n];
        int[]suffixMax = new int[n];
        
        prefixMax[0] = arr[0];
        for(int i = 1; i < n; ++i)
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);

        suffixMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; --i)
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        
        for(int i = 0; i < n; ++i) {
            int maxLeft  = prefixMax[i];
            int maxRight = suffixMax[i];
            if(maxLeft > arr[i] && arr[i] < maxRight)
                total += Math.min(maxLeft, maxRight) - arr[i];
        }
        return total;
    }

 */
