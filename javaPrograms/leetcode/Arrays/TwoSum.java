import java.util.Arrays;

class TwoSum
{
    public static int[] solution(int[]arr, int target)
    {
        // int[][]numsWithIndex = new int[arr.length][2];
        // for(int i = 0; i < arr.length; ++i) {
        //     numsWithIndex[i][0] = arr[i];
        //     numsWithIndex[i][1] = i;
        // }

        // Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // int left = 0, right = arr.length-1;

        // while(left < right) {
        //     int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
        //     if(sum == target) return new int[]{numsWithIndex[left][1], numsWithIndex[right][1]};
        //     else if(sum < target) left++;
        //     else right--;
        // }

        for(int i = 1; i < arr.length; ++i) {
            for(int j = i; j < arr.length; ++j) {
                if(arr[j] + arr[j-i] == target)
                    return new int[]{j-i, j};
            }
        }
        return new int[]{};
    }
    
    public static void main(String[]args)
    {
        int[]arr = {3, 2, 4};
        int target = 6;
        int[]res = new int[2];
        res = solution(arr, target);
        for(int i = 0; i < res.length; ++i)
            System.out.print(res[i]+" ");
        System.out.println();
    }
}
