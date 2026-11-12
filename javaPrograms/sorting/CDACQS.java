import java.util.*;


// TWO TECHNIQUES FOR QUICK SORT:
// LOMUTO'S PARTITION (SINGLE INDEX)
// HOARE (TWO POINTERS)
class CDACQS {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int findPivot(int[] arr, int low, int high) {
        int reference = arr[high];
        for (int i = low; i < high; ++i) {
            if (arr[i] < reference) {
                swap(arr[i], reference);
            }
        }
        return reference;
    }
    private static void quickSort(int[] arr, int low, int high) {
        int pivot = findPivot(arr, int low, int high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
