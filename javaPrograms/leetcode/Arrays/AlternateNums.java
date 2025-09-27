/*
 * You are given a 0-indexed integer array nums of even length
 * consisting of an equal number of positive and negative integers.
 *
 * You should return the array of nums such that the the array follows the
 * given conditions:
 * 
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were
 * present in nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the
 * aforementioned conditions. 
 *
 * Example:
 *
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 *
 * The resultant array must start from a positive element
 * so we initialize the positive index as 0 and negative index as 1
 * and start traversing the array such that whenever we see the
 * first positive element, it occupies the space at 0
 * and then posIndex increases by 2 (alternate places).
 * Similarly, when we encounter the first negative element,
 * it occupies the position at index 1, and then each time we find a
 * negative number, we put it on the negIndex and it increments by 2.
 * When both the negIndex and posIndex exceed the size of the array,
 * we see that the whole array is now rearranged alternatively according to
 * the sign.
 */
class AlternateNums {

    public static int[] solution(int[]arr) {
        int n = arr.length;
        int[]ans = new int[n];
        int pos = 0; int neg = 1;
        
        for(int i = 0; i < n; ++i) {
            if(arr[i] < 0) {
                ans[neg] = arr[i];
                neg += 2;
            } else {
                ans[pos] = arr[i];
                pos += 2;
            }
        }
        return ans;
    }
    
    public static void main(String[]args) {
        int[]arr = {3,1,-2,-5,2,-4};
        arr = solution(arr);
        for(int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]+" ");
    }
}
