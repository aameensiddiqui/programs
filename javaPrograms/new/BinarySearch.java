class BinarySearch {
    public static void main(String[]args){
        int[]arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23};
        int num = 7;
        int ans = findByBinarySearch(arr, num);
        if(ans == -9999) System.out.println("Not found.");
        else System.out.println(num +" found. Its index is: "+ ans);
    }   
    public static int findByBinarySearch(int[]arr, int num){
        int low_index = 0;
        int high_index = arr.length - 1;
        while(low_index <= high_index){
            int mid_index = (low_index + high_index) / 2;
            if(arr[mid_index] == num) 
                return mid_index;
            if(arr[mid_index] > num){
                high_index = mid_index - 1;
            } else {
                low_index = mid_index + 1;
            }
        }
        return -9999;
    }
}
