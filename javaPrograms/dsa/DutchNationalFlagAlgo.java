/*
  A variation of Dutch National Flag Algorithm

  Leetcode problem 75:
  Given an array nums with n objects colored red, white, or blue,
  sort them in-place so that objects of the same color are adjacent,
  with the colors in the order red, white, and blue.
  
  We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
  
  You must solve this problem without using the library's sort function.
  
  Example 1:
  Input: nums = [2,0,2,1,1,0]
  Output: [0,0,1,1,2,2]
  Example 2:
  Input: nums = [2,0,1]
  Output: [0,1,2]
 */

class DutchNationalFlagAlgo
{
    public static void solution(int[]arr)
    {
        int low = 0, mid = 0, high = arr.length-1;
        while(mid <= high) {
            if(arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
            } else if(arr[mid] == 1) mid++;
            else if(arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
    
    public static void main(String[]args)
    {
        int[]arr = {2,0,2,1,1,0};
        solution(arr);
        for(int i = 0; i < arr.length; ++i)
            System.out.println(arr[i]);
    }
}
