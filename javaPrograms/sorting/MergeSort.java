import java.util.*;

class MergeSort
{
    public static void mergeSort(int[]arr, int low, int high)
    {
        if(low >= high) return;
        int mid = (low+high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[]arr, int low, int mid, int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]); left++;
            } else {
                temp.add(arr[right]); right++;
            }
        }

        while(left <= mid) {
            temp.add(arr[left]); left++;
        }
        
        while(right <= high) {
            temp.add(arr[right]); right++;
        }

        for(int i = low; i <= high; ++i) {
            arr[i] = temp.get(i-low);
        }
    }
    
    public static void main(String[]args)
    {
        Random r = new Random();
        int[]arr = new int[100];

        System.out.println("before sorting:");
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt(10000);
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n-----------------------------------\nafter sorting:");
        
        mergeSort(arr, 0, arr.length-1);
        
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
