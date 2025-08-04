// import java.util.Arrays;

class SquareOfArray
{
    // public static void solution(int[]arr)
    // {
    //     for(int i = 0; i < arr.length; ++i) {
    //         arr[i] = arr[i]*arr[i];
    //     }
    //     Arrays.sort(arr);
    // }

    public static void solution(int[]arr)
    {
        int n = arr.length;
        int[]result = new int[n];
        int left = 0, right = n-1, pos = n-1;

        while(left <= right) {
            int rightSq = arr[right]*arr[right];
            int leftSq = arr[left]*arr[left];

            if(leftSq < rightSq) {
                result[pos] = rightSq;
                right--;
            } else {
                result[pos] = leftSq;
                left++;
            }
            pos--;
        }
        for(int i = 0; i < result.length; ++i)
            System.out.print(result[i]+" ");
    }
    
    public static void main(String[]args)
    {
        int[]arr = {-4, -1, 0, 3, 10};
        solution(arr);
    }
}
