class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int j = 0, i = n ; j < n ; j++){
            nums1[i] = nums2[j];
            i++;
        }
        bubbleSort(nums1);
        for(int i = 0 ; i < nums1.length ; i++){
            // if(nums1[i] == 0) continue;
            System.out.print(nums1[i]+" ");
        }
    }
    public static int[] bubbleSort(int[]arr){
        int n = arr.length;
        for(int i = n-1 ; i >= 0 ; i--){
            boolean didSwap = false;
            for(int j = 0 ; j < i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            if(!didSwap) break;
        }
        return arr;
    }

    public static void main(String[]args){
        int[]nums1 = {5, 32, 2, 0, 0, 0};
        int m = 3;
        // int m = nums1.length;
        int[]nums2 = {11, 2, 65};
        int n = 3;
        // int n = nums2.length;
        merge(nums1, m, nums2, n);
    }
}