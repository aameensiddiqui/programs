class KthMissing
{
    public static int solution(int[]arr, int k)
    {
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] <= k) k++;
        }
        return k;
    }
    
    public static void main(String[]args)
    {
        int[]arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(solution(arr, k));
    }
}
