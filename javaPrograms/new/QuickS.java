import java.util.Random;

class QuickS {
    public static void main(String[] args) {
        Random r = new Random();
        int[]arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = r.nextInt(100);
        }
        System.out.println("Before: ");
        printarray(arr);

        qsort(arr, 0, arr.length-1);

        System.out.println("After: ");
        printarray(arr);
    }    

    private static void qsort(int[]arr, int low, int high){
        if(low >= high) return;

        int pivotIndex = new Random().nextInt(high - low) + low;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);

        int leftPointer = partition(arr, low, high, pivot);

        qsort(arr, low, leftPointer-1);
        qsort(arr, leftPointer+1, high);
    }

    private static int partition(int[]arr, int low, int high, int pivot){
        int leftP = low;
        int rightP = high-1;

        while(leftP < rightP){
            while(arr[leftP] <= pivot && leftP < rightP) leftP++;
            while(arr[rightP] >= pivot && leftP < rightP) rightP--;
            swap(arr, leftP, rightP);
        }
        if(arr[leftP] > arr[high]) swap(arr, leftP, high);
        else leftP = high;
        return leftP;
    }

    private static void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void printarray(int[]arr) {
        System.out.print("{");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]);
            if(i == arr.length-1) System.out.print("}");
            else System.out.print(" , ");
        }
        System.out.println();
    }
}
