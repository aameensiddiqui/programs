class SquareRootBinarySearch {

    public static int squareRoot(int n) {
        int low = 1, high = n;
        while(low <= high) {
            long mid = (low + high) / 2;
            long square = mid*mid;
            if(square == n) return (int)mid;
            else if(square < n) low = (int)(mid+1);
            else high = (int)(mid-1);
        }
        return high;
    }
/*
Given two numbers N and M, find the Nth root of M.
The nth root of a number M is defined as a number X
when raised to the power N equals M.
If the 'nth root is not an integer, return -1.
*/
    // to save from lossy conversions
    public static int func(int mid, int n, int m) {
        long ans = 1;
        for(int i = 1; i <= n; ++i) {
            ans = ans * mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    
    public static int nthRoot(int n, int m) {
        int low = 1, high = m;
        while(low <= high) {
            int mid = (low + high) / 2;
            int val = func(mid, n, m);
            if(val == 1) return mid;
            else if(val == 0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    
    public static void main(String[]args) {
        int n = 5;
        int m = 1024;
        // System.out.println(squareRoot(n));
        System.out.println(nthRoot(n, m));
    }
}
