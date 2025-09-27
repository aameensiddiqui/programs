/*
You are given a ****sorted**** array containing N integers and a number X,
you have to find the occurrences of X in the given array.
*/
class Occurrences {

    public static int count(int[]arr, int n, int x) {
        int low = 0, high = n-1, focc = -1, locc = -1;

        // first occurrence
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] == x) {
                focc = mid;
                high = mid-1;
            } else if(arr[mid] > x) high = mid-1;
            else low = mid+1;
        }

        // last occurrence
        low = 0; high = n-1;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] == x) {
                locc = mid;
                low = mid+1;
            } else if(arr[mid] > x) high = mid-1;
            else low = mid+1;
        }
        if(focc == -1) return 0;
        return locc - focc + 1;
    }
    
    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
        int ans = count(arr, n, x);
        System.out.println("The number of occurrences is: " + ans);
    }
}
