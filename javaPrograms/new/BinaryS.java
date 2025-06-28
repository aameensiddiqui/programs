class BinaryS {
    public static void main(String[]args){
        int[]arr = new int[10000];
        for(int i = 1,  j = 0 ; j < 10000 ; i++){
            boolean is = isPrime(i);
            if(is){
                arr[j] = i;
                j++;
            }
        }
        int num = 7;
        int ans = binaryS(arr, num);
        if (ans == -9999) {
            System.err.println("Not Found");
        } else {
            System.out.println("Found! "+num+" is at ====> "+ans);
        }
    }
    public static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3 ; i <= Math.sqrt(n) ; i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static int binaryS(int[]arr, int n){
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -9999;
    } 
}
