class RotateArray {

    public static int[] rotate(int[]arr, int k) {
        int n = arr.length;
        if(n == 0) return arr;
        int[]temp = new int[k];
        k = k % n;
        for(int i = 0; i < k; ++i) {
            temp[i] = arr[n-k+i];
        }
        for(int i = n-1; i >= k; --i) {
            arr[i] = arr[i-k];
        }
        for(int i = 0; i < k; ++i) {
            arr[i] = temp[i];
        }
        return arr;
    }
    
    public static void main(String[]args) {
        int[]arr = {1,2,3,4,5,6,7};
        int k = 3;
        arr = rotate(arr, k);
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
