class ThirdMaxNum
{
    public static int solution(int[]arr)
    {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == max1 || arr[i] == max2 || arr[i] == max3) continue;
            if(arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] > max2 && arr[i] < max1) {
                max3 = max2;
                max2 = arr[i];
            }
            else if(arr[i] > max3 && arr[i] < max2) max3 = arr[i];
        }
        
        if(max3 == Long.MIN_VALUE) return (int) max1;
        return (int) max3;
    }
    
    public static void main(String[]args)
    {
        int[]arr = {1,2,-2147483648};
        System.out.println(solution(arr));
    }
}
