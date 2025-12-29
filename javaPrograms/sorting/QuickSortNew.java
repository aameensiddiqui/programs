import java.util.Random;

class QuickSortNew {
    public static void main(String[] args) {

        // mai java ke util me ke Random class ka ek object bana raha hu...
        // maine uska naam "randoom" rakha hai...
        Random randoom = new Random();

        // mai ek arr naam ka array bana raha hu uski length 10 hai
        int[]arr = new int[100];

        // for loop <--> array
        // for loop ki madat se array bhar raha hu
        // randoom 0 to 99 me se koi bhi number generate karega aur array me bharega
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = randoom.nextInt(1000);
        }

        // initial array OR
        // array ka pehla roop OR
        // pehle mai aisa dikhta tha
        System.out.println("Before");
        printArray(arr);

        // phir mai ne qsort ki goli li aur mai sorted ho gaya
        qsort(arr, 0, arr.length-1);
        System.out.println("After");
        printArray(arr);
    }  

    // ye function jo bhi array iske paas ayega usko ye print karneka kaam karega
    private static void printArray(int[]arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }  

    // quicksort function
    private static void qsort(int[]arr, int low, int high){
        if(low >= high) return;

        int pivot = arr[high];
        int partitionIndex = partition(arr, low, high, pivot);

        qsort(arr, low, partitionIndex-1);
        qsort(arr, partitionIndex+1, high);

    }

    private static int partition(int[]arr, int low, int high, int pivot){
        int i = low;

        for(int j = low ; j < high ; j++){
            if(arr[j] < pivot){
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);
        return i;
    }

    private static void swap(int[]arr, int i, int j){
        if(i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
