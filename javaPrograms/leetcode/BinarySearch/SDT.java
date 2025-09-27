class SDT
{
    public static int sumDiv(int[]arr, int div) {
        int sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }
    
    public static int solution(int[]arr, int t)
    {
        if(arr.length > t) return -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > max) max = arr[i];
        }
        int low = 1, high = max;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(sumDiv(arr, mid) <= t) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
                   
    public static void main(String[]args)  
    {
        int[]arr = {44,22,33,11,1};
        //int[]arr = {1, 2, 5, 9};
        // o/p---->   1  1  1  2 = 5
        int t = 5;
        int ans = solution(arr, t);
        System.out.println(ans);
    }
}
