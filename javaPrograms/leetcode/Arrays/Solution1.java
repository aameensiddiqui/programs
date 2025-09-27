class Solution1 {
     public static int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[cnt] = nums[i];
                cnt++;
            }
        }    
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        System.out.println(cnt);
        return cnt;
    }

    public static void main(String[]args){
        int[]arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        removeElement(arr, val);
    }
}